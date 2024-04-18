package servives;

import forTest.Test;

import java.util.Scanner;

public class CommandHandlerService {

    public void handelCommand(String command){
        Test test=new Test();
            switch (command){
                case "1":test.addItemsAndPrint();
                    displayCommand("If you want  Add items then remove one press 2 ");
                    userInput("2");
                break;
                case "2":test.removeItemAndPrint();
                    displayCommand("If you want  Add items then get them press 3 ");
                    userInput("3");
                    break;
                case "3":test.getItemAndPrint();
                    displayCommand("If you want  Add items then relocate it press 4 ");
                    userInput("4");
                    break;
                case "4":test.relocateItemAndPrint();
                    displayCommand("If you want  Add items then get all  press 5 ");
                    userInput("5");
                    break;
                case "5":test.getAllMaterialsQuantityAndPrint();
                    displayCommand("If you want try again press 6 ");
                    userInput("6");
                    break;
                case "6":userInput("0");
                    break;
                default:
                    System.out.println("Something went wrong");
                    break;
            }

    }

    public void displayCommand(String message){
        System.out.println(message);
    }

    public void userInput(String message){
        Scanner scanner=new Scanner(System.in);
        if (message.equals("0")){
            displayCommand("If you want add Items press 1 ");
            message="1";
        }
        String input=scanner.nextLine();
        if (message.equals(input)){
            handelCommand(input);
        }
        else {
            System.out.println("Wrong Input try again");
            userInput(message);
        }

    }

}
