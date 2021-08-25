package by.it.academy.dao.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConnectionPool {
    public static final String PATH_TO_DB_PROPERTIES = "src/main/resources/db.properties";


    ConnectionPool(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(PATH_TO_DB_PROPERTIES));
        } catch (IOException e) {
            //log
            e.printStackTrace();
        }
    }
}
