package framework.util.propertyManagement;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by karthik.m on 6/4/2018.
 */
public class PayPlusProperties {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayPlusProperties.class);
    private static final PayPlusProperties ME = new PayPlusProperties();
    private static final int INVALID_VALUE = Integer.MIN_VALUE;
    public static final String PROPERTIES_FILE = "payPlus.properties";
    public static final String FILE_NAME_PROPERTY = "payPlus.propertiesFile";
    private Properties properties = new Properties();

    private void loadProperties(InputStream propertiesStream) {
        try {
            properties.load(propertiesStream);
            setSystemProperties();
        } catch (Exception e) {
            LOGGER.error("Failed to load properties file", e);
        }
    }

    private void setSystemProperties() {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String name = (String) propertyNames.nextElement();
            String systemValue = System.getProperty(name);
            if (StringUtils.isBlank(systemValue)) {
                setProperty(name, StringUtils.trim(properties.getProperty(name)));
            } else {
                properties.put(name, systemValue);
            }
        }
    }

    public String getProperty(String name) {
        return properties.getProperty(name);
    }

    public String getProperty(String name, String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }

    public int getIntProperty(String name) {
        return getIntProperty(name, INVALID_VALUE);
    }

    public long getLongProperty(String name) {
        return getLongProperty(name, INVALID_VALUE);
    }

    public boolean getBooleanProperty(String name) {
        return getBooleanProperty(name, false);
    }

    public int getIntProperty(String name, int defaultValue) {
        try {
            return Integer.parseInt(getProperty(name, "" + defaultValue));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public long getLongProperty(String name, long defaultValue) {
        try {
            return Long.parseLong(getProperty(name, "" + defaultValue));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean getBooleanProperty(String name, boolean defaultValue) {
        try {
            return Boolean.parseBoolean(getProperty(name, "" + defaultValue));
        } catch (Exception e) {
            return false;
        }
    }

    private InputStream getPropertiesFile() {
        String propertyFile = System.getProperty(FILE_NAME_PROPERTY, PROPERTIES_FILE);
        return this.getClass().getResourceAsStream("/" + propertyFile);
    }

    public static final PayPlusProperties getInstance() {
        PayPlusProperties me = ME;
        me.init();
        return me;
    }

    public void setProperty(String name, String value) {
        properties.setProperty(name, value);
        System.setProperty(name, value);
    }

    public void setPropertyIfAbsent(String name, String value) {
        if (properties.getProperty(name) != null || System.getProperty(name) != null) {
            return;
        }
        setProperty(name, value);
    }


    public void clear() {
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            System.clearProperty((String) propertyNames.nextElement());
        }
        properties.clear();
    }

    public void init() {
        loadProperties(getPropertiesFile());
    }

}
