package Caculator;

public class Key {
    private String key;
    public Key(String key){
        this.key = key;
    }

    public String getK() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public double getNum(){
        double num = Double.valueOf(key);
        return num;
    }
}
