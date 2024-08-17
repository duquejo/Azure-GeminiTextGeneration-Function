/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.functions;

import com.functions.application.command.CommandHandler;
import com.functions.domain.model.CommandResult;
import com.functions.application.validation.ValidateRequest;
import com.functions.application.command.prompt.CreatePromptCommand;
import com.functions.infrastructure.factory.DependencyFactory;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

    @FunctionName("HttpExample")
    public HttpResponseMessage run(
        @HttpTrigger(
            name = "req",
            methods = HttpMethod.GET,
            authLevel = AuthorizationLevel.FUNCTION
        )
        HttpRequestMessage<Optional<CreatePromptCommand>> req,
        final ExecutionContext context) {

        Locale.setDefault(Locale.ENGLISH);

        CreatePromptCommand request = req.getBody().orElse(null);

        try {
            // Validate requests
            CreatePromptCommand validated = ValidateRequest.validate(request);

            // Dependencies factory startup
            CommandHandler<CreatePromptCommand> createPromptCommandCommandHandler = DependencyFactory.createPromptHandler();
            CommandResult response = createPromptCommandCommandHandler.handle(validated);

            return req.createResponseBuilder(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body(response)
                .build();

        } catch (Exception ex) {
            context.getLogger().warning(ex.getMessage());

            HashMap<String, Object> response = new LinkedHashMap<>();

            response.put("status", HttpStatus.BAD_REQUEST.name());
            response.put("code", HttpStatus.BAD_REQUEST.value());
            response.put("errors", ex.getMessage());

            return req.createResponseBuilder(HttpStatus.BAD_REQUEST)
                .header("Content-Type", "application/json")
                .body(response)
                .build();
        }
    }
}
