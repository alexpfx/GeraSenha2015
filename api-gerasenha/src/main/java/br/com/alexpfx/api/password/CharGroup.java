package br.com.alexpfx.api.password;

import java.util.List;

/**
 * Created by alexandre on 13/01/15.
 */
public enum CharGroup {

    VOWELS("aeiouy"),
    CONSONANTS("bcdfghjklmnpqrstvxzw"),
    VOWELS_UPPER(VOWELS.toString().toUpperCase()),
    CONSONANTS_UPPER(CONSONANTS.toString().toUpperCase()),
    ALPHABET(VOWELS.toString() + CONSONANTS.toString()),
    ALPHABET_UPPER(VOWELS_UPPER.toString() + CONSONANTS_UPPER.toString()),
    NUMBERS("0123456789"),
    SPECIAL_CHARS("!@#$%&*()_+[]/;.,<>:?}{=-");


    private String group;


    private CharGroup(String group) {
        this.group = group;
    }

    public String toString() {
        return group;
    }

    public static String concatAndConvert(List<CharGroup> charGroups) {
        StringBuilder sb = new StringBuilder();
        for (CharGroup cg : charGroups) {
            sb.append(cg.toString());
        }
        return sb.toString();
    }
}
