package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** The response type for listing existing translation models. */
public class TranslationModels extends GenericModel {

    protected List<TranslationModel> models;

    /**
     * Gets the models.
     *
     * <p>An array of available models.
     *
     * @return the models
     */
    public List<TranslationModel> getModels() {
        return models;
    }
}