package br.com.alexpfx.api.password;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alexandre on 13/01/15.
 */
public abstract class CommonPasswordOptions {

    public CommonPasswordOptions(Integer size) {
        this.size = size;
    }

    private Integer size;

}
