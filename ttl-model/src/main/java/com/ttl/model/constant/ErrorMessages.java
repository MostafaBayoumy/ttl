package com.ttl.model.constant;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/15/2022 - 2:37 PM
 */
public enum ErrorMessages {

    PARATICIPANT_MAX_NUMBER("you should have 12 participant maximum per league"),
    MATCH_DOES_NOT_EXIST("Match doesn't exist!"),
    CAN_NOT_CLOSE_ROUND("Can't close round until all matches are played"),
    LEAGUE_CAN_NOT_BE_NULL("League can't be null"),
    FIRST_ROUND_EXIST("First Round has been already created");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
