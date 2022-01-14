package englishBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class C01 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(12, 13, 65, 3, 7, 34, 22, 60, 42, 55));
		
		getHalfOfDistictElementsInReverseOrder(list);
		
		
	}
	
	//Create a method to find the half of the elements which are distinct and greater than 5 in reverse order in the list
	
	public static void getHalfOfDistictElementsInReverseOrder(List<Integer> list) {
	List<Double> result=	list.
								stream().
								distinct().
								filter(t-> t>5).
								map(t->t/2.0).
								sorted(Comparator.reverseOrder()).
								collect(Collectors.toList());//Sonuclarý liste depolar
	System.out.println(result);
	}
	
	

}
