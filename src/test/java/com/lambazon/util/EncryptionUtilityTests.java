package com.lambazon.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EncryptionUtilityTests {

	@Test
	public void test_basic_encrypt_decrypt_functions(){
		String clearText = "Scott Stanlick";
		
		String encrypted = EncryptionUtility.encrypt(clearText);
		assertNotSame(clearText, encrypted);
		
		out(clearText);
		out(encrypted);
		
		String decrypted = EncryptionUtility.decrypt(encrypted);
		assertEquals(clearText, decrypted);
	}
	
	@Test
	public void test_one_way_encryption_with_no_way_to_decrypt_valid(){
		String clearText = "Scott Stanlick";
		
		String encrypted = EncryptionUtility.oneWayEncryption(clearText);
		System.out.println(encrypted);
		assertNotSame(clearText, encrypted);
		
		assertTrue(EncryptionUtility.checkPassword(clearText, encrypted));
	}
	
	@Test
	public void test_one_way_encryption_with_no_way_to_decrypt_invalid(){
		String clearText = "Scott Stanlick";
		
		String encrypted = EncryptionUtility.oneWayEncryption(clearText);
		System.out.println(encrypted);
		assertNotSame(clearText, encrypted);
		
		assertFalse(EncryptionUtility.checkPassword(clearText+" ", encrypted));
	}
	
	private void out(String s) {
		System.out.println(s);
	}
}
