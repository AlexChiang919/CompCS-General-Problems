import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 
 * @author Alex Chiang
 *
 */
public class CoinChange {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader(""));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		while (T-- > 0) {
			int change = (int) (Double
					.parseDouble(scan.readLine().substring(1)) * 100);
			int N = Integer.parseInt(scan.readLine());
			HashMap<Character, Integer> denoms = new HashMap<Character, Integer>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(scan.readLine());
				denoms.put(st.nextToken().charAt(0),
						Integer.parseInt(st.nextToken()));
				ArrayList<Character> coins = dp(denoms, change);
				
			}
		}
		scan.close();
	}
	
	public static ArrayList<Character> dp(HashMap<Character, Integer> denoms, int change) {
		char check = check(change, denoms);
		if (change == 0)
			return null;
		return null;
	}

	public static char check(int change, HashMap<Character, Integer> denoms) {
		for (char c : denoms.keySet())
			if (change == denoms.get(c))
				return c;
		return '.';
	}
	
	public static String out(ArrayList<Character> coins, HashMap<Character, Integer> denoms) {
		TreeMap<Integer, Character> tree = new TreeMap<Integer, Character>();
		for (char c : denoms.keySet())
			tree.put(denoms.get(c), c);
		Collections.sort(coins, null);
		return null;
	}
	
	public static void vuh() {
		
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
