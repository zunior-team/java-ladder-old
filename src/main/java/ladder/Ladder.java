package ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Ladder {
    private List<Line> ladders;
    private int height;
    private List<String> people;

    public Ladder(int height, String[] people) {
        this.height = height;
        //배열에서 ArrayList로.
        this.people = Arrays.asList(people);
        ladders = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ladders.add(new Line(people.length));
        }
    }

    //매개변수를 최대한 없애기 위해 만들어 보았고 전역변수를 이용하는 연습을 해보려고 get메소드를 만들었다.
    public List<String> getPeople() {
        return people;
    }

    public List<Line> getLadders() {
        return ladders;
    }

    public void makeLadders() {
        for (int i = 0; i < height; i++) {
            ladders.get(i).oneLine(people.size());
        }
    }

    public HashMap<Integer, Integer> moveLine() {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < people.size(); i++) {
            hash.put(i, userPossition(i));
//            System.out.println(people[i]);
        }
        return hash;
    }

    //foreach문을 사용할 때는 배열이나 리스트에 원소값만 가져올 때
    //하지만 인덱스가 필요할때는 사용할 수 없다.
    public int userPossition(int position) {
        for (Line line : ladders) {
            position = line.move(position);
        }
        return position;
    }
}