public class Search {
    public static int binarySearch(int[] a, int x){
        int i = 0;
        int j = a.length - 1;
        int start = (i+j)/2;
        while(i != j && a[start] != x){
            if(a[start] < x){
                i = start;
            }else{
                j = start;
            }
            start = (i+j) / 2;
        }
        return a[start] == x ? start : -1;
    }

    public static int[] insertionSort(int[] a){
        int[] res = new int[a.length];
        for(int i = 0; i < a.length; i++){
            int j = trovaIndiceDoveInserire(res, a[i], i);
            inserisci(res, j, a[i]);
        }
        return res;
    }

    public static void selectionSort(int[] a){
        for(int i = 0; i < a.length; i++){
            int m = 0;
            for(int j = i+1; j < a.length; j++){
                if(a[i] > a[j]){
                    m = j;
                }
            }
            if(i != m){
                swap(a, i, m);
            }
        }
    }

//    public static int[] mergeSort(int[] a){
//        if(a.length <= 1){
//            return a;
//        }
//        return merge(copy(a, 0, a.length/2), copy(a, a.length/2, a.length));
//    }

    public static void mergeSort(int[] a, int from, int to){
        if(from < to){
            int middle = (from+to)/2;
            mergeSort(a, from, middle);
            mergeSort(a, middle+1, to);
            merge(a, from, middle, to);
        }
    }

    private static void merge(int[] a, int from, int middle, int to){
        int[] b = new int[to-from+1];
        int i = from;
        int j = middle + 1;
        int k = 0;
        while(i <= middle && j <= to){
            if(a[i] < a[j]){
                b[k] = a[i++];
            }else{
                b[k] = a[j++];
            }
            k++;
        }
        while(i <= middle){
            b[k++] = a[i++];
        }
        while(j <= to){
            b[k++] = a[j++];
        }
        for(int q = from; q <= to; q++){
            a[q] = b[q-from];
        }
    }

//    public static int[] merge(int[] a, int[] b){
//        int[] result = new int[a.length + b.length];
//        int c = 0;
//        int i = 0;
//        int j = 0;
//        while(i < a.length){
//            while(j < b.length && b[j] < a[i]){
//                result[c++] = b[j++];
//            }
//            result[c++] = a[i++];
//        }
//        while(j < b.length){
//            result[c++] = b[j++];
//        }
//        return result;
//    }

    private static int[] copy(int[] a, int left, int right){
        int[] res = new int[right+left-1];
        for(int i = left; i<=right; i++){
            res[i-left] = a[i];
        }
        return res;
    }

    private static void swap(int a[], int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int trovaIndiceDoveInserire(int[] a, int v, int last){
        for(int i = 0; i < last; i++){
            if(a[i] > v) return i;
        }
        return last;
    }

    private static void inserisci(int[] a, int i, int x){
        if(i < 0 || i >= a.length) return;
        for(int j = 0; j < a.length; j++){
            int tmp = a[j];
            a[j] = x;
            x = tmp;
        }
    }
}
