package br.com.alexpfx.app.gerasenha2015;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;

import br.com.alexandrealessi.gerasenha2015.R;

/**
 * Created by alexandre on 25/01/15.
 */
public class ConcatenatedPasswordOptionsDialogFragment extends DialogFragment {

    private OnConcatenatedPasswordOptionsPositiveButtonClick listener;

    @Override
    public void onAttach(Activity activity) {
        listener = (OnConcatenatedPasswordOptionsPositiveButtonClick) activity;
        super.onAttach(activity);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View baseView = inflater.inflate(R.layout.options_dialog_concatenated_passwords, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(baseView);

        final Checkable includeUpperCheckBox = (Checkable) ViewUtils.getView(baseView, R.id.incluir_maiusculas_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(includeUpperCheckBox);

        final TextView tagsTv = (TextView) ViewUtils.getView(baseView, R.id.password_tag_textview);
        final TextView nrWordsTv = (TextView) ViewUtils.getView(baseView, R.id.nr_words_textview);
        final TextView maxLengthTv = (TextView) ViewUtils.getView(baseView, R.id.password_max_length_textview);
        final TextView separatorsTv = (TextView) ViewUtils.getView(baseView, R.id.separators_textview);

        builder.setPositiveButton("Gerar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ConcatenatedPasswordOptionsViewModel options = new ConcatenatedPasswordOptionsViewModel.Builder()
                        .includeUpper(includeUpperCheckBox.isChecked())
                        .maxLength(nrWordsTv.getText().toString())
                        .tags(tagsTv.getText().toString())
                        .separators(separatorsTv.getText().toString()).build();
                listener.onConcatenatedPasswordOptionsPositiveButtonClick(options);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        });
        return builder.create();
    }

    public interface OnConcatenatedPasswordOptionsPositiveButtonClick {
        void onConcatenatedPasswordOptionsPositiveButtonClick(ConcatenatedPasswordOptionsViewModel optionsViewModel);
    }
}
