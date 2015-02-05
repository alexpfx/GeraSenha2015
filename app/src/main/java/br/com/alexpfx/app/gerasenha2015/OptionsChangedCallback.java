package br.com.alexpfx.app.gerasenha2015;

import br.com.alexpfx.app.gerasenha2015.model.IPasswordOptionsWrapper;

/**
 * Created by alexandre on 03/02/15.
 */
public interface OptionsChangedCallback {
    void onOptionsChange(IPasswordOptionsWrapper newOptions);
}
