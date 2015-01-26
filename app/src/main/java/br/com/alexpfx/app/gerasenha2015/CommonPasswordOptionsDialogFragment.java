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

import java.util.HashMap;
import java.util.Map;

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
        listener = (OnCommonPasswordOptionsPositiveButtonClick) activity;
    }


    public String getTextViewText(View parent, int resId) {
        TextView tv = (TextView) parent.findViewById(resId);
        return tv.getText().toString();
    }

    public View getView(View parent, int resId) {
        return parent.findViewById(resId);
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View baseView = inflater.inflate(R.layout.dialog_opcoes_senha, null);

        final AutoCompleteTextView passwordSizeView = (AutoCompleteTextView) baseView.findViewById(R.id.password_size_autocompletetextview);
        final Integer[] passwordSizeArray = ArrayUtils.toObject(getResources().getIntArray(R.array.password_sizes));
        passwordSizeView.setAdapter(new ArrayAdapter<Integer>(passwordSizeView.getContext(), android.R.layout.simple_list_item_1, passwordSizeArray));

        attachCheckBoxSelectInverseListener(baseView);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(baseView);
        builder.setPositiveButton(R.string.gerar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                processPositiveButton(baseView, passwordSizeView);
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

    private boolean getCheckableValue(Checkable chk) {
        return chk.isChecked();
    }

    private void processPositiveButton(View parentView, TextView passwordSizeView) {
        Map<String, Boolean> selected = new HashMap<>();
        selected.put("numbers", getCheckableValue((Checkable) getView(parentView, R.id.numbers_checkbox)));
        selected.put("lower", getCheckableValue((Checkable) getView(parentView, R.id.lower_checkbox)));
        selected.put("upper", getCheckableValue((Checkable) getView(parentView, R.id.upper_checkbox)));
        selected.put("special", getCheckableValue((Checkable) getView(parentView, R.id.special_checkbox)));

        final String tags = getTextViewText(parentView, R.id.password_tags_edittext);
        int passwordsize;
        try {
            passwordsize = Integer.valueOf(passwordSizeView.getText().toString());
        } catch (NumberFormatException e) {
            passwordsize = 0;
        }
        listener.onCommonOptionsDialogPasswordPositiveButtonClick(tags, passwordsize, selected);
    }


    private void attachCheckBoxSelectInverseListener(View paraentView) {
        View numbersCheckBox = getView(paraentView, R.id.numbers_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(numbersCheckBox);
        View lowerCheckBox = getView(paraentView, R.id.lower_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(lowerCheckBox);
        View upperCheckBox = getView(paraentView, R.id.upper_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(upperCheckBox);
        View specialCheckBox = getView(paraentView, R.id.special_checkbox);
        SelectInverseCheckboxTouch.createAndAttachTo(specialCheckBox);
    }


    public interface OnCommonPasswordOptionsPositiveButtonClick {
        void onCommonOptionsDialogPasswordPositiveButtonClick(String tags, Integer passwordSize, Map<String, Boolean> selectedCharGroups);
    }


}
