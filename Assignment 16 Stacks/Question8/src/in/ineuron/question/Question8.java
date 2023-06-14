package in.ineuron.question;
import java.util.*;
public class Question8 {
	static void leftSmaller(int arr[], int n, int SE[]) {
		Stack<Integer> S = new Stack<>();
		for (int i = 0; i < n; i++) {
			while (!S.empty() && S.peek() >= arr[i]) {
				S.pop();
			}
			if (!S.empty()) {
				SE[i] = S.peek();
			}
			else {
				SE[i] = 0;
			}
			S.push(arr[i]);
		}
	}
	static int findMaxDiff(int arr[], int n) {
		int[] LS = new int[n];
		leftSmaller(arr, n, LS);
		int[] RRS = new int[n];
		reverse(arr);
		leftSmaller(arr, n, RRS);
		int result = -1;
		for (int i = 0; i < n; i++) {
			result = Math.max(result, Math.abs(LS[i] - RRS[n - 1 - i]));
		}
		return result;
	}

	static void reverse(int a[]) {
		int i, k, n = a.length;
		int t;
		for (i = 0; i < n / 2; i++) {
			t = a[i];
			a[i] = a[n - i - 1];
			a[n - i - 1] = t;
		}
	}
	public static void main(String args[]) {
		int arr[] = {5,1,9,2,5,1,7};
		int n = arr.length;
		System.out.println("Maximum diff : " + findMaxDiff(arr, n));
	}
}
