package eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import org.junit.Test;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;

public class DigitalsignetureTest extends TestCase {

	KeyPair keyPair_1 = null;
	KeyPair keyPair_2 = null;
	Digitalsigneture digitalSignature = new Digitalsigneture();
	@Before
	public void setUp() {
		// create key pair1
		RSAGenerator keyGen = new RSAGenerator();
		keyPair_1 = null;
		try{
			keyPair_1 = keyGen.GenerateRSAKeys();
		}catch (NoSuchAlgorithmException exp){
            JOptionPane.showMessageDialog(null,"ONE of your Java Securiy Feature not available", "Platform Error", JOptionPane.ERROR_MESSAGE);
        }

        // create key pair2
        keyPair_2 = null;
		try{
			keyPair_2 = keyGen.GenerateRSAKeys();
		}catch (NoSuchAlgorithmException exp){
            JOptionPane.showMessageDialog(null,"ONE of your Java Securiy Feature not available", "Platform Error", JOptionPane.ERROR_MESSAGE);
        }

        digitalSignature = new Digitalsigneture();
	}

	@Test // Test Number: 1

	public void testCorrectKeyPair() throws Exception{
        // sign hello world
        byte[]signature = digitalSignature.signeture("hello world", keyPair_1.getPrivate());
        // verify signature
        assertTrue(digitalSignature.verifySignature(signature, "hello world", keyPair_1.getPublic()));
	}

	@Test // Test Number: 2

	public void testIncorrectKeyPair() throws Exception{
		// sign hello world with key 1
        byte[]signature = digitalSignature.signeture("hello world", keyPair_1.getPrivate());
        // verify signature with key 2
        assertFalse(digitalSignature.verifySignature(signature, "hello world", keyPair_2.getPublic()));
	}

	@Test // Test Number: 3

	public void testNullMessage() throws Exception{
		try {
			// sign nullMessage
        	byte[]signature = digitalSignature.signeture(null, keyPair_1.getPrivate());
			fail("Signed Null Message, failed this test");
		} catch (Exception e) {
			// good, exception caught
		}
	}

	@Test // Test Number: 4

	public void testEmptyMessage() throws Exception{
		try {
			// sign empty message
        	byte[]signature = digitalSignature.signeture("", keyPair_1.getPrivate());
			fail("Signed Empty Message, failed this test");
		} catch (Exception e) {
			// good
		}
	}

	@Test // Test Number: 5

	public void testVerifyNullMessage() throws Exception{
		// sign hello world with key 1
        byte[]signature = digitalSignature.signeture("hello world", keyPair_1.getPrivate());
        try {
        	// verify with null message
        	digitalSignature.verifySignature(signature, null, keyPair_2.getPublic());
        	fail("should not veirfy with null message");
        } catch (Exception e) {
        	// good
        }
	}

	@Test // Test Number: 6

	public void testVerifyEmptyMessage() throws Exception{
		// sign hello world with key 1
        byte[]signature = digitalSignature.signeture("hello world", keyPair_1.getPrivate());
        try {
        	// verify with empty  message
        	digitalSignature.verifySignature(signature, "", keyPair_2.getPublic());
        	fail("should not veirfy with empty message");
        } catch (Exception e) {
        	// good
        }
	}

	@Test // Test Number: 7

	public void testVerifyNullSignature() throws Exception{
        try {
        	// verify with empty  message
        	digitalSignature.verifySignature(null, "hello world", keyPair_2.getPublic());
        	fail("should not veirfy with null signature");
        } catch (Exception e) {
        	// good
        }
	}

	@After
	public void teardown() {
		digitalSignature = null;
	}
}