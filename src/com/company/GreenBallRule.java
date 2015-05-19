package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public class GreenBallRule extends  ColorSpecificRule {
    @Override
    public Color ruleColor() {
        return Color.GREEN;
    }

    @Override
    protected boolean executeRulesSpecificToColor(Ball newBall, Bag bag) {
        int greenBallCount = (int)bag.count(Color.GREEN);
        return greenBallCount+1<=3;
    }

}
