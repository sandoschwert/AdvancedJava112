package java112.labs2;

import java.util.*;

public class MapDemo {

	public static void main(String[] args) {
	
		//ArrayList<String or Analyzer or a type>
		//for maps you must put in types for both the key and the value
		//no primitives in maps Integer (the class which creates and object) 
		//versus int, no object on the heap, just a number we can manipulate
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		//put method allows you to add pairs to the map
		map.put("one", 1);
		map.put("two", 2);
		map.put("four", 4);
		map.put("three", 3);
		
		System.out.println(map);  //toString method will work
		
		//the way we know
		//for (Analyzer analyzer : analyzers) { do stuff }
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
		
			System.out.println("Key = " + entry.getKey() 
				+ " , value = " + entry.getValue());
			
			//this is useful - Sincerely Paula
			//map.put(entry.getKey(), entry.getValue() + 1);
		
		}
	
	}

}
