package com.geekcircle.Java.SystemDesign.RateLimiterMethodClass;

import java.util.concurrent.TimeUnit;

public class Limit {

    private String name;

    private InvocationType type;

    private int invocationLimit;

    private int backoffPeriod;

    private TimeUnit timeUnit;

    private int inTimeUnit;

    public Limit(String name, InvocationType type, int invocationLimit, int backoffPeriod, int inTimeUnit, TimeUnit timeUnit) {
        this.name = name;
        this.type = type;
        this.invocationLimit = invocationLimit;
        this.backoffPeriod = backoffPeriod;
        this.inTimeUnit = inTimeUnit;
        this.timeUnit = timeUnit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InvocationType getType() {
        return type;
    }

    public void setType(InvocationType type) {
        this.type = type;
    }

    public int getInvocationLimit() {
        return invocationLimit;
    }

    public void setInvocationLimit(int invocationLimit) {
        this.invocationLimit = invocationLimit;
    }

    public int getBackoffPeriod() {
        return backoffPeriod;
    }

    public void setBackoffPeriod(int backoffPeriod) {
        this.backoffPeriod = backoffPeriod;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public int getInTimeUnit() {
        return inTimeUnit;
    }

    public void setInTimeUnit(int inTimeUnit) {
        this.inTimeUnit = inTimeUnit;
    }
}
