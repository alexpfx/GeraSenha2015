package br.com.alexandrealessi.suseproject.api.utils;



/**
 * Created by alexandre on 01/11/14.
 */
public class UtilsString {

	public static String pickUp (String charList) {
		if (charList == null){
			return "";
		}
		return String.valueOf (charList.charAt (UtilsMath.getRandom ().nextInt (charList.length ())));
	}

	public static String pickUpOneEach (String [] stringList){
		if (stringList == null || stringList.length == 0){
			return "";
		}
		validateStringList (stringList);
		StringBuilder sb = new StringBuilder ();
		for (String s:stringList){
			sb.append (pickUp (s));
		}
		return sb.toString ();
	}

	private static void validateStringList (String[] stringList) {
		for (String s : stringList){
			if (s == null){
				throw new IllegalArgumentException ("stringList contains null values");
			}
		}
	}
}

