package taskone;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com)
 */
public class Sumator {


    /**
     * Calculates the sum of two Integer numbers
     * @param a Integer first number
     * @param b Integer second number
     * @return Integer the sum of a and b
     */
    public int sum(Integer a, Integer b) {
        int sum = a + b;
        return sum;
    }

    /**
     * Calculates the sum of two Double numbers
     * @param a Double first number
     * @param b Double second number
     * @return Double the sum of a and b
     */
    public double sum(Double a, Double b) {
        double sum = a + b;
        return sum;
    }

    /**
     * Calculates sum of two numeral strings
     * @param a String first string
     * @param b String second string
     * @return Integer sum of a and b
     */
    public Integer sum(String a, String b) {
        Integer sum = Integer.parseInt(a)+ Integer.parseInt(b);
        return sum;
    }

    /**
     * Calculates the sum of two BigInteger numbers
     * @param a BigInteger first number
     * @param b BigInteger second number
     * @return BigInteger the sum of a and b
     */
    public BigInteger sum(BigInteger a, BigInteger b) {
        BigInteger sum = a.add(b);
        return sum;
    }

    /**
     * Calculates the sum of two BigDecimal numbers
     * @param a BigDecimal first number
     * @param b BigDecimal second number
     * @return BigDecimal the sum of a and b
     */
    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        BigDecimal sum = a.add(b);
        return sum;
    }
}