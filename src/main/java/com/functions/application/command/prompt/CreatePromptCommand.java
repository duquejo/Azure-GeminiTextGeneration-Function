package com.functions.application.command.prompt;


import com.functions.application.command.Command;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreatePromptCommand implements Command {
    @NotEmpty
    @NotNull
    private String text;
    public String getText() {
        return text;
    }
}
