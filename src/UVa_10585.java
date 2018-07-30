import java.util.Scanner;

public class UVa_10585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			int[][] dist = new int[n][n];
			int[][] time = new int[n][n];
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++) if(i!=j) dist[i][j] = time[i][j] = 2000000;
			while(e-->0) {
				int src = sc.nextInt()-1;
				int dest = sc.nextInt()-1;
				int t = sc.nextInt();
				int d = sc.nextInt();
				if(t<time[src][dest] || (t==time[src][dest] && d<dist[src][dest])) {
					time[src][dest] = time[dest][src] = t;
					dist[src][dest] = dist[dest][src] = d;
				}
			}
			for(int k=0; k<n; k++)
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						if(time[i][k]+time[k][j]<time[i][j]) {
							time[i][j] = time[i][k]+time[k][j];
							dist[i][j] = dist[i][k]+dist[k][j];
						} else if(time[i][k]+time[k][j]==time[i][j] && dist[i][k]+dist[k][j]<dist[i][j])
							dist[i][j] = dist[i][k]+dist[k][j];
			int q = sc.nextInt();
			while(q-->0) {
				int src = sc.nextInt()-1;
				int dest = sc.nextInt()-1;
				System.out.println(time[src][dest]==2000000 ? "No Path." : "Distance and time to reach destination is "+dist[src][dest]+" & "+time[src][dest]+".");
			}
			if(nC>0) System.out.println();
		}
	}
}
