import java.util.Scanner;
class Student{
	private String name;
	private String sex;

	public Student(){

	}

	public Student(String name, String sex){
		this.name = name;
		this.sex = sex;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setSex(String sex){
		if(sex.equals("��") || sex.equals("Ů")){
			this.sex = sex;
		}
		else{
			this.sex = "����";
		}
	}

	public String getName(){
		return name;
	}
	public String getSex(){
		return sex;
	}

	public String toString(){
		return String.format("��Һã��ҽ�%s���Ա�%s", name, sex);
	}
}