package br.com.alexpfx.api.password;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.alexandrealessi.suseproject.api.services.*;
import br.com.alexandrealessi.suseproject.api.services.SyllabicPasswordGenerator;

/**
 * Created by alexandre on 15/01/15.
 */
public class SyllabicPasswordOptions extends CommonPasswordOptions {


    private List<SyllabicPasswordPatternType> orderedPattern;

    public SyllabicPasswordOptions(Integer size) {
        super(size);
    }

    public void setOrderedPattern(List<SyllabicPasswordPatternType> orderedPattern) {
        this.orderedPattern = orderedPattern;
    }

    public List<SyllabicPasswordPatternType> getOrderedPattern() {
        return orderedPattern;
    }
}
