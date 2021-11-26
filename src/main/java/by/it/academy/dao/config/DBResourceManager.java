package by.it.academy.dao.config;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final String DB_RESOURCE="db_config";
    private static final DBResourceManager instance = new DBResourceManager();

    public static DBResourceManager getInstance() {
        return instance;
    }

    private ResourceBundle resourceBundle=ResourceBundle.getBundle(DB_RESOURCE);

    public String getKey(String key) {
        return resourceBundle.getString(key);
    }
}
