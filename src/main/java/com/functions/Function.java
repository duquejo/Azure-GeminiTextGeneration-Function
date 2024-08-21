/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */

package com.functions;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.infrastructure.adapter.input.PromptRestAdapter;
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
            PromptRestAdapter restAdapter = new PromptRestAdapter(promptUseCase);

            PromptResponse response = restAdapter.execute(request);

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
