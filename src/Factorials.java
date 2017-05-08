import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Factorials {

	private static boolean recursion = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("factorials.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		Arrays.fill(prev, new BigInteger("1"));
		prev[0] = new BigInteger("1");
		prev[1] = new BigInteger("1");
		prev[2] = new BigInteger("2");
		while (scan.ready()) {
			int i = Integer.parseInt(scan.readLine());
			if (!recursion)
				printLine(fac(i));
			else
				printLine(facRecur(i));
		}
		scan.close();
	}
	
	private static BigInteger[] prev = new BigInteger[10000];
	
	public static BigInteger fac(int n) {
		BigInteger nn = new BigInteger("" + n);
		if (n == 0 || n == 1)
			return new BigInteger("1");
		else if (prev[n].toString().equals("1"))
			prev[n] = nn.multiply(fac(n - 1));
		return prev[n];
	}
	
	public static BigInteger facRecur(int n) {
		BigInteger nn = new BigInteger("" + n);
		if (n == 0 || n == 1)
			return new BigInteger("1");
		else
			return nn.multiply(facRecur(n - 1));
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
