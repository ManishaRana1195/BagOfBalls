package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public class BlueBallRule extends ColorSpecificRule {
    @Override
    public Color ruleColor() {
        return Color.BLUE;
    }

    @Override
    protected boolean executeRulesSpecificToColor(Ball newBall, Bag bag) {
        return bag.count(Color.BLUE)+1<=Bag.totalNoOfBalls;
    }
}
