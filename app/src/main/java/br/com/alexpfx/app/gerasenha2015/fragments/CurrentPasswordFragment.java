package br.com.alexpfx.app.gerasenha2015.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexpfx.app.gerasenha2015.OnOptionsChanged;
import br.com.alexpfx.app.gerasenha2015.PasswordGeneratorManager;

/**
 * Created by alexandre on 01/02/15.
 */
public class CurrentPasswordFragment extends Fragment {

    private FragmentActivity mContext;
    private DialogFragment passwordOptionsDialog;
    private PasswordGeneratorManager manager;

    private OnOptionsChanged listener;
    private PasswordGeneratorManager.PasswordGeneratorManagerHolder passwordGeneratorManagerHolder;


    @Override
    public void onAttach(Activity activity) {
        mContext = (FragmentActivity) activity;
        passwordGeneratorManagerHolder =  (PasswordGeneratorManager.PasswordGeneratorManagerHolder) activity;
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_current_password, container, false);

        ImageButton btnPasswordSettings = (ImageButton) v.findViewById(R.id.btn_password_settings);

        btnPasswordSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passwordGeneratorManagerHolder.getPasswordGeneratorManager().showGenerateOptionsDialog(mContext.getSupportFragmentManager());
            }
        });

        final ImageButton geraSenhaButton = (ImageButton) v.findViewById(R.id.btn_new_password);
        geraSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO chamar listener
                passwordGeneratorManagerHolder.getPasswordGeneratorManager().generate();
            }
        });









        return v;
    }

    public DialogFragment getPasswordOptionsDialog() {
        return passwordOptionsDialog;
    }

    public void setPasswordOptionsDialog(DialogFragment newPasswordOptionsDialog) {
        passwordOptionsDialog = newPasswordOptionsDialog;
    }
}
