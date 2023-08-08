import java.util.Scanner;
class StuOperator{
	static Student[] stu = new Student[10];
	public static void begin(){
		System.out.println("********欢迎来到学生管理系统********");
		System.out.println("********您有如下选择********");
	}

	public static void init(){
		stu[0] = new Student("张三", "男");
		stu[1] = new Student("李四", "女");
	}

	public static void menu(){
		System.out.println("1.查看学生 2.添加学生 3.修改学生 4.删除学生 0.退出");
		System.out.printf("请选择编号：");
	}
	
	public static void look(){
		System.out.println("您选择了查看学生，学生信息如下：");
		System.out.println("编号\t 姓名\t 性别");
		for(int i = 0; stu[i] != null; i ++){
			System.out.printf("%d\t %s\t %s\n", i + 1, stu[i].getName(), stu[i].getSex());
		}
	}

	public static void add(){
		Scanner read = new Scanner(System.in);
		System.out.println("你选择了添加学生");
		Student s = new Student();
		System.out.printf("请输入学生姓名：");
		s.setName(read.nextLine());
		System.out.printf("请输入学生性别：");
		s.setSex(read.nextLine());
		int idex = 0;
		while(stu[idex] != null) idex ++;  //寻找空数组下标
		stu[idex] = s;
	}

	public static void exchange(){
		Scanner read = new Scanner(System.in);
		System.out.println("你选择了修改学生");
		System.out.printf("请输入你想修改学生的编号：");
		int idex = read.nextInt();
		read.nextLine();  //读取回车
		idex --;  //映射到数组下标
		if(stu[idex] != null){
			System.out.printf("该学生的信息为： 姓名：%s   性别：%s\n", stu[idex].getName(), stu[idex].getSex());
			System.out.println("请选择您的操作：1.修改该学生的姓名 2.修改该学生的性别 3.修改姓名及性别");
			int c = read.nextInt();
			read.nextLine();  //读取回车
			switch(c){
				case 1:
					System.out.printf("请输入该学生应修改的名字：");
					String s1 = read.nextLine();
					stu[idex].setName(s1);
					break;
				case 2:
					System.out.printf("请输入该学生应修改的性别：");
					String s2 = read.nextLine();
					stu[idex].setSex(s2);
					break;
				case 3:
					System.out.printf("请输入该学生应修改的名字：");
					String s3 = read.nextLine();
					stu[idex].setName(s3);
					System.out.printf("请输入该学生应修改的性别：");
					String s4 = read.nextLine();
					stu[idex].setSex(s4);
					break;
					}
		}
		else{
			System.out.println("您输入的学生编号不存在");
		}
	}
	
	public static void del(){
		Scanner read = new Scanner(System.in);
		System.out.println("你选择了删除学生");
		System.out.printf("请输入你想删除学生编号：");
		int idex = read.nextInt();
		idex --;   //映射到数组下标
		if(stu[idex] != null){
			for(int i = idex; stu[i] != null; i ++){
				stu[i] = stu[i + 1];
			}
		}
		else{
			System.out.println("您输入的学生编号不存在");
		}
	}
	public static void end(){
		System.out.println("再见");
	}
}