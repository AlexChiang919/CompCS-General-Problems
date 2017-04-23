import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class SimpleMaze {

	static boolean draw = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader scan;
		try {
			scan = new BufferedReader(new FileReader("simplemaze.txt"));
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
			for (int i = 0; i < rs; i++) {
				maze[i] = scan.readLine().toCharArray();
			}
			int[] start = linearSearch(maze, 'o');
			printLine("Shortest Path: " + bofus(maze, start[0], start[1]));
			printArray(maze);
			printLine();
		}
		scan.close();
	}

	public static int[] linearSearch(char[][] array, char ch) {
		for (int r = 0; r < array.length; r++)
			for (int c = 0; c < array[r].length; c++)
				if (array[r][c] == ch)
					return new int[] { r, c };
		return new int[] { -1, -1 };
	}
	
	private static int[][] d = { {-1, 0, 1, 0}, {0, -1, 0, 1} };

	public static int bofus(char[][] array, int sr, int sc) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(sr);
		q.add(sc);
		int[][] dis = new int[array.length][array[0].length];
		for (int[] i : dis)
			Arrays.fill(i, 1000000);
		dis[sr][sc] = 0;
		int er = -1;
		int ec = -1;
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			if (array[r][c] == '?') {
				er = r;
				ec = c;
			}
			for (int i = 0; i < 4; i++) {
				int rr = r + d[0][i];
				int cc = c + d[1][i];
				if (!inBounds(array, rr, cc) || array[rr][cc] == '#')
					continue;
				if (dis[r][c] + 1 < dis[rr][cc]) {
					dis[rr][cc] = dis[r][c] + 1;
					q.add(rr);
					q.add(cc);
				}
			}
		}
		if (draw)
			draw(array, dis, er, ec);
		if (!(Math.min(er, ec) <= -1))
			return dis[er][ec];
		return -1;
	}
	
	public static void draw(char[][] array, int[][] dis, int er, int ec) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(er);
		q.add(ec);
		List<Integer> used = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			int r = q.poll();
			int c = q.poll();
			for (int i = 0; i < 4; i++) {
				int rr = r + d[0][i];
				int cc = c + d[1][i];
				if (!inBounds(array, rr, cc) || array[rr][cc] == '#')
					continue;
				if (array[rr][cc] == 'o')
					break;
				if (dis[r][c] - 1 == dis[rr][cc] && !used.contains(dis[rr][cc])) {
					used.add(dis[rr][cc]);
					array[rr][cc] = '.';
					q.add(rr);
					q.add(cc);
				}
			}
		}
	}
	
	public static void printArray(char[][] array) {
		for (char[] ch : array) {
			for (char c : ch)
				print(c);
			printLine();
		}
	}
	
	public static boolean inBounds(char[][] array, int r, int c) {
		return (Math.min(r, c) >= 0) && (r < array.length) && (c < array[r].length);
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
