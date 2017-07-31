package com.wolfpaulus.aws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrimeTest {

    @Test
    public void evaluateRequest() throws IOException {
        Request request = new ObjectMapper().readValue("{\"number\": 17}", Request.class);
        Response response = Prime.check(request.getNumber());
        assertTrue(response.d == 1);
        System.out.println(response);

        request = new ObjectMapper().readValue("{\"number\": 49}", Request.class);
        response = Prime.check(request.getNumber());
        assertEquals(response.d, 7);
        System.out.println(response);
    }
}
