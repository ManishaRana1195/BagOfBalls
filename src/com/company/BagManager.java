package com.company;

import java.util.List;
import java.util.Scanner;

/**
 * Created by manisharana on 4/1/15.
 */
public class BagManager {

   public static void main(String args[]){
        Bag bag=new Bag();
        Scanner scanner=new Scanner(System.in);
       do {
           System.out.println("Enter the color of the ball U want to enter");
           Color color = Color.valueOf(scanner.next());
           if(color!=null) {
               Ball ball = new Ball(color);
               bag.addBall(ball);
               bag.getSummary();
           } else {
               System.out.println("No such colored ball exists.");
           }
           System.out.println("Do you want to continue?? [Y/N]");
       }while(scanner.next().equals("Y"));
    }

}
