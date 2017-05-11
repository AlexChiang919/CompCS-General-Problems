import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Alex Chiang
 *
 */
public class WordCookies {

	private static final Set<String> dict = new HashSet<String>();
	private static char[] letters;
	private static boolean[] used;

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		BufferedReader scann;
		try {
			scan = new BufferedReader(new FileReader("wordcookies_letters.txt"));
			scann = new BufferedReader(new FileReader("wordcookies.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		while (scann.ready())
			dict.add(scann.readLine());
		letters = scan.readLine().toCharArray();
		Arrays.sort(letters);
		used = new boolean[letters.length];
		Arrays.fill(used, false);
		recur("");
		scan.close();
		scann.close();
	}

	public static void recur(String currentWord) {
		if (dict.contains(currentWord))
			printLine(currentWord);
		for (int i = 0; i < letters.length; i++) {
			if (!used[i]) {
				used[i] = true;
				recur(currentWord + letters[i]);
				used[i] = false;
			}
		}
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
