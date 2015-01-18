package br.com.alexpfx.api.password;

import java.util.List;

/**
 * Created by alexandre on 15/01/15.
 */
public class SyllabicPasswordOptions implements PasswordOptions{


    private Integer size;
    private List<CharGroup> sortedPattern;

    private SyllabicPasswordOptions(Builder builder) {
        size = builder.size;
        sortedPattern = builder.sortedPattern;
    }

    public Integer getSize() {
        return size;
    }

    public List<CharGroup> getSortedPattern() {
        return sortedPattern;
    }

    public static final class Builder {
        private Integer size;
        private List<CharGroup> sortedPattern;

        public Builder() {
        }

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder sortedPattern(List<CharGroup> sortedPattern) {
            this.sortedPattern = sortedPattern;
            return this;
        }

        public SyllabicPasswordOptions build() {
            return new SyllabicPasswordOptions(this);
        }
    }
}
