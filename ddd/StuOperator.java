import java.util.Scanner;
class StuOperator{
	static Student[] stu = new Student[10];
	public static void begin(){
		System.out.println("********��ӭ����ѧ������ϵͳ********");
		System.out.println("********��������ѡ��********");
	}

	public static void init(){
		stu[0] = new Student("����", "��");
		stu[1] = new Student("����", "Ů");
	}

	public static void menu(){
		System.out.println("1.�鿴ѧ�� 2.���ѧ�� 3.�޸�ѧ�� 4.ɾ��ѧ�� 0.�˳�");
		System.out.printf("��ѡ���ţ�");
	}
	
	public static void look(){
		System.out.println("��ѡ���˲鿴ѧ����ѧ����Ϣ���£�");
		System.out.println("���\t ����\t �Ա�");
		for(int i = 0; stu[i] != null; i ++){
			System.out.printf("%d\t %s\t %s\n", i + 1, stu[i].getName(), stu[i].getSex());
		}
	}

	public static void add(){
		Scanner read = new Scanner(System.in);
		System.out.println("��ѡ�������ѧ��");
		Student s = new Student();
		System.out.printf("������ѧ��������");
		s.setName(read.nextLine());
		System.out.printf("������ѧ���Ա�");
		s.setSex(read.nextLine());
		int idex = 0;
		while(stu[idex] != null) idex ++;  //Ѱ�ҿ������±�
		stu[idex] = s;
	}

	public static void exchange(){
		Scanner read = new Scanner(System.in);
		System.out.println("��ѡ�����޸�ѧ��");
		System.out.printf("�����������޸�ѧ���ı�ţ�");
		int idex = read.nextInt();
		read.nextLine();  //��ȡ�س�
		idex --;  //ӳ�䵽�����±�
		if(stu[idex] != null){
			System.out.printf("��ѧ������ϢΪ�� ������%s   �Ա�%s\n", stu[idex].getName(), stu[idex].getSex());
			System.out.println("��ѡ�����Ĳ�����1.�޸ĸ�ѧ�������� 2.�޸ĸ�ѧ�����Ա� 3.�޸��������Ա�");
			int c = read.nextInt();
			read.nextLine();  //��ȡ�س�
			switch(c){
				case 1:
					System.out.printf("�������ѧ��Ӧ�޸ĵ����֣�");
					String s1 = read.nextLine();
					stu[idex].setName(s1);
					break;
				case 2:
					System.out.printf("�������ѧ��Ӧ�޸ĵ��Ա�");
					String s2 = read.nextLine();
					stu[idex].setSex(s2);
					break;
				case 3:
					System.out.printf("�������ѧ��Ӧ�޸ĵ����֣�");
					String s3 = read.nextLine();
					stu[idex].setName(s3);
					System.out.printf("�������ѧ��Ӧ�޸ĵ��Ա�");
					String s4 = read.nextLine();
					stu[idex].setSex(s4);
					break;
					}
		}
		else{
			System.out.println("�������ѧ����Ų�����");
		}
	}
	
	public static void del(){
		Scanner read = new Scanner(System.in);
		System.out.println("��ѡ����ɾ��ѧ��");
		System.out.printf("����������ɾ��ѧ����ţ�");
		int idex = read.nextInt();
		idex --;   //ӳ�䵽�����±�
		if(stu[idex] != null){
			for(int i = idex; stu[i] != null; i ++){
				stu[i] = stu[i + 1];
			}
		}
		else{
			System.out.println("�������ѧ����Ų�����");
		}
	}
	public static void end(){
		System.out.println("�ټ�");
	}
}