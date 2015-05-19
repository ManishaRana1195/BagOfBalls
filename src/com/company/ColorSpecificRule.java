package com.company;

/**
 * Created by manisharana on 4/1/15.
 */
public abstract class ColorSpecificRule implements Rule {

    @Override
    public final boolean checkAddition(Ball newBall, Bag bag) {
        if(newBall.getColor().equals(ruleColor())) {
            return executeRulesSpecificToColor(newBall, bag);
        }
        return true;
    }

    public abstract Color ruleColor();

    protected abstract boolean executeRulesSpecificToColor(Ball newBall,   Bag bag);
}
