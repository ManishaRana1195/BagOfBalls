package com.company;

import com.sun.xml.internal.xsom.impl.scd.Iterators;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    public static int totalNoOfBalls = 12;
    ArrayList<Ball> balls=new ArrayList<>();
    private List<Rule> rules = new ArrayList<>();

    public void Bag(){
        rules.add(new RedBallRule());
        rules.add(new GreenBallRule());
        rules.add(new BlueBallRule());
        rules.add(new YellowBallRule());
        rules.add(new TotalRule());
    }

    public void addBall(final Ball ball){
        final Bag currentBag = this;

        boolean allSatisfied = rules.stream().allMatch(
                rule -> rule.checkAddition(ball, currentBag)
        );

        if(allSatisfied) {
            balls.add(ball);
        }
        else
            System.out.println("You cannot add another "+ball.getColor()+" ball");
    }

    public void getSummary(){
        System.out.println("Number of balls:\n Yellow:" + count(Color.YELLOW) + "\n Blue:" + count(Color.BLUE) + "\n Green:" + count(Color.GREEN) + "\n Red:" + count(Color.RED));

    };

    public ArrayList<Ball> getBalls() {
        return balls;
    }

    public int getNoOfBalls() {
        return balls.size();
    }


    public int count(Color ballColor) {
        return (int)this.getBalls().stream().filter(ball -> ball.getColor().equals(ballColor)).count();
    }
}
