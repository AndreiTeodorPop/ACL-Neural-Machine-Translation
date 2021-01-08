package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** IdentifiableLanguages. */
public class IdentifiableLanguages extends GenericModel {

    protected List<IdentifiableLanguage> languages;

    /**
     * Gets the languages.
     *
     * <p>A list of all languages that the service can identify.
     *
     * @return the languages
     */
    public List<IdentifiableLanguage> getLanguages() {
        return languages;
    }
}