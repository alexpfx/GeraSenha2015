package br.com.alexpfx.app.gerasenha2015.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexpfx.app.gerasenha2015.managers.PasswordGeneratorManager;

/**
 * Created by alexandre on 01/02/15.
 */
public class CurrentPasswordFragment extends Fragment {

    OnNewPasswordListener onNewPasswordListener;
    private DialogFragment passwordOptionsDialog;
    private PasswordGeneratorManager passwordGeneratorManager;
    private TextView tvCurrentPassword;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_current_password, container, false);

        final ImageButton btnPasswordSettings = (ImageButton) v.findViewById(R.id.btn_password_settings);
        tvCurrentPassword = (TextView) v.findViewById(R.id.current_password_textView);

        btnPasswordSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final ImageButton geraSenhaButton = (ImageButton) v.findViewById(R.id.btn_new_password);
        geraSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordGeneratorManager != null) {
                    String newPass = passwordGeneratorManager.generate();
                    String oldPass = tvCurrentPassword.getText().toString();
                    tvCurrentPassword.setText(newPass);
                    if (onNewPasswordListener != null) {
                        onNewPasswordListener.receivePassword(newPass, oldPass);
                    }
                }
            }
        });
        return v;
    }

    public void setPasswordGeneratorManager(PasswordGeneratorManager passwordGeneratorManager) {
        this.passwordGeneratorManager = passwordGeneratorManager;
    }

    /**
     * Listeners para outras operações com a password gerado ou com a atual.
     */
    public static interface OnNewPasswordListener {
        public void receivePassword(String newPassword, String oldPassword);
    }
}
