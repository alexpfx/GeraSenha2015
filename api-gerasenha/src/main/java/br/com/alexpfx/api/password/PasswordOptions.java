package br.com.alexpfx.api.password;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexandre on 13/01/15.
 */
public class PasswordOptions <T extends Object>{
    public static final String KEY_SIZE = "KEY_SIZE";
    public static final String KEY_CHAR_GROUP_ARRAY = "KEY_CHAR_GROUP_ARRAY";
    public static final String KEY_SYLLABIC_PASSWORD_PATTERN = "KEY_SYLLABIC_PASSWORD_PATTERN";


    private Map<String, T> parameters = new HashMap<String, T>();


    public void put(String key, T value) {
        parameters.put(key, value);
    }

    public <E extends T> E getOption(String key, E defaultIfNull) {
        T value = parameters.get(key);
        return (value != null) ? (E) value : defaultIfNull;
    }

}
