package lottoGame.domain;

public class Lotto {
    String name = "";
    int num = 0;

    public Lotto(String name, int num){
        this.name = name;
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }
}
