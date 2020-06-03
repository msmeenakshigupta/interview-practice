package HackerRank;

/**
 * created by megupta on 25/04/20
 */

import java.util.*;
import java.lang.*;
public class featuresAlexa {

    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

    // CLASS BEGINS, THIS CLASS IS REQUIRED

        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
        public ArrayList<String> popularNFeatures(int numFeatures,
                                                  int topFeatures,
                                                  List<String> possibleFeatures,
                                                  int numFeatureRequests,
                                                  List<String> featureRequests)
        {
            // WRITE YOUR CODE HERE
            Map<String, Integer> requestCount = new HashMap<String,Integer>();
            for(String request : featureRequests){
                for(String possibleFeature : possibleFeatures){
                    if(request.contains(possibleFeature)){
                        int count =0;
                        if(requestCount.containsKey(possibleFeature)){
                            count = requestCount.get(possibleFeature);
                        }
                        count++;
                        requestCount.put(possibleFeature, count);
                        break;
                    }
                }
            }
            List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>> (requestCount.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
                public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2 ){
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });
            HashMap<String, Integer> temp = new LinkedHashMap< String, Integer>();

            for(Map.Entry<String,Integer> aa : list){
                temp.put(aa.getKey(), aa.getValue());
            }
            ArrayList<String> res = new ArrayList<String> ();
            int mapSize = temp.size();
            int count =0;
            for(String key : temp.keySet()){
                if(mapSize-count> topFeatures){
                    count++;
                }else{
                    res.add(key);
                }
            }
            return res;
        }
        // METHOD SIGNATURE ENDS
    }

