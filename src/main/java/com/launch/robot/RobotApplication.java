package com.launch.robot;

public class RobotApplication {

    private  Robot robot;

    RobotApplication(Robot robot){
        this.robot=robot;
    }

    public  void executeCommand(String command){
        String commandType = command.split("\\s+")[0];
        int x , y;
        Direction direction;
        switch(commandType){
            case "MOVE":
                robot.move();
                break;
            case "LEFT":
                robot.turnLeft();
                break;
            case "RIGHT":
                robot.turnRight();
                break;
            case "REPORT":
                robot.report();
                break;
            case "PLACE":
                try {
                    String[] tokens = command.split("[,\\s+]");
                    x = getAsInteger(tokens[1]);
                    y = getAsInteger(tokens[2]);
                    direction = Direction.valueOf(tokens[3]);
                }catch(Exception e){
                    System.out.println("Invalid command. use PLACE X,Y,F");
                    break;
                }
                robot.place(x,y,direction);
                break;
            default:
               System.out.println("Unknown Command!");
                break;
        }

    }


    private int getAsInteger(String n){
      return  Integer.parseInt(n);
    }

}
