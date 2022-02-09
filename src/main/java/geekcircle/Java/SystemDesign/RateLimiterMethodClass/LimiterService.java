package com.geekcircle.Java.SystemDesign.RateLimiterMethodClass;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class LimiterService {

    Map<String,Limit> nameLimitMap;
    Map<String,Map<Long, Integer>> nameRequestMap;
    Map<String, Date> nextRequest;

    private static LimiterService limiterService;

    private LimiterService() {
        nameLimitMap = new LinkedHashMap<>();
        nameRequestMap = new LinkedHashMap<>();
        nextRequest = new LinkedHashMap<String, Date>();
        initialize();
    }

    private void initialize(){
        nameLimitMap.put("Foo", new Limit("Foo", InvocationType.CLASS, 100, 1,1, TimeUnit.MINUTES));
        nameLimitMap.put("Foo.a()", new Limit("a", InvocationType.METHOD, 50, 10,10, TimeUnit.SECONDS));
        nameLimitMap.put("Foo.b()", new Limit("b", InvocationType.METHOD, 25, 10,20, TimeUnit.SECONDS));
        nameLimitMap.put("Bar", new Limit("Bar", InvocationType.CLASS, 100, 10,10, TimeUnit.SECONDS));
    }

    public static LimiterService getLimiterService(){
        if(limiterService == null){
            synchronized (LimiterService.class){
                if(limiterService == null){
                    limiterService = new LimiterService();
                }
            }
        }
        return limiterService;
    }

    public Object call(String call){
        Object object = null;
        long keyTime = new Date().getTime()/1000; //Second
        Limit limit;
        if(nameLimitMap.containsKey(call)){
            limit = nameLimitMap.get(call);
            if(limit.getTimeUnit() == TimeUnit.MINUTES){
                keyTime /= (60 * limit.getInTimeUnit());
            } else {
                keyTime /= (limit.getInTimeUnit());
            }
        } else {
            System.out.println("Something Went Wrong");
            return object;
        }

        switch (call){
            case "Foo" : {
                if(nameRequestMap.containsKey(call)){
                    if(nameRequestMap.get(call).containsKey(keyTime)){
                        Integer count = nameRequestMap.get(call).get(keyTime);
                        if(count == 1){
                            int addBackOff = 0;
                            if(limit.getBackoffPeriod() > 0){
                                int factor = 1;
                                if(limit.getTimeUnit() == TimeUnit.MINUTES){
                                    factor = 60;
                                }
                                addBackOff = limit.getBackoffPeriod() * factor;
                            }
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(new Date());
                            calendar.add(Calendar.SECOND, addBackOff);
                            nextRequest.put(call, calendar.getTime());
                        }
                    }
                }
                //Limiting




                /*if(){

                } else {
                    System.out.println("Limit Exhaust : next request in ");
                }*/
                object = new Foo();
                break;
            }
            case "Foo.a()" : {
                //
                //Class Limiting
                /*if(){

                } else {
                    System.out.println("Limit Exhaust : next request in ");
                }*/
                Foo foo = new Foo();
                //Method Limiting
                /*if(){

                } else {
                    System.out.println("Limit Exhaust : next request in ");
                }*/
                foo.a();
                break;
            }

            case "Foo.b()" : {
                //Class Limiting
                /*if(){

                } else {
                    System.out.println("Limit Exhaust : next request in ");
                }*/
                Foo foo = new Foo();

                //Method Limiting
                object = foo.b();
                break;
            }

            case "Bar" : {
                /*if(){

                } else {
                    System.out.println("Limit Exhaust : next request in ");
                }*/
                object = new Bar();
                break;
            }
        }
        return object;
    }
}
