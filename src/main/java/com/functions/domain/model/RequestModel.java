package com.functions.domain.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class RequestModel {
    @NotEmpty
    @NotNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
