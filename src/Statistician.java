import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Statistician {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("statistician.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(scan.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long[] arr = new long[m + 1];
			Arrays.fill(arr, -1);
			printLine(String.format("%.2f", dp(m, n, arr) / ((double) m - 1) * 100.0) + "%");
		}
		scan.close();
	}

	public static long dp(int end, int digit, long[] arr) {
		if (digit == 0)
			return 0;
		if (end == digit)
			arr[digit] = 1;
		if (arr[end] == -1)
			arr[end] = (String.valueOf(end).contains("" + digit) ? 1 : 0) + dp(end - 1, digit, arr);
		return arr[end];
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
