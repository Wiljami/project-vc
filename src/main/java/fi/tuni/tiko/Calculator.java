package fi.tuni.tiko;

public class Calculator {
	
	int x;
	int y;

	public Calculator() {
	
	}

	public int subtract(int minuend, int subtrahend){
		return minuend - subtrahend;
	}
	
	public int divide(int x, int y) {
		return x / y;
	}

	public int multiplication(int x, int y) {
		return x * y;
	}

	public int addition(int x, int y) {
		return x + y;
	}

	public int[] fibonacci(int x) {
		int[] series = new int[x];
		series[0] = 1;
		if (x == 1) return series;
		series[1] = 1;
		if (x == 2) return series;
		for (int n = 3; n <= x; n++) {
			series[n-1] = series[n-2] + series[n-3];
		}
		return series;
	}

	public void startPoemGenerator(){
		SecretPoemGenerator poems = new SecretPoemGenerator();
		poems.startPoemGenerator();
	}

	public void startSnake(){
		SecretSnake snake = new SecretSnake();
		snake.startSnake();
	}
}
