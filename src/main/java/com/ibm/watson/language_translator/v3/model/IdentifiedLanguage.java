package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** IdentifiedLanguage. */
public class IdentifiedLanguage extends GenericModel {

    protected String language;
    protected Double confidence;

    /**
     * Gets the language.
     *
     * <p>The language code for an identified language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the confidence.
     *
     * <p>The confidence score for the identified language.
     *
     * @return the confidence
     */
    public Double getConfidence() {
        return confidence;
    }
}