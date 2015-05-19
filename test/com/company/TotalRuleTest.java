package com.company;

import javafx.beans.binding.When;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.when;


public class TotalRuleTest {

    Bag bagMock;

    @Before
    public void setup(){
         bagMock = mock(Bag.class);
    }
    @Test
    public void shouldNotAllowMoreThan12Balls() {
        TotalRule totalRule = new TotalRule();
        when(bagMock.getNoOfBalls()).thenReturn(12);
        boolean added = totalRule.checkAddition(new Ball(Color.BLUE), bagMock);
        assertFalse("Any more balls should not be allowed.", added);
    }

    @Test
    public void shouldAllowAdditionIfLessThanOrEqualTo12Balls() {
        TotalRule totalRule = new TotalRule();
        when(bagMock.getNoOfBalls()).thenReturn(10);
        boolean added = totalRule.checkAddition(new Ball(Color.BLUE), bagMock);
        assertTrue(added);
    }

    @Test
    public void shouldAllowLessThanEqualTo3GreenBalls(){
        Rule greenBallRule = new GreenBallRule();
        when(bagMock.count(Color.GREEN)).thenReturn(2);
        boolean added = greenBallRule.checkAddition(new Ball(Color.GREEN), bagMock);
        assertTrue(added);
    }

    @Test
    public void shouldNotAllowMoreThan3balls(){
        Rule greenBallRule = new GreenBallRule();
        when(bagMock.count(Color.GREEN)).thenReturn(3);
        boolean added = greenBallRule.checkAddition(new Ball(Color.GREEN), bagMock);
        assertFalse(added);
    }

    @Test
    public void shouldAllowAnyNumberOfBlueBallsLessThanOrEqualTo12Balls(){
        Rule blueBallRule = new BlueBallRule();
        when(bagMock.count(Color.BLUE)).thenReturn(11);
        boolean added = blueBallRule.checkAddition(new Ball(Color.BLUE), bagMock);
        assertTrue(added);
    }

    @Test
    public void shouldNotAllowMoreThan12BlueBalls(){
        Rule blueBallRule = new BlueBallRule();
        stub(bagMock.count(Color.BLUE)).toReturn(12);
        boolean added = blueBallRule.checkAddition(new Ball(Color.BLUE), bagMock);
        assertFalse(added);
    }

    @Test
    public  void  shouldNotAllowRedBallsMoreThanDoubleTheGreenBalls(){
        RedBallRule redBallRule = new RedBallRule();
        when(bagMock.count(Color.GREEN)).thenReturn(1);
        when(bagMock.count(Color.RED)).thenReturn(2);
        boolean added = redBallRule.checkAddition(new Ball(Color.RED), bagMock);
        assertFalse(added);
    }

    @Test
    public void shouldAllowYellowBallsLessThanOrEqualTo40PercentOfTheCurrentNumberOfBalls(){

        YellowBallRule yellowBallRule = new YellowBallRule();
        when(bagMock.getNoOfBalls()).thenReturn(10);
        when(bagMock.count(Color.YELLOW)).thenReturn(4);
        boolean added = yellowBallRule.checkAddition(new Ball(Color.YELLOW), bagMock);
        assertFalse(added);
    }





}
