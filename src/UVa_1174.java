import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UVa_1174 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int nC = Integer.parseInt(br.readLine());
		while(nC-->0) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			int nE = Integer.parseInt(br.readLine());
			int index = 0;
			HashMap<String, Integer> map = new HashMap<>();
			ArrayList<Edge> e = new ArrayList<>();
			while(nE-->0) {
				String[] split = br.readLine().split("\\s+");
				if(!map.containsKey(split[0])) map.put(split[0], index++);
				if(!map.containsKey(split[1])) map.put(split[1], index++);
				e.add(new Edge(map.get(split[0]), map.get(split[1]), Integer.parseInt(split[2])));
			}
			Collections.sort(e);
			DisjointSet ds = new DisjointSet(n);
			int total = 0;
			for(int i=0; i<e.size(); i++)
				if(!ds.isSameSet(e.get(i).src, e.get(i).dest)) {
					ds.union(e.get(i).src, e.get(i).dest);
					total+=e.get(i).weight;
				}
			System.out.println(total);
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
			return p[i]==i ? i : (p[i] = findSet(p[i]));
		}
		
		boolean isSameSet(int i, int j) {
			return findSet(i)==findSet(j);
		}
		
		void union(int i, int j) {
			if(!isSameSet(i, j)) {
				int x = findSet(i);
				int y = findSet(j);
				if(rank[y]>rank[x]) p[x] = y;
				else {
					p[y] = x;
					if(rank[x]==rank[y]) rank[x]++;
				}
			}
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;
		
		public Edge(int s, int d, int w) {
			src = s;
			dest = d;
			weight = w;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(weight, o.weight);
		}
	}
}
