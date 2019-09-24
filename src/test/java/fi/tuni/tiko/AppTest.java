package fi.tuni.tiko;

import org.junit.Assert;
import org.junit.Test;
import fi.tuni.tiko.Calculator;

public class AppTest 
{

    @Test
    public void subtractionTest(){
	Calculator testCalc = new Calculator();
       	Assert.assertEquals(testCalc.subtract(2, 1), 1);
	Assert.assertEquals(testCalc.subtract(-5, 5), -10);
    }
}
