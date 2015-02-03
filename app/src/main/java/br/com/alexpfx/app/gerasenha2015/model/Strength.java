package br.com.alexpfx.app.gerasenha2015.model;

/**
 * Created by alexandre on 01/02/15.
 */
public class Strength {
    private final Double entropy;
    private final Integer combinations;

    private Strength(Builder builder) {
        entropy = builder.entropy;
        combinations = builder.combinations;
    }


    public static final class Builder {
        private Double entropy;
        private Integer combinations;

        public Builder() {
        }

        public Builder entropy(Double entropy) {
            this.entropy = entropy;
            return this;
        }

        public Builder combinations(Integer combinations) {
            this.combinations = combinations;
            return this;
        }

        public Strength build() {
            return new Strength(this);
        }
    }
}
