package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public class RedBallRule extends ColorSpecificRule {
    @Override
    public Color ruleColor() {
        return Color.RED;
    }

    @Override
    public boolean executeRulesSpecificToColor(Ball newBall, Bag bag) {
        int greenBallCount =(int) bag.count(Color.GREEN);
        int redBallCount = (int)bag.count(Color.RED);
        return redBallCount+1 <= greenBallCount*2;
    }

}
