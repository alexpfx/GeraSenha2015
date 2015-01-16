package br.com.alexpfx.api.password;

import java.util.List;

/**
 * Created by alexandre on 15/01/15.
 */
public class SimplyPasswordOptions extends CommonPasswordOptions{

    private List<CharGroup> charGroups;

    public SimplyPasswordOptions(Integer size, List<CharGroup> charGroups) {
        super(size);
        this.charGroups = charGroups;
    }



}
