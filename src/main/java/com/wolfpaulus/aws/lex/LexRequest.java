package com.wolfpaulus.aws.lex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * The LexRequest gets deserialized by jackson, when the LambdaFunction gets called from Lex.
 * Model description found here: https://github.com/awslabs/aws-lex-convo-bot-example
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LexRequest {

    @JsonProperty("currentIntent")
    public CurrentIntent currentIntent;
    @JsonProperty("bot")
    public Map<String, String> bot; // look in the map for name, alias, and version
    @JsonProperty("userId")
    public String userId;
    @JsonProperty("inputTranscript")
    public String inputTranscript;
    @JsonProperty("invocationSource")
    public String invocationSource;
    @JsonProperty("outputDialogMode")
    public String outputDialogMode;
    @JsonProperty("messageVersion")
    public String messageVersion;
    @JsonProperty("sessionAttributes")
    public Map<String, String> sessionAttributes;

    public LexRequest() {
    }

    @JsonCreator
    public LexRequest(
            @JsonProperty("messageVersion") String messageVersion,
            @JsonProperty("invocationSource") String invocationSource,
            @JsonProperty("userId") String userId,
            @JsonProperty("sessionAttributes") Map<String, String> sessionAttributes,
            @JsonProperty("bot") Map<String, String> bot,
            @JsonProperty("outputDialogMode") String outputDialogMode,
            @JsonProperty("currentIntent") CurrentIntent currentIntent,
            @JsonProperty("inputTranscript") String inputTranscript) {

        this.currentIntent = currentIntent;
        this.bot = bot;
        this.userId = userId;
        this.inputTranscript = inputTranscript;
        this.invocationSource = invocationSource;
        this.messageVersion = messageVersion;
        this.sessionAttributes = sessionAttributes;
    }

    @Override
    public String toString() {
        return "Intent " + currentIntent.toString() + "; Bot " + bot.toString() + "; InputTranscript " + inputTranscript;
    }
}
