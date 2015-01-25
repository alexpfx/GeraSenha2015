package br.com.alexpfx.app.gerasenha2015;


import android.content.Context;
import android.support.v4.app.DialogFragment;

import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;

/**
 * Created by alexandre on 19/01/15.
 */
public class SenhaMenuItem {

    private final PasswordGenerator<PasswordOptions> generator;
    private final DialogFragment dialogFragment;
    private final String title;
    private final String subTitle;
    private final int itemIconImgSrc;
    private Context context;

    private SenhaMenuItem(Builder builder) {
        generator = builder.generator;
        dialogFragment = builder.dialogFragment;
        title = builder.title;
        subTitle = builder.subTitle;
        itemIconImgSrc = builder.itemIconImgSrc;
    }

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

    public DialogFragment getDialogFragment() {
        return dialogFragment;
    }

    public String gerarSenha() {
        return generator.generatePassword();
    }

    public static final class Builder {
        private PasswordGenerator<PasswordOptions> generator;
        private DialogFragment dialogFragment;
        private String title;
        private String subTitle;
        private int itemIconImgSrc;

        public Builder() {
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

        public SenhaMenuItem build() {
            return new SenhaMenuItem(this);
        }

        public Builder generator(PasswordGenerator generator) {
            this.generator = generator;
            return this;
        }

        public Builder dialogFragment(DialogFragment dialogFragment) {
            this.dialogFragment = dialogFragment;
            return this;
        }
    }
}
