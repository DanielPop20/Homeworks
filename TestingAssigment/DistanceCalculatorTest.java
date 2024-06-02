package TestingAssigment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistanceCalculatorTest {
    @Test
    void testSimpleExpression() {
        assertEquals(1090, DistanceCalculator.compute("10 cm + 1 m - 10 mm"));
    }

    @Test
    void testComplexExpression() {
        assertEquals(1001900, DistanceCalculator.compute("1 km + 1 m - 10 cm + 1000 mm"));
    }

    @ParameterizedTest
    @CsvSource({
            "10 cm + 1 m - 10 mm, 1090",
            "1 km - 100 m, 900000",
            "5 m + 5 dm - 50 cm, 5000",
            "2 m + 300 cm - 2000 mm, 3000"
    })
    void testParameterized(String expression, int expected) {
        assertEquals(expected, DistanceCalculator.compute(expression));
    }
}
