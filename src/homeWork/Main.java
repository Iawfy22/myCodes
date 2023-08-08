package homeWork;

import homeWork.character;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入角色1名称以及初始血量：");
        String n1 = sc.next();
        int h1 = sc.nextInt();
        System.out.println("请输入角色2名称以及初始血量：");
        String n2 = sc.next();
        int h2 = sc.nextInt();

        character c1 = new character();
        c1.setName(n1);
        c1.setHp(h1);
        character c2 = new character();
        c2.setName(n2);
        c2.setHp(h2);

        while(true){
            int a1 = random.nextInt(20);
            c1.setAttack(a1);
            c2.aaa(c1);
            if(c2.getHp() <= 0){
                System.out.println(c1.getName() + "胜出");
                break;
            }

            int a2 = random.nextInt(20);
            c2.setAttack(a2);
            c1.aaa(c2);
            if(c1.getHp() <= 0){
                System.out.println(c2.getName() + "胜出");
                break;
            }
        }
    }
}