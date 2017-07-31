package com.wolfpaulus.aws;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.log4j.Logger;

@SuppressWarnings("WeakerAccess")
public class Response {
    static final Logger log = Logger.getLogger(Response.class);

    @JsonProperty("answer")
    public final String answer;
    @JsonProperty("n")
    public long n;
    @JsonProperty("d")
    public long d = 1;

    public Response(final long n, final long d) {
        this.n = n;
        this.d = d;
        answer = String.format("No, %d is not a prime number. It's divisible by %d", n, d);
    }

    public Response(final long n) {
        log.info("Found a prime number " + n);
        this.n = n;
        answer = String.format("Yes, %d is a prime number, divisible only by itself and 1", n);
    }

    public Response() {
        answer = "A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.";
    }

    @Override
    public String toString() {
        return answer;
    }

}
