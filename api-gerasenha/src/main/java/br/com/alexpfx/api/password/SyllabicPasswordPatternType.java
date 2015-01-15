package br.com.alexpfx.api.password;

/**
 * Created by alexandre on 13/01/15.
 */
public enum SyllabicPasswordPatternType {
    SYLLABLE(0), NUMBER(1), SPECIAL_CHAR(2);
    private int code;

    private SyllabicPasswordPatternType(int code) {
        this.code = code;
    }
}

