package br.com.alexpfx.app.gerasenha2015.model;

import java.util.Date;
import java.util.List;

/**
 * Created by alexandre on 01/02/15.
 */
public class Password {
    private final String password;
    private final Strength strength;
    private final List<String> tags;
    private final Date dateTime;

    private Password(Builder builder) {
        password = builder.password;
        strength = builder.strength;
        tags = builder.tags;
        dateTime = builder.dateTime;
    }


    public String getPassword() {
        return password;
    }

    public Strength getStrength() {
        return strength;
    }

    public List<String> getTags() {
        return tags;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public static final class Builder {
        private String password;
        private Strength strength;
        private List<String> tags;
        private Date dateTime;

        public Builder() {
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder strength(Strength strength) {
            this.strength = strength;
            return this;
        }

        public Builder tags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder dateTime(Date dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Password build() {
            return new Password(this);
        }
    }
}
