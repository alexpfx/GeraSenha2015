package br.com.alexpfx.app.gerasenha2015.managers;

import java.util.Date;

import br.com.alexpfx.app.gerasenha2015.model.Password;
import br.com.alexpfx.app.gerasenha2015.model.Strength;
import br.com.alexpfx.supersenha.lib.NISTStrengthCalculator;
import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;
import br.com.alexpfx.supersenha.lib.PasswordStrengthCalculator;

/**
 * Created by alexandre on 01/02/15.
 */
public abstract class PasswordGeneratorManager {
    private final PasswordGenerator generator;
    private PasswordOptions options;
    private PasswordStrengthCalculator strengthCalculator;

    protected PasswordGeneratorManager(PasswordGenerator generator) {
        this.generator = generator;
        strengthCalculator = new NISTStrengthCalculator();
    }

    public final void setOptions(PasswordOptions options) {
        this.options = options;
    }

    private String generate() {
        if (options == null) {
            options = getDefaultOptions();
        }
        generator.setPasswordOptions(options);
        return generator.generatePassword();
    }

    public Password generatePassword (){
        String ps = generate();
        double entropy = strengthCalculator.calculateEntropy(ps);
        Strength strength = new Strength.Builder().entropy(entropy).averageGuesses(strengthCalculator.calculateNumberGuesses(entropy)).build();
        Password p = new Password.Builder().dateTime(new Date()).password(ps).strength(strength).build();
        return p;
    }

    public abstract PasswordOptions getDefaultOptions();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

}
