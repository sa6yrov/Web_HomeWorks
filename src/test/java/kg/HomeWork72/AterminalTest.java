package kg.HomeWork72;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AterminalTest {
    @Test
    public void checkMoney(){
        int[] array = Aterminal.getCorrectAtm();
        String result = Aterminal.checkMoney(array);
        assertEquals("OK", result);
    }

    @Test
    public void checkMoney2(){
        int[] array = Aterminal.getIncorrectAtm();
        String result = Aterminal.checkMoney(array);
        assertEquals("OK", result);
    }

    @Test
    public void checkMoney3(){
        int[] array = Aterminal.getIncorrectAtm2();
        String result = Aterminal.checkMoney(array);
        assertEquals("OK", result);
    }
}
