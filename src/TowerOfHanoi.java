import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

/**
 * 
 * @author Alex Chiang
 *
 */
public class TowerOfHanoi {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("towerofhanoi.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		while (T-- > 0) {
			int disks = Integer.parseInt(scan.readLine());
			printLine(disks);
			Stack<Integer> a = new Stack<Integer>(), b = new Stack<Integer>(), c = new Stack<Integer>();
			for (int i = disks; i > 0; i--)
				a.add(i);
			if (disks % 2 == 0) {
				while (!check(c, disks)) {
					if (check(a, b)) {
						b.add(a.pop());
						printLine("A->B");
					} else {
						a.add(b.pop());
						printLine("B->A");
					}
					if (check(c, disks))
						break;
					if (check(a, c)) {
						c.add(a.pop());
						printLine("A->C");
					} else {
						a.add(c.pop());
						printLine("C->A");
					}
					if (check(c, disks))
						break;
					if (check(b, c)) {
						c.add(b.pop());
						printLine("B->C");
					} else {
						b.add(c.pop());
						printLine("C->B");
					}
				}
			} else {
				while (!check(c, disks)) {
					if (check(a, c)) {
						c.add(a.pop());
						printLine("A->C");
					} else {
						a.add(c.pop());
						printLine("C->A");
					}
					if (check(c, disks))
						break;
					if (check(a, b)) {
						b.add(a.pop());
						printLine("A->B");
					} else {
						a.add(b.pop());
						printLine("B->A");
					}
					if (check(c, disks))
						break;
					if (check(b, c)) {
						c.add(b.pop());
						printLine("B->C");
					} else {
						b.add(c.pop());
						printLine("C->B");
					}
				}
			}
		}
		scan.close();
	}
	
	public static boolean check(Stack<Integer> c, int disks) {
		return c.size() == disks;
	}
	
	public static boolean check(Stack<Integer> s1, Stack<Integer> s2) {
		if (s1.size() == 0)
			return false;
		if (s2.size() == 0)
			return true;
		return s1.peek() < s2.peek();
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
