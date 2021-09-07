package by.it.academy.dao.config;

import java.util.ResourceBundle;

public class DBResourceManager {

    private final static String DB_RESOURCE = "resources.db";

    private final static DBResourceManager instance = new DBResourceManager();

    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(DB_RESOURCE);

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) {
        return resourceBundle.getString(key);
    }
}
