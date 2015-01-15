package br.com.alexandrealessi.suseproject.api.utils;

import java.util.Random;

/**
 * Created by alexandre on 02/11/14.
 */
public class UtilsMath {

	private static final Random random = new Random ();

	public static final Random getRandom () {
		return random;
	}

	public static final double log2 (double n){
		return Math.log (n) / Math.log (2);
	}

}
