package vn.jv.util;

import com.platinum.pcv.PasswordComplexityException;
import com.platinum.pcv.PasswordComplexityValidator;


/**
 * Wrapper of third-party util to enforce password complexity
 * 
 * 
 * 
 */
public class PasswordEnforcementUtil {
	public static final String EIGHT_CHARS_PASS_REGEX = "(?=[@#!$%&+=\\-_a-zA-Z0-9]*?[A-Z])"
			+ "(?=[@#!$%&+=\\-_a-zA-Z0-9]*?[a-z])" + "(?=[@#!$%&+=\\-_a-zA-Z0-9]*?[0-9])"
			+ "(?=[@#!$%&+=\\-_a-zA-Z0-9]*?[@#!$%&+=\\-_])[@#!$%&+=\\-_a-zA-Z0-9]{8,}";

	static {
		int minPasswordLength = 8; // Minimum length of a password
		int maxPasswordLength = 25; // Maximum length of a password
		int minLowerAlphaChars = 1; // Minimum amount of lowercase alpha characters in the password
		int minUpperAlphaChars = 1; // Minimum amount of uppercase alpha characters in the password
		int minSpecialChars = 1; // Minimum amount of special characters in the password
		int minNumericalChars = 1; // Minimum amount of numerical characters in the password
		boolean allowExtendedAsciiSymbols = false; // Allow extended ascii characters in the password?
		int lastPasswordDifferInChars = 4; // The password must differ by X amount of characters compared to the last
											// one
		int passwordHistoryLen = 4; // Validate we haven't used this password in this many iterations (we use the list
									// of old pw's you pass in for this)
		boolean allowPhoneNumbers = false; // Allow phone numbers in the password?
		boolean allowDates = false; // Allow dates in the password?
		boolean restrictedByDictionary = false; // Deny dictionary words within the password?
		float dictionaryAccuracy = 17; // Default Bloom Filter settings
		int dictionaryMinWordLength = 4; // Default dictionary word length. Anything smaller and you'll get lots of hits
		PasswordComplexityValidator.configure(minPasswordLength, maxPasswordLength, minLowerAlphaChars,
				minUpperAlphaChars, minSpecialChars, minNumericalChars, allowExtendedAsciiSymbols,
				lastPasswordDifferInChars, passwordHistoryLen, allowPhoneNumbers, allowDates, restrictedByDictionary,
				dictionaryAccuracy, dictionaryMinWordLength);
	}

	public static void validatePassword(String password) throws PasswordComplexityException {
		PasswordComplexityValidator.validatePassword(password, null);
	}

	public static void main(String[] args) {
		try {
			validatePassword("helLo3455");
		} catch (Exception e) {
			System.err.println("Error -> " + Lib.getAllMessages(e));
		}
	}
}
