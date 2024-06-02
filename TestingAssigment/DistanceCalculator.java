package TestingAssigment;

import java.util.HashMap;
import java.util.Map;

public class DistanceCalculator {

    private static final Map<String, Integer> conversionFactors;

    static {
        conversionFactors = new HashMap<>();
        conversionFactors.put("mm", 1);
        conversionFactors.put("cm", 10);
        conversionFactors.put("dm", 100);
        conversionFactors.put("m", 1000);
        conversionFactors.put("km", 1000000);
    }

    public static int compute(String expression) {
        String[] tokens = expression.split(" ");
        int result = 0;

        for (int i = 0; i < tokens.length; i += 3) {
            int value = Integer.parseInt(tokens[i]);
            String unit = tokens[i + 1];

            if (i > 0) {
                String operator = tokens[i - 1];
                if (operator.equals("-")) {
                    value = -value;
                }
            }

            result += value * conversionFactors.get(unit);
        }

        return result;
    }
}
