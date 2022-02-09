package com.geekcircle.Java.SystemDesign.RateLimiterMethodClass;

import java.util.Date;

public class Request {

    private Integer remainingCount;

    private Date lastRequest;

    public Request(Integer remainingCount, Date lastRequest) {
        this.remainingCount = remainingCount;
        this.lastRequest = lastRequest;
    }

    public Integer getRemainingCount() {
        return remainingCount;
    }

    public void setRemainingCount(Integer remainingCount) {
        this.remainingCount = remainingCount;
    }

    public Date getLastRequest() {
        return lastRequest;
    }

    public void setLastRequest(Date lastRequest) {
        this.lastRequest = lastRequest;
    }
}
