import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Factorials {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("factorials.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		Arrays.fill(prev, 1);
		prev[0] = 1;
		prev[1] = 1;
		prev[2] = 2;
		prev[3] = 6;
		while (scan.ready()) {
			int i = Integer.parseInt(scan.readLine());
			printLine(fac(i));
		}
		scan.close();
	}
	
	private static long[] prev = new long[50];
	
	public static long fac(int n) {
		if (n == 0 || n == 1)
			return 1;
		else
			prev[n] = n * fac(n - 1);
		return prev[n];
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
