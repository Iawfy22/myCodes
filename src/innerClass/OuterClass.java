package innerClass;


//内部类
public class OuterClass {
    public static void main(String[] args) {
        //创建Person的静态成员内部类的实例
        Person.Dog dog = new Person.Dog();
        dog.eat();

        //非静态内部类
//        Person.Bird bird = new Person.Dog();  //报错  因为是非静态，所以不属于类
        Person p1 = new Person();  //要先实例化外部类
        Person.Bird bird = p1.new Bird();  //由外部类对象再进行创建内部类对象
        bird.eat();

    }
}

class Person {

    int a;

    public Person() {
    }

    public Person(int a) {
        this.a = a;
    }

    //静态内部类
    static class Dog{   //只供Person类使用
        public void eat(){
            System.out.println("吃骨头");
        }
    }

    //非静态内部类
    class Bird{
        public void eat(){
            System.out.println("吃虫子");
        }
    }

    //内部类
    public void method(){
        //非匿名
        class InnerClass1{

        }
    }
}
