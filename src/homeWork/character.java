package homeWork;

public class character {
    private String name;
    private int hp;
    private int attack;

    public void setName(String name){
        this.name = name;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public String getName(){
        return name;
    }
    public int getHp(){
        return hp;
    }
    public int getAttack(){
        return attack;
    }
    public void aaa(character c){
        hp = (hp - c.getAttack() > 0) ? hp - c.getAttack() : 0;
        System.out.println(c.getName() + "正在攻击" + name + "," + name + "掉血" + c.getAttack() + ",剩余血量" + hp);
    }
}
