package vn.jv.util;

import java.util.GregorianCalendar;
import java.util.Random;

import vn.jv.constant.WebConstants;


/**
 * Simple password generator
 * 
 *
 */
public class PasswordGeneratorUtil {
	static final String LOWER_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
	static final String UPPER_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static final String NUMBER_CHARACTERS = "1234567890";
	static final String SYMBOL_CHARACTERS = "~!#$%^&*+?";
	
	/**
	 * Generate a password with given length 
	 * @param length Password's length
	 * @param uppers Number of upper-case (capital) characters (A, B, C...)
	 * @param digits Number of digits (0, 1, 2...)
	 * @return
	 */
	public static String generatePassword(int length, int uppers, int digits) {
		return generatePassword(length, 0, uppers, digits, 0);
	}
	
	/**
	 * Generate a password with given length 
	 * @param length Password's length
	 * @param uppers Number of upper-case (capital) characters (A, B, C...)
	 * @param digits Number of digits (0, 1, 2...)
	 * @param symbols Number of symbols (~, @, #...)
	 * @return
	 */
	public static String generatePassword(int length, int uppers, int digits, int symbols) {
		return generatePassword(length, 0, uppers, digits, symbols);
	}
	
	public static String generatePassword(int length, int lowers, int uppers, int digits, int symbols) {
		if(length < (lowers + uppers + digits + symbols)) {
			throw new RuntimeException("Length must be equal or greater than total of {lowers + uppers + digits + symbols}");
		}
		if(length != (lowers + uppers + digits + symbols)) {
			lowers = length - (uppers + digits + symbols);
		}
			
		StringBuilder password = new StringBuilder();
		password.append(getRandomChars(lowers, LOWER_CHARACTERS));
		password.append(getRandomChars(uppers, UPPER_CHARACTERS));
		password.append(getRandomChars(digits, NUMBER_CHARACTERS));
		password.append(getRandomChars(symbols, SYMBOL_CHARACTERS));
		return shuffle(password.toString());
	}

	public static String shuffle(String s) {
		StringBuilder result = new StringBuilder();
		while (s.length() != 0) {
			int index = (int) Math.floor(Math.random() * s.length());
			char c = s.charAt(index);
			s = s.substring(0, index) + s.substring(index + 1);
			result.append(c);
		}
		return result.toString();
	}

	private static String getRandomChars(int noOfChars, String characters) {
		StringBuilder randomChars = new StringBuilder();
		for (int i = 0; i < noOfChars; i++) {
			int index = (int) Math.floor(Math.random() * characters.length());
			randomChars.append(characters.charAt(index));
		}
		return randomChars.toString();
	}
	
	public static String createPasswordHash() {
		String passwordHash = "";
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "+/";
		Random random = new Random(GregorianCalendar.getInstance().getTimeInMillis());

		for (int i = 0; i < WebConstants.FixValue.PASSWORD_HASH_LENGTH; i++) {
			int number = random.nextInt(64);
			passwordHash += chars.charAt(number);
		}

		return passwordHash;
	} 
	
	public static void main(String[] args) {
		System.out.println(generatePassword(18, 1, 1, 1));
	}

}
