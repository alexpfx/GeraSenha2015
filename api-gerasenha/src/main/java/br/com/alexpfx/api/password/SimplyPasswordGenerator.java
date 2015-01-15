package br.com.alexpfx.api.password;

import java.util.Arrays;
import java.util.List;

import br.com.alexpfx.api.password.br.com.alexpfx.utils.RandomUtils;

/**
 * Created by alexandre on 13/01/15.
 */
public class SimplyPasswordGenerator implements PasswordGenerator {
    private static final Integer DEFAULT_PASSWORD_SIZE = 10;
    private static final List<CharGroup> DEFAULT_CHAR_GROUP_ARRAY = Arrays.asList(new CharGroup[]{CharGroup.ALPHABET});

    @Override
    public String generatePassword(PasswordOptions options) {
        List<CharGroup> charsGroups = options.<List<CharGroup>>getOption(PasswordOptions.KEY_CHAR_GROUP_ARRAY, DEFAULT_CHAR_GROUP_ARRAY);
        String charList = CharGroup.concatAndConvert(charsGroups);
        Integer passwordSize = options.<Integer>getOption(PasswordOptions.KEY_SIZE, DEFAULT_PASSWORD_SIZE);
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordSize; i++) {
//            password.append(RandomUtils.getOneCharacterOf(charList));
        }
        return password.toString();
    }
}
