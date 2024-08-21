package com.functions.domain.factory;

import com.functions.domain.model.ContentModel;
import com.functions.domain.model.PartModel;
import com.functions.domain.model.TextModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromptFactoryImpl implements PromptFactory {
    @Override
    public Map<String, Object> create(String text) {
        TextModel textModel = new TextModel(text);
        PartModel partModel = new PartModel(List.of(textModel));
        ContentModel contentModel = new ContentModel(List.of(partModel));
        return new HashMap<>(contentModel.toMap());
    }
}
