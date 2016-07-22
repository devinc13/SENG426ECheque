package eCheque;

import static org.junit.Assert.*;

import org.junit.Test;

public class EChequeTest {

	@Test
	public void testInitialization() {
		ECheque echeque = new ECheque();
		assertNotNull(echeque);
	}
	
	@Test
	public void testEmptyaccountholder() {
		ECheque echeque = new ECheque();
		echeque.setaccountholder("");
		String test = echeque.getaccountholder();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardaccountholder() {
		ECheque echeque = new ECheque();
		echeque.setaccountholder("John Doe");
		String test = echeque.getaccountholder();
		assertEquals("John Doe", test);
	}
	
	@Test
	public void testUnsetaccountholder() {
		ECheque echeque = new ECheque();
		String test = echeque.getaccountholder();
		assertNull(test);
	}
	
	@Test
	public void testEmptyaccountNumber() {
		ECheque echeque = new ECheque();
		echeque.setaccountNumber("");
		String test = echeque.getaccountNumber();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardaccountNumber() {
		ECheque echeque = new ECheque();
		echeque.setaccountNumber("1234567890");
		String test = echeque.getaccountNumber();
		assertEquals("1234567890", test);
	}
	
	@Test
	public void testUnsetaccountNumber() {
		ECheque echeque = new ECheque();
		String test = echeque.getaccountNumber();
		assertNull(test);
	}
	
	@Test
	public void testEmptybankname() {
		ECheque echeque = new ECheque();
		echeque.setbankname("");
		String test = echeque.getbankname();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardbankname() {
		ECheque echeque = new ECheque();
		echeque.setbankname("Test Bank");
		String test = echeque.getbankname();
		assertEquals("Test Bank", test);
	}
	
	@Test
	public void testUnsetbankname() {
		ECheque echeque = new ECheque();
		String test = echeque.getbankname();
		assertNull(test);
	}
	
	@Test
	public void testEmptypayToOrderOf() {
		ECheque echeque = new ECheque();
		echeque.setpayToOrderOf("");
		String test = echeque.getpayToOrderOf();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardpayToOrderOf() {
		ECheque echeque = new ECheque();
		echeque.setpayToOrderOf("Test");
		String test = echeque.getpayToOrderOf();
		assertEquals("Test", test);
	}
	
	@Test
	public void testUnsetpayToOrderOf() {
		ECheque echeque = new ECheque();
		String test = echeque.getpayToOrderOf();
		assertNull(test);
	}
	
	@Test
	public void testEmptyamountofMony() {
		ECheque echeque = new ECheque();
		echeque.setamountofMony("");
		String test = echeque.getMoney();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardamountofMony() {
		ECheque echeque = new ECheque();
		echeque.setamountofMony("Test Money");
		String test = echeque.getMoney();
		assertEquals("Test Money", test);
	}
	
	@Test
	public void testUnsetamountofMony() {
		ECheque echeque = new ECheque();
		String test = echeque.getMoney();
		assertNull(test);
	}
	
	@Test
	public void testEmptycurrencytype() {
		ECheque echeque = new ECheque();
		echeque.setcurrencytype("");
		String test = echeque.getcurrencytype();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardcurrencytype() {
		ECheque echeque = new ECheque();
		echeque.setcurrencytype("TEST");
		String test = echeque.getcurrencytype();
		assertEquals("TEST", test);
	}
	
	@Test
	public void testUnsetcurrencytype() {
		ECheque echeque = new ECheque();
		String test = echeque.getcurrencytype();
		assertNull(test);
	}
	
	@Test
	public void testEmptychequeNumber() {
		ECheque echeque = new ECheque();
		echeque.setchequeNumber("");
		String test = echeque.getchequeNumber();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardchequeNumber() {
		ECheque echeque = new ECheque();
		echeque.setchequeNumber("1234567890");
		String test = echeque.getchequeNumber();
		assertEquals("1234567890", test);
	}
	
	@Test
	public void testUnsetchequeNumber() {
		ECheque echeque = new ECheque();
		String test = echeque.getchequeNumber();
		assertNull(test);
	}
	
	@Test
	public void testUnsetguaranteed() {
		ECheque echeque = new ECheque();
		boolean test = echeque.getguaranteed();
		assertFalse(test);
	}
	
	@Test
	public void testStandardguaranteed() {
		ECheque echeque = new ECheque();
		echeque.setguaranteed(true);
		boolean test = echeque.getguaranteed();
		assertTrue(test);
	}
	
	@Test
	public void testEmptyearnday() {
		ECheque echeque = new ECheque();
		echeque.setearnday("");
		String test = echeque.getearnday();
		assertEquals("", test);
	}
	
	@Test
	public void testStandardearnday() {
		ECheque echeque = new ECheque();
		echeque.setearnday("01-23-2016");
		String test = echeque.getearnday();
		assertEquals("01-23-2016", test);
	}
	
	@Test
	public void testUnsetearnday() {
		ECheque echeque = new ECheque();
		String test = echeque.getearnday();
		assertNull(test);
	}
	
	@Test
	public void testEmptybanksignature() {
		ECheque echeque = new ECheque();
		byte[] in = new byte[0];
		echeque.setbanksignature(in);
		byte[] test = echeque.getbanksignature();
		assertEquals(in, test);
		assertTrue(test.length == 0);
	}
	
	@Test
	public void testStandardbanksignature() {
		ECheque echeque = new ECheque();
		byte[] in = {127,-128,0};
		echeque.setbanksignature(in);
		byte[] test = echeque.getbanksignature();
		assertEquals(in, test);
		assertTrue(test.length == 3);
	}
	
	@Test
	public void testUnsetbanksignature() {
		ECheque echeque = new ECheque();
		byte[] test = echeque.getbanksignature();
		assertNull(test);
	}
	
	@Test
	public void testEmptydrawersiganure() {
		ECheque echeque = new ECheque();
		byte[] in = new byte[0];
		echeque.setdrawersiganure(in);
		byte[] test = echeque.getdrawersiganure();
		assertEquals(in, test);
		assertTrue(test.length == 0);
	}
	
	@Test
	public void testStandarddrawersiganure() {
		ECheque echeque = new ECheque();
		byte[] in = {127,-128,0};
		echeque.setdrawersiganure(in);
		byte[] test = echeque.getdrawersiganure();
		assertEquals(in, test);
		assertTrue(test.length == 3);
	}
	
	@Test
	public void testUnsetdrawersiganure() {
		ECheque echeque = new ECheque();
		byte[] test = echeque.getdrawersiganure();
		assertNull(test);
	}

}
