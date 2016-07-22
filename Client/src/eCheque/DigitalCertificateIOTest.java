package eCheque;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class DigitalCertificateIOTest extends TestCase{

	DigitalCertificate dcObj;
	DigitalCertificateIO dcIO;
	
	@Before
	public void setUp() throws NoSuchAlgorithmException{
		dcObj = new DigitalCertificate();								// Create a new DigitalCertificate.java instance 
		dcIO = new DigitalCertificateIO();								// Create a new DigitalCertificateIO.java instance 
		byte[] testByteArray = new byte[]{127,-128,0};					// Create a test byte array 
        RSAGenerator keyGen = new RSAGenerator();						// Create a new RSAGenerator.java instance
        KeyPair RSAKeys = keyGen.GenerateRSAKeys();						// Call method GenerateRSAKeys() in RSAGenerator to get a key pair
        PublicKey publicKey = RSAKeys.getPublic();						// Call method getPublic() from the key pair to get the public key 
        
        // set some digital certificate values
        dcObj.setHolderName("Megan");
        dcObj.setSubject("New Client");
        dcObj.setIssuer("BMO");
        dcObj.setSerialNumber("12345");
        dcObj.setValidFrom("01-23-201");
        dcObj.setValidTo("01-23-2017");
        dcObj.setPublicKey(publicKey);
        dcObj.setIssuerSignature(testByteArray);
	}
	
	@Test 
	public void testDCIOInit(){
		assertNotNull(dcIO);
	}
	
	@Test // Test Number: 1
	public void testSaveDC(){ 
		DigitalCertificate retrievedDcObj = new DigitalCertificate();
		
        // Set DC file
        try{
        	dcIO.SaveDC(dcObj, "test.epc");								// Try to save file as test.epc
        }
        catch(Exception e){
        	assertTrue(false);											// Test failed 
        }
        
        // Get DC file
        try {
        	retrievedDcObj = dcIO.readDigitalCertificate("test.epc");	// Try to read test.epc file
        }
        catch(Exception e){
        	assertTrue(false);											// Test failed 
        }
        
        // Test passes if dcObj that was set is equal the the one that is retrieved
        assertEquals(dcObj.getHolderName(), retrievedDcObj.getHolderName());
        assertEquals(dcObj.getSubject(), retrievedDcObj.getSubject());
        assertEquals(dcObj.getIssuer(), retrievedDcObj.getIssuer());
        assertEquals(dcObj.getSerialNumber(), retrievedDcObj.getSerialNumber());
        assertEquals(dcObj.getValidFrom(), retrievedDcObj.getValidFrom());
        assertEquals(dcObj.getValidTo(), retrievedDcObj.getValidTo());
        assertEquals(dcObj.getpublicKey(), retrievedDcObj.getpublicKey());
        assertEquals(Arrays.toString(dcObj.getIssuerSignature()), Arrays.toString(retrievedDcObj.getIssuerSignature()));
	}
	
	@After
	public void tearDown(){
		dcObj = null;
	}
}
