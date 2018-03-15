package view;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class InputViewTest {
    @Test
    public void checkValidationPass() {
        String validName = "ABCDE";
        assertTrue(InputView.isValid(validName));
    }

    @Test
    public void checkValidationFail() {
        String invalidName = "ABCDEF";
        assertFalse(InputView.isValid(invalidName));
    }
}
