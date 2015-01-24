package br.com.alexpfx.app.gerasenha2015;

import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;

/**
 * Created by alexandre on 19/01/15.
 */
public class SenhaMenuItem {

    private final PasswordGenerator<PasswordOptions> generator;
    private final String title;
    private final String subTitle;
    private final int itemIconImgSrc;
    private final ColorTriade colors;


    public PasswordGenerator<PasswordOptions> getGenerator() {
        return generator;
    }

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getItemIconImgSrc() {
        return itemIconImgSrc;
    }

    public ColorTriade getColors() {
        return colors;
    }

    private SenhaMenuItem(Builder builder) {
        generator = builder.generator;
        title = builder.title;
        subTitle = builder.subTitle;
        itemIconImgSrc = builder.itemIconImgSrc;
        colors = builder.colors;
    }


    public String gerarSenha() {
        return generator.generatePassword();
    }

    public static final class Builder {
        private PasswordGenerator<PasswordOptions> generator;
        private String title;
        private String subTitle;
        private int itemIconImgSrc;
        private ColorTriade colors;

        public Builder() {
        }

        public Builder generator(PasswordGenerator generator) {
            this.generator = generator;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder itemIconImgSrc(int itemIconImgSrc) {
            this.itemIconImgSrc = itemIconImgSrc;
            return this;
        }

        public Builder colors(ColorTriade colors) {
            this.colors = colors;
            return this;
        }

        public SenhaMenuItem build() {
            return new SenhaMenuItem(this);
        }
    }
}
