package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.database_Dao;
import com.read_database;

public class read_databaseTest {
    private   read_database  readdata; 
    public static Map<String,List<database_Dao>> name_map = new HashMap<String,List<database_Dao>>();
	public static Map<String,List<String>> DLC_map = new HashMap<String,List<String>>();
	public static Map<String,String> DLC_id=new HashMap<String,String>();
	public static List<String> name_list=new ArrayList<String>();
	@Before
	public void setUp() throws Exception {
		readdata=new read_database();
		
	}

	

	@Test
	public void testAnalyze_database() {
		System.out.println("testAnalyze_database");
		  Map<String,List<database_Dao>> map = new HashMap<String,List<database_Dao>>();
		  List<database_Dao> list = new ArrayList<database_Dao>();
		  map=readdata.analyze_database("database.txt");
		  for (String key : map.keySet()) {

			    list = map.get(key);
              System.out.println("list---"+list);
              System.out.println("--------------------------------------------------");
              for (database_Dao datadao : list) {  
            	System.out.println("A"+datadao.getA());
          		System.out.println("B"+datadao.getB());
          		System.out.println("length:"+datadao.getLength());
          		System.out.println("Sign:"+datadao.getSign());
          		System.out.println("position:"+datadao.getStart_position());
          		System.out.println("name:"+datadao.getSignal_name());
  	        }  
			}
	}

	@Test
	public void testAnalyze_database_by_String() {
		System.out.println("testAnalyze_database_by_String()");
		readdata.analyze_database_by_String("t31D80000000000000006");
	}

	@Test
	public void testAnalyze_database_Dao() {
		System.out.println("testAnalyze_database_Dao()");
		database_Dao datadao=(database_Dao) readdata.analyze_database_Dao("SG_ CDU_HVACIonButtonSt : 12|1@0+ (1,0) [0|1] \"\"  HVAC");
		System.out.println("A"+datadao.getA());
		System.out.println("B"+datadao.getB());
		System.out.println("length:"+datadao.getLength());
		System.out.println("Sign:"+datadao.getSign());
		System.out.println("position:"+datadao.getStart_position());
		System.out.println("name:"+datadao.getSignal_name());
	}

}
