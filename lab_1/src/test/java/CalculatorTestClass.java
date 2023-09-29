import org.example.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTestClass {
    @Test
    void testAdd2num() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2,3");
        assertEquals(5, result);
    }

    @Test
    void testEmpty() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add(" ");
        assertEquals(0, result);
    }
    @Test
    void test1num() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("27");
        assertEquals(27, result);
    }
    @Test
    void test1001() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("1001");
        assertEquals(1001, result);
    }

    @Test
    void test10012005() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("1001,2005");
        assertEquals(3006, result);
    }
    @Test
    void test3num() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2,7,8");
        assertEquals(0, result);
    }

    @Test
    void testComaEnd() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2,7,");
        assertEquals(0, result);
    }
    @Test
    void testComaStart() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add(",2,7");
        assertEquals(0, result);
    }

    @Test
    void testNoComa() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2!7");
        assertEquals(0, result);
    }
    @Test
    void testLetter() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("g");
        assertEquals(0, result);
    }

    @Test
    void testLetterNumber() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("g6");
        assertEquals(0, result);
    }

    @Test
    void testLetterNumberComa() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("6,h");
        assertEquals(0, result);
    }

    @Test
    void testAddNeg() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("-6,-20");
        assertEquals(-26, result);
    }

    @Test
    void testAddNegPos() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("-6,20");
        assertEquals(14, result);
    }

    @Test
    void testAddZero() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("0,20");
        assertEquals(20, result);
    }

}
