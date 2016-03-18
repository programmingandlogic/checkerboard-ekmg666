/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends SuperKarel {

    public void run() {
        putBeeper();
        justDoIt();
        check();
        check();
        check(); 
        check();
        check();
        check(); 
        check();
        check();
    }
    private void justDoIt(){
  
         while (noBeepersPresent()){
                move();
                putBeeper();
            }
         
        while (beepersPresent()) {
            move();
        }
       
    }
    private void startRowOne(){
    	 turnLeft();
    	 if (frontIsBlocked()) {
    		 turnLeft();
    		 move();
    		 turnAround();
    		 move(); 
    	 } else {
    		 move();
             putBeeper();
             turnLeft();
    	 }
    }
    private void startRowTwo(){
    	 turnRight();
    	 if (frontIsBlocked()) {
    		 turnRight();
    		 move(); 
    		 turnAround();
    		 move(); 
    	 } else {
    		 move();
             putBeeper();
             turnRight();
    	 }
    }
    private void check(){
    	 
    	while (frontIsBlocked()) {
    		if (facingEast()) {
    			startRowOne();
    		}
    	while (frontIsBlocked()) {
    		if (facingWest()) {
    			startRowTwo();
    		}
    	}
    	}
    	 while (frontIsClear()) {
         	if (facingEast()) {
         		justDoIt();
         	}
         	if (facingWest()) {
         		justDoIt(); 
         	}
          }
    }

}