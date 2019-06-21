package main;


import java.util.Scanner;

/**
 * Contains main class with main method
 */
public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        coffeeMachine.setMachineState(CoffeeMachine.MachineState.CHOOSING_AN_ACTION);


        while (!coffeeMachine.getMachineState().equals(CoffeeMachine.MachineState.EXIT)) {
            coffeeMachine.machineStateInAction();
            coffeeMachine.accordingToState(scanner.next());
        }


    }
}

