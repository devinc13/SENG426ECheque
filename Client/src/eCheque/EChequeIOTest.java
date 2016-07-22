package eCheque;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class EChequeIOTest {

	@Test
	public void testInitialization() {
		EChequeIO echequeIO = new EChequeIO();
		assertNotNull(echequeIO);
	}
	
	@Test
	public void testsavecheque() {
		String filename = "echeque";
		byte[] in = {127,-128,0};
		EChequeIO echequeIO = new EChequeIO();
		ECheque echeque = new ECheque();
		echeque.setaccountholder("John Doe");
		echeque.setaccountNumber("1234567890");
		echeque.setamountofMony("Test Money");
		echeque.setbankname("Test Bank");
		echeque.setbanksignature(in);
		echeque.setchequeNumber("1234567890");
		echeque.setcurrencytype("TEST");
		echeque.setdrawersiganure(in);
		echeque.setearnday("01-23-2016");
		echeque.setguaranteed(true);
		echeque.setpayToOrderOf("Test");
		
		try{
			echequeIO.savecheque(echeque, filename);
		}
		catch(IOException e){
			System.out.println("Could not save file: IO error.");
		}
	}
	
	@Test
	public void testreadcheque() {
		boolean exceptionFlag = false;
		
		String filename = "echeque";
		byte[] in = {127,-128,0};
		EChequeIO echequeIO = new EChequeIO();
		ECheque echeque = new ECheque();
		echeque.setaccountholder("John Doe");
		echeque.setaccountNumber("1234567890");
		echeque.setamountofMony("Test Money");
		echeque.setbankname("Test Bank");
		echeque.setbanksignature(in);
		echeque.setchequeNumber("1234567890");
		echeque.setcurrencytype("TEST");
		echeque.setdrawersiganure(in);
		echeque.setearnday("01-23-2016");
		echeque.setguaranteed(true);
		echeque.setpayToOrderOf("Test");
		
		try{
			echequeIO.savecheque(echeque, filename);
			ECheque read = echequeIO.readcheque(filename);
			assertEquals(echeque.getaccountholder(), read.getaccountholder());
			assertEquals(echeque.getaccountNumber(), read.getaccountNumber());
			assertEquals(echeque.getMoney(), read.getMoney());
			assertEquals(echeque.getbankname(), read.getbankname());
			assertEquals(new String(echeque.getbanksignature()), new String(read.getbanksignature()));
			assertEquals(echeque.getchequeNumber(), read.getchequeNumber());
			assertEquals(echeque.getcurrencytype(), read.getcurrencytype());
			assertEquals(new String(echeque.getdrawersiganure()), new String(read.getdrawersiganure()));
			assertEquals(echeque.getearnday(), read.getearnday());
			assertEquals(echeque.getguaranteed(), read.getguaranteed());
			assertEquals(echeque.getpayToOrderOf(), read.getpayToOrderOf());
		}
		catch(IOException e){
			System.out.println("Could not access file: IO error.");
		}
		catch(ClassNotFoundException e){
			System.out.println("File does not contain an ECheque object.");
			exceptionFlag = true;
		}
		assertFalse(exceptionFlag);
	}
	
	@Test
	public void testreadchequeInvalid() {
		boolean exceptionFlag = false;
		
		String filename = "echequeInvalid";
		EChequeIO echequeIO = new EChequeIO();
		
		try{
			echequeIO.readcheque(filename);
		}
		catch(IOException e){
			System.out.println("Could not access file: IO error.");
			exceptionFlag = true;
		}
		catch(ClassNotFoundException e){
			System.out.println("File does not contain an ECheque object.");
			exceptionFlag = true;
		}
		assertTrue(exceptionFlag);
		
	}

}