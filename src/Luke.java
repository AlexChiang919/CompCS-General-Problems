import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class Luke {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("luke.dat"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		char[][] maze = new char[T][T];
		for (int i = 0; i < T; i++)
			maze[i] = scan.readLine().toCharArray();
		int N = Integer.parseInt(scan.readLine());
		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(scan.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			printLine((bofus(maze, sr, sc)) ? "yes" : "no");
		}
		scan.close();
	}

	private static int[][] d = { { -1, 0, 1, 0 }, { 0, -1, 0, 1 } };

	public static boolean bofus(char[][] maze, int sr, int sc) {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[][] b = new boolean[maze.length][maze[0].length];
		for (boolean[] bb : b)
			Arrays.fill(bb, true);
		b[sr][sc] = false;
		q.add(sr);
		q.add(sc);
		boolean solve = false;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			if (maze[r][c] == 'L') {
				solve = true;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int rr = r + d[0][i];
				int cc = c + d[1][i];
				if (!inBounds(maze, rr, cc) || maze[rr][cc] == 'X')
					continue;
				if (b[rr][cc]) {
					b[rr][cc] = false;
					q.add(rr);
					q.add(cc);
				}
			}
		}
		q = null;
		return solve;
	}

	public static boolean inBounds(char[][] maze, int r, int c) {
		return Math.min(r, c) >= 0 && Math.max(r, c) < maze.length;
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
