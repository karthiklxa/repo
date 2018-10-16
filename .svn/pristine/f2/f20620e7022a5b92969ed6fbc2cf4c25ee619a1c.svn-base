package framework.util.propertyManagement;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class MessageReader {
    public static final String PAYPLUS_LOCALE_LANGUAGE_PROPERTY = "money.locale.language";
    public static final String PAYPLUS_LOCALE_COUNTRY_PROPERTY = "money.locale.country";
    private static final PayPlusProperties mfsTestProperties = PayPlusProperties.getInstance();
    private static String language = mfsTestProperties.getProperty(PAYPLUS_LOCALE_LANGUAGE_PROPERTY, "en");
    private static String country = mfsTestProperties.getProperty(PAYPLUS_LOCALE_COUNTRY_PROPERTY, "US");

    public static String validateMessage(String ActualMessage, String Code, Object... params) {
        String message = getMessage(Code, null);
        if (params != null && params.length != 0) {
            message = MessageFormat.format(message, params);
        }

        assertEquals(ActualMessage, message);
        return message;
    }

    /**
     * Get Dynamic message
     *
     * @param Code
     * @param params
     * @return
     */
    public static String getDynamicMessage(String Code, Object... params) {
        String message = getMessage(Code, null);
        return MessageFormat.format(message, params);
    }

    private static ResourceBundle resourceBundle = null;

    public static boolean loadResourceBundle(Locale locale) {
        if (locale == null) {
            locale = new Locale(language, country);
        }
        try {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static String getMessage(String code, Locale locale) {
        if (resourceBundle == null || locale != null) {
            if (!loadResourceBundle(locale))
                return "";
        }

        String str = "";
        try {
            str = resourceBundle.getString(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.trim();
    }

    public static void validateMessageContains(String ActualMessage, String Code) {
        String message = getMessage(Code, null);
        assertTrue(ActualMessage.contains(message));
    }
}
