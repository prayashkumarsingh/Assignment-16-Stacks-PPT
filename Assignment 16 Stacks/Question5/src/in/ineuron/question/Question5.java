package in.ineuron.question;
import java.util.*;
public class Question5 {
	static Stack<Integer> st = new Stack<>();
	static void push_digits(int number) {
		while (number != 0) {
			st.push(number % 10);
			number = number / 10;
		}
	}
	static int reverseNumber(int number) {
		push_digits(number);
		int reverse = 0;
		int i = 1;
		while (!st.isEmpty()) {
			reverse = reverse + (st.peek() * i);
			st.pop();
			i = i * 10;
		}
		return reverse;
	}
	public static void main(String[] args) {
		int number = 6899;
		System.out.println(reverseNumber(number));
	}
}
