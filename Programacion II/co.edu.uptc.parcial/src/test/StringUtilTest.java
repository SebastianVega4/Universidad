package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilTest {
    @Test
    public void testReverse() {
        StringUtil util = new StringUtil();
        String input = "Hola";
        String reversed = util.reverse(input);
        assertEquals("aloH", reversed);
    }
}
