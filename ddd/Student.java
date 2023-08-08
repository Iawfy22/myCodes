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
		if(sex.equals("男") || sex.equals("女")){
			this.sex = sex;
		}
		else{
			this.sex = "保密";
		}
	}

	public String getName(){
		return name;
	}
	public String getSex(){
		return sex;
	}

	public String toString(){
		return String.format("大家好，我叫%s，性别：%s", name, sex);
	}
}