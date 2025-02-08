package org.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Message {

    private static Properties properties = new Properties();

    // Static block to load properties at class initialization
    static {
        try (InputStream inputStream = Message.class.getClassLoader().getResourceAsStream("message.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                System.out.println("Property file 'message.properties' not found in the classpath.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get message by key
    public static String getMessage(String key) {
        return properties.getProperty(key, "Message not found for key: " + key);
    }
}
