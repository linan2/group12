package test;



import static org.junit.Assert.*;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.junit.Before;
import org.junit.Test;

import com.Send_Values;

public class Send_ValuesTest {
	private static Send_Values send=new Send_Values();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTodo() {
		Send_Values test1=new Send_Values();
		test1.run();
	}

	

	@Test
	public void testSubBytes() {
		String s2="hello";
		byte b2[] = s2.getBytes();
		System.out.println("-------------");
;		System.out.println(send.subBytes(b2, 0, 2));
	}

	@Test
	public void testToInt() {
		String s1="123";
		String s2="hello";
		byte b1[] = s1.getBytes();
		byte b2[] = s2.getBytes();
		int i1=send.toInt(b1);
		int i2=send.toInt(b2);
		
		System.out.println(send.toInt(b1));
		assertEquals(123, send.toInt(b1));
		System.out.println(send.toInt(b2));
		
	}

	@Test
	public void testRun() {
		Send_Values test1=new Send_Values();
		test1.run();
	}

}
