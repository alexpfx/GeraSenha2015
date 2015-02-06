package br.com.alexpfx.app.gerasenha2015;




import android.support.v4.app.DialogFragment;

import br.com.alexpfx.app.gerasenha2015.fragments.BasePasswordOptionsDialogFragment;
import br.com.alexpfx.app.gerasenha2015.managers.PasswordGeneratorManager;

/**
 * Created by alexandre on 19/01/15.
 */
public class SenhaMenuItem {

    private String title;
    private String subTitle;
    private int itemIconImgSrc;
    private PasswordGeneratorManager passwordGeneratorManager;
    private BasePasswordOptionsDialogFragment passwordOptionsDialogFragment;


    public BasePasswordOptionsDialogFragment getPasswordOptionsDialogFragment() {
        return passwordOptionsDialogFragment;
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

    public PasswordGeneratorManager getPasswordGeneratorManager() {
        return passwordGeneratorManager;
    }

    private SenhaMenuItem(Builder builder) {
        title = builder.title;
        subTitle = builder.subTitle;
        itemIconImgSrc = builder.itemIconImgSrc;
        passwordGeneratorManager = builder.passwordGeneratorManager;
        passwordOptionsDialogFragment = builder.passwordOptionsDialogFragment;
    }


    public static final class Builder {
        private String title;
        private String subTitle;
        private int itemIconImgSrc;
        private PasswordGeneratorManager passwordGeneratorManager;
        private BasePasswordOptionsDialogFragment passwordOptionsDialogFragment;

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

        public Builder passwordGeneratorManager(PasswordGeneratorManager passwordGeneratorManager) {
            this.passwordGeneratorManager = passwordGeneratorManager;
            return this;
        }

        public Builder passwordOptionsDialogFragment(BasePasswordOptionsDialogFragment passwordOptionsDialogFragment) {
            this.passwordOptionsDialogFragment = passwordOptionsDialogFragment;
            return this;
        }

        public SenhaMenuItem build() {
            return new SenhaMenuItem(this);
        }
    }


}
