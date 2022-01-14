package englishBatch;

import java.util.List;

public class Utils {

	public static void printInTheSameLineWithSpace(Object o) {
		System.out.print(o+" ");
	}
	public static boolean checkToBeEven (int x) {
		return x%2==0;
	}
	
	public static boolean checkToBeOdd (int x) {
		return x%2==1;
	}
	
	public static int getSquare(int x) {
		return x*x;
	}
	public static int getCube(int x) {
		return x*x*x;
	}
	
	public static double getHalf(int x) {
		return x/2.0;
	}
}