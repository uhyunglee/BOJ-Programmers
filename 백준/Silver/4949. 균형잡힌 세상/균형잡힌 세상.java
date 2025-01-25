import java.io.*;
import java.util.*;

public class Main {

	static int T;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		while(true) {
			
			
			String end = br.readLine();
			if(end.equals("."))
				break;
			
			StringTokenizer st = new StringTokenizer(end,"[]()",true);

			Stack<String> stk = new Stack<>();
			
			boolean flag = true;
			
			while(st.hasMoreTokens()) {
				String temp = st.nextToken();
				
				if(temp.equals("(") || temp.equals("[")) {
					stk.push(temp);
				}else if(temp.equals(")")) {
					if(stk.isEmpty()) {
						flag = false;
						break;
					}
					if(stk.peek().equals("("))
						stk.pop();
					else {
						flag = false;
						break;
					}
				}else if(temp.equals("]")) {
					if(stk.isEmpty()) {
						flag = false;
						break;
					}
					if(stk.peek().equals("["))
						stk.pop();
					else {
						flag = false;
						break;
					}
				}

			}

			
			if(flag && stk.isEmpty())
				sb.append("yes").append("\n");
			else
				sb.append("no").append("\n");
		}
		
	
		System.out.println(sb);

		}
	
	
}