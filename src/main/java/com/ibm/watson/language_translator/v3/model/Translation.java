package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** Translation. */
public class Translation extends GenericModel {

    protected String translation;

    /**
     * Gets the translation.
     *
     * <p>Translation output in UTF-8.
     *
     * @return the translation
     */
    public String getTranslation() {
        return translation;
    }
}