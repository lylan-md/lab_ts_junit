import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

public class CustomMathTest {
    public static Collection sumValues() {
        return Arrays.asList(new Object[][] {
                {1,1,2},
                {-1,1,0},
                {10,15,25}
        });
    }

    public static Collection divisionValues() {
        return Arrays.asList(new Object[][] {
                {4,2,2},
                {-30,3,-10},
                {10,0,0}
        });
    }

    @ParameterizedTest
    @MethodSource("sumValues")
    public void testSum(int x, int y, int sumResult) {
        int result = CustomMath.sum(x, y);
        Assertions.assertEquals(sumResult, result);
    }

    @ParameterizedTest
    @MethodSource("divisionValues")
    void testDivisionByZero(int x, int y, int expResult) {
        try {
            int result = CustomMath.division(x, y);
            Assertions.assertEquals(expResult, result);
            if (y == 0) {
                Assertions.fail("Division by zero not caught!");
            }
        } catch (IllegalArgumentException e) {
            if (y != 0) {
                Assertions.fail("Generated incorrect exception!");
            }
        }
    }
}