package com.launch.robot;


import java.util.Scanner;

/**
 * Bootstrap the application and accept commands.
 */
public class Main {

    public static void main(String[] args){
        System.out.println("*******************************");
        System.out.println("ROBOT CREATED.AWAITING COMMAND.");
        System.out.println("*******************************");
        Robot robot = new Robot();
        RobotApplication application = new RobotApplication(robot);
        Scanner scanner = new Scanner(System.in);
        String command="";
        while(true){
         command = scanner.nextLine();
         application.executeCommand(command);
        }
    }


}
