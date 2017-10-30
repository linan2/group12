package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.CAnalData;

public class CAnalDataTest2 {
  
	private CAnalData canalData;
	@Before
	public void setUp() throws Exception {
		canalData=new CAnalData("T32085E0040002A000048");
	}

	@Test
	public void testComputeData() {
		System.out.println("testComputeData2()");
		canalData.computeData();
		System.out.println("DATAS:"+(new String(canalData.getDatas())));
		System.out.println("DLC:"+canalData.getDLC());
		System.out.println("FlAG:"+canalData.getFLAG());
		System.out.println("ID:"+canalData.getID());
		System.out.println("Data:"+canalData.getiData());
		System.out.println("size:"+canalData.getSize());
		System.out.println("DATA:"+canalData.getDATA());
		
		 ArrayList<char[]> list=canalData.getDATA();
		 
		 for (char[] tmp : list) {  
	            System.out.println(new String(tmp));  
	        }  
	}

}
