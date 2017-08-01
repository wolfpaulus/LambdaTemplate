package com.wolfpaulus.aws;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.wolfpaulus.aws.lex.LexRequest;
import com.wolfpaulus.aws.lex.LexResponse;
import org.apache.log4j.Logger;

/**
 * The Prime class implement an RequestHandler interface,
 * i.e. {@link Request} and {@link Response} classes with (Jackson annotations) have been implemented.
 * This demo reads an integer from the Request class and finds out, if that is a prime number.
 * The result will returned in an instance of the Response class.
 */
public class Prime implements RequestHandler<Request, Response> {
    private static final Logger log = Logger.getLogger(Prime.class);

    /**
     * Check if the provided number is evenly divisible only by itself and one.
     *
     * @param n {@link Long}
     * @return {@link boolean} true, if the provided long is a prime number
     */
    static Response check(final long n) {
        if (n < 2) {
            return new Response();
        }
        if (n == 2 || n == 3) {
            return new Response(n);
        }
        if (n % 2 == 0) {
            return new Response(n, 2);
        }
        if (n % 3 == 0) {
            return new Response(n, 3);
        }
        final long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0) {
                return new Response(n, i - 1);
            }
            if (n % (i + 1) == 0) {
                return new Response(n, i + 1);
            }

        }
        return new Response(n);
    }

    /**
     * Handles a Lambda Function request
     *
     * @param input   {@link Request} The Lambda Function input
     * @param context {@link Context} The Lambda execution environment context object.
     * @return {@link Response} - The Lambda Function output
     */
    @Override
    public Response handleRequest(final Request input, final Context context) {
        log.info("Request received:" + input);
        return Prime.check(input.getNumber());
    }
    /**
     * Handles a Lambda Function request coming from Lex
     *
     * @param input   {@link LexRequest} The Lambda Function input
     * @param context {@link Context} The Lambda execution environment context object.
     * @return {@link LexResponse} - The Lambda Function output
     */
    public LexResponse handleLexRequest(final LexRequest input, final Context context) {
        log.info("LexRequest received:" + input.toString());
        String s;
        try {
            final long p = Long.parseLong(input.currentIntent.slots.get("number"));
            s = Prime.check(p).answer;
        } catch (Exception e) {
            s = e.getLocalizedMessage();
        }
        return new LexResponse(s, input.sessionAttributes);
    }
}
