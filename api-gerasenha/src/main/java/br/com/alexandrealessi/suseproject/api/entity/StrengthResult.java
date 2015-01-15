package br.com.alexandrealessi.suseproject.api.entity;

/**
 * Created by alexandre on 08/11/14.
 */
public class StrengthResult {

	private final double seconds;
	private final Reason reason;
	private final double averageGuesses;

	public StrengthResult (double averageGuesses, double seconds, Reason reason){
		this.seconds = seconds;
		this.reason = reason;
		this.averageGuesses = averageGuesses;
	}

	public double getSeconds () {
		return seconds;
	}

	public Reason getReason () {
		return reason;
	}

	public double getAverageGuesses () {
		return averageGuesses;
	}
}
