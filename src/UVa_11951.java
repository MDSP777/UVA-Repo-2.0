import java.util.Scanner;

public class UVa_11951 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		for(int x=1; x<=nC; x++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int k = sc.nextInt();
			int[][] grid = new int[r][c];
			int[][] sums = new int[r+1][c+1];
			for(int i=0; i<r; i++)
				for(int j=0; j<c; j++) {
					grid[i][j] = sc.nextInt();
					sums[i+1][j+1] = grid[i][j]+sums[i][j];
				}
			
		}
	}
}
