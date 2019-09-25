package fi.tuni.tiko;

import org.junit.Assert;
import org.junit.Test;
import fi.tuni.tiko.Calculator;

public class AppTest 
{
    Calculator testCalc = new Calculator();

    @Test
    public void subtractionTest(){
       	Assert.assertEquals(testCalc.subtract(2, 1), 1);
	Assert.assertEquals(testCalc.subtract(-5, 5), -10);
    }

    @Test
    public void additionTest() {
	Assert.assertEquals(testCalc.addition(2,1),3);
	Assert.assertEquals(testCalc.addition(-5,5),0);
    }

    @Test
    public void multiplicationTest() {
        Assert.assertEquals(testCalc.multiplication(5,5),25);
        Assert.assertEquals(testCalc.multiplication(-5,5),-25);
    }

}
