package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class NamesTest {
    @Test
    public void nameTester() {
        ArrayList<String> tester = new ArrayList<String>(Arrays.asList("joe", "jane", "josh"));
        assertEquals(true, Names.checkLengthOfNames(tester));

        ArrayList<String> tester1 = new ArrayList<String>(Arrays.asList("joseph", "jane"));
        assertEquals(false, Names.checkLengthOfNames(tester1));
    }


}