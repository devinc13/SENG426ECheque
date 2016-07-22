package eCheque;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import org.junit.Test;

import junit.framework.TestCase;


public class DigitalCertificateTest extends TestCase{
	
	@Test // Test Number: 1
	public void testSetHolderNameEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setHolderName("");								// Call method setHolderName() and provide an empty/null string 
        String result = dcObj.getHolderName();					// Call method getHolderName() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setHolderName() equals the return value from getHolderName() 
	}
	
	
	@Test // Test Number: 2
	public void testSetHolderNameTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setHolderName("Megan");							// Call method setHolderName() and provide an= typical  string 
        String result = dcObj.getHolderName();					// Call method getHolderName() and store the string in a variable
        assertTrue("Megan" == result);							// Ensure the input to setHolderName() equals the return value from getHolderName() 
	}
	
	
	@Test // Test Number: 3
	public void testSetSubjectEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSubject("");									// Call method setSubject() and provide an empty/null string 
        String result = dcObj.getSubject();						// Call method getSubject() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setSubject() equals the return value from getSubject() 
	}
	
	
	@Test // Test Number: 4
	public void testSetSubjectTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSubject("New Client");							// Call method setSubject() and provide a typical string 
        String result = dcObj.getSubject();						// Call method getSubject() and store the string in a variable
        assertTrue("New Client" == result);						// Ensure the input to setSubject() equals the return value from getSubject() 
	}
	
	@Test // Test Number: 5
	public void testSetIssuerEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setIssuer("");									// Call method setIssuer() and provide an empty/null string 
        String result = dcObj.getIssuer();						// Call method getIssuer() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 6
	public void testSetIssuerTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setIssuer("BMO");									// Call method setIssuer() and provide a typical string 
        String result = dcObj.getIssuer();						// Call method getIssuer() and store the string in a variable
        assertTrue("BMO" == result);							// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 7
	public void testSetSerialNumberEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSerialNumber("");								// Call method setSerialNumber() and provide an empty/null string
        String result = dcObj.getSerialNumber();				// Call method getSerialNumber() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 8
	public void testSetSerialNumberTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSerialNumber("12345");							// Call method setSerialNumber() and provide a typical string 
        String result = dcObj.getSerialNumber();				// Call method getSerialNumber() and store the string in a variable
        assertTrue("12345" == result);							// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 9
	public void testSetValidFromEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidFrom("");									// Call method setValidFrom() and provide an empty/null string
        String result = dcObj.getValidFrom();					// Call method getValidFrom() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 10
	public void testSetValidFromTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidFrom("01-06-2016");						// Call method setValidFrom() and provide a typical string 
        String result = dcObj.getValidFrom();					// Call method getValidFrom() and store the string in a variable
        assertTrue("01-06-2016" == result);						// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 11
	public void testSetValidToEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidTo("");									// Call method setValidTo() and provide an empty/null string
        String result = dcObj.getValidTo();						// Call method getValidTo() and store the string in a variable
        assertTrue("" == result);								// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
		
	@Test // Test Number: 12
	public void testSetValidToTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidTo("01-06-2017");							// Call method setValidTo() and provide a typical string 	
        String result = dcObj.getValidTo();						// Call method getValidTo() and store the string in a variable
        assertTrue("01-06-2017" == result);						// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 13
	public void testSetPublicKeyEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setPublicKey(null);								// Call method setPublicKey() and provide an empty/null string
        PublicKey result = dcObj.getpublicKey();				// Call method getpublicKey() and store the string in a variable
        assertTrue(null == result);								// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 14
	public void testSetPublicKeyTypical() throws NoSuchAlgorithmException {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        RSAGenerator keyGen = new RSAGenerator();				// Create a new RSAGenerator.java instance
        KeyPair RSAKeys = keyGen.GenerateRSAKeys();				// Call method GenerateRSAKeys() in RSAGenerator to get a key pair
        PublicKey publicKey = RSAKeys.getPublic();				// Call method getPublic() from the key pair to get the public key
        dcObj.setPublicKey(publicKey);							// Call method setPublicKey() in DigitalCertificate and provide a typical string
        PublicKey result = dcObj.getpublicKey();				// Call method getpublicKey() in DigitalCertificate and store the string in a variable
        assertTrue(publicKey == result);						// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}	
	
	@Test // Test Number: 15
	public void testSetIssueSignatureEmpty() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        byte[] testByteArray = new byte[]{};					// Create an empty byte array
        dcObj.setIssuerSignature(testByteArray);				// Call method setIssuerSignature() and provide an empty/null byte array
        byte[] result = dcObj.getIssuerSignature();				// Call method getIssuerSignature() and store the result in an byte array
        assertTrue(testByteArray == result);					// Ensure the input to setIssuerSignature() equals the return value from getIssuerSignature() 
	}
	
	@Test // Test Number: 16
	public void testSetIssueSignatureTypical() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        byte[] testByteArray = new byte[]{127,-128,0};			// Create a regular byte array
        dcObj.setIssuerSignature(testByteArray);				// Call method setIssuerSignature() and provide an empty/null byte array
        byte[] result = dcObj.getIssuerSignature();				// Call method getIssuerSignature() and store the result in an byte array
        assertTrue(testByteArray == result);					// Ensure the input to setIssuerSignature() equals the return value from getIssuerSignature() 
	}
	
	@Test // Test Number: 17
	public void testGetHolderName() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setHolderName("Megan");							// Call method setHolderName(“Some Name”)
        String result = dcObj.getHolderName();					// Call method getHolderName() and store the result in a string
        assertTrue("Megan" == result);							// Ensure the input to setHolderName() equals the return value from getHolderName() 
	}
	
	@Test // Test Number: 18
	public void testGetSubject() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSubject("New Client");							// Call method setSubject(“Some Subject”)
        String result = dcObj.getSubject();						// Call method getSubject() and store the result in a string
        assertTrue("New Client" == result);						// Ensure the input to setSubject() equals the return value from getSubject() 
	}
	
	@Test // Test Number: 19
	public void testGetIssuer() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setIssuer("BMO");									// Call method setIssuer(“Some Issuer”)
        String result = dcObj.getIssuer();						// Call method getIssuer() and store the result in a string
        assertTrue("BMO" == result);							// Ensure the input to setIssuer() equals the return value from getIssuer() 
	}
	
	@Test // Test Number: 20
	public void testGetSerialNumber() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setSerialNumber("12345");							// Call method setSerialNumber(“Some Serial Number”)
        String result = dcObj.getSerialNumber();				// Call method getSerialNumber() and store the result in a string
        assertTrue("12345" == result);							// Ensure the input to setIssuer() equals the return value from getSerialNumber() 
	}
	
	@Test // Test Number: 21
	public void testGetValidFrom() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidFrom("01-06-2016");						// Call method setValidFrom(“Some Valid From Date”)
        String result = dcObj.getValidFrom();					// Call method getValidFrom() and store the result in a string
        assertTrue("01-06-2016" == result);						// Ensure the input to setValidFrom() equals the return value from getValidFrom() 
	}
	
	@Test // Test Number: 22
	public void testGetValidTo() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        dcObj.setValidTo("01-06-2017");							// Call method setValidTo(“Some Valid To Date”)
        String result = dcObj.getValidTo();						// Call method getValidTo() and store the result in a string
        assertTrue("01-06-2017" == result);						// Ensure the input to setValidTo() equals the return value from getValidTo() 
	}
	
	@Test // Test Number: 23
	public void testGetpublicKey() throws NoSuchAlgorithmException{
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        RSAGenerator keyGen = new RSAGenerator();				// Create a new RSAGenerator.java instance
        KeyPair RSAKeys = keyGen.GenerateRSAKeys();				// Call method GenerateRSAKeys() in RSAGenerator to get a key pair
        PublicKey publicKey = RSAKeys.getPublic();				// Call method getPublic() from the key pair to get the public key
        dcObj.setPublicKey(publicKey);							// Call method setPublicKey(“Some Public Key”)
        PublicKey result = dcObj.getpublicKey();				// Call method getpublicKey() and store the result in a string
        assertTrue(publicKey == result);						// Ensure the input to setpublicKey() equals the return value from getpublicKey() 
	}
	
	@Test // Test Number: 24
	public void testGetIssuerSignature() {
        DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        byte[] testByteArray = new byte[]{127,-128,0};			// Create an typical byte array
        dcObj.setIssuerSignature(testByteArray);				// Call method setIssuerSignature() and provide an empty/null byte array
        byte[] result = dcObj.getIssuerSignature();				// Call method getIssuerSignature() and store the result in an byte array
        assertTrue(testByteArray == result);					// Ensure the input to setIssuerSignature() equals the return value from getIssuerSignature() 
	}
	
	
	@Test // Test Number 25
	public void testDCInit(){
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
		assertNotNull(dcObj);									// Ensure that the return value is not null 
	}
	
	@Test // Test Number 26
	public void testHolderNameNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getHolderName());						// Call method getHolderName() and ensure that the return value is null 
	}
	
	@Test // Test Number 27
	public void testSubjectNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getSubject());							// Call method getSubject() and ensure that the return value is null 
	}
	
	@Test // Test Number 28
	public void testIssuerNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getIssuer());							// Call method getIssuer() and ensure that the return value is null 
	}
	
	@Test // Test Number 29
	public void testSerialNumberNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getSerialNumber());					// Call method getSerialNumber() and ensure that the return value is null 
	}
	
	@Test // Test Number 30
	public void testValidFromNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getValidFrom());						// Call method getValidFrom() and ensure that the return value is null 
	}
	
	@Test // Test Number 31
	public void testValidToNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getValidTo());							// Call method getValidTo() and ensure that the return value is null 
	}
	
	@Test // Test Number 32
	public void testPublicKeyNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getpublicKey());						// Call method getpublicKey() and ensure that the return value is null 
	}
	
	@Test // Test Number 33
	public void testIssuerSignatureNull()
	{
		DigitalCertificate dcObj = new DigitalCertificate();	// Create a new DigitalCertificate.java instance 
        assertNull(dcObj.getIssuerSignature());					// Call method getIssuerSignature() and ensure that the return value is null 
	}
}
