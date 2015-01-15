package br.com.alexandrealessi.suseproject.api.services;


import org.apache.commons.lang.StringUtils;

import java.util.List;

import br.com.alexandrealessi.suseproject.api.entity.Reason;
import br.com.alexandrealessi.suseproject.api.entity.StrengthResult;
import br.com.alexandrealessi.suseproject.api.utils.UtilsMath;

import static org.apache.commons.lang.StringUtils.*;

/**
 * Created by alexandre on 06/11/14.
 */
public class PasswordStrengthCalculator {

	public float calculateEntropyByNIST (String password) {
		password = password.trim ();
		int size = password.length ();
		if (size == 0) {
			return 0.0f;
		}
		float bits = 0;
		for (int i = 0; i < password.length (); i++) {
			if (i == 0) {
				bits += 4f;
				continue;
			}
			if (i < 8f) {
				bits += 2f;
			} else if (i < 20f) {
				bits += 1.5f;
			} else {
				bits += 1f;
			}
		}
		if (isOneOfItMixCase (password) && isOneOfItNonAlphanumeric (password)) {
			bits += 6;
		}
		return bits;
	}

	public StrengthResult calculateStrength (String password, float entropy, double guessesPerSecond, List<String> wordList) {
		password = password.trim ();
		if (wordList.contains (password)) {
			return new StrengthResult(UtilsMath.log2(wordList.size()), 0.0d, Reason.DICTIONARY_WORD);
		}
		double len = Math.pow (2, entropy);
		return new StrengthResult (len, len / guessesPerSecond, Reason.NORMAL);
	}

	private boolean isOneOfItNonAlphanumeric (String password) {
		for (int i = 0; i < password.length (); i++) {
			if (! isAlphanumeric(String.valueOf(password.charAt(i)))) {
				return true;
			}
		}
		return false;
	}

	private boolean isOneOfItMixCase (String password) {
		return ! (isAllLowerCase(password) && isAllUpperCase(password));
	}
}
