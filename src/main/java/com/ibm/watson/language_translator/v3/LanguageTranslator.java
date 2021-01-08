package com.ibm.watson.language_translator.v3;

import com.google.gson.JsonObject;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import com.ibm.watson.common.SdkCommon;
import com.ibm.watson.language_translator.v3.app.TranslationFrame;
import com.ibm.watson.language_translator.v3.model.*;


import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import okhttp3.MultipartBody;

public class LanguageTranslator extends BaseService {

    private static final String DEFAULT_SERVICE_NAME = "language_translator";

    private static final String DEFAULT_SERVICE_URL =
            "https://gateway.watsonplatform.net/language-translator/api";

    private final String versionDate;

    /**
     * Constructs a new `LanguageTranslator` client using the DEFAULT_SERVICE_NAME.
     *
     * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
     *                    will keep your API calls from failing when the service introduces breaking changes.
     */
    public LanguageTranslator(String versionDate) {
        this(
                versionDate,
                DEFAULT_SERVICE_NAME,
                ConfigBasedAuthenticatorFactory.getAuthenticator(DEFAULT_SERVICE_NAME));
    }

    /**
     * Constructs a new `LanguageTranslator` client with the DEFAULT_SERVICE_NAME and the specified
     * Authenticator.
     *
     * @param versionDate   The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
     *                      will keep your API calls from failing when the service introduces breaking changes.
     * @param authenticator the Authenticator instance to be configured for this service
     */
    public LanguageTranslator(String versionDate, Authenticator authenticator) {
        this(versionDate, DEFAULT_SERVICE_NAME, authenticator);
    }

    /**
     * Constructs a new `LanguageTranslator` client with the specified serviceName.
     *
     * @param versionDate The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
     *                    will keep your API calls from failing when the service introduces breaking changes.
     * @param serviceName The name of the service to configure.
     */
    public LanguageTranslator(String versionDate, String serviceName) {
        this(versionDate, serviceName, ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName));
    }

    /**
     * Constructs a new `LanguageTranslator` client with the specified Authenticator and serviceName.
     *
     * @param versionDate   The version date (yyyy-MM-dd) of the REST API to use. Specifying this value
     *                      will keep your API calls from failing when the service introduces breaking changes.
     * @param serviceName   The name of the service to configure.
     * @param authenticator the Authenticator instance to be configured for this service
     */
    public LanguageTranslator(String versionDate, String serviceName, Authenticator authenticator) {
        super(serviceName, authenticator);
        setServiceUrl(DEFAULT_SERVICE_URL);
        com.ibm.cloud.sdk.core.util.Validator.isTrue(
                (versionDate != null) && !versionDate.isEmpty(), "version cannot be null.");
        this.versionDate = versionDate;
        this.configureService(serviceName);
    }

    /**
     * Translate.
     *
     * <p>Translates the input text from the source language to the target language. A target language
     * or translation model ID is required. The service attempts to detect the language of the source
     * text if it is not specified.
     *
     * @param translateOptions the {@link TranslateOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link TranslationResult}
     */
    public ServiceCall<TranslationResult> translate(TranslateOptions translateOptions) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(
                translateOptions, "translateOptions cannot be null");
        String[] pathSegments = {"v3/translate"};
        RequestBuilder builder =
                RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "translate");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");
        final JsonObject contentJson = new JsonObject();
        contentJson.add(
                "text",
                com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(translateOptions.text()));
        if (translateOptions.modelId() != null) {
            contentJson.addProperty("model_id", translateOptions.modelId());
        }
        if (translateOptions.source() != null) {
            contentJson.addProperty("source", translateOptions.source());
        }
        if (translateOptions.target() != null) {
            contentJson.addProperty("target", translateOptions.target());
        }
        builder.bodyJson(contentJson);
        ResponseConverter<TranslationResult> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<TranslationResult>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * List identifiable languages.
     *
     * <p>Lists the languages that the service can identify. Returns the language code (for example,
     * `en` for English or `es` for Spanish) and name of each language.
     *
     * @param listIdentifiableLanguagesOptions the {@link ListIdentifiableLanguagesOptions} containing
     *                                         the options for the call
     * @return a {@link ServiceCall} with a response type of {@link IdentifiableLanguages}
     */
    public ServiceCall<IdentifiableLanguages> listIdentifiableLanguages(
            ListIdentifiableLanguagesOptions listIdentifiableLanguagesOptions) {
        String[] pathSegments = {"v3/identifiable_languages"};
        RequestBuilder builder =
                RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "listIdentifiableLanguages");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");

        ResponseConverter<IdentifiableLanguages> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<IdentifiableLanguages>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * List identifiable languages.
     *
     * <p>Lists the languages that the service can identify. Returns the language code (for example,
     * `en` for English or `es` for Spanish) and name of each language.
     *
     * @return a {@link ServiceCall} with a response type of {@link IdentifiableLanguages}
     */
    public ServiceCall<IdentifiableLanguages> listIdentifiableLanguages() {
        return listIdentifiableLanguages(null);
    }

    /**
     * Identify language.
     *
     * <p>Identifies the language of the input text.
     *
     * @param identifyOptions the {@link IdentifyOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link IdentifiedLanguages}
     */
    public ServiceCall<IdentifiedLanguages> identify(IdentifyOptions identifyOptions) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(
                identifyOptions, "identifyOptions cannot be null");
        String[] pathSegments = {"v3/identify"};
        RequestBuilder builder =
                RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "identify");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");
        builder.bodyContent(identifyOptions.text(), "text/plain");
        ResponseConverter<IdentifiedLanguages> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<IdentifiedLanguages>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * List models.
     *
     * <p>Lists available translation models.
     *
     * @param listModelsOptions the {@link ListModelsOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link TranslationModels}
     */
    public ServiceCall<TranslationModels> listModels(ListModelsOptions listModelsOptions) {
        String[] pathSegments = {"v3/models"};
        RequestBuilder builder =
                RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "listModels");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");
        if (listModelsOptions != null) {
            if (listModelsOptions.source() != null) {
                builder.query("source", listModelsOptions.source());
            }
            if (listModelsOptions.target() != null) {
                builder.query("target", listModelsOptions.target());
            }
            if (listModelsOptions.xDefault() != null) {
                builder.query("default", String.valueOf(listModelsOptions.xDefault()));
            }
        }
        ResponseConverter<TranslationModels> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<TranslationModels>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * List models.
     *
     * <p>Lists available translation models.
     *
     * @return a {@link ServiceCall} with a response type of {@link TranslationModels}
     */
    public ServiceCall<TranslationModels> listModels() {
        return listModels(null);
    }

    /**
     * Create model.
     *
     * <p>Uploads Translation Memory eXchange (TMX) files to customize a translation model.
     *
     * <p>You can either customize a model with a forced glossary or with a corpus that contains
     * parallel sentences. To create a model that is customized with a parallel corpus <b>and</b> a
     * forced glossary, proceed in two steps: customize with a parallel corpus first and then
     * customize the resulting model with a glossary. Depending on the type of customization and the
     * size of the uploaded corpora, training can range from minutes for a glossary to several hours
     * for a large parallel corpus. You can upload a single forced glossary file and this file must be
     * less than <b>10 MB</b>. You can upload multiple parallel corpora tmx files. The cumulative file
     * size of all uploaded files is limited to <b>250 MB</b>. To successfully train with a parallel
     * corpus you must have at least <b>5,000 parallel sentences</b> in your corpus.
     *
     * <p>You can have a <b>maximum of 10 custom models per language pair</b>.
     *
     * @param createModelOptions the {@link CreateModelOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link TranslationModel}
     */
    public ServiceCall<TranslationModel> createModel(CreateModelOptions createModelOptions) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(
                createModelOptions, "createModelOptions cannot be null");
        com.ibm.cloud.sdk.core.util.Validator.isTrue(
                (createModelOptions.forcedGlossary() != null)
                        || (createModelOptions.parallelCorpus() != null),
                "At least one of forcedGlossary or parallelCorpus must be supplied.");
        String[] pathSegments = {"v3/models"};
        RequestBuilder builder =
                RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "createModel");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");
        builder.query("base_model_id", createModelOptions.baseModelId());
        if (createModelOptions.name() != null) {
            builder.query("name", createModelOptions.name());
        }
        MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
        multipartBuilder.setType(MultipartBody.FORM);
        if (createModelOptions.forcedGlossary() != null) {
            okhttp3.RequestBody forcedGlossaryBody =
                    RequestUtils.inputStreamBody(
                            createModelOptions.forcedGlossary(), "application/octet-stream");
            multipartBuilder.addFormDataPart("forced_glossary", "filename", forcedGlossaryBody);
        }
        if (createModelOptions.parallelCorpus() != null) {
            okhttp3.RequestBody parallelCorpusBody =
                    RequestUtils.inputStreamBody(
                            createModelOptions.parallelCorpus(), "application/octet-stream");
            multipartBuilder.addFormDataPart("parallel_corpus", "filename", parallelCorpusBody);
        }
        builder.body(multipartBuilder.build());
        ResponseConverter<TranslationModel> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<TranslationModel>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * Delete model.
     *
     * <p>Deletes a custom translation model.
     *
     * @param deleteModelOptions the {@link DeleteModelOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link DeleteModelResult}
     */
    public ServiceCall<DeleteModelResult> deleteModel(DeleteModelOptions deleteModelOptions) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(
                deleteModelOptions, "deleteModelOptions cannot be null");
        String[] pathSegments = {"v3/models"};
        String[] pathParameters = {deleteModelOptions.modelId()};
        RequestBuilder builder =
                RequestBuilder.delete(
                        RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "deleteModel");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");

        ResponseConverter<DeleteModelResult> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<DeleteModelResult>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }

    /**
     * Get model details.
     *
     * <p>Gets information about a translation model, including training status for custom models. Use
     * this API call to poll the status of your customization request. A successfully completed
     * training will have a status of `available`.
     *
     * @param getModelOptions the {@link GetModelOptions} containing the options for the call
     * @return a {@link ServiceCall} with a response type of {@link TranslationModel}
     */
    public ServiceCall<TranslationModel> getModel(GetModelOptions getModelOptions) {
        com.ibm.cloud.sdk.core.util.Validator.notNull(
                getModelOptions, "getModelOptions cannot be null");
        String[] pathSegments = {"v3/models"};
        String[] pathParameters = {getModelOptions.modelId()};
        RequestBuilder builder =
                RequestBuilder.get(
                        RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
        builder.query("version", versionDate);
        Map<String, String> sdkHeaders =
                SdkCommon.getSdkHeaders("language_translator", "v3", "getModel");
        for (Entry<String, String> header : sdkHeaders.entrySet()) {
            builder.header(header.getKey(), header.getValue());
        }
        builder.header("Accept", "application/json");

        ResponseConverter<TranslationModel> responseConverter =
                ResponseConverterUtils.getValue(
                        new com.google.gson.reflect.TypeToken<TranslationModel>() {
                        }.getType());
        return createServiceCall(builder.build(), responseConverter);
    }



    public static void main(String[] args) throws FileNotFoundException {

//        TranslationFrame.createCustomModel();
//        AvailableModels.displayListOfModels();
        TranslationFrame.displayMyModel();
//        TranslationFrame.displayBaseModel();
    }
}