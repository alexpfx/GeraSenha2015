package br.com.alexpfx.app.gerasenha2015;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by alexandre on 25/01/15.
 */
public class ConcatenatedPasswordOptionsDialogFragment extends DialogFragment {

    public interface OnConcatenatedPasswordOptionsPositiveButtonClick{
        void onConcatenatedPasswordOptionsPositiveButtonClick ();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }
}
