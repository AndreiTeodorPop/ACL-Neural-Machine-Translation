package com.ibm.watson.language_translator.v3.app;

import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.*;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

/** The application interface */
public class TranslationFrame {

    /** Constants for authentication */
    private static final String VERSION = "2018-05-01";
    private static final String API_KEY = "ITKqbUWsH65DKlxdpXYOwZhypyzKVSVeaQvRy0ibgFt6";
    private static final String SERVICE_URL = "https://api.eu-gb.language-translator.watson.cloud.ibm.com/instances/8348e1a2-2306-4ddb-b020-e425d62cd4f8";

    /** Id of the model created */
    private static final String MODEL_ID = "62d1ea6c-4f06-4c7a-a34a-4c5a3e69af7f";

    /** Interface window */
    private static final ImageIcon rus = new ImageIcon("C:\\Users\\a magic potato\\Desktop\\Java Apps\\LanguageTranslator\\src\\main\\resources\\russian.gif");
    private static final ImageIcon us = new ImageIcon("C:\\Users\\a magic potato\\Desktop\\Java Apps\\LanguageTranslator\\src\\main\\resources\\america.gif");
    private static JFrame frame;
    private static String s;


    /**
     * Display a application interface for translation process using created model
     */
    public static void displayMyModel() {
        IamAuthenticator authenticator = new IamAuthenticator(API_KEY);
        LanguageTranslator languageTranslator = new LanguageTranslator(VERSION, authenticator);
        languageTranslator.setServiceUrl(SERVICE_URL);
        frame = new JFrame();
        s = (String) JOptionPane.showInputDialog(frame, "Input text for translation: ",
                "English - Russian Translator", JOptionPane.PLAIN_MESSAGE, us, null, "");
        try {
            TranslateOptions translateOptions = new TranslateOptions.Builder()
                    .addText(s)
                    .modelId("en-ru")
                    .build();
            TranslationResult translationResult = languageTranslator.translate(translateOptions).execute().getResult();
            JOptionPane.showMessageDialog(frame, "Text for translation:  " + "\"" + s + "\"" + "\n" + translationResult, "Result", JOptionPane.PLAIN_MESSAGE, rus);
        } catch (BadRequestException e) {
            int input = JOptionPane.showOptionDialog(null, "Text cannot be null!", "Translation Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            if(input == JOptionPane.OK_OPTION)
            {
                displayMyModel();
            }
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    /**
     * Display a application interface for translation process using base model
     */
    public static void displayBaseModel() {
        IamAuthenticator authenticator = new IamAuthenticator(API_KEY);
        LanguageTranslator languageTranslator = new LanguageTranslator(VERSION, authenticator);
        languageTranslator.setServiceUrl(SERVICE_URL);
        frame = new JFrame();
        s = (String) JOptionPane.showInputDialog(frame, "Input text for translation: ",
                "English - Russian Translator", JOptionPane.PLAIN_MESSAGE, us, null, "");
        try {
            TranslateOptions translateOptions = new TranslateOptions.Builder()
//                .addText("Я больше не могу это выносить.")
                    .addText(s)
                    .modelId(MODEL_ID)
                    .build();
            TranslationResult translationResult = languageTranslator.translate(translateOptions).execute().getResult();
            JOptionPane.showMessageDialog(frame, "Text for translation:  " + "\"" + s + "\"" + "\n" + translationResult, "Result", JOptionPane.PLAIN_MESSAGE, rus);
        } catch (BadRequestException e) {
            int input = JOptionPane.showOptionDialog(null, "Text cannot be null!", "Translation Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
            if(input == JOptionPane.OK_OPTION)
            {
                displayMyModel();
            }
        } catch (IllegalArgumentException e) {
            return;
        }
    }

    public static void createCustomModel() throws FileNotFoundException {
        IamAuthenticator authenticator = new IamAuthenticator(API_KEY);
        LanguageTranslator languageTranslator = new LanguageTranslator(VERSION, authenticator);
        languageTranslator.setServiceUrl(SERVICE_URL);

        File parallelCorpus = new File("C:\\Users\\a magic potato\\Desktop\\Java Apps\\LanguageTranslator\\src\\main\\java\\com" +
                "\\ibm\\watson\\language_translator\\v3\\documents\\rus-eng.tmx");
        CreateModelOptions createModelOptions = new CreateModelOptions.Builder()
                .baseModelId("en-ru")
                .name("custom-en-ru")
                .parallelCorpus(parallelCorpus)
                .build();

        TranslationModel model = languageTranslator.createModel(createModelOptions)
                .execute().getResult();

        System.out.println(model);
    }

}