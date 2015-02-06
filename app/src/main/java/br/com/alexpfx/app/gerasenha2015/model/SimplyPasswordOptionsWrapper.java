package br.com.alexpfx.app.gerasenha2015.model;

import br.com.alexpfx.supersenha.lib.PasswordOptions;
import br.com.alexpfx.supersenha.lib.SimplyPasswordOptions;

/**
 * Created by alexandre on 05/02/15.
 */
public class SimplyPasswordOptionsWrapper implements IPasswordOptionsWrapper {
    private Integer passwordLength;
    private boolean alpha;
    private boolean alphaUpperCase;
    private boolean numbers;
    private boolean specialChars;

    private SimplyPasswordOptionsWrapper(Builder builder) {
        passwordLength = builder.passwordLength;
        alpha = builder.alpha;
        alphaUpperCase = builder.alphaUpperCase;
        numbers = builder.numbers;
        specialChars = builder.specialChars;
    }

    @Override
    public PasswordOptions getPasswordOptions() {
        return new SimplyPasswordOptions.Builder().size(passwordLength).alpha(alpha).alphaUpperCase(alphaUpperCase).numbers(numbers).specialChars(specialChars).build();
    }


    public static final class Builder {
        private Integer passwordLength;
        private boolean alpha;
        private boolean alphaUpperCase;
        private boolean numbers;
        private boolean specialChars;

        public Builder() {
        }

        public Builder passwordLength(Integer passwordLength) {
            this.passwordLength = passwordLength;
            return this;
        }

        public Builder alpha(boolean alpha) {
            this.alpha = alpha;
            return this;
        }

        public Builder alphaUpperCase(boolean alphaUpperCase) {
            this.alphaUpperCase = alphaUpperCase;
            return this;
        }

        public Builder numbers(boolean numbers) {
            this.numbers = numbers;
            return this;
        }

        public Builder specialChars(boolean specialChars) {
            this.specialChars = specialChars;
            return this;
        }

        public SimplyPasswordOptionsWrapper build() {
            return new SimplyPasswordOptionsWrapper(this);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
