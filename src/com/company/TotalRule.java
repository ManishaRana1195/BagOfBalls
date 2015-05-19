package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public class TotalRule implements Rule {

    @Override
    public boolean checkAddition(Ball ball, Bag bag) {
        return (bag.getNoOfBalls()+1 <= Bag.totalNoOfBalls) ;
    }
}
