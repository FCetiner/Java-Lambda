package englishBatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 1)in functional programing we can use "Lambda expressions but if using method reference is possible
 * using Lambda expressions is not recommended
 * 2)Method Reference is like "Class Name::MethodName
 * For Example String::lenght(Be careful we dont use parenthesis  in method reference)
 */
public class Fp02 {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>(Arrays.asList(4, 13, 65, 3, 7, 4, 2, 55,12));
		
		printElements(list);
		System.out.println();
		printEvenElement(list);
		System.out.println();
		printSquareOffOddElements(list);
		System.out.println();
		printCubeOfDistinctElements(list);
		System.out.println();
		sumOfSquaresOfDistinctEvenElements(list);
		productOfCubesOfDistictEvenElements(list);
		getMaxElement(list);
		getMinElement(list);
		getMinGreaterThanSeven(list);
		getHalfOfDistictElementsInReverseOrder(list);
		
	}
	
	public static void printElements (List<Integer> list) {
		list.stream().forEach(Utils::printInTheSameLineWithSpace);
	}
	
	public static void printEvenElement(List<Integer> list) {
		list.stream().filter(Utils::checkToBeEven).forEach(Utils::printInTheSameLineWithSpace);
	}
	
	public static void printSquareOffOddElements(List<Integer> list) {
		list.stream().filter(Utils::checkToBeOdd).map(Utils::getSquare).forEach(Utils::printInTheSameLineWithSpace);
	}
	
	public static void printCubeOfDistinctElements(List<Integer> list) {
		list.stream().distinct().filter(Utils::checkToBeOdd).map(Utils::getCube).forEach(Utils::printInTheSameLineWithSpace);
	}
	
	public static void sumOfSquaresOfDistinctEvenElements(List<Integer> list) {
	Integer sum=list.stream().distinct().filter(Utils::checkToBeEven).map(Utils::getSquare).reduce(0, Math::addExact);
	System.out.println(sum);
	}
	public static void productOfCubesOfDistictEvenElements(List<Integer> list) {
	Integer product	=list.stream().distinct().filter(Utils::checkToBeEven).map(Utils::getCube).reduce(1, Math::multiplyExact);
	System.out.println(product);
	}
	
	public static void getMaxElement(List<Integer> list) {
		Integer max	=list.stream().reduce(Integer.MIN_VALUE,Math::max);
		System.out.println(max);
	}
	
	public static void getMinElement(List<Integer> list) {
		Integer min	=list.stream().reduce(Integer.MAX_VALUE,Math::min);
		System.out.println(min);
	}
	
	public static void getMinGreaterThanSeven (List<Integer> list) {
		Integer min	=list.stream().filter(t->t>7).filter(Utils::checkToBeEven).reduce(Integer.MAX_VALUE,Math::min);
	System.out.println("minimum:"+min);
	}
	
	public static void getHalfOfDistictElementsInReverseOrder(List<Integer> list){
	List<Double>result=list.stream().distinct().filter(t->t>5).map(Utils::getHalf).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
	System.out.println(result);
	}
	

}
