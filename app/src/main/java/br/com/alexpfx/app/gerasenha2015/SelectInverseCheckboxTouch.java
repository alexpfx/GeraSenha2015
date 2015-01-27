package br.com.alexpfx.app.gerasenha2015;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;

/**
 * Created by alexandre on 25/01/15.
 */
public class SelectInverseCheckboxTouch implements View.OnTouchListener {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!(event.getAction() == MotionEvent.ACTION_UP)) {
            return false;
        }
        Checkable chk = (Checkable) v;
        chk.setChecked(!chk.isChecked());
        return true;
    }

    public static void createAndAttachTo (Checkable checkable){
        ((View)checkable).setOnTouchListener(new SelectInverseCheckboxTouch());
    }

}
