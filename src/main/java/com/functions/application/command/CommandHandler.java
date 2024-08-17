package com.functions.application.command;

import com.functions.domain.model.CommandResult;

public interface CommandHandler<T extends Command> {
    CommandResult handle(T command);
}
