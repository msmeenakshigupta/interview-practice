package com.geekcircle;

import com.geekcircle.Thread.*;

public class Main {

    public static void main(String[] args) {

        String exampleToRun = "VolatileVariable";
        ThreadBaseClass threadBaseClass;
        switch (exampleToRun){
            case "ThreadExample" : {
                threadBaseClass = new ThreadExample();
                break;
            }
            case "ThreadPoolExample" : {
                threadBaseClass = new ThreadPoolExample();
                break;
            }
            case "ThreadSequence" : {
                threadBaseClass = new ThreadSequence();
                break;
            }
            case "ProducerConsumer" : {
                threadBaseClass = new ProducerConsumer();
                break;
            }
            case "PrintOddEvenExample" : {
                threadBaseClass = new PrintOddEvenExample();
                break;
            }
            case "PrintSequenceByThread" : {
                threadBaseClass = new PrintSequenceByThread();
                break;
            }
            case "ThreadImplementation" : {
                threadBaseClass = new ThreadImplementation();
                break;
            }
            case "DaemonThread" : {
                threadBaseClass = new DaemonThread();
                break;
            }
            case "SynchronizedBlock" : {
                threadBaseClass = new SynchronizedBlock();
                break;
            }
            case "VolatileVariable" : {
                threadBaseClass = new VolatileVariable();
                break;
            }
            default: {
                threadBaseClass = new ThreadBaseClass();
            }
        }
        threadBaseClass.doProcess();
    }
}
