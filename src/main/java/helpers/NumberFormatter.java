package helpers;

import static healthcheck.Constants.DECIMAL_PATTERN;

import java.text.DecimalFormat;

public class NumberFormatter {

    public static String round(double number) {
        return new DecimalFormat(DECIMAL_PATTERN).format(number);
    }
}
