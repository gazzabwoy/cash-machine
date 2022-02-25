//Bank Machine Pin code, 3 attempts, then access account.
//©®™ Gary Duffner ™®©

import java.util.Scanner;

public class Cash {

    public static void main(String[] args) {


        int restart = 1;

        while (restart < 2) {//restart system

            restart = 1;
            int t = 3;


            do {//t = amount ot attempts before card is blocked

                //clearscreen//
                System.out.print("\033[H\033[2J");
                System.out.flush();//clear the screen

                Scanner scan = new Scanner(System.in);//define new scanner score
                System.out.println("Card Scanned and is valid..."); //
                System.out.println("Please Enter your pin..."); //asking user to input pin
                int pin = scan.nextInt(); //defining the int "pin" as user input
                
                String correctpin = "Incorrect pin";//defining the string "incorrect" status

                if (pin == 1234) {

                    correctpin = "Pin is correct"; //changing string "correctpin" status
                    System.out.println(correctpin); //printing status of "pass"
                    System.out.println("Just a sec, getting acount details"); // correct pin

                    t = -2;

                } else { //default configuration

                    System.out.println(correctpin);// pass is set to this by default
                    System.out.println("Try Again, you have: " + t + " attempts left before card is blocked");//incorrect pin
                    t--;
                    try {
                        // thread to sleep for 1000 milliseconds
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                if (t == -2) {
                    System.out.println("Gary's Account.......");
                } else if (t == -1) {
                    System.out.println("You had 3 unsuccesful attempts");
                    System.out.println("You card is now blocked");
                    System.out.println("Contact your bank to resolve this!");
                    t = 3;
                    try {
                        // thread to sleep for xxxx milliseconds
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

            } while (t > -1);// if set to zero it grants access with 1 attempt left!!

            int funds = 0;
            int savings = 100000;
            int current = 50000;
            int account;
            int action;
            int selection;
            int retry = 0;
            int cont = 0;


            String SA = "Savings Account";
            String CA = "Current Account";
            String ac = " ";


            do {//retry account selection

                Scanner scan = new Scanner(System.in);//define new scanner score
                System.out.println("**** Please input a valid selection ****");
                System.out.println("Welcome to The Bank of College");
                System.out.println("What account would you like see?");
                System.out.println("Press 1 for " + (CA) + " : Balance £" + current);
                System.out.println("Press 2 for " + (SA) + " : Balance £" + savings);
                account = scan.nextInt();


                if (account == 1) { //clearscreen//
                    System.out.print("\033[H\033[2J");
                    System.out.flush();//clear the screen
                    funds = current;
                    ac = CA;

                    retry = 1;
                }

                if (account == 2) {//clearscreen//
                    System.out.print("\033[H\033[2J");
                    System.out.flush();//clear the screen
                    funds = savings;
                    ac = SA;

                    retry = 1;

                } else {
                    System.out.println(" ");
                }

            

            // use this code for both accounts //

            do {//cont

                //clearscreen//1
                System.out.print("\033[H\033[2J");
                System.out.flush();//clear the screen

                System.out.println("Balance of your " + (ac) + "  = £ " + funds);
                System.out.println("What would you like to do?");
                System.out.println("Press 1 to make a deposit");
                System.out.println("Press 2 to make a withdrawal");
                System.out.println("Press 3 to make a transfer");
                System.out.println("Press 4 to change account");
                System.out.println("Press 5 to Exit");
               
                action = scan.nextInt();

                switch (action) {

                    case 1: {
                        System.out.println("How much would you like to deposit?");
                        selection = scan.nextInt();
                        funds = funds + selection;
                        System.out.println("Thank you, your new balance is £ " + funds);

                    }
                    break;
                    case 2: {
                        System.out.println("How much would you like to withdraw?");
                        selection = scan.nextInt();
                        if (funds - selection < 0) {
                            System.out.println("Not enough funds in account to complete this action");
                            break;
                        } else {
                            funds = funds - selection;

                        }

                        System.out.println("Thank you, your new balance is £ " + funds);
                    }
                    break;

                    case 3: {
                        System.out.println("How much would you like to transfer?");
                        selection = scan.nextInt();
                        if (funds - selection < 0) {
                            System.out.println("Not enough funds in account to complete this action");
                            break;
                        } else if (selection > funds) {
                            System.out.println("Unable to comply with your request");
                            break;
                        } else {
                            funds = funds - selection;

                        }
                        if (account == 1) {
                            current = current - selection;
                            savings = savings + selection;
                        } else {
                            current = current + selection;
                            savings = savings - selection;
                        }
                        System.out.println("Thank you, your new balance is £ " + funds);
                    }
                    break;

                    case 4: {
                        System.out.println("You are currently viewing your " + (ac));
                    }

                    System.out.println("Taking you back to account selection screen ");
                    retry = 1;
                    break;
                    
                    

                    case 5: {

                        System.out.println("Have a nice day");
                        
						retry = 1;
						cont = 1;
						
                    }
					break;
                }
            } while (retry == 0);

        } while (cont == 0) ;


    }

    }
}