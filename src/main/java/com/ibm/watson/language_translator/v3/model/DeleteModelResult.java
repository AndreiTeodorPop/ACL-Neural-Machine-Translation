package com.ibm.watson.language_translator.v3.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/** DeleteModelResult. */
public class DeleteModelResult extends GenericModel {

    protected String status;

    /**
     * Gets the status.
     *
     * <p>"OK" indicates that the model was successfully deleted.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }
}