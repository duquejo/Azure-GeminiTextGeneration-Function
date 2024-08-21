/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.functions;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.infrastructure.adapter.input.FunctionInputAdapter;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;
import com.functions.infrastructure.configuration.DependencyFactory;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.*;

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
        HttpRequestMessage<Optional<PromptRequest>> req,
        final ExecutionContext context) {

        Locale.setDefault(Locale.ENGLISH);

        PromptRequest request = req.getBody().orElse(null);

        try {
            CreatePromptUseCase promptUseCase = DependencyFactory.createPromptUseCase();
            FunctionInputAdapter functionInputAdapter = new FunctionInputAdapter(promptUseCase);
            PromptResponse response = functionInputAdapter.execute(request);

            context.getLogger().info(response.toString());

            return req.createResponseBuilder(response.getStatus())
                .header("Content-Type", "application/json")
                .body(response)
                .build();
        } catch (InterruptedException iEx) {
            context.getLogger().warning(iEx.getMessage());

            Thread.currentThread().interrupt();

            PromptResponse response = PromptResponse.builder()
                .message(iEx.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .prompt(request.getText())
                .build();

            return req.createResponseBuilder(response.getStatus())
                .header("Content-Type", "application/json")
                .body(response)
                .build();
        } catch (Exception ex) {

            context.getLogger().warning(ex.getMessage());

            PromptResponse response = PromptResponse.builder()
                .message(ex.getMessage())
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .prompt(request.getText())
                .build();

            return req.createResponseBuilder(response.getStatus())
                .header("Content-Type", "application/json")
                .body(response)
                .build();
        }
    }
}
