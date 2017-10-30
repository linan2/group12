package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.CAnalData;

public class CAnalDataTest {
   
	private CAnalData canalData1,canalData2,canalData3,canalData4,canalData5,canalData6;
	private List<CAnalData> canlist=new ArrayList<CAnalData>();
	@Before
	public void setUp() throws Exception {
		
		canalData1=new CAnalData("t3608000000FD00000001");
		canalData2=new CAnalData("t42080000000000E11000");
		canalData3=new CAnalData("t35880000000F07042009");
		canalData4=new CAnalData("t42B8000000000000025D");
		canalData5=new CAnalData("t35880000171B00400840");
		canalData6=new CAnalData("t32180000F10100007835");
		canlist.add(canalData1);
		canlist.add(canalData2);
		canlist.add(canalData3);
		canlist.add(canalData4);
		canlist.add(canalData5);
		
		
	}

	
	

	@Test
	public void testComputeData() {
		
        
		System.out.println("length"+canlist.size());
		for(CAnalData canalData:canlist){
			System.out.println("testComputeData()---");
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
	

}
