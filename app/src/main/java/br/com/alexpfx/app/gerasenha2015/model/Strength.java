package br.com.alexpfx.app.gerasenha2015.model;

import java.math.BigInteger;

/**
 * Created by alexandre on 01/02/15.
 */
public class Strength {
    private final Double entropy;
    private final BigInteger averagueGuesses;

    private Strength(Builder builder) {
        entropy = builder.entropy;
        averagueGuesses = builder.averageGuesses;
    }

    public Double getEntropy() {
        return entropy;
    }

    public BigInteger getAveragueGuesses() {
        return averagueGuesses;
    }

    public static final class Builder {
        private Double entropy;
        private BigInteger averageGuesses;

        public Builder() {
        }

        public Builder entropy(Double entropy) {
            this.entropy = entropy;
            return this;
        }

        public Builder averageGuesses(BigInteger avgGuesses) {
            this.averageGuesses = avgGuesses;
            return this;
        }

        public Strength build() {
            return new Strength(this);
        }
    }
}
