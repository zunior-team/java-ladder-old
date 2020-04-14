package ladder;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReduceTest {

    @Test
    void Test() {
        List<SomeObject> list = Arrays.asList(new SomeObject(1), new SomeObject(2), new SomeObject(3), new SomeObject(4));

        Integer reduce = list.stream()
                .reduce(0, (subPosition, someObject) -> someObject.calculate(subPosition), (x, y) -> {throw new IllegalArgumentException("parallel operation not allowed this logic");});


        System.out.println(reduce);
    }


    private static class SomeObject {
        private int x;
        public SomeObject(int x) {
            this.x = x;
        }
        public int calculate(int position) {
            return position + x;
        }
    }
}
