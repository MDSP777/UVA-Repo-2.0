import java.util.Scanner;

public class UVa_10755 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			long[][][] vals = new long[a][b][c];
			for(int i=0; i<a; i++)
				for(int j=0; j<b; j++)
					for(int k=0; k<c; k++) vals[i][j][k] = sc.nextLong();
			long max = 0;
			
		}
	}
}
