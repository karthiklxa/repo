package framework.util.common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

import static com.jayway.jsonpath.internal.JsonFormatter.prettyPrint;

/**
 * Created by karthik.m on 6/14/2018.
 */
public class Utils {
    private static WebDriver driver;

    public static Map jsonToMap(String json) {
        return new Gson().fromJson(json, Map.class);
    }

    public static <T> T clone(T t) {
        Gson gson = new Gson();
        String json = gson.toJson(t);
        return (T) gson.fromJson(json, t.getClass());
    }

    public static <T> List<T> list(T... values) {
        return Arrays.asList(values);
    }

    public static <T> List<T> list(int numberOfElements, T value) {
        ArrayList<T> list = new ArrayList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(clone(value));
        }
        return list;
    }

    public static String json(String json, JsonPathOperation... operations) {
        DocumentContext context = JsonPath.parse(json);
        for (JsonPathOperation operation : operations) {
            context = operation.perform(context);
        }
        return prettyPrint(context.jsonString());
    }

    public static void setValueUsingJs(WebElement elem, String value) {
        driver = DriverFactory.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + value + "';", elem);
    }



    /**
     *  scroll To Bottom Of Page
     */
    public static void scrollToBottomOfPage() {
        driver = DriverFactory.getDriver();
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void checkElementIsEditable(String elemValue, ExtentTest t1) {
        try {
            WebElement check = DriverFactory.getDriver().findElement(By.xpath(elemValue));
            t1.info("Element found");
            if (!check.getTagName().contains("label")) {
                if (check.getAttribute("readonly").contains("true")) {
                    t1.pass("Element have readonly Attribute ");
                } else {
                    t1.fail("Element dose not have readonly Attribute ");
                }
            } else {
                t1.info("Element is Label ");
            }

        } catch (Exception e) {
            t1.fail("Element is Not Verified ");
        }
    }


    /**
     * put Thread Sleep
     * @param miliSecond
     */
    public static void putThreadSleep(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException e) {
            System.err.println("Interrupted Exception occurred :" + e);
        }catch (Exception e) {
            System.err.println("Exception occurred :" + e);
        }
    }


    public static String removeExtraSpace(String text){
        return new String(text).trim().replaceAll("\\s{2,}", " ");
    }


}
