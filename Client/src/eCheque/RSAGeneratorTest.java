package eCheque;

import static org.junit.Assert.*;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import org.junit.Test;

public class RSAGeneratorTest {

	@Test
	public void testRSAGeneratorInit() {
		RSAGenerator keyGen = new RSAGenerator();
		assertFalse(keyGen == null);
		assertTrue(keyGen.getClass().equals(RSAGenerator.class));
	}

	@Test
	public void testRSAGeneratorRSA() {
		RSAGenerator keyGen = new RSAGenerator();
		KeyPair RSAKeys = null;
		try{
			RSAKeys = keyGen.GenerateRSAKeys();
		}catch (NoSuchAlgorithmException exp){
            JOptionPane.showMessageDialog(null,"ONE of your Java Securiy Feature not available", "Platform Error", JOptionPane.ERROR_MESSAGE);
        }

		assertTrue(RSAKeys.getPublic().getAlgorithm() == "RSA");
	}
	
	@Test
	public void testRSAGeneratorKeyPair() {
		RSAGenerator keyGen = new RSAGenerator();
		KeyPair RSAKeys = null;
		try{
			RSAKeys = keyGen.GenerateRSAKeys();
		}catch (NoSuchAlgorithmException exp){
            JOptionPane.showMessageDialog(null,"ONE of your Java Securiy Feature not available", "Platform Error", JOptionPane.ERROR_MESSAGE);
        }

		assertTrue(RSAKeys.getClass().equals(KeyPair.class));
	}

}
