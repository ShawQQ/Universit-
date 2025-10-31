public class Recursion {
	public static int factorial(int n){
		return n == 1 ? 1 : n * factorial(n - 1);
	}

	public static int fibonacci(int n){
		return n == 0 || n == 1 ? 1 : fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static double potenza(double a, int n){
		if(n == 0) return 1;
		return a * potenza(a, n - 1);
	}

	public static String toBase(int n, int base){
		return _toBase(n, base, "");
	}

	public static boolean isPrime(int n){
		if(n <= 1) return false;
		return _isPrime(n, 2);
	}

	private static boolean _isPrime(int n, int k){
		if(n == k) return true;
		if(n % k == 0) return false;
		return _isPrime(n, k + 1);
	}


	private static String _toBase(int n, int base, String result){
		if(n == 0 && result != "") return result;
		return _toBase(n/base, base, digitOf(n % base) + result);
	}

	private static char digitOf(int d){
		if(d < 10){
			return ((char) ('0' + d));
		}else{
			return ((char) ('A' + (d - 10)));
		}
	}
}
