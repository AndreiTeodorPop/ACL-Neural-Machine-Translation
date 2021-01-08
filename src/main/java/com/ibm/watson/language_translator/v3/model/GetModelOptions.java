package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The getModel options. */
public class GetModelOptions extends GenericModel {

    protected String modelId;

    /** Builder. */
    public static class Builder {
        private String modelId;

        private Builder(GetModelOptions getModelOptions) {
            this.modelId = getModelOptions.modelId;
        }

        /** Instantiates a new builder. */
        public Builder() {}

        /**
         * Instantiates a new builder with required properties.
         *
         * @param modelId the modelId
         */
        public Builder(String modelId) {
            this.modelId = modelId;
        }

        /**
         * Builds a GetModelOptions.
         *
         * @return the getModelOptions
         */
        public GetModelOptions build() {
            return new GetModelOptions(this);
        }

        /**
         * Set the modelId.
         *
         * @param modelId the modelId
         * @return the GetModelOptions builder
         */
        public Builder modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }
    }

    protected GetModelOptions(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
        modelId = builder.modelId;
    }

    /**
     * New builder.
     *
     * @return a GetModelOptions builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }

    /**
     * Gets the modelId.
     *
     * <p>Model ID of the model to get.
     *
     * @return the modelId
     */
    public String modelId() {
        return modelId;
    }
}