package com.functions.application.factory;

import com.functions.domain.model.ContentModel;
import com.functions.domain.model.PartModel;
import com.functions.domain.model.TextModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromptFactory {

    private PromptFactory() {}

    public static Map<String, Object> create(String text) {
        TextModel textModel = new TextModel(text);
        PartModel partModel = new PartModel(List.of(textModel));
        ContentModel contentModel = new ContentModel(List.of(partModel));
        return new HashMap<>(contentModel.toMap());
    }
}
