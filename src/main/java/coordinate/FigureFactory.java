package coordinate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory {

    private enum Type{
        ONE(1),
        TWO(2),
        THREE(3),
        SA(4);

        private int countOfMatch;
        private int winningMoney;

        private Type(int countOfMatch){
            this.countOfMatch = countOfMatch;
        }

        boolean matchSize(int countOfMatch){
            return this.countOfMatch == countOfMatch;
        }

        static Type find(int size) {
            for (Type value : Type.values()) {
                if (value.countOfMatch == size) {
                    return value;
                }
            }
            return null;
        }
    }

    private static Map<Type, FigureCreator> a = new HashMap<>();
        static {
            a.put(Type.TWO, new LineCreator());
            a.put(Type.THREE, new TriangleCreator());
            a.put(Type.SA, new RectangleCreator());
        }

    static Figure getInstance(List<Point> points) {
        FigureCreator creator = a.get( Type.find(points.size()) );
        return creator.create(points);
    }

    private static class LineCreator implements FigureCreator {
        @Override
        public Figure create(List<Point> points) {
            return new Line(points);
        }
    }

    private static class TriangleCreator implements FigureCreator {
        @Override
        public Figure create(List<Point> points) {
            return new Triangle(points);
        }
    }

    private static class RectangleCreator implements FigureCreator {
        @Override
        public Figure create(List<Point> points) {
            return new Rectangle(points);
        }
    }
}
