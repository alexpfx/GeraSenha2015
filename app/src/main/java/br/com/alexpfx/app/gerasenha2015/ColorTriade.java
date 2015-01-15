package br.com.alexpfx.app.gerasenha2015;

import android.content.res.Resources;

/**
 * Created by alexandre on 11/01/15.
 */
public class ColorTriade {
    private final int primaryColor;
    private final int primaryColorDark;
    private final int accentColor;

    private ColorTriade(int primaryColor, int primaryColorDark, int accentColor) {
        this.primaryColor = primaryColor;
        this.primaryColorDark = primaryColorDark;
        this.accentColor = accentColor;
    }

    public static ColorTriade create(int primaryColor, int primaryColorDark, int accentColor) {
        return new ColorTriade(primaryColor, primaryColorDark, accentColor);
    }

    public static ColorTriade create(Resources resources, int primaryColor, int primaryColorDark, int accentColor) {
        return new ColorTriade(resources.getColor(primaryColor), resources.getColor(primaryColorDark), resources.getColor(accentColor));
    }

    public int getPrimaryColor() {
        return primaryColor;
    }

    public int getPrimaryColorDark() {
        return primaryColorDark;
    }

    public int getAccentColor() {
        return accentColor;
    }
}
