package br.com.alexpfx.app.gerasenha2015.managers;

import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;
import br.com.alexpfx.supersenha.lib.SimplyPasswordGenerator;
import br.com.alexpfx.supersenha.lib.SimplyPasswordOptions;

/**
 * Created by alexandre on 04/02/15.
 */
public class SimplyPasswordGeneratorManager extends PasswordGeneratorManager{
    public SimplyPasswordGeneratorManager() {
        super(new SimplyPasswordGenerator());
    }

    @Override
    public PasswordOptions getDefaultOptions() {
        return new SimplyPasswordOptions.Builder ().alpha(true).alphaUpperCase(true).numbers(true).specialChars(false).size(12).build();
    }
}
