package br.com.alexpfx.app.gerasenha2015;

import br.com.alexpfx.supersenha.lib.ConcatenatedPasswordOptions;

/**
 * Created by alexandre on 26/01/15.
 */
public class ConcatenatedPasswordOptionsViewModel {

    private String tags;
    private boolean includeUpper;
    private String nrWords;
    private String maxLength;
    private String separators;

    private ConcatenatedPasswordOptionsViewModel(Builder builder) {
        tags = builder.tags;
        includeUpper = builder.includeUpper;
        nrWords = builder.nrWords;
        maxLength = builder.maxLength;
        separators = builder.separators;
    }

    public String getTags() {
        return tags;
    }

    public boolean isIncludeUpper() {
        return includeUpper;
    }

    public String getNrWords() {
        return nrWords;
    }

    public String getMaxLength() {
        return maxLength;
    }

    public String getSeparators() {
        return separators;
    }

    public static final class Builder {
        private String tags = "";
        private boolean includeUpper = false;
        private String nrWords = "3";
        private String maxLength = "60";
        private String separators = "";

        public Builder() {
        }

        public Builder tags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder includeUpper(boolean includeUpper) {
            this.includeUpper = includeUpper;
            return this;
        }

        public Builder nrWords(String nrWords) {
            this.nrWords = nrWords;
            return this;
        }

        public Builder maxLength(String maxLength) {
            this.maxLength = maxLength;
            return this;
        }

        public Builder separators(String separators) {
            this.separators = separators;
            return this;
        }

        public ConcatenatedPasswordOptionsViewModel build() {
            return new ConcatenatedPasswordOptionsViewModel(this);
        }
    }
}
