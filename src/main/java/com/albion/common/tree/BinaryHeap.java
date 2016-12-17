package com.albion.common.tree;

public class BinaryHeap {

	private int[] result = null;
	private int heapSize = -1;

	public int left(int i) {
		// return (i+1)*2 - 1;
		return 2 * i + 1;
	}

	public int right(int i) {
		// return (i+1)*2;
		return 2 * i + 2;
	}

	public int parent(int i) {
		return i / 2;
	}

	public BinaryHeap(int[] aInput) {
		setResult(aInput);
	}

	public BinaryHeap(int[] aInput, boolean buildMaxHeap) {
		setResult(aInput);
		if (buildMaxHeap == true) {
			max_heapify(aInput, aInput.length, 0);
		} else {
			buildMinHeap(result);
		}
	}

	public void max_heapify(int[] A, int n, int i) {
		int l = left(i);
		int r = right(i);
		int largest = 0;
		if (l < n && A[l] > A[i]) {
			largest = l;
		} else {
			largest = i;
		}

		if (r < n && A[r] > A[largest]) {
			largest = r;
		}

		if (largest != i) {
			int temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			max_heapify(A, n, largest);
		}
	}

//	public void buildMaxHeap(int[] A) {
//		int half = A.length / 2;
//		for (int i = half - 1; i >= 0; i--) {
//			max_heapify(A, i);
//		}
//	}

	public void buildMinHeap(int[] A) {
		int half = A.length / 2;
		for (int i = half; i >= 1; i--) {
			min_heapify(A, i);
		}
	}

	public void min_heapify(int[] A, int i) {
		int l = left(i);
		int r = right(i);
		int smallest;
		if (l < A.length && A[l] < A[i]) {
			smallest = l;
		} else {
			smallest = i;
		}

		if (r < A.length && A[r] < A[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			int temp = A[smallest];
			A[smallest] = A[i];
			A[i] = temp;
			min_heapify(A, smallest);
		}
	}

	public int size() {
		return heapSize;
	}

	public int[] getResult() {
		return result;
	}

	public void setResult(int[] input) {
		result = new int [input.length];
		System.arraycopy(input, 0, result, 0, input.length);
	}
}
