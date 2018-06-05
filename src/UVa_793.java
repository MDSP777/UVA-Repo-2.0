import java.util.Scanner;

public class UVa_793 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			int n = sc.nextInt();
			sc.nextLine();
			int success = 0;
			int fail = 0;
			DisjointSet ds = new DisjointSet(n);
			while(sc.hasNext()) {
				String s = sc.nextLine();
				if(s.isEmpty()) break;
				String[] split = s.split("\\s+");
				if(split[0].equals("c")) ds.union(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1);
				else {
					if(ds.isSameSet(Integer.parseInt(split[1])-1, Integer.parseInt(split[2])-1)) success++;
					else fail++;
				}
			}
			System.out.println(success+","+fail);
			if(nC>0) System.out.println();
		}
	}
	
	static class DisjointSet {
		int[] p;
		int[] rank;
		
		public DisjointSet(int n) {
			p = new int[n];
			rank = new int[n];
			for(int i=0; i<n; i++) p[i] = i;
		}
		
		int findSet(int i) {
			if(p[i]==i) return i;
			p[i] = findSet(p[i]);
			return p[i];
		}
		
		boolean isSameSet(int i, int j) {
			return findSet(i)==findSet(j);
		}
		
		void union(int i, int j) {
			if(!isSameSet(i, j)) {
				int x = findSet(i);
				int y = findSet(j);
				if(rank[x]>rank[y]) p[y] = x;
				else {
					p[x] = y;
					if(rank[x]==rank[y]) rank[y]++;
				}
			}
		}
	}
}
