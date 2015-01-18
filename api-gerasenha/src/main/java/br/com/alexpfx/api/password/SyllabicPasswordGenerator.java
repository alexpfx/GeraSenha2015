package br.com.alexpfx.api.password;

import java.util.List;

import br.com.alexpfx.api.password.br.com.alexpfx.utils.RandomUtils;

/**
 * Created by alexandre on 13/01/15.
 */
public class SyllabicPasswordGenerator implements PasswordGenerator<SyllabicPasswordOptions> {

    @Override
    public String generatePassword(SyllabicPasswordOptions options) {
        Integer passwordSize = options.getSize();
        List<CharGroup> sortedPattern = options.getSortedPattern();
        return createSyllabicPassword(passwordSize, sortedPattern);
    }

    private String createSyllabicPassword(int passwordSize, List<CharGroup> pattern) {
        validatePattern(pattern);
        StringBuilder sb = new StringBuilder();
        int patternIndex = 0;
        do {
            if (patternIndex == pattern.size()) {
                patternIndex = 0;
            }
            CharGroup charGroup = pattern.get(patternIndex++);
            sb.append(RandomUtils.getOneCharacterOf(charGroup.toString()));
        } while (sb.length() < passwordSize);
        return sb.toString().substring(0, passwordSize);
    }


    private void validatePattern(List<CharGroup> pattern) {
        if (pattern == null || pattern.size() == 0) {
            throw new IllegalArgumentException("Pattern is Null or Empty");
        }
        for (CharGroup p : pattern) {
            if (p == null)
                throw new IllegalArgumentException("Pattern is Null or Empty");
        }
    }

}
