package br.com.alexpfx.app.gerasenha2015.managers;

import java.io.Reader;

import br.com.alexpfx.supersenha.lib.ConcatenatedPasswordGenerator;
import br.com.alexpfx.supersenha.lib.ConcatenatedPasswordOptions;
import br.com.alexpfx.supersenha.lib.PasswordOptions;

/**
 * Created by alexandre on 04/02/15.
 */
public class ConcatenatedPasswordManager extends PasswordGeneratorManager {


    public ConcatenatedPasswordManager(Reader reader) {
        super(new ConcatenatedPasswordGenerator(reader));
    }

    @Override
    public PasswordOptions getDefaultOptions() {
        return new ConcatenatedPasswordOptions.Builder().numberOfWords(3).separator("@").maxSize(60).build();
    }
}
