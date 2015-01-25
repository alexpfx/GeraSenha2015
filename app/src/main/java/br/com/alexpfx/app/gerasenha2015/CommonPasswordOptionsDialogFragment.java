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
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckedTextView;
import android.widget.EditText;
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

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Map<String, CheckedTextView> selectedList = new HashMap<>();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogPasswordOptionsCustomView = inflater.inflate(R.layout.dialog_opcoes_senha, null);
        final AutoCompleteTextView passwordSizeView = (AutoCompleteTextView) dialogPasswordOptionsCustomView.findViewById(R.id.password_size_autocompletetextview);
        ViewGroup includeOnPassCheckBoxes = (ViewGroup) dialogPasswordOptionsCustomView.findViewById(R.id.include_on_pass_groupview);
        int childCount = includeOnPassCheckBoxes.getChildCount();
        final TextView tagsEditText = (EditText) dialogPasswordOptionsCustomView.findViewById(R.id.password_tags_edittext);
        for (int i = 0; i < childCount; i++) {
            CheckedTextView childAt = (CheckedTextView) includeOnPassCheckBoxes.getChildAt(i);
            childAt.setOnTouchListener(new SelectInverseCheckboxTouch());
            selectedList.put((String) childAt.getTag(), childAt);
        }
        final Integer[] passwordSize = ArrayUtils.toObject(getResources().getIntArray(R.array.password_sizes));
        passwordSizeView.setAdapter(new ArrayAdapter<Integer>(passwordSizeView.getContext(), android.R.layout.simple_list_item_1, passwordSize));
        builder.setView(dialogPasswordOptionsCustomView);
        builder.create();

        builder.setPositiveButton(R.string.gerar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Map<String, Boolean> selected = new HashMap<>();
                for (String s : selectedList.keySet()) {
                    selected.put(s, selectedList.get(s).isChecked());
                }
                CheckedCharGroupsViewModel viewModel = new CheckedCharGroupsViewModel(selected);
                String tags = tagsEditText.getText().toString();
                String passwordsize = ((TextView) passwordSizeView).getText().toString();
                listener.onCommonOptionsDialogPasswordPositiveButtonClick(tags, passwordsize, selected);
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
        void onCommonOptionsDialogPasswordPositiveButtonClick(String tags, String passwordSize, Map<String, Boolean> selectedCharGroups);
    }


}
