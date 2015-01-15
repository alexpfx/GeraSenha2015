package br.com.alexpfx.api.password;

import static br.com.alexandrealessi.suseproject.api.utils.UtilsString.pickUp;
import static br.com.alexandrealessi.suseproject.api.utils.UtilsString.pickUpOneEach;
import static br.com.alexpfx.api.password.PasswordOptions.KEY_SYLLABIC_PASSWORD_PATTERN;
import static br.com.alexpfx.api.password.SyllabicPasswordPatternType.*;

/**
 * Created by alexandre on 13/01/15.
 */
public class SyllabicPasswordGenerator implements PasswordGenerator {
    @Override
    public String generatePassword(PasswordOptions options) {
        Integer passwordSize = options.<Integer>getOption(PasswordOptions.KEY_SIZE, 10);
        SyllabicPasswordPatternType[] pattern = options.<SyllabicPasswordPatternType[]>getOption(KEY_SYLLABIC_PASSWORD_PATTERN, new SyllabicPasswordPatternType[]{SYLLABLE, NUMBER});
        String consonants = CharGroup.CONSONANTS.toString();
        String vowels = CharGroup.VOWELS.toString();
        String numbers = CharGroup.NUMBERS.toString();
        String specialChars = CharGroup.SPECIAL_CHARS.toString();
        return createSyllabicPassword(passwordSize, consonants, vowels, numbers, specialChars, pattern);
    }

    private String createSyllabicPassword(int passwordSize, String consonants, String vowels, String numbers, String specialChars, SyllabicPasswordPatternType[] pattern) {
        validatePattern(pattern);
        validateSyllable(consonants, vowels);
        StringBuilder sb = new StringBuilder();
        int patternIndex = 0;
        do {
            if (patternIndex == pattern.length) {
                patternIndex = 0;
            }
            SyllabicPasswordPatternType type = pattern[patternIndex++];
            String s = getByType(type, consonants, vowels, numbers, specialChars);
            sb.append(s);
        } while (sb.length() < passwordSize);
        return sb.toString().substring(0, passwordSize);
    }

    private String getByType(SyllabicPasswordPatternType type, String consonants, String vowels, String numbers, String specialChars) {
        switch (type) {
            case SYLLABLE:
                return pickUpOneEach(new String[]{consonants, vowels});
            case NUMBER:
                return pickUp(numbers);
            case SPECIAL_CHAR:
                return pickUp(specialChars);
        }
        return "";
    }

    private void validateSyllable(String consonants, String vowels) {
        if (consonants == null || consonants == "" || vowels == null || vowels == "") {
            throw new IllegalArgumentException("consonants or vowels is null or empty");
        }
    }

    private void validatePattern(SyllabicPasswordPatternType[] pattern) {
        if (pattern == null || pattern.length == 0) {
            throw new IllegalArgumentException("Pattern is Null or Empty");
        }
        for (SyllabicPasswordPatternType p : pattern) {
            if (p == null)
                throw new IllegalArgumentException("Pattern is Null or Empty");
        }
    }

}
