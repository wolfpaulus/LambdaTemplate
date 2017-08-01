package com.wolfpaulus.aws.lex;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * Using during the Jackson deserialization.
 * Model description found here: https://github.com/awslabs/aws-lex-convo-bot-example
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CurrentIntent {
    @JsonProperty("name")
    public String name;
    @JsonProperty("slots")
    public Map<String, String> slots;
    @JsonProperty("confirmationStatus")
    public String confirmationStatus;

    public CurrentIntent() {
    }

    @JsonCreator
    public CurrentIntent(
            @JsonProperty("name") String name,
            @JsonProperty("slots") Map<String, String> slots,
            @JsonProperty("confirmationStatus") String confirmationStatus) {
        this.name = name;
        this.slots = slots;
        this.confirmationStatus = confirmationStatus;
    }
}
