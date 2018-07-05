import java.util.BitSet;
import java.util.Scanner;

public class UVa_12734 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int nC = sc.nextInt();
		while(nC-->0) {
			BitSet bits = new BitSet();
			for(int i=0; i<100; i+=2) bits.set(i);
			for(int i=100; i>0; i--) {
				StringBuilder sb = new StringBuilder("Ask ");
				StringBuilder ans = new StringBuilder();
				for(int j=0; j<i; j++) ans.append(bits.get(j) ? "1" : "0");
				sb.append(ans);
				System.out.println(sb.toString());
				System.out.flush();
				String n = sc.next();
//				if(n.equals("1")) {
//					sb = new StringBuilder("Answer ").append(ans);
//					System.out.println(sb);
//					System.out.flush();
//					break;
//				}
			}
		}
	}
}
