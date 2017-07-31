package com.wolfpaulus.aws;

@SuppressWarnings({"unused"})
public class Request {
    private long number;

    public Request() {
    }

    long getNumber() {
        return number;
    }

    public void setNumber(final long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
