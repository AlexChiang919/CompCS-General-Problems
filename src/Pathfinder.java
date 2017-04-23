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
public class Pathfinder {

	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("pathfinder.txt"));
		} catch (FileNotFoundException ex) {
			printF(true, "File not found: %s", ex.getMessage());
			return;
		}
		int T = Integer.parseInt(scan.readLine());
		while (T-- > 0) {
			StringTokenizer st = new StringTokenizer(scan.readLine());
			int rs = Integer.parseInt(st.nextToken());
			int cs = Integer.parseInt(st.nextToken());
			char[][] maze = new char[rs][cs];
			long[][] steps = new long[rs][cs];
			for (long[] s : steps)
				Arrays.fill(s, -1);
			for (int i = 0; i < rs; i++)
				maze[i] = scan.readLine().toCharArray();
			printLine(dp(maze, 0, 0, steps));
		}
		scan.close();
	}
	
	public static long dp(char[][] maze, int r, int c, long[][] steps) {
		if (!inBounds(maze, r, c) || maze[r][c] == '#')
			return 0;
		if (r == maze.length - 1 && c == maze.length - 1)
			return 1;
		else if (steps[r][c] == -1)
			steps[r][c] = dp(maze, r + 1, c, steps) + dp(maze, r, c + 1, steps);
		return steps[r][c];
	}
	
	public static boolean inBounds(char[][] maze, int r, int c) {
		return Math.min(r, c) >= 0 && r < maze.length && c < maze[r].length;
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
