package com.functions.application.command.prompt;

import com.functions.application.command.CommandHandler;
import com.functions.domain.model.CommandResult;
import com.functions.domain.service.PromptService;

public class CreateCommandHandler implements CommandHandler<CreatePromptCommand> {

    private final PromptService service;

    public CreateCommandHandler(PromptService service) {
        this.service = service;
    }

    @Override
    public CommandResult handle(CreatePromptCommand command) {
        String result = service.create(command.getText());
        return new CommandResult(true, result);
    }
}
