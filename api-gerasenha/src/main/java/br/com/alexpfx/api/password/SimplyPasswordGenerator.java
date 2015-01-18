package br.com.alexpfx.api.password;

import java.util.List;

import br.com.alexpfx.api.password.br.com.alexpfx.utils.RandomUtils;

/**
 * Created by alexandre on 13/01/15.
 */
public class SimplyPasswordGenerator implements PasswordGenerator<SimplyPasswordOptions> {

    @Override
    public String generatePassword(SimplyPasswordOptions options) {
        Integer size = options.getSize();
        List<CharGroup> charGroups = options.getCharGroups();

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < size; i++) {
            password.append(RandomUtils.getOneCharacterOf(CharGroup.concatAndConvert(charGroups)));
        }
        return password.toString();
    }


}
