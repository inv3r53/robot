package com.launch.robot;

public class Robot {
    private int x;
    private int y;
    private Direction currentDirection;
    private boolean invalidState;
    private static final String REPORT_MESSAGE = "Output: %d,%d,%s";
    private static final int MIN_POS=0;
    private static final int MAX_POS=4;

    Robot(){
      this.invalidState=true;
    }

    public void move(){
        if(invalidState){
            return;
        }
      int dx=   currentDirection.getX();
      int dy=   currentDirection.getY();

      if(!isValidLocation(x+dx,y+dy)){
          //no-op
          return;
      }
      x=x+dx;
      y=y+dy;
    }

    public void turnLeft(){
        if(invalidState){
            return;
        }
        currentDirection=currentDirection.left();
    }
    public void turnRight(){
        if(invalidState){
            return;
        }
        currentDirection=currentDirection.right();
    }

    public String getReport(){
        return String.format(REPORT_MESSAGE,x,y,currentDirection);
    }

    public void report(){
        if(invalidState){
            return;
        }
        System.out.println(getReport());
    }

    public void place(int x,int y,Direction d){
        if(!isValidLocation(x,y) || d == null){
            //mark invalid for bad placement(initial or later ) so that subsequent commands in invalid state get discarded until valid placement.
            invalidState=true;
          return;
        }
        invalidState=false;
        this.x=x;
        this.y=y;
        this.currentDirection=d;
    }

    private boolean isValidLocation(int x , int y){
        return x>=MIN_POS&&x<=MAX_POS&&y>=MIN_POS&&y<=MAX_POS;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public boolean isInvalidState() {
        return invalidState;
    }
}
