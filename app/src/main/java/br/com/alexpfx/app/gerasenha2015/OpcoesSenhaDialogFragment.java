package br.com.alexpfx.app.gerasenha2015;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;

import br.com.alexandrealessi.gerasenha2015.R;

/**
 * Created by alexandre on 24/01/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class OpcoesSenhaDialogFragment extends DialogFragment{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_opcoes_senha,null));
        builder.setPositiveButton(R.string.gerar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 OpcoesSenhaDialogFragment.this.getDialog().cancel();
            }
        });

        return builder.create();
    }
}
