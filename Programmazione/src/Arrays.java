public class Arrays {
	public static void inverti(int[] a){
		int i = 0;
		int j = a.length - 1;
		while(j > i){
			int tmp = a[j];
			a[j] = a[i];
			a[i] = tmp;
			i++;
			j--;
		}
	}

	public static int[] invertiNotInPlace(int[] a){
		int[] newArr = new int[a.length];
		for(int i = 0; i < a.length; i++){
			newArr[i] = a[a.length - i - 1];
		}
		return newArr;
	}

	public static int min_array(int[] a){
		int min = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i] < min){
				min = a[i];
			}
		}
		return min;
	}

	public static int max_array(int[] a){
		int max = a[0];
		for(int i = 0; i < a.length; i++){
			if(a[i] < max){
				max = a[i];
			}
		}
		return max;
	}

	public static int[] concatena(int a[], int b[]){
		int[] result = new int[a.length + b.length];
		for(int i = 0; i < a.length; i++){
			result[i] = a[i];
		}
		for(int i = 0; i < b.length; i++){
			result[i + a.length] = b[i];
		}

		return result;
	}

	public static boolean le(int a[], int b[]){
		if(a.length > b.length) return false;
		for(int i = 0; i < a.length; i++){
			if(a[i] > b[i]) return false;
		}
		return true;
	}

	public static int[][] permutazioni(int n){
		return generatePermutation(getIntegerList(n));
	}

	private static int[][] generatePermutation(int[] a){
		int[][] result = new int[Recursion.factorial(a.length)][a.length];
		if(a.length == 1){
			result[0] = a;
			return result;
		}
		int counter = 0;
		for(int i = 0; i < a.length; i++){
			int[] currentList = inserisci(0, a, i);
			int[] newList = removeFirstElement(currentList);
			int[][] permutations = generatePermutation(newList);
			for(int j = 0; j < permutations.length; j++){
				result[counter++] = concatena(new int[] {currentList[0]}, permutations[j]);
			}
		}
		return result;
	}

	private static int[] inserisci(int k, int[] a, int i){
		int[] result = new int[a.length];
		for(int j = 0; j < a.length; j++){
			if(j == i){
				result[j] = a[k];
			}else if(j == k){
				result[j] = a[i];
			}else{
				result[j] = a[j];
			}
		}
		return result;
	}

	private static int[] removeFirstElement(int[] a){
		int[] result = new int[a.length - 1];
		for(int i = 0; i < a.length - 1; i++){
			result[i] = a[i + 1];
		}

		return result;
	}

	private static int[][] concatenaMatrix(int[][] a, int[][] b){
		int[][] result = new int[a.length + b.length][a[0].length];
		for(int i = 0; i < a.length; i++){
			result[i] = a[i];
		}
		for(int j = 0; j < b.length; j++){
			result[j + a.length] = b[j];
		}
		return result;
	}


	private static int[] getIntegerList(int n){
		int[] result = new int[n];
		for(int i = 0; i < n; i++){
			result[i] = i + 1;
		}
		return result;
	}
}
