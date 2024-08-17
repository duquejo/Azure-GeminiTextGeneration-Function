/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.functions;

import com.functions.application.command.PromptHandler;
import com.functions.application.validation.ValidateRequest;
import com.functions.domain.model.RequestModel;
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
        HttpRequestMessage<Optional<RequestModel>> req,
        final ExecutionContext context) {

        Locale.setDefault(Locale.ENGLISH);

        RequestModel request = req.getBody().orElse(null);

        try {
            // Validate requests
            RequestModel validated = ValidateRequest.validate(request);

            // Dependencies factory startup
            PromptHandler handler = DependencyFactory.createPromptHandler();

            String response = handler.execute(validated.getText());

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
