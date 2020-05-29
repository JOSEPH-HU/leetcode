public class Tictactoe{
	public static void main(String[] args) {
		String []board = {"OOXXOXXX","XXXOXOXO","OXOXXXOO","XOXOXXXX","OXOOXOOO","XOOOOOOO","OXXXOOOX","XOXOOXXX"};
		assert "Draw"== solution(board);
		String []board1 = {"OOX","XXO","OX "};
		assert "Pending" == solution(board1);
		String []board2 = {"OOX","XXO","OXO"};
		assert "Draw" == solution(board2);
		String[] board3 = {"O X"," XO","X O"};
		assert "X" == solution(board3);
		String[] board4 = {"OX ","OO ","XXO"};
		assert "O" == solution(board4);
	}

	public static String solution(String[] board){
		if(board.length==1){
			return board[0]; }

		int len = board.length;

		//转换成二维数组
		char[][] arrs = new char[len][len];
		for(int i=0;i<len;i++){
			arrs[i] = board[i].toCharArray();
		}
		boolean flag = false;
		int value = 0;
		//判断行
		for(int i=0;i<len;i++){
			value = 0;
			for(int j=0;j<len;j++){
				if(arrs[i][j]=='X'){
					value++;
				}else if(arrs[i][j]=='O'){
					value--;
				}else if(arrs[i][j] == ' '&& !flag){
					flag = true;
				}
			}
				if(value==len){
					return "X";
				}
				if(value+len==0){
					return "O";
				}
		}

		//判断列
		value = 0;
		for(int i=0;i<len;i++){
			value = 0;
			for(int j=0;j<len;j++){
				if(arrs[j][i]=='X'){
					value++;
				}else if(arrs[j][i]=='O'){
					value--;
				}else if(arrs[j][i]==' ' && !flag){
					flag = true;
				}
			}
			if(value==len){
				return "X";
			}
			if(value+len==0){
				return "O";
			}
		}

		//正对角线
		value = 0;
		for(int i=0;i<len;i++){
			if(arrs[i][i]=='X'){
				value++;
			}else if(arrs[i][i]=='O'){
				value--;
			}else if(arrs[i][i]==' '&&!flag){
				flag = true;
			}
		}
		if(value==len){
			return "X";
		}
		if(value+len==0){
			return "O";
		}

		//反向对角线
		value = 0;
		for(int i=0;i<len;i++){
			if(arrs[i][len-i-1]=='X'){
				value++;
			}else if(arrs[i][len-i-1]=='O'){
				value--;
			}else if(arrs[i][len-i-1] == ' '&&!flag){
				flag = true;
			}
		}
		if(value==len){
			return "X";
		}
		if(value+len==0){
			return "O";
		}

		if(flag){
			return "Pending";
		}

		return "Draw";

		}
}
