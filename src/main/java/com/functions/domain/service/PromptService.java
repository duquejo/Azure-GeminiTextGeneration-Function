package com.functions.domain.service;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.domain.exception.ValidationException;
import com.functions.domain.factory.PromptFactory;
import com.functions.infrastructure.adapter.output.client.HttpClient;
import com.functions.domain.model.PromptRequest;
import com.functions.domain.model.PromptResponse;
import com.functions.infrastructure.util.StringUtils;
import com.microsoft.azure.functions.HttpStatus;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.Map;

@RequiredArgsConstructor
public class PromptService implements CreatePromptUseCase {

    private final HttpClient httpClient;
    private final PromptFactory promptFactory;
    private final ValidationService<PromptRequest> validationService;

    private final String apiKey = System.getenv("GEMINI_API_KEY");
    private final String url = System.getenv("GEMINI_URL");

    @Override
    public PromptResponse createPrompt(PromptRequest prompt) throws ValidationException {

        PromptRequest promptRequest = validationService.validate(prompt);

        String promptToSearch = promptRequest.getText();
        URI uri = StringUtils.simpleFormatUri(url, apiKey);
        Map<String, Object> payload = promptFactory.create(promptToSearch);

        String promptResponse = httpClient.invoke(uri, payload);

        return new PromptResponse(promptToSearch, promptResponse, HttpStatus.OK);
    }
}
