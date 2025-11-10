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
		if(a.length == 1){
			return new int[][] { a };
		}
		int[][] result = new int[Recursion.factorial(a.length)][a.length];
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

    public static int[][] permutazioni2(int n){
		if(n == 1){
			return new int[][] { { 1 } };
		}
        int[][] permutations = permutazioni2(n - 1);
        int[][] res = new int[n * permutations.length][n];
		int k = 0;
		for(int i = 0; i < permutations.length; i++){
			int[] current = new int[n];
			copyStartingFromIndex(permutations[i], 0, current);
			for(int q = 0; q < n; q++){
				res[k++] = inserisci(n, current, q);
			}
		}

        return res;
    }

	private static int[] inserisci(int k, int[] a, int i){
		if(i < 0 || i > a.length) return new int[] {};
		int[] res = new int[a.length];
		copyStartingFromIndex(a, 0, res);
		for(int j = i; j < a.length; j++){
			int tmp = res[j];
			res[j] = k;
			k = tmp;
		}
		return res;
	}

    private static void copyStartingFromIndex(int[] a, int k, int[] result){
        for(int i = 0; i < a.length; i++){
        	if(i + k >= result.length) return;
            result[i + k] = a[i];
        }
    }

    private static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

	private static int[] removeFirstElement(int[] a){
		int[] result = new int[a.length - 1];
		for(int i = 0; i < a.length - 1; i++){
			result[i] = a[i + 1];
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
