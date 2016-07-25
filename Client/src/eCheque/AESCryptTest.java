package eCheque;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

import static org.hamcrest.CoreMatchers.*;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.After;
import org.junit.Before;

public class AESCryptTest extends TestCase {
	private AESCrypt aesCrypt;
	
	@Before
	public void setUp() {
		aesCrypt = new AESCrypt();
	}
	
	@Test
    public void testGenerateRandomAESKey() throws Exception {
		// Generate secret key and make sure it's not null
		SecretKey secretKey = aesCrypt.GenerateRandomAESKey();
		assertNotNull(secretKey);
		
		// Generate a second secret key and make sure it's not null
		SecretKey secretKey2 = aesCrypt.GenerateRandomAESKey();
		assertNotNull(secretKey2);
		
		// Make sure the two keys aren't the same by comparing their hash codes
		assertThat(secretKey.hashCode(), not(equalTo(secretKey2.hashCode())));
    }
	
	@Test
	public void testInitializeCipherNullKey() {
		// Use flag to check if exception is thrown
		int exceptionFlag = 0;
		Cipher cipher = null;
		
		try {
			// Initialize cipher with null key 
			cipher = aesCrypt.initializeCipher(null, 0);
		} catch (Exception e) {
			exceptionFlag = 1;
		}
		
		// Make sure flag was set to one and that cipher is null
		assertEquals(1, exceptionFlag);
		assertNull(cipher);
	}
	
	@Test
	public void testInitializeCipherEncrypt() throws Exception {
		// Create valid key
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		
		// Create AES encrypting cipher
		Cipher cipher = aesCrypt.initializeCipher(key, 0);
		
		// Make sure returned cipher isn't null
		assertNotNull(cipher);
		
		// Make sure we created an AES cipher
		assertEquals("AES", cipher.getAlgorithm());		
	}
	
	@Test
	public void testInitializeCipherDecrypt() throws Exception {
		// Create valid key
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		
		// Create AES encrypting cipher
		Cipher cipher = aesCrypt.initializeCipher(key, 1);
		
		// Make sure returned cipher isn't null
		assertNotNull(cipher);
		
		// Make sure we created an AES cipher
		assertEquals("AES", cipher.getAlgorithm());		
	}
	
	@Test
	public void testInitializeCipherWrap() throws Exception {
		// Create valid key
		Key key = KeyPairGenerator.getInstance("RSA").genKeyPair().getPublic();
		
		// Create AES encrypting cipher
		Cipher cipher = aesCrypt.initializeCipher(key, 2);
		
		// Make sure returned cipher isn't null
		assertNotNull(cipher);
		
		// Make sure we created an AES cipher
		assertEquals("RSA", cipher.getAlgorithm());		
	}
	
	@Test
	public void testInitializeCipherUnwrap() throws Exception {
		// Create valid key
		Key key = KeyPairGenerator.getInstance("RSA").genKeyPair().getPublic();
		
		// Create AES encrypting cipher
		Cipher cipher = aesCrypt.initializeCipher(key, 3);
		
		// Make sure returned cipher isn't null
		assertNotNull(cipher);
		
		// Make sure we created an AES cipher
		assertEquals("RSA", cipher.getAlgorithm());		
	}
	
	@Test
	public void testCryptNullIn() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{
		// Create valid key and cipher
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);

		// Create output stream
        OutputStream out = new ByteArrayOutputStream(); 
		
		// Use flag to check if exception is thrown
		int exceptionFlag = 0;
		
		try {
			// Run crypt with null input stream
			aesCrypt.crypt(null, out, cipher);
		} catch (Exception e) {
			exceptionFlag = 1;
		}
		
		// Make sure flag was set to one (meaning an exception was thrown)
		assertEquals(1, exceptionFlag);
	}
	
	@Test
	public void testCryptNullOut() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		// Create valid key and cipher
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);

		// Create input stream
		InputStream in = new ByteArrayInputStream("test data".getBytes());
		
		// Use flag to check if exception is thrown
		int exceptionFlag = 0;
		
		try {
			// Run crypt with null output stream
			aesCrypt.crypt(in, null, cipher);
		} catch (Exception e) {
			exceptionFlag = 1;
		}
		
		// Make sure flag was set to one (meaning an exception was thrown)
		assertEquals(1, exceptionFlag);
	}
	
	@Test
	public void testCryptNullCipher() {
		// Create input and output streams
		InputStream in = new ByteArrayInputStream("test data".getBytes());
		OutputStream out = new ByteArrayOutputStream();

		// Use flag to check if exception is thrown
		int exceptionFlag = 0;
		
		try {
			// Run crypt with null input stream
			aesCrypt.crypt(in, out, null);
		} catch (Exception e) {
			exceptionFlag = 1;
		}
		
		// Make sure flag was set to one (meaning an exception was thrown)
		assertEquals(1, exceptionFlag);
	}
	
	@Test
	public void testCryptValidDecrypt() throws Exception {
		// Create valid key and cipher
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.DECRYPT_MODE, key);
		
		// Create input and output streams. Input stream is encrypted version of the string "test"
		InputStream in = new ByteArrayInputStream("—®yL…/—¹–zÔðµ#7".getBytes());		OutputStream out = new ByteArrayOutputStream();
		
		// Run crypt
		aesCrypt.crypt(in, out, cipher);
		
		// Make sure we decrypted the correct string
		assertEquals("test", out.toString());
	}
	
	@Test
	public void testCryptValidEncrypt() throws Exception {
		// Create valid key and cipher
		Key key = new SecretKeySpec("fjdkslshfkdlshff".getBytes(), "AES");
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		
		// Create input and output streams. Input stream is encrypted version of the string "test"
		InputStream in = new ByteArrayInputStream("JSDFLKJDFSLJHSDFHJHHSDF".getBytes());
		OutputStream out = new ByteArrayOutputStream();
		
		// Run crypt
		aesCrypt.crypt(in, out, cipher);
		// Make sure we encrypted the correct string
		assertEquals("}³É$?ß(_¥{&9ß¤/ŠAs¨Á7Úþs€9åTë.}", out.toString());
	}
	
	@Test
	public void testInilizeAESKeyByPasswordNull() {
		// Try null password
		SecretKeySpec key = aesCrypt.inilizeAESKeyByPassword(null);
		assertNull(key);
		
		// Try empty string as password
		key = aesCrypt.inilizeAESKeyByPassword("");
		assertNull(key);
	}
	
	@Test
	public void testInilizeAESKeyByPasswordValid() {
		// Create key with valid password
		SecretKeySpec key = aesCrypt.inilizeAESKeyByPassword("password");
		
		// Make sure returned key is not null
		assertNotNull(key);
		
		// Make sure returned key is the expected value
		assertEquals(95424, key.hashCode());
	}
	
	@After
	public void teardown() {
		aesCrypt = null;
	}
}
