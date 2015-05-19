package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public class YellowBallRule extends ColorSpecificRule {
    @Override
    public Color ruleColor() {
        return Color.YELLOW;
    }

    @Override
    protected boolean executeRulesSpecificToColor(Ball newBall, Bag bag) {
        return ((int)bag.count(Color.YELLOW)+1 <= .04 * bag.getNoOfBalls());
    }
}
