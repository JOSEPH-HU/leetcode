import java.util.ArrayList;
import java.util.List;

public class Convert{
	public static void main(String[] args) {
		String s = "LEETCODEISHIRING";
		System.out.println("LCIRETOESIIGEDHN".equals(solution(s, 3)));
		System.out.println("LDREOEIIECIHNTSG".equals(solution(s, 4)));
		
	}

	public static String solution(String s,int numRows){
		if(numRows==1){return s;}

		List<StringBuilder> rows = new ArrayList<StringBuilder>();

		for(int i=0;i<Math.min(numRows,s.length());i++){
			rows.add(new StringBuilder());
		}

		int curRow = 0;
		boolean goDown = false;

		for(char c :s.toCharArray()){
			rows.get(curRow).append(c);
			if(curRow==0 || curRow == numRows-1){
				goDown = !goDown;
			}
			curRow += goDown?1:-1;
		}

		StringBuilder sb = new StringBuilder();
		for(StringBuilder row:rows){
			sb.append(row);
		}
		return sb.toString();
	}
}
