import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVa_10154 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Turtle> t = new ArrayList<>();
		do {
//			t.add(new Turtle(sc.nextInt(), sc.nextInt()));
			int w = sc.nextInt();
			int s = sc.nextInt();
			if(w==0 && s==0) break;
			
		} while(sc.hasNext());
		Collections.sort(t);
	}
	
	static class Turtle implements Comparable<Turtle> {
		int weight;
		int str;
		
		public Turtle(int w, int s) {
			weight = w;
			str = s;
		}

		@Override
		public int compareTo(Turtle o) {
			return Integer.compare(o.str-o.weight, this.str-this.weight);
		}
	}
}
