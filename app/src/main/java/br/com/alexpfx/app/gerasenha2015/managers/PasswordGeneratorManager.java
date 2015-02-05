package br.com.alexpfx.app.gerasenha2015.managers;

import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;

/**
 * Created by alexandre on 01/02/15.
 */
public abstract class PasswordGeneratorManager {
    private final PasswordGenerator generator;
    private PasswordOptions options;

    protected PasswordGeneratorManager(PasswordGenerator generator) {
        this.generator = generator;
    }

    public final void setOptions(PasswordOptions options) {
        this.options = options;
    }

    public final String generate() {
        if (options == null) {
            options = getDefaultOptions();
        }
        generator.setPasswordOptions(options);
        return generator.generatePassword();
    }

    public abstract PasswordOptions getDefaultOptions();


}
