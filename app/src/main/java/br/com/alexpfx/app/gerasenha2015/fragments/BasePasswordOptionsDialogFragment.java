package br.com.alexpfx.app.gerasenha2015.fragments;

import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.com.alexpfx.app.gerasenha2015.OptionsChangedCallback;

/**
 * Created by alexandre on 05/02/15.
 */
public class BasePasswordOptionsDialogFragment extends DialogFragment {
    private boolean shown = false;
    private OptionsChangedCallback listener;

    @Override
    public void show(FragmentManager manager, String tag) {
        if (shown){
            return;
        }
        super.show(manager, tag);
        shown = true;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        shown = false;
        super.onDismiss(dialog);
    }

    public void setListener(OptionsChangedCallback listener) {
        this.listener = listener;
    }

    public OptionsChangedCallback getListener() {
        return listener;
    }
}
