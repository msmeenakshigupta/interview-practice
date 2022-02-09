package com.geekcircle.Java.DesignPatterns.Behavioural.A6_ChainOfResponsibiityDP;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-09-19
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

abstract class AbstractLogger {

    private AbstractLogger nextLogger;

    abstract boolean log(Integer logLevel, String message);

    public AbstractLogger getNextLogger() {
        return nextLogger;
    }

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }
}

class ErrorLogger extends AbstractLogger {

    private Integer level = 1;

    @Override
    boolean log(Integer logLevel, String message) {
        if(logLevel != this.level){
            AbstractLogger nextLogger = getNextLogger();
            if(nextLogger != null){
                nextLogger.log(logLevel, message);
            }
        } else {
            System.out.println("Logged by Error Logger");
        }
        return true;
    }

}

class DebugLogger extends AbstractLogger {

    private Integer level = 2;

    @Override
    boolean log(Integer logLevel, String message) {
        if(logLevel != this.level){
            AbstractLogger nextLogger = getNextLogger();
            if(nextLogger != null){
                nextLogger.log(logLevel, message);
            }
        } else {
            System.out.println("Logged by Debug Logger");
        }
        return true;
    }
}

class InfoLogger extends AbstractLogger {

    private Integer level = 3;

    @Override
    boolean log(Integer logLevel, String message) {
        if(logLevel != this.level){
            AbstractLogger nextLogger = getNextLogger();
            if(nextLogger != null){
                nextLogger.log(logLevel, message);
            }
        } else {
            System.out.println("Logged by Info Logger");
        }
        return true;
    }
}

class DefaultLogger extends AbstractLogger {

    @Override
    boolean log(Integer logLevel, String message) {
        System.out.println("Logged by Default Logger");
        return true;
    }
}



public class ChainOfResponsibilityDesignPattern {

    private static AbstractLogger initializeLogger(){
        AbstractLogger defaultLogger = new DefaultLogger();
        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger errorLogger = new ErrorLogger();
        infoLogger.setNextLogger(defaultLogger);
        debugLogger.setNextLogger(infoLogger);
        errorLogger.setNextLogger(debugLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger logger = initializeLogger();
        logger.log(1, "TEST");
    }

}
