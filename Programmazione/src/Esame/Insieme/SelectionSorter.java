package Esame.Insieme;

public class SelectionSorter implements Sorter {
	public void sort(int[] toSort, int n) {
		for(int i = 0; i < n; i++){
			int m = 0;
			for(int j = i+1; j < n; j++){
				if(toSort[i] > toSort[j]){
					m = j;
				}
			}
			if(i != m){
				swap(toSort, i, m);
			}
		}
	}

	private void swap(int a[], int i, int j){
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
