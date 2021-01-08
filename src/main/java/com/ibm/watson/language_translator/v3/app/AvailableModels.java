package com.ibm.watson.language_translator.v3.app;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslationModels;

/** The listModels display */
public class AvailableModels {

    /** The application interface */
    private static final String API_KEY = "FhSM8LituYOJ7tYPOs93opaOVW78hAPNtrbEY5FvWy6L";
    private static final String VERSION = "2018-05-01";
    private static final String SERVICE_URL = "https://api.eu-gb.language-translator.watson.cloud.ibm.com/instances/52c48680-4d2c-4227-b4bd-a9358bbaed98";

    /** Display a list of existing models for translation */
    public static void displayListOfModels() {
        IamAuthenticator authenticator = new IamAuthenticator(API_KEY);
        LanguageTranslator languageTranslator = new LanguageTranslator(VERSION, authenticator);
        languageTranslator.setServiceUrl(SERVICE_URL);
        TranslationModels models = languageTranslator.listModels().execute().getResult();
        System.out.println(models);
    }
}
