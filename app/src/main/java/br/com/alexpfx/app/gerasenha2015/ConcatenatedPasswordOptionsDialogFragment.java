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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Checkable;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.alexandrealessi.gerasenha2015.R;
import br.com.alexpfx.app.gerasenha2015.model.ConcatenatedOptionsWrapper;

/**
 * Created by alexandre on 25/01/15.
 */
public class ConcatenatedPasswordOptionsDialogFragment extends DialogFragment {

    private OptionsChangedCallback listener;

    @Override
    public void onAttach(Activity activity) {
        listener = (OptionsChangedCallback) activity;
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

//        final TextView tagsTv = (TextView) ViewUtils.getView(baseView, R.id.password_tag_textview);

        final AutoCompleteTextView nrWordsTv = (AutoCompleteTextView) ViewUtils.getView(baseView, R.id.nr_words_textview);
        Integer[] wordCount = ArrayUtils.toObject(getResources().getIntArray(R.array.word_count));
        nrWordsTv.setAdapter(new ArrayAdapter<Integer>(nrWordsTv.getContext(), android.R.layout.simple_list_item_1, wordCount));

        Integer[] passwordMaxSizeArray = ArrayUtils.toObject(getResources().getIntArray(R.array.password_max_sizes));
        final AutoCompleteTextView maxLengthTv = (AutoCompleteTextView) ViewUtils.getView(baseView, R.id.password_max_length_textview);
        maxLengthTv.setAdapter(new ArrayAdapter<Integer>(nrWordsTv.getContext(), android.R.layout.simple_list_item_1, passwordMaxSizeArray));


        final TextView separatorsTv = (TextView) ViewUtils.getView(baseView, R.id.separators_textview);

        builder.setPositiveButton("Gerar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Integer nrWord = StringUtils.isBlank(nrWordsTv.getText())?null:Integer.valueOf(nrWordsTv.getText().toString());
                Integer maxLen = StringUtils.isBlank(maxLengthTv.getText())?null:Integer.valueOf(maxLengthTv.getText().toString());
                Boolean includeUpper = includeUpperCheckBox.isChecked();
                String separators = separatorsTv.getText().toString();
                listener.onOptionsChange(new ConcatenatedOptionsWrapper.Builder().includeUpper(includeUpper).maxLength(maxLen).nrWords(nrWord).separators(separators).build());
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        return builder.create();
    }


}
