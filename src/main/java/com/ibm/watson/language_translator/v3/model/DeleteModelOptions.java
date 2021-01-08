package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** The deleteModel options. */
public class DeleteModelOptions extends GenericModel {

    protected String modelId;

    /** Builder. */
    public static class Builder {
        private String modelId;

        private Builder(DeleteModelOptions deleteModelOptions) {
            this.modelId = deleteModelOptions.modelId;
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
         * Builds a DeleteModelOptions.
         *
         * @return the deleteModelOptions
         */
        public DeleteModelOptions build() {
            return new DeleteModelOptions(this);
        }

        /**
         * Set the modelId.
         *
         * @param modelId the modelId
         * @return the DeleteModelOptions builder
         */
        public Builder modelId(String modelId) {
            this.modelId = modelId;
            return this;
        }
    }

    protected DeleteModelOptions(Builder builder) {
        com.ibm.cloud.sdk.core.util.Validator.notEmpty(builder.modelId, "modelId cannot be empty");
        modelId = builder.modelId;
    }

    /**
     * New builder.
     *
     * @return a DeleteModelOptions builder
     */
    public Builder newBuilder() {
        return new Builder(this);
    }

    /**
     * Gets the modelId.
     *
     * <p>Model ID of the model to delete.
     *
     * @return the modelId
     */
    public String modelId() {
        return modelId;
    }
}