package br.com.alexpfx.app.gerasenha2015.fragments;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexpfx.app.gerasenha2015.OptionsChangedCallback;
import br.com.alexpfx.app.gerasenha2015.managers.PasswordGeneratorManager;
import br.com.alexpfx.app.gerasenha2015.model.IPasswordOptionsWrapper;
import br.com.alexpfx.app.gerasenha2015.model.Password;
import br.com.alexpfx.app.gerasenha2015.model.Strength;

/**
 * Created by alexandre on 01/02/15.
 */
public class CurrentPasswordFragment extends Fragment implements OptionsChangedCallback {

    OnNewPasswordListener onNewPasswordListener;
    private BasePasswordOptionsDialogFragment passwordOptionsDialog;
    private PasswordGeneratorManager passwordGeneratorManager;
    private TextView tvPasswordStrength;
    private TextView tvCurrentPassword;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //capturar OnNewPasswordListener

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_current_password, container, false);

        final ImageButton btnPasswordSettings = (ImageButton) v.findViewById(R.id.btn_password_settings);
        tvCurrentPassword = (TextView) v.findViewById(R.id.tv_current_password);
        tvPasswordStrength = (TextView) v.findViewById(R.id.tv_password_strength);

        btnPasswordSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordOptionsDialog != null) {
                    if (!passwordOptionsDialog.isVisible()) {
                        passwordOptionsDialog.show(getActivity().getSupportFragmentManager(), "optionsDialog");
                    }
                }
            }
        });

        final ImageButton geraSenhaButton = (ImageButton) v.findViewById(R.id.btn_new_password);

        final ImageButton shareButton = (ImageButton) v.findViewById(R.id.btn_share_password);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "body";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, getString(R.string.action_share)));
            }
        });

        final ImageButton copyButton = (ImageButton) v.findViewById(R.id.btn_copy_password);
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = tvCurrentPassword.getText();
                if (text.length() == 0) {
                    toast("Não há senha para copiar!");
                    return;
                }
                ClipboardManager clipboard = (ClipboardManager) getActivity().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Senha Gerada", text);
                clipboard.setPrimaryClip(clip);
                toast("Senha copiada para área de transferência!");
            }
        });


        geraSenhaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordGeneratorManager != null) {
                    Password newPass = passwordGeneratorManager.generatePassword();
                    String oldPass = tvCurrentPassword.getText().toString();
                    tvCurrentPassword.setText(newPass.getPassword());
                    DecimalFormat decimalFormat = new DecimalFormat("#.#");
                    decimalFormat.setRoundingMode(RoundingMode.HALF_EVEN);
                    tvPasswordStrength.setText(decimalFormat.format(newPass.getStrength().getEntropy())+" bits, "+newPass.getStrength().getAveragueGuesses()+" tentativas");

                    if (onNewPasswordListener != null) {
                        onNewPasswordListener.receivePassword(newPass);
                    }
                }
            }
        });


        return v;
    }

    public void setPasswordGeneratorManager(PasswordGeneratorManager passwordGeneratorManager) {
        this.passwordGeneratorManager = passwordGeneratorManager;
    }

    public void setPasswordOptionsDialog(BasePasswordOptionsDialogFragment passwordOptionsDialog) {
        this.passwordOptionsDialog = passwordOptionsDialog;
    }

    @Override
    public void onOptionsChange(IPasswordOptionsWrapper newOptions) {
        Toast.makeText(getActivity().getApplicationContext(), newOptions.getPasswordOptions().toString(), Toast.LENGTH_SHORT).show();
        passwordGeneratorManager.setOptions(newOptions.getPasswordOptions());
    }

    public void toast(String text) {
        Toast.makeText(getActivity().getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    /**
     * Listeners para outras operações com a password gerado ou com a atual.
     */
    public static interface OnNewPasswordListener {
        public void receivePassword(Password password);
    }
}
