package eCheque;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;

public class EChequeRegisterationTest {
	
	EChequeRegisteration eChequeReg;
	
	@Before
	public void setUp() {
		eChequeReg = new EChequeRegisteration();
	}

	@Test // bankName
	public void bankNameTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getBankName(), null);
		
		// set to empty string
		eChequeReg.setBankName("");
		assertEquals(eChequeReg.getBankName(), "");
		
		// set to valid string
		eChequeReg.setBankName("rBc");
		assertEquals(eChequeReg.getBankName(), "rBc");
	}

	@Test // bankAddress
	public void bankAddressTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getBankAddress(), null);
		
		// set to empty string
		eChequeReg.setBankAddress("");
		assertEquals(eChequeReg.getBankAddress(), "");
		
		// set to valid string
		eChequeReg.setBankAddress("1234 AbcD Rd");
		assertEquals(eChequeReg.getBankAddress(), "1234 AbcD Rd");
	}

	@Test // accountNumber
	public void accountNumberTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getAccountNumber(), null);
		
		// set to empty string
		eChequeReg.setAccountNumber("");
		assertEquals(eChequeReg.getAccountNumber(), "");
		
		// set to valid string
		eChequeReg.setAccountNumber("1234567890");
		assertEquals(eChequeReg.getAccountNumber(), "1234567890");
	}

	@Test // clientName
	public void clientNameTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getClientName(), null);
		
		// set to empty string
		eChequeReg.setClientName("");
		assertEquals(eChequeReg.getClientName(), "");
		
		// set to valid string
		eChequeReg.setClientName("John Smith");
		assertEquals(eChequeReg.getClientName(), "John Smith");
	}

	@Test // eWallet
	public void eWalletLocationTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getEWalletLoaction(), null);
		
		// set to empty string
		eChequeReg.setEWalletLoaction("");
		assertEquals(eChequeReg.getEWalletLoaction(), "");
		
		// set to valid string
		eChequeReg.setEWalletLoaction("/eWallet");
		assertEquals(eChequeReg.getEWalletLoaction(), "/eWallet");
	}

	@Test // userNameHash
	public void userNameHashTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getUsername(), 0);
		
		// set to valid int
		eChequeReg.setUsername(1234567890);
		assertEquals(eChequeReg.getUsername(), 1234567890);
	}

	@Test // passwordHash
	public void passwordHashTest() {
		// test get unset value is null
		assertEquals(eChequeReg.getPasword(), 0);
		
		// set to valid int
		eChequeReg.setPasword(1234567890);
		assertEquals(eChequeReg.getPasword(), 1234567890);
	}

	@After
	public void teardown() {
		eChequeReg = null;
	}
}