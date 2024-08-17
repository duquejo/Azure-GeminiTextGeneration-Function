package com.functions.infrastructure.factory;

import com.functions.application.command.PromptHandler;
import com.functions.domain.service.PromptService;
import com.functions.domain.service.PromptServiceImpl;
import com.functions.infrastructure.adapter.HttpClient;
import com.functions.infrastructure.adapter.nethttpclient.NetHttpClientFactory;

public class DependencyFactory {

    private DependencyFactory() {}

    public static PromptHandler createPromptHandler() {
        HttpClient client = new NetHttpClientFactory().create();
        PromptService service = new PromptServiceImpl(client);
        return new PromptHandler(service);
    }
}
