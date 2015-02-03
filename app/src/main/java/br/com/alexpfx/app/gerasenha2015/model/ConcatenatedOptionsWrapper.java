package br.com.alexpfx.app.gerasenha2015.model;

import br.com.alexpfx.supersenha.lib.ConcatenatedPasswordOptions;
import br.com.alexpfx.supersenha.lib.PasswordOptions;
import br.com.alexpfx.supersenha.lib.WordFilter;

/**
 * Created by alexandre on 02/02/15.
 */
public class ConcatenatedOptionsWrapper implements IPasswordOptionsWrapper{
    private boolean includeUpper;
    private Integer nrWords;
    private Integer maxLength;
    private String separators;

    private ConcatenatedOptionsWrapper(Builder builder) {
        includeUpper = builder.includeUpper;
        nrWords = builder.nrWords;
        maxLength = builder.maxLength;
        separators = builder.separators;
    }

    @Override
    public PasswordOptions getPasswordOptions() {
        //TODO tratar includeUpper quando estiver disponivel na API.
        return new ConcatenatedPasswordOptions.Builder().maxSize(maxLength).separator(separators).numberOfWords(nrWords).build();
    }


    public static final class Builder {
        private boolean includeUpper;
        private Integer nrWords;
        private Integer maxLength;
        private String separators;

        public Builder() {
        }

        public Builder includeUpper(boolean includeUpper) {
            this.includeUpper = includeUpper;
            return this;
        }

        public Builder nrWords(Integer nrWords) {
            this.nrWords = nrWords;
            return this;
        }

        public Builder maxLength(Integer maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder separators(String separators) {
            this.separators = separators;
            return this;
        }

        public ConcatenatedOptionsWrapper build() {
            return new ConcatenatedOptionsWrapper(this);
        }
    }
}
