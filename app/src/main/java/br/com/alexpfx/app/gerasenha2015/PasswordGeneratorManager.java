package br.com.alexpfx.app.gerasenha2015;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

import br.com.alexpfx.app.gerasenha2015.model.IPasswordOptionsWrapper;
import br.com.alexpfx.supersenha.lib.PasswordGenerator;
import br.com.alexpfx.supersenha.lib.PasswordOptions;

/**
 * Created by alexandre on 01/02/15.
 */
public class PasswordGeneratorManager implements OnOptionsChanged{
    private PasswordGenerator generator;
    private DialogFragment passwordOptionsDialog;

    private PasswordOptions currentOptions;

    public void showGenerateOptionsDialog (FragmentManager fragmentManager){
        if (passwordOptionsDialog != null){
            passwordOptionsDialog.show(fragmentManager, "mPasswordOptions");
        }
    }

    public String generate (){
        if (generator != null){
            generator.setPasswordOptions(currentOptions);
            return generator.generatePassword();
        }
        return "";
    }


    @Override
    public void onOptionsChange(IPasswordOptionsWrapper newOptions) {
        currentOptions = newOptions.getPasswordOptions();
    }

    public void setPasswordOptionsDialog(DialogFragment passwordOptionsDialog) {
        this.passwordOptionsDialog = passwordOptionsDialog;
    }

    public static interface PasswordGeneratorManagerHolder {
        PasswordGeneratorManager getPasswordGeneratorManager();
    }
}
