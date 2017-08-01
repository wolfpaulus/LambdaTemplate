package com.wolfpaulus.aws;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wolfpaulus.aws.lex.LexRequest;
import org.junit.Assert;
import org.junit.Test;

public class LexRequestTest {
    @Test
    public void testInstantiation() throws Exception {
        final String json = "{\"messageVersion\":\"1.0\",\"invocationSource\":\"FulfillmentCodeHook\",\"userId\":\"387w0c6j0qv5mg53t0at7vf2h23fh1p\",\"sessionAttributes\":{},\"bot\":{\"name\":\"TestBot\",\"alias\":\"null\",\"version\":\"$LATEST\"},\"outputDialogMode\":\"Text\",\"currentIntent\":{\"name\":\"IsPrimeNumber\",\"slots\":{\"num\":\"17\"},\"confirmationStatus\":\"None\"},\"inputTranscript\":\"is 17 prime\"}";
        final ObjectMapper mapper = new ObjectMapper();
        final LexRequest ri = mapper.readValue(json, LexRequest.class);
        Assert.assertTrue("FulfillmentCodeHook".equals(ri.invocationSource));
    }
}
