package br.com.alexpfx.app.gerasenha2015.managers;

import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;
import br.com.alexpfx.supersenha.lib.SimplyPasswordOptions;
import br.com.alexpfx.supersenha.lib.SyllabicPasswordGenerator;

/**
 * Created by alexandre on 04/02/15.
 */
public class SyllabicPasswordGeneratorManager extends PasswordGeneratorManager {
    public SyllabicPasswordGeneratorManager() {
        super(new SyllabicPasswordGenerator());
    }

    @Override
    public PasswordOptions getDefaultOptions() {
        return new SimplyPasswordOptions.Builder ().alpha(true).alphaUpperCase(true).numbers(true).specialChars(false).size(12).build();
    }
}
