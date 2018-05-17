import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UVa_11631 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] split = br.readLine().split(" ");
			int v = Integer.parseInt(split[0]);
			int e = Integer.parseInt(split[1]);
			if(v==0 && e==0) break;
			Vertex[] vertices = new Vertex[v];
			for(int i=0; i<v; i++) vertices[i] = new Vertex(i);
			Edge[] edges = new Edge[e];
			int totalWeight = 0;
			for(int i=0; i<e; i++) {
				split = br.readLine().split(" ");
				edges[i] = new Edge(i, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
				totalWeight += edges[i].weight;
				vertices[Integer.parseInt(split[0])].edgeIds.add(i);
				vertices[Integer.parseInt(split[1])].edgeIds.add(i);
			}
			PriorityQueue<Edge> q = new PriorityQueue<>();
			boolean[] connected = new boolean[v];
			boolean[] addedEdge = new boolean[e];
			connected[0] = true;
			int totalVertices = 1;
			int bestWeight = 0;
			for(int i=0; i<vertices[0].edgeIds.size(); i++) {
				q.add(edges[vertices[0].edgeIds.get(i)]);
				addedEdge[vertices[0].edgeIds.get(i)] = true;
			}
			while(totalVertices<v) {
				Edge newEdge = q.poll();
				while(connected[newEdge.src] && connected[newEdge.dest]) newEdge = q.poll();
				Vertex newVertex = vertices[connected[newEdge.src] ? newEdge.dest : newEdge.src];
				if(connected[newEdge.src]) connected[newEdge.dest] = true;
				else connected[newEdge.src] = true;
				bestWeight += newEdge.weight;
				totalVertices++;
				for(int i=0; i<newVertex.edgeIds.size(); i++)
					if(!addedEdge[newVertex.edgeIds.get(i)]) {
						addedEdge[newVertex.edgeIds.get(i)] = true;
						q.add(edges[newVertex.edgeIds.get(i)]);
					}
			}
			sb.append(totalWeight-bestWeight).append("\n");
		}
		System.out.print(sb);
	}

	static class Vertex {
		int id;
		ArrayList<Integer> edgeIds;
		
		public Vertex(int id) {
			this.id = id;
			edgeIds = new ArrayList<>();
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int id;
		int src; 
		int dest;
		int weight;
		
		public Edge(int id, int src, int dest, int weight) {
			this.id = id;
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
}
