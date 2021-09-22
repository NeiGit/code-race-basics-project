import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    @DisplayName("sum | given 2 and 3 | result should be 5")
    public void sumOk() {
        // given
        int n1 = 2;
        int n2 = 3;

        // when
        final int sum = sum(n1, n2);

        // then
        assertEquals(5, sum);
    }

    private static int sum(int n1, int n2) {
        return n1 + n2;
    }
}
