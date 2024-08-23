package javalab0;

public class App {

	/**
	 * 
	 * @param k is distance in cm
	 * @return distance in m
	 */

	public int integerNumbersTask(int a, int b) {
		assert (a > b);
		return a / b;
	}

	/**
	 * 
	 * @param numbers a and b
	 * @return true, if a > 2 and b < 3
	 */
	public boolean booleanTask(int a, int b) {
		return a > 2 && b < 3;
	}

	/**
	 * 
	 * @param parameter is integer numbers a, b, c
	 * @return count of positives numbers
	 */
	public int ifTask(int a, int b, int c) {
		int result = 0;

		if (a > 0) {
			result++;
		}
		if (b > 0) {
			result++;
		}
		if (c > 0) {
			result++;
		}

		return result;
	}

	/**
	 * 
	 * @param k
	 * @return return count of days in month
	 */
	public int switchTask(int k) {
		int result = 0;
		switch (k) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				result = 31;
				break;
			case 2:
				result = 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				result = 30;
				break;
		}
		return result;
	}

	/**
	 * 
	 * @param k is integer number
	 * @return 
	 */
	public int[] forTask(int k) {
		int[] result = new int[10];

		for (int i = 0; i < 10; i++) {
			result[i] += k * (i + 1);
		}

		return result;
	}

	public boolean whileTask(int n) {
		assert n > 0;
		while (n != 0) {
			if (n == 1) {
				return true;
			}
			if (n % 3 != 0) {
				return false;
			}
			n = n / 3;
		}
		return false;
	}

	public double[] arrayTask(int n, double a, double d) {
		double[] result = new double[n];

		for (int i = 0; i < n; i++) {
			result[i] = a;
			a *= d;
		}

		return result;
	}

	/**
	 * 
	 * @param m
	 * @param n
	 * @param array
	 * @return matrix m x n where each row has array
	 */
	public int[][] twoDimensionArrayTask(int m, int n, int[] array) {
		assert (array.length == n);
		int result[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = array[j];
			}
		}

		return result;
	}

	public static void main(String... strings) {
		System.out.println("Start of zero lab");
		System.out.println("Done!!!");
	}

}