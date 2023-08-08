import java.util.Scanner;

public class Lab4_5{
	public static void main(String[] args){
		Scanner read = new Scanner(System.in);
		StuOperator.begin();
		StuOperator.init();
		while(true){
			StuOperator.menu();
			int choice = read.nextInt();
			if(choice == 1) StuOperator.look();
			else if(choice == 2) StuOperator.add();
			else if(choice == 3) StuOperator.exchange();
			else if(choice == 4) StuOperator.del();
			else if(choice == 0) break;
			else System.out.println("请选择正确选项");
		}
		StuOperator.end();
	}
}