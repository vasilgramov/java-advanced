import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class p07_validTimeTest {
    @Test
    public void test() {
        String[] inputs = { "12:33:24 AM", "33:12:11 PM", "inv 23:52:34 AM", "00:13:23 PM", "9:3:12 АМ" };

        String[] expectedResult = { "valid", "invalid", "invalid", "invalid", "invalid" };

        int counter = 0;
        for (String input : inputs) {
            String result = p07_validTime.isValid(input);

            assertEquals(expectedResult[counter], result);
            counter++;
        }
    }
}