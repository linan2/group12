package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.database_Dao;


public class database_DaoTest {

	private  database_Dao  Testdata;
	@Before
	public void setUp() throws Exception {
		
		Testdata=new database_Dao("abc", 1, 2, 3, 4, "abcd");
	}

	

	

	@Test
	public void testGetSignal_name() {
		Testdata.getSignal_name();
		assertEquals("abc", Testdata.getSignal_name()); 
		System.out.println("testGetSignal_name()");
	}

	@Test
	public void testSetSignal_name() {
		Testdata.setSign("sing");
		System.out.println(Testdata.getSignal_name());
		System.out.println("testSetSignal_name()");
	}

	@Test
	public void testGetStart_position() {
		Testdata.getStart_position();
		assertEquals(1, Testdata.getStart_position());
		System.out.println("testGetStart_position()");
	}

	@Test
	public void testSetStart_position() {
		Testdata.setStart_position(1);
		System.out.println(Testdata.getSign());
		System.out.println("testSetStart_position()");
	}

	@Test
	public void testGetLength() {
		Testdata.getLength();
		assertEquals(2, Testdata.getLength());
		System.out.println("testGetLength()");

	}

	@Test
	public void testSetLength() {
		Testdata.setLength(5);
		System.out.println(Testdata.getLength());
		System.out.println("testSetLength()");

	}

	@Test
	public void testGetA() {
		Testdata.getA();
		float n=(float) 3.0;
		System.out.println(Testdata.getA());
		System.out.println("testGetA()"); 
	}

	@Test
	public void testSetA() {
		System.out.println("testSetA()");
		Testdata.setA(6);
		System.out.println(Testdata.getA());
		
	}

	@Test
	public void testGetB() {
		Testdata.getA();
	float n=(float) 4.0;
	System.out.println(Testdata.getB());
	System.out.println("testGetB()");
	
	}

	@Test
	public void testSetB() {
		System.out.println("testSetB()");
		Testdata.setLength(7);
		System.out.println(Testdata.getB());
	}

	@Test
	public void testGetSign() {
		Testdata.getSign();
		assertEquals("abcd", Testdata.getSign()); 
		System.out.println("testGetSign()");
	}

	@Test
	public void testSetSign() {
		Testdata.setSign("sing");
		System.out.println(Testdata.getSign());
		System.out.println("testSetSign()");
	}

}
