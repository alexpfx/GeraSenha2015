package br.com.alexpfx.app.gerasenha2015;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Checkable;
import android.widget.TextView;

import org.apache.commons.lang3.ArrayUtils;

import br.com.alexandrealessi.gerasenha2015.R;

/**
 * Created by alexandre on 24/01/15.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class CommonPasswordOptionsDialogFragment extends DialogFragment {

    private OnCommonPasswordOptionsPositiveButtonClick listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View baseView = inflater.inflate(R.layout.dialog_opcoes_senha, null);
        final AutoCompleteTextView passwordSizeView = (AutoCompleteTextView) baseView.findViewById(R.id.password_length_textview);
        Integer[] passwordSizeArray = ArrayUtils.toObject(getResources().getIntArray(R.array.password_sizes));
        passwordSizeView.setAdapter(new ArrayAdapter<Integer>(passwordSizeView.getContext(), android.R.layout.simple_list_item_1, passwordSizeArray));

//        final TextView tagsTextView = (TextView) ViewUtils.getView(baseView, R.id.tag_textview);
        final TextView passwordMaxLength = (TextView) ViewUtils.getView(baseView, R.id.password_length_textview);

        final Checkable numbersChk = (Checkable) ViewUtils.getView(baseView, R.id.numbers_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(numbersChk);
        final Checkable lowerChk = (Checkable) ViewUtils.getView(baseView, R.id.lower_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(lowerChk);
        final Checkable upperChk = (Checkable) ViewUtils.getView(baseView, R.id.upper_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(upperChk);
        final Checkable specialChk = (Checkable) ViewUtils.getView(baseView, R.id.special_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(specialChk);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(baseView);
        builder.setPositiveButton(R.string.gerar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CommonPasswordOptionsViewModel options = new CommonPasswordOptionsViewModel.Builder()
//                        .tags(tagsTextView.getText().toString())
                        .passwordSize(passwordMaxLength.getText().toString())
                        .hasNumbers(numbersChk.isChecked())
                        .hasLowerCase(lowerChk.isChecked())
                        .hasUpperCase(upperChk.isChecked())
                        .hasSpecialChars(specialChk.isChecked()).build();
                if (listener != null){
                    listener.onCommonOptionsDialogPasswordPositiveButtonClick(options);
                }
            }
        });

        builder.setNegativeButton(R.string.cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CommonPasswordOptionsDialogFragment.this.dismiss();
            }
        });

        return builder.create();
    }

    public interface OnCommonPasswordOptionsPositiveButtonClick {
        void onCommonOptionsDialogPasswordPositiveButtonClick(CommonPasswordOptionsViewModel options);
    }//85

    public void setListener(OnCommonPasswordOptionsPositiveButtonClick listener) {
        this.listener = listener;
    }
}
