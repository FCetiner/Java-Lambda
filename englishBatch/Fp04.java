package englishBatch;import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Fp04 {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<>(Arrays.asList(12,9,13,4,9,2,5,12,15));;
	
		System.out.println(getSumFromSevenToHundred());
		System.out.println(getMultiplationOfIntegersFromTwoToEleven());
		System.out.println(getFactorial(5));
		System.out.println(calculateSumOfEven(-2, -5));
		System.out.println(calculateSumOfDigitsInGivenRange(23, 32));
	
	
	
	
	} 
	//create a method to find the sum of int from 7 to 100
	//list olmadan çözeceðiz
	//1.st way
	public static int getSumFromSevenToHundred() {
		//Instream does the same with for loop in structured programing
		return IntStream.range(7, 101).reduce(0, Math::addExact);
	}
	
	
	//2.st way rangeClosed iki kýsýmda inclusivedir
		public static int getSumFromSevenToHundred2() {
			
			return IntStream.rangeClosed(7, 100).reduce(0, Math::addExact);
		}
		
	//	create a method to find the multiplation of the integers from 2 to 11 both inv

		private static int getMultiplationOfIntegersFromTwoToEleven() {
			return IntStream.rangeClosed(2, 11).reduce(1, Math::multiplyExact);
		}

//create a method to find the factorial of a given number
		public static int getFactorial(int num) {
			return IntStream.rangeClosed(1, num).reduce(1, Math::multiplyExact);
		}

		public static Object getFactorial02(int num) {
			return num>0 ? IntStream.rangeClosed(1, num).reduce(1, Math::multiplyExact) : "Dont use negative numbers";
		}
		
		//create a method to calculate the sum of even integers between two integers
		//Intstreamde sum methodu kullanýlabilir
		public static int calculateSumOfEven(int x, int y) {
		int a=0;
		if (x>y) {
			a=x;
			x=y;
			y=a;
		}
				
	return  IntStream.rangeClosed(x, y).filter(Utils::checkToBeEven).sum();
		}

		//create a method to calculate the sum of digits of every integers between two integers

		private static int calculateSumOfDigitsInGivenRange(int x, int y) {
			return IntStream.rangeClosed(x, y).map(Utils::getSumOfDigits).sum();
		}

}
