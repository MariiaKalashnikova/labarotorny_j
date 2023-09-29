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
        assertEquals(0, result);
    }

    @Test
    void test10012005() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("1001,2005");
        assertEquals(0, result);
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
        assertEquals(0, result);
    }

    @Test
    void testAddNegPos() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("-6,20");
        assertEquals(0, result);
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

    @Test
    void testDel() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n8*9*1");
        assertEquals(18, result);
    }

    @Test
    void testNoDel() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n8*9;1");
        assertEquals(0, result);
    }

    @Test
    void testDelNeg() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n8*-9,2");
        assertEquals(0, result);
    }

    @Test
    void testNeg() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("-5");
        assertEquals(0, result);
    }

    @Test
    void testDel1() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\*\\n8*9*1");
        assertEquals(0, result);
    }
    @Test
    void testDel2() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n7\\n8*9,1");
        assertEquals(25, result);
    }

    @Test
    void testDel3() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*7\\n8*9,1");
        assertEquals(0, result);
    }
    @Test
    void testDelStart() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n*7\\n8*9,1");
        assertEquals(0, result);
    }
    @Test
    void testDelEnd() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\*\\n7\\n8*9,1*");
        assertEquals(0, result);
    }

    @Test
    void testDelNumber() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\4\\n544");
        assertEquals(0, result);
    }

    @Test
    void testDelNumber1() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\4\\n541");
        assertEquals(6, result);
    }

    @Test
    void testNumber1000() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("1000\\n999,1000");
        assertEquals(2999, result);
    }
    @Test
    void testNumber1() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("-1001");
        assertEquals(0, result);
    }

    @Test
    void testNumber2() {
        StringCalculator calc = new StringCalculator();
        int result = calc.add("\\\\^\\n1001^6,5");
        assertEquals(11, result);
    }


}
