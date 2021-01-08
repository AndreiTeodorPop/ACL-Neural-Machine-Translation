package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** IdentifiableLanguage. */
public class IdentifiableLanguage extends GenericModel {

    protected String language;
    protected String name;

    /**
     * Gets the language.
     *
     * <p>The language code for an identifiable language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Gets the name.
     *
     * <p>The name of the identifiable language.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }
}