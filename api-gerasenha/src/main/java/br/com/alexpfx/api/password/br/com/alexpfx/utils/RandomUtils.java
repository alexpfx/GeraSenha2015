package br.com.alexpfx.api.password.br.com.alexpfx.utils;

import java.util.Random;

import br.com.alexandrealessi.suseproject.api.utils.UtilsMath;

/**
 * Created by alexandre on 13/01/15.
 */
public class RandomUtils {
    private static final Random random = new Random ();

    public static String getOneCharacterOf (String charList) {
        if (charList == null){
            return "";
        }
        return String.valueOf (charList.charAt (UtilsMath.getRandom().nextInt (charList.length ())));
    }



}
