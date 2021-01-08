package com.ibm.watson.language_translator.v3.model;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;
import java.util.List;

/** TranslationResult. */
public class TranslationResult extends GenericModel {

    @SerializedName("word_count")
    protected Long wordCount;

    @SerializedName("character_count")
    protected Long characterCount;
//
//    @SerializedName("detected_language")
//    protected String detectedLanguage;
//
//    @SerializedName("detected_language_confidence")
//    protected Double detectedLanguageConfidence;

    protected List<Translation> translations;

    protected Translation translation;

    /**
     * Gets the wordCount.
     *
     * <p>An estimate of the number of words in the input text.
     *
     * @return the wordCount
     */
    public Long getWordCount() {
        return wordCount;
    }

    /**
     * Gets the characterCount.
     *
     * <p>Number of characters in the input text.
     *
     * @return the characterCount
     */
    public Long getCharacterCount() {
        return characterCount;
    }

    /**
     * Gets the detectedLanguage.
     *
     * <p>The language code of the source text if the source language was automatically detected.
     *
     * @return the detectedLanguage
     */
//    public String getDetectedLanguage() {
//        return detectedLanguage;
//    }

    /**
     * Gets the detectedLanguageConfidence.
     *
     * <p>A score between 0 and 1 indicating the confidence of source language detection. A higher
     * value indicates greater confidence. This is returned only when the service automatically
     * detects the source language.
     *
     * @return the detectedLanguageConfidence
     */
//    public Double getDetectedLanguageConfidence() {
//        return detectedLanguageConfidence;
//    }

    /**
     * Gets the translations.
     *
     * <p>List of translation output in UTF-8, corresponding to the input text entries.
     *
     * @return the translations
     */
    public List<Translation> getTranslations() {
        return translations;
    }

    public Translation getTranslation() {
        return translation;
    }
}