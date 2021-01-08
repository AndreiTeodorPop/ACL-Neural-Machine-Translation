package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** IdentifiedLanguages. */
public class IdentifiedLanguages extends GenericModel {

    protected List<IdentifiedLanguage> languages;

    /**
     * Gets the languages.
     *
     * <p>A ranking of identified languages with confidence scores.
     *
     * @return the languages
     */
    public List<IdentifiedLanguage> getLanguages() {
        return languages;
    }
}