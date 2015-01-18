package br.com.alexpfx.api.password;

import java.util.List;

/**
 * Created by alexandre on 15/01/15.
 */
public class SimplyPasswordOptions implements PasswordOptions {

    private Integer size;
    private List<CharGroup> charGroups;

    private SimplyPasswordOptions(Builder builder) {
        size = builder.size;
        charGroups = builder.charGroups;
    }

    public Integer getSize() {
        return size;
    }

    public List<CharGroup> getCharGroups() {
        return charGroups;
    }

    public static final class Builder {
        private Integer size;
        private List<CharGroup> charGroups;

        public Builder() {
        }

        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder charGroups(List<CharGroup> charGroups) {
            this.charGroups = charGroups;
            return this;
        }

        public SimplyPasswordOptions build() {
            return new SimplyPasswordOptions(this);
        }
    }
}
