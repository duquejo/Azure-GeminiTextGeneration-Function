package com.functions.infrastructure.configuration;

import com.functions.application.ports.input.CreatePromptUseCase;
import com.functions.domain.exception.MisconfigurationException;
import com.functions.domain.factory.PromptFactory;
import com.functions.domain.factory.PromptFactoryImpl;
import com.functions.domain.service.PromptService;
import com.functions.domain.service.ValidationService;
import com.functions.infrastructure.adapter.output.client.HttpClient;
import com.functions.infrastructure.adapter.output.client.NetHttpClientFactory;
import com.functions.domain.model.PromptRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DependencyFactory {

    public static CreatePromptUseCase createPromptUseCase() throws MisconfigurationException {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();
        HttpClient client = new NetHttpClientFactory().create();
        PromptFactory factory = new PromptFactoryImpl();
        ValidationService<PromptRequest> validationService = new ValidationService<>();

        return new PromptService(client, factory, validationService, configurationManager);

    }
}
