package englishBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Fp03 {

	public static void main(String[] args) {
		 List<String> list = new ArrayList<String>(Arrays.asList("Mehmet", "emre", "nilgun", "yýldýx", "kader", "emine", "islam", "islam", "emre"));

		 printInUpperCases01(list);
		 System.out.println();
		 printElementsSortedLenghts(list);
		 System.out.println();
		 printDistictSortedByLastCharacter(list);
		 System.out.println();
		 printSortedByLenghtFirstThenByInitial(list);
		 System.out.println();
		 removeIfTheLengthIsGreaterThanFive(list);
	}
	//Create a method to print all list elements in upperCase
	
	public static void printInUpperCases01(List<String> list) {
		list.stream().map(String::toUpperCase).forEach(Utils::printInTheSameLineWithSpace);
	}
	//2. way
//	public static void printInUpperCases02(List<String> list) {
//		list.replaceAll(String::toUpperCase);
//		System.out.println(list);
//	}
	
	//Create a method to print elements after ordering according to their lenghts
	
	public static void printElementsSortedLenghts(List<String> list) {
		list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printInTheSameLineWithSpace);
	}
	
	//Create a method to print elements after ordering according to their lenghts in reverse order
	
		public static void printElementsReversedSortedLenghts(List<String> list) {
			list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Utils::printInTheSameLineWithSpace);
		}
	
	//Create a method to sort the distinct elements by using their test characters
		
		public static void printDistictSortedByLastCharacter(List<String> list) {
			list.stream().distinct().sorted(Comparator.comparing(Utils::getLastChar)).forEach(Utils::printInTheSameLineWithSpace);
		}
		
		//Create a method to sort the elements according to their lengths then according to their first character
		
		public static void printSortedByLenghtFirstThenByInitial(List<String> list) {
			list.stream().sorted(Comparator.comparing(String::length).thenComparing(Utils::getFirstChar)).forEach(Utils::printInTheSameLineWithSpace);

		}
		
		//remove the elements if the length of the element is greater than 5
		
		private static void removeIfTheLengthIsGreaterThanFive(List<String> list) {
			list.removeIf(t-> t.length()>5);
			System.out.println(list);
		}
		//Remove the elements if the length is between 8 and 10 or ending with "0"
		
		//streamdan sonra remove methodlari kullanýlamýyor
//		public static void removeElementIfLengthisBetween8and10orEndingWithO(List<String> list) {
//			list.removeIf(t-> t.length()>7 && t.length()<11||t.endsWith("o"));
//			System.out.println(list);
//		}
		
		//create a method to check if the length of all elements are less than 12
		
		public static boolean checkToBeLessThanTwelwe(List<String> list) {
		return	list.stream().allMatch(t-> t.length()<12);
		}
	
}
