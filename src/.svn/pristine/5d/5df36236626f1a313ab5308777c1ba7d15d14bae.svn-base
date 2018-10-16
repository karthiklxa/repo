package framework.util.Encryption;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Created by karthik.m on 9/13/2018.
 */
public class CurrencySymbol
{
    public static String getCurrencySymbol(String currencyDetails) {
        try {
            Gson gson = new Gson();
            JSONObject json = new JSONObject(currencyDetails);
            /**
             * Java only understands unicode format when it's inside a Java source file and the compiler      handles it
             *  parses it and converts it to a single character. If you read the value from somewhere, it won't be interpreted
             *  as a unicode character except in a .properties file, which is a bit special.
             *  You would have to strip off the leading \\u", parse just the "XXXX" into an int using Integer.parseInt("XXXX", 16),
             *  and then cast int to a char, which you can then put into a String.
             *
             **/
            if (null != currencyDetails) {
                //String resp = (String) json.get("currencyDetails");
                JSONObject json1 = (JSONObject) json.get("currencyDetails");
                String symbolNative= (String) json1.get("symbol");

                if (symbolNative.contains("\\u")) {
                    String unicodeString = symbolNative.substring(symbolNative.lastIndexOf("\\u")).replace("\\u", "");
                    int unicodeInteger = Integer.parseInt(unicodeString, 16);
                    char unicodeChar = (char) unicodeInteger;
                    return String.valueOf(unicodeChar);

                } else {
                    return symbolNative;
                }
            }
        } catch (JsonParseException e) {
//            logger.error("JSON parse exception in getCurrencySymbol method in PayAction class", e);
        }
        return null;

    }

}
