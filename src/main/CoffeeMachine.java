package main;

class CoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private MachineState machineState;
    private int fillingCount = 0;
    CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    void accordingToState(String userInput) {
        switch (this.getMachineState()) {
            case CHOOSING_AN_ACTION:
                action(userInput);
                break;
            case CHOOSING_A_COFFEE:
                System.out.println(buyCoffe(userInput));
                break;
            case FILLING_THE_MACHINE:
                this.setMachineState(MachineState.WE_FILLIN);

                break;
            case WE_FILLIN:
                switch (fillingCount) {
                    case (0):
                        System.out.print("Write how many ml of milk do you want to add:");
                        break;
                    case (1):
                        System.out.print("Write how many grams of coffee beans do you want to add");
                        break;
                    case (2):
                        System.out.print("Write how many disposable cups of coffee do you want to add:");
                        break;
                    case (3):
                        break;
                    default:
                        break;
                }

                fillMachine(userInput);
            case EXIT:
                break;
        }

    }

    private void action(String userInput) {
        switch (userInput) {
            case ("buy"):
                System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                this.setMachineState(MachineState.CHOOSING_A_COFFEE);
                break;
            case ("fill"):
                System.out.println("\nWrite how many ml of water do you want to add:");
                this.setMachineState(MachineState.WE_FILLIN);
                break;
            case ("take"):
                takeFromMachine();
                break;
            case ("remaining"):
                System.out.println(returnLeftovers());
                break;
            case ("exit"):
                this.setMachineState(MachineState.EXIT);
                break;
            default:
                System.out.println("I can't do that");
                break;
        }
    }

    private String buyCoffe(String coffeeChoice) {
        this.setMachineState(MachineState.CHOOSING_AN_ACTION);
        switch (coffeeChoice) {
            case ("1"):
                if (water >= 250 && beans >= 16 && cups > 0) {
                    water -= 250;
                    beans -= 16;
                    cups -= 1;
                    money += 4;
                    return "Ihave enough resources, making you a coffee!\n";
                } else if (water < 250) {
                    return "\nSorry, not enough water!\n";
                } else if (beans < 16) {
                    return "\nSorry, not enough beans!\n";
                } else {
                    return "\nSorry, not enough cups!\n";
                }

            case ("2"):

                if (water >= 350 && milk >= 75 && beans >= 20 && cups > 0) {
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups -= 1;
                    money += 7;
                    return "I have enough resources, making you a coffee!\n";
                } else if (water < 350) {
                    return "\nSorry, not enough water!\n";
                } else if (milk < 75) {
                    return "\nSorry, not enough milk!\n";
                } else if (beans < 20) {
                    return "\nSorry, not enough beans!\n";
                } else {
                    return "\nSorry, not enough cups!\n";
                }
            case ("3"):
                if (water >= 200 && milk >= 100 && beans >= 12 && cups > 0) {
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups -= 1;
                    money += 6;
                    return "I have enough resources, making you a coffee!\n";
                } else if (water < 200) {
                    return "\nSorry, not enough water!\n";
                } else if (milk < 100) {
                    return "\nSorry, not enough milk!\n";
                } else if (beans < 12) {
                    return "\nSorry, not enough beans!\n";
                } else {
                    return "\nSorry, not enough cups!\n";
                }
            case ("back"):
                return "";
            default:
                return "\nI dont have this option";
        }


    }

    private String returnLeftovers() {
        String moneyString;
        if (money == 0) {
            moneyString = "0 of money";
        } else {
            moneyString = "$" + money + " of money";
        }
        return "\nThe coffee machine has:\n"
                + water + " of water\n"
                + milk + " of milk\n"
                + beans + " of coffee beans\n"
                + cups + " of disposable cups\n"
                + moneyString + "\n";

    }

    private void fillMachine(String userInput) {
        switch (fillingCount) {
            case (0):
                water += Integer.parseInt(userInput);
                fillingCount++;
                break;
            case (1):
                milk += Integer.parseInt(userInput);
                fillingCount++;
                break;
            case (2):
                beans += Integer.parseInt(userInput);
                fillingCount++;
                break;
            case (3):
                cups += Integer.parseInt(userInput);
                fillingCount = 0;
                this.setMachineState(MachineState.CHOOSING_AN_ACTION);
                break;
            default:
                break;
        }

        System.out.println();
    }

    private void takeFromMachine() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
        this.setMachineState(MachineState.CHOOSING_AN_ACTION);
    }

    void machineStateInAction() {
        if (this.getMachineState().equals(MachineState.CHOOSING_AN_ACTION)) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
        }
    }

    /**
     * Getter and Setter section below
     */

    MachineState getMachineState() {
        return machineState;
    }

    void setMachineState(MachineState machineState) {
        this.machineState = machineState;
    }

    public enum MachineState {
        CHOOSING_AN_ACTION, CHOOSING_A_COFFEE, FILLING_THE_MACHINE, WE_FILLIN, EXIT
    }


}
