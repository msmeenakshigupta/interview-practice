class Logger {

    Map<String, Integer> messageHistory;
    /** Initialize your data structure here. */
    public Logger() {
        messageHistory = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int prev = messageHistory.getOrDefault(message, -1);
        if(prev>-1 && timestamp-prev<10)
            return false;
        else
            messageHistory.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
