package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The listIdentifiableLanguages options. */
public class ListIdentifiableLanguagesOptions extends GenericModel {

    /** Builder. */
    public static class Builder {

        private Builder(ListIdentifiableLanguagesOptions listIdentifiableLanguagesOptions) {}

        /** Instantiates a new builder. */
        public Builder() {}

        /**
         * Builds a ListIdentifiableLanguagesOptions.
         *
         * @return the listIdentifiableLanguagesOptions
         */
        public ListIdentifiableLanguagesOptions build() {
            return new ListIdentifiableLanguagesOptions(this);
        }
    }

    private ListIdentifiableLanguagesOptions(Builder builder) {}

    /**
     * New builder.
     *
     * @return a ListIdentifiableLanguagesOptions builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }
}