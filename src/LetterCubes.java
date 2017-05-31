import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class LetterCubes {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader(""));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		char[][] cubes = new char[T][];
		for (int a = 0; a < T; a++) {
			StringTokenizer st = new StringTokenizer(scan.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				cubes[a][i] = st.nextToken().charAt(0);
		}
		int words = Integer.parseInt(scan.readLine());
		while (words-- > 0) {
			String word = scan.readLine();
			
		}
		scan.close();
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
