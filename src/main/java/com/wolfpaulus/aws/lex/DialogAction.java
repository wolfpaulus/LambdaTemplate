package com.wolfpaulus.aws.lex;

import com.amazonaws.services.lexmodelbuilding.model.Message;

/**
 * DialogAction gets send back inside the LexResponse.
 * Model description found here: https://github.com/awslabs/aws-lex-convo-bot-example
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DialogAction {
    public String type = "Close";
    public String fulfillmentState = "Fulfilled";
    public Message message;

    public DialogAction() {
    }

    public DialogAction(final String s) {
        this.message = new Message().withContent(s).withContentType("PlainText");
    }
}
