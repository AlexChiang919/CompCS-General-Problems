import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Fibonacci {

	public static void main(String[] args) throws IOException {
		boolean recursion = false;
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("fibonacci.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		long[] seq = new long[10000000];
		while (T-- > 0) {
			int n = Integer.parseInt(scan.readLine());
			if (recursion)
				printLine(fibRecur(n));
			else
				printLine(fib(n, seq));
		}
		scan.close();
	}
	
	public static long fib(int n, long[] seq) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (seq[n] == 0)
			seq[n] = fib(n - 1, seq) + fib(n - 2, seq);
		return seq[n];
	}
	
	public static long fibRecur(long n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fibRecur(n - 1) + fibRecur(n - 2);
	}

	public static void print(Object... o) {
		for (Object obj : o) {
			System.out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			System.out.println();
			return;
		}
		for (Object obj : o) {
			System.out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		System.out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
