import java.util.ArrayList;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<Boolean>();

    public void addTrueFalse(Boolean bool) {
        points.add(bool);
    }

    public void checkNext() {
        for (int i = 0; i < points.size() - 1; i++) {
            setValue(i);
        }
    }

    public Boolean setValue(int i){
        if (points.get(i).booleanValue() == true && i != points.size() -1){
            points.set(i + 1, false);
            return points.get(i + 1);
        }
        return points.get(i);
    }

    public int sizeLine(){
        return points.size();
    }

    public String result(int i){
        checkNext();
        if (points.get(i).booleanValue() == true && i != points.size() -1)
            return "-----";
        return "     ";
    }

//    @Override
//    public String toString() {
//        return "Line{" +
//                "points=" + points +
//                '}';
//    }
}