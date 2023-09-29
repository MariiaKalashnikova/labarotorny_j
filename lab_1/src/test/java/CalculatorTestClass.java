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
        assertEquals(17, result);
    }

    @Test
    void testComaEnd() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2,7,11,");
        assertEquals(0, result);
    }
    @Test
    void testComaStart() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add(",12,2,7");
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
        int result = calc.add("-6,-20,-3");
        assertEquals(-29, result);
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

    @Test
    void testAddNoComa() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("3,20*8");
        assertEquals(0, result);
    }

    @Test
    void testAddNoComaEnd() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4,5,6*");
        assertEquals(0, result);
    }

    @Test
    void testAddDec() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4,5,6.7");
        assertEquals(0, result);
    }

    @Test
    void testNoComa1() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("!");
        assertEquals(0, result);
    }

    @Test
    void testComaN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("2,3\\n7");
        assertEquals(12, result);
    }

    @Test
    void testLineN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("23\\n3");
        assertEquals(26, result);
    }

    @Test
    void testLine() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("23\\3");
        assertEquals(0, result);
    }
    @Test
    void testN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("23n3");
        assertEquals(0, result);
    }
    @Test
    void testFewLineN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("23\\n3\\n8\\n2");
        assertEquals(36, result);
    }

    @Test
    void testMuch() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("23\\n3,9,3\\n8*7");
        assertEquals(0, result);
    }

    @Test
    void testAddNEnd() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4\\n9\\n");
        assertEquals(0, result);
    }

    @Test
    void testAddNStart() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\n4\\n9");
        assertEquals(0, result);
    }

    @Test
    void testAddFewN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4\\n\\n9");
        assertEquals(0, result);
    }

    @Test
    void testComaandN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4\\n,9");
        assertEquals(0, result);
    }

    @Test
    void testLineeN() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("4\\9n8");
        assertEquals(0, result);
    }

}
