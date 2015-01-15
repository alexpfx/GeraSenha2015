package br.com.alexandrealessi.suseproject.api.services;

import static br.com.alexandrealessi.suseproject.api.utils.UtilsString.pickUp;
import static br.com.alexandrealessi.suseproject.api.utils.UtilsString.pickUpOneEach;
/**
 * Created by alexandre on 02/11/14.
 */
public class SyllabicPasswordGenerator {

	public String createSyllabicPassword (int passwordSize, String consonants, String vowels, String numbers, String specialChars, PatternType[] pattern) {
		validatePattern (pattern);
		validateSyllable (consonants, vowels);
		StringBuilder sb = new StringBuilder ();
		int patternIndex = 0;
		do {
			if (patternIndex == pattern.length) {
				patternIndex = 0;
			}
			PatternType type = pattern[patternIndex++];
			String s = getByType (type, consonants, vowels, numbers, specialChars);
			sb.append (s);
		} while (sb.length () < passwordSize);
		return sb.toString ().substring (0, passwordSize);
	}

	private String getByType (PatternType type, String consonants, String vowels, String numbers, String specialChars) {
		switch (type) {
			case SYLLABLE:
				return pickUpOneEach (new String[] {consonants, vowels});
			case NUMBER:
				return pickUp (numbers);
			case SPECIAL_CHAR:
				return pickUp (specialChars);
		}
		return "";
	}

	private void validateSyllable (String consonants, String vowels) {
		if (consonants == null || consonants == "" || vowels == null || vowels == "") {
			throw new IllegalArgumentException ("consonants or vowels is null or empty");
		}
	}

	private void validatePattern (PatternType[] pattern) {
		if (pattern == null || pattern.length == 0) {
			throw new IllegalArgumentException ("Pattern is Null or Empty");
		}
		for (PatternType p:pattern){
			if (p == null)
				throw new IllegalArgumentException ("Pattern is Null or Empty");
		}
	}

	public static enum PatternType {
		SYLLABLE (0), NUMBER (1), SPECIAL_CHAR (2);
		private final int codigo;

		private PatternType (int codigo) {
			this.codigo = codigo;
		}
	}
}
