package java112.labs1;
import java.util.*;

//this class is created to demonstrate List and Set

public class ListSetDemo {

	public static void main(String[] args) {
	
		List<String> list = new ArrayList<String>();
		//or you could write List<String> list = new ArrayList<>();
		list.add("first");
		list.add("first");
		list.add("second");
		list.add("Second");
		list.add("FIRST");
		list.add("third");
		list.add("fourth");
		
		System.out.println();
		System.out.println(list);
		System.out.println();
		
		Set<String> set = new TreeSet<>(list);
		
		System.out.println();
		System.out.println(set);
		System.out.println();
		
		for (String token : list) {
			System.out.println(token);
		}
		
		System.out.println();
		
		for (String tolkien : set) {
			System.out.println(tolkien);
		}
		
	}
	
	
}
