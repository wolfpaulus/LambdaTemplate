package com.wolfpaulus.aws.lex;

import java.util.Map;

/**
 * The LexResponse is used to communicate a result back to Lex.
 * Model description found here: https://github.com/awslabs/aws-lex-convo-bot-example
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LexResponse {
    public Map<String, String> sessionAttributes;
    public DialogAction dialogAction;

    public LexResponse(final String s, final Map<String, String> attributes) {
        sessionAttributes = attributes;
        dialogAction = new DialogAction(s);
    }
}
