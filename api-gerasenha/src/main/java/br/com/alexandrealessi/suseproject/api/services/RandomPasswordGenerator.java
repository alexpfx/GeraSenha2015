package br.com.alexandrealessi.suseproject.api.services;


import br.com.alexandrealessi.suseproject.api.utils.UtilsString;

import static br.com.alexandrealessi.suseproject.api.utils.UtilsMath.getRandom;

/**
 * Created by alexandre on 01/11/14.
 */
public class RandomPasswordGenerator {

	public String createRandomPassword (int size, String charList) {
		StringBuilder sb = new StringBuilder ();
		for (int i = 0; i < size; i++) {
			int n = getRandom ().nextInt (charList.length ());
			sb.append (UtilsString.pickUp(charList));
		}
		return sb.toString ();
	}
}
