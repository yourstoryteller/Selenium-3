package Package6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class P6C3 {

	public static void main(String[] args) {
		
		/* 
		======== JAVA STREAMS ========
		
		. Java Streams work only with Collections.
		  If you have Array, convert Array to List.
	
		. Convert Collection to Stream for further process.
		*/
		
		
		// =========================================================================================
		
		
		// Exercise
		
		ArrayList <String> names = new ArrayList <String>();
		names.add("Vipul");
		names.add("Sana");
		names.add("Rohit");
		names.add("Sonam");
		names.add("Abhi");
		names.add("Anand");
		names.add("Sayoojya");
		names.add("Vishwanath");
		
		String [] citiesArray = {"Mumbai", "Pune", "Thane", "Nashik", "Aurangabad"}; 
		List <String> cities = Arrays.asList(citiesArray); // Convert Array to List.
		
		
		// [1] - Count no. of names in a list starting from alphabet "A".
		long count = names.stream().filter(name -> name.startsWith("A")).count();
		// System.out.println(count);
		
		
		// [2] - Print all names in a list whose length is greater than 4.
		// names.stream().filter(n -> n.length() > 4).forEach(name -> System.out.println(name));
		
		
		// [3] - Print all names in a list whose length is greater than 4 and limit result set to 2.
		// names.stream().filter(n -> n.length() > 4).limit(2).forEach(n -> System.out.println(n));
		
		
		// [4] - Print all names in a list ending with "a" in uppercase.
		// names.stream().filter(n -> n.endsWith("a")).map(n -> n.toUpperCase()).forEach(n -> System.out.println(n));
		
		
		// [5] - Print all names in a list in uppercase.
		// names.stream().map(n -> n.toUpperCase()).forEach(n -> System.out.println(n));
		
		
		// [6] - Print all names in a list in uppercase in sorted way
		// names.stream().sorted().map(n -> n.toUpperCase()).forEach(n -> System.out.println(n));
		
		
		// [7] - Merge 2 lists.
		Stream <String> mergedStream = Stream.concat(names.stream(), cities.stream());
		// mergedStream.forEach(ms -> System.out.println(ms));
		
		
		// [8] - Check Whether "Sonam" is present in Stream.
		 boolean flag = mergedStream.anyMatch(ms -> ms.equalsIgnoreCase("Sonam"));
		// System.out.println(flag);
		
		// [9] - Convert Stream back to List.
		List <String> colorsList = Stream.of("Red", "White", "Black", "Blue", "Green").map(c -> c.toLowerCase()).collect(Collectors.toList());
		// System.out.println(colorsList);
		
		// [10] - Print unique and sorted values.
		Stream.of(3, 5, 6, 4, 1, 6, 4, 12, 45, 23, 12).distinct().sorted().forEach(v -> System.out.println(v));
		
	}

}
