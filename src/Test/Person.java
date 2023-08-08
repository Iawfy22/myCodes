package Test;

public class Person {
    String name;
    int age;
    static String sex;
    public Person(){   //无参构造方法
        this("猪猪侠", 6);
    }
    public Person(String name, int age){  //含参构造方法
        this.name = name;
        this.age = age;
    }
    public Person(int age){
        this.age = age;
    }
    public void speak(){
        System.out.println("大家好，我叫" + name + "，今年" + age + "岁");
    }
    public static void eat(){
        System.out.println("正在吃饭！");
    }
}
