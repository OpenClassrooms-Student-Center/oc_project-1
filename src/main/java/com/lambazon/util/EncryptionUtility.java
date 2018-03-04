package com.lambazon.util;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

/**
 * 
 * @author stanlick
 *
 *
 * @see http://www.jasypt.org/
 */

public class EncryptionUtility {

	static BasicTextEncryptor  textEncryptor;
	static String privateData;

	static {
		textEncryptor = new BasicTextEncryptor();
		privateData = "secret-data";
		textEncryptor.setPasswordCharArray("some-random-data".toCharArray());
	}

	public static String encrypt(String strClearText) {
		return textEncryptor.encrypt(strClearText);
	}

	public static String decrypt(String strEncodedText) {
		return textEncryptor.decrypt(strEncodedText);
	}
	
	public static String oneWayEncryption(String strClearText) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.encryptPassword(strClearText);
	}

	public static boolean checkPassword(String strClearText, String strEncodedText) {
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
		return passwordEncryptor.checkPassword(strClearText, strEncodedText);
	}
}
