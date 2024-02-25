/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.themeparkticketing;

import static java.lang.System.exit;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class ThemeParkTicketingDriver {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //Scanner
        
        char confirmation;
        int choice;
        int maxlimit;
        int themepark_choice = 0;
        int duration_choice = 0;
        int category_choice = 0;
        int currentTicket = 0;
        double tempDurationCharges = 0.00;
        double tempCategoryCharges = 0.00;
        double tempSubtotal = 0.00;
        String currentCategory = null;
        String currentDurationType = null;
        
        
        ///Menu interface declare
        Menu ticketmenu = new Ticket();
        Menu themeParkmenu = new ThemePark();
        Menu ticketCategoryMenu = new TicketCategory();
        
        
        //Predefined User (Customer & Staff)
        Account acc = new Account("C00001", "abc123");//preset login  password
        User[] userList = {new Customer("C001", "Joshua", "joshua@happy.com", "0111111111", new Account("jkjk", "jkjk")),
                           new Customer("C002", "KokLoong", "kokloong@handsome.com", "0122222222", new Account("klhandsome", "abc123")),
                           new Admin("A001", "Ecas", "ecas@gmail.com", "0166277259", new Account("ecaslai", "123456"))
                          };
        
        //Empty User (no user login)
        User currentUser = null; 
        
        //Empty temporary ID/Pass for verification
        String tempID = "";
        String tempPass = "";
        String tempPass2 = "";
        String tempName = "";
        String tempEmail = "";
        String tempContact = "";
        
        
        //Predefined TicketCategory
        TicketCategory adultCategory = new TicketCategory("Adult", 'A', 10.00);
        TicketCategory childCategory = new TicketCategory("Child", 'C', 0.00);
 
        //Predefined facility & themepark
        Facility[] waterFacilityList = { new Facility("Wave Pool", "big wave with shread of excitement"),
                                         new Facility("High Speed Water Slider", "Heart-stopping, yet breathtalking joyride"),
                                         new Facility("Family Raft", "Classic yet favourite waterslide for guest of all ages")
                                        };
        
        Facility[] historicalFacilityList = { new Facility("Dreamland", "Ambitious park for historical lover"),
                                              new Facility("Mountain Coaster", "Traditional wooden roller coaster"),
                                              new Facility("Pantomime Threater", "Traditional musical comedy stages")
                                            };
        
        Facility[] fantasyFacilityList = { new Facility("Bumper Car", "Ram together for the ultimate rush of adrenaline!"),
                                           new Facility("Fantasy Adventure", "Aboard for scenic tour and magical scenery"),
                                           new Facility("Castle Rush", "Immerse into the medieval worlds"),
                                         };
        
        Facility[][] facilityList = {waterFacilityList, historicalFacilityList, fantasyFacilityList};
        
        ThemePark[] themeparkList = { new ThemePark("Water Theme Park", "Thrilling water rideds and night shows", facilityList[0], 30.00),
                                      new ThemePark("Historical Theme Park", "Authentic insight into the history", facilityList[1], 50.00),
                                      new ThemePark("Fantasy Theme Park", "Dive into imaginary", facilityList[2], 20.00)
                                    };
        
        Ticket[] ticketList = new Ticket[5]; // maximum 5 ticket
        
        ///System First page
        int choiceUser = 0; // number choice
        
        do {
            System.out.println("\n==============================");
            System.out.println("  Themepark Ticketing System  ");
            System.out.println("==============================");
            System.out.println(" 1) Login");
            System.out.println(" 2) Register");
            System.out.println(" 3) Exit");
            System.out.print("==> Enter your selection (1-3): ");
            //try catch for input validation
            try {
                choiceUser = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number!");
                sc.nextLine();
            }
            
            

            switch(choiceUser) {
                case 1:
                    currentUser = null;
                    for(int j = 0; j < 3; j++){
                        System.out.println("\n---------------");
                        System.out.println("   Login User");
                        System.out.println("---------------");
                        System.out.print("ID       : ");
                        tempID = sc.nextLine();
                        System.out.print("Password : ");
                        tempPass = sc.nextLine();
            
                        for(int i = 0; i < userList.length ; i++){
                            if(userList[i].getAcc().getLoginID().equals(tempID) && userList[i].getAcc().getPassword().equals(tempPass))
                            {
                                currentUser = userList[i]; //Assign login user to currentUser
                                i = userList.length;
                                System.out.println("Login Successful !!");
                                System.out.println("Welcome back " + currentUser.getName() + "\n");
                                break;
                            }
                        }
                        if(currentUser == null){
                            if(j < 2){
                                System.out.println("Please Enter a valid ID/Password. (" + (3-(j+1)) + " attempt(s) left)\n");
                                
                            }
                            else{
                                System.out.println("!!!!!!!!  Login Failed  !!!!!!!!"); 
                                System.out.println("\n Return to first page...."); 
                            }  
                        }
                        else{
                            break;
                        }
                    }
                    break;
        
                    
                case 2:
                
                System.out.println("Register\n----------");
                System.out.print("ID       : ");
                tempID = sc.nextLine();

                
                do{
                    System.out.print("\nPassword : ");
                    tempPass = sc.nextLine();
                    System.out.print("Confirm Password : ");
                    tempPass2 = sc.nextLine();
                    if(!tempPass.equals(tempPass2)){
                        System.out.println("Password not match");
                    }
                }while(!tempPass.equals(tempPass2));

            
                
                System.out.print("\nName     : ");
                tempName = sc.nextLine();
                System.out.print("Email    : ");
                tempEmail = sc.nextLine();
                System.out.print("Contact  : ");
                tempContact = sc.nextLine();
                if (tempPass.equals(tempPass2)) {
                    userList = Arrays.copyOf(userList, userList.length + 1);
                    userList[userList.length - 1] = new Customer(tempID, tempName, tempEmail, tempContact,
                            new Account(tempID, tempPass));
                    System.out.println("Register Success");
                } else {
                    System.out.println("Password not match");
                }
                break;

                case 3:
                    System.out.println("\n********************************************************************");
                    System.out.println("* Ending session... Thank you for using themePark ticketing system *");
                    System.out.println("********************************************************************\n");
                    exit(0);
                default:
                    System.out.println("Invalid selection! Please try again.");
            } 
            
            
            //After User Login
            
            if(currentUser instanceof Customer){
                do{
                    //Main Menu
                    System.out.println("======= THEMEPARK TICKETING ======");
                    System.out.println("==================================");
                    System.out.println("||             MENU             ||");
                    System.out.println("==================================");
                    System.out.println("||  1. Add Ticket               ||");
                    System.out.println("||  2. Check Added Ticket       ||");
                    System.out.println("||  3. Check ThemePark List     ||");
                    System.out.println("||  4. Checkout                 ||");
                    System.out.println("||  5. Check User Info          ||");
                    System.out.println("||  6. Logout                   ||");
                    System.out.println("==================================");
                    System.out.print("\n Enter choice(1-6): ");

                    choice = sc.nextInt();
                    sc.nextLine();

                    switch(choice){
                        //Add Ticket
                        case 1:
                            //preset ticket


                            System.out.println("\n\n|=========== ADD TICKET ===========|");

                            //ThemePark List
                            themeParkmenu.displayMenu();
                            ThemePark.displayThemePark(themeparkList);
                            System.out.print("\n Choose the themepark (1-" + themeparkList.length + "): ");

                            //choice input & validation
                            maxlimit = themeparkList.length;
                            themepark_choice = themeParkmenu.inputChoice(maxlimit); 

                            //default themepark choice
                            ThemePark currentThemePark = themeparkList[0];

                            //set ThemePark based on choice
                            currentThemePark = themeparkList[themepark_choice - 1];


                            ///Facility Menu
                            System.out.println("================================================\n");

                            System.out.println("\n\tFACILITY LISTING (" + currentThemePark.getName() + ")");
                            System.out.println("------------------------------------------------------------------------------------------------------");
                            System.out.println("| NO | Facility                  | Description                                             | Status  |");
                            System.out.println("|------------------------------------------------------------------------------------------|---------|");

                            for(int i = 0; i < currentThemePark.getFacility().length ; i++){
                                System.out.printf ("| %2d | %-25s | %-55s | %-7s |\n",i+1, currentThemePark.getFacility()[i].getName(), currentThemePark.getFacility()[i].getFacilityDesc(),currentThemePark.getFacility()[i].getStatus() );
                                System.out.println("|____|___________________________|_________________________________________________________|_________| ");
                            }

                            System.out.printf(" << ThemePark price:  RM %5.2f (Surcharge not included) >>", currentThemePark.getParkCharges());
                            System.out.println("---------------------------------------------------------------------");

                            //Add Ticket confirmation
                            System.out.print("Wish to add ticket? (Enter Y to confirm): ");
                            confirmation = sc.findInLine(".").charAt(0);
                            sc.nextLine();

                            //User acknowledge and confirm to add the ticket
                            if(confirmation == 'Y' || confirmation == 'y'){
                                //Ask user for ticket pass duration
                                Ticket.displayTicketPass();
                                duration_choice = sc.nextInt();
                                sc.nextLine();

                                //Ask user for ticket Category (Adult/Child)
                                ticketCategoryMenu.displayMenu();
                                maxlimit = 2; //Only 2 selection
                                category_choice = ticketCategoryMenu.inputChoice(maxlimit);
                            }

                            //Return to menu page if user enter any other key
                            else{ 
                                System.out.println("Return to Menu...(Press ENTER to continue \n");
                                try
                                {
                                    System.in.read();
                                }  
                                catch(Exception e)
                                {}  
                                break; // Back to Menu
                            }

                            //Insert data into ticket
                            ticketList[currentTicket] = new Ticket(LocalDate.now(), "", 0.00, adultCategory, themeparkList[0]);

                            //set Duration Type for ticket
                            switch(duration_choice){
                                case 1:
                                    ticketList[currentTicket].setDurationType("1-day Pass");
                                    tempDurationCharges = 0.00;
                                    break;
                                case 2:
                                    ticketList[currentTicket].setDurationType("3-day Pass") ;
                                    tempDurationCharges = 30.00;
                                    break;
                                case 3:
                                    ticketList[currentTicket].setDurationType("1-week Pass");
                                    tempDurationCharges = 100.00;
                                    break;
                            }


                            switch(category_choice){
                                case 1:
                                    ticketList[currentTicket].setCategory(adultCategory);
                                    tempCategoryCharges = 10.00;
                                    break;
                                case 2:
                                    ticketList[currentTicket].setCategory(childCategory);
                                    tempCategoryCharges = 0.00;
                                    break;
                            }

                            //calculate & set subtotal
                            tempSubtotal = currentThemePark.getParkCharges() + tempDurationCharges + tempCategoryCharges;
                            ticketList[currentTicket].setSubtotal(tempSubtotal); //set Subtotal of Ticket

                            ticketList[currentTicket].setThemePark(currentThemePark); //set ThemePark of Ticket


                            System.out.println("\nGenerating ticket detail....\n");

                            //ToString()
                            System.out.println(ticketList[currentTicket]);

                            category_choice++;

                            //Parse, wait for user key in Enter
                            System.out.println("\nTicket successfully added!! (press Enter key to continue)\n");
                            try
                            {
                                System.in.read();
                            }  
                            catch(Exception e)
                            {}  

                            ///add ticket no
                            currentTicket++;
                            break;

                        //Check Added Ticket
                        case 2:
                            System.out.println("\n|========= TICKET LIST =========|");
                            int qtyTicket = 0;
                            for(int i = 0; i < ticketList.length ; i++){
                                if(ticketList[i] != null){
                                    qtyTicket++;
                                    System.out.printf("%-24s",ticketList[i].toString());
                                }      
                            }
                            System.out.println("Total of " + qtyTicket + " ticket(s) added. \n\n");
                            break;
                        
                            
                        //Check Facility
                        case 3:
                            themeParkmenu.displayMenu();
                            ThemePark.displayThemePark(themeparkList);
                            break;
                            
                            
                        //Checkout
                        case 4: 
                            int payableAmount = 0;
                            int paymentMethodSelection = 0;
                            boolean paymentMethodSelectionCheck = false;
                            boolean paymentSuccessful = false;
                            PaymentStatus status;
                            
                            for(int i = 0; i < ticketList.length ; i++){
                                if(ticketList[i] != null){
                                    payableAmount += ticketList[i].getSubtotal();
                                }
                            }
                            if(payableAmount == 0){
                                System.out.println("\nPlease add Ticket first!\n");
                                break;
                            }
                            System.out.println("\nTotal Payable Amount: RM " + payableAmount);
                            
                            while (paymentMethodSelectionCheck == false || paymentSuccessful == false) {
                                System.out.print("\n==========================\nSelect your payment method\n==========================");
                                System.out.print("\n1) E-wallet");
                                System.out.print("\n2) Online Banking");
                                System.out.print("\n3) Card");
                                System.out.print("\n4) Cancel Order");
                                System.out.print("\n\nPlease select the payment method(1-4) : ");
                                
                                try {
                                    paymentMethodSelection = sc.nextInt();
                                } catch (Exception e) {
                                    
                                }
                                sc.nextLine();
                                
                                switch (paymentMethodSelection) {
                                case 1:
                                    System.out.print("\n========\nE-wallet\n========");

                                    int eWalletSelection = 0;
                                    boolean eWalletCondition = false;
                                    String eWalletType = " ";
                                    paymentMethodSelectionCheck = true;

                                    while (eWalletCondition == false) {
                                        System.out.print("\nSelect your EWallet Type");
                                        System.out.print("\n1. GrabPay");
                                        System.out.print("\n2. ShopeePay ");
                                        System.out.print("\n3. TouchNGo");
                                        System.out.print("\n\nPlease enter your selection : ");
                                        
                                        try {
                                            eWalletSelection = sc.nextInt();
                                        } catch (Exception e) {

                                        }
                                        sc.nextLine();
                                        if (eWalletSelection == 1) {
                                            eWalletType = "GrabPay";
                                            eWalletCondition = true;
                                        } else if (eWalletSelection == 2) {
                                            eWalletType = "ShopeePay";
                                            eWalletCondition = true;
                                        } else if (eWalletSelection == 3) {
                                            eWalletType = "TouchNGo";
                                            eWalletCondition = true;
                                        } else {
                                            System.out.print("Please enter a valid selection. ");
                                        }
                                    }
                                    System.out.print("Enter your EWallet Balance  : ");
                                    double eWalletBalance = sc.nextDouble();
                                    
                                    status = PaymentStatus.PENDING;
                                    
                                    if (eWalletBalance < payableAmount) {
                                        System.out.print("Insufficiant balance! Please try again.\n");
                                    } else { 
                                        Ewallet eWallet  = new Ewallet(eWalletType, eWalletBalance, status);
                                        eWallet.pay();
                                        eWallet.status = PaymentStatus.PAID;
                                        paymentSuccessful = true;
                                        System.out.print("\nPayment Successful! Enjoy~~\n");

                                        System.out.print(eWallet.toString());
                                    }
                                    
                                    break;
                                    
                                case 2:
                                    paymentMethodSelectionCheck = true;

                                    System.out.print("\n==============\nOnline Banking\n==============");
                                    System.out.print("\nEnter Bank Name    : ");
                                    String bankName = sc.nextLine();

                                    System.out.print("Enter username     : ");
                                    String bankUsername = sc.nextLine();

                                    System.out.print("Enter password     : ");
                                    String bankPassword = sc.nextLine();

                                    System.out.print("Enter Bank Balance : ");
                                    double bankBalance = sc.nextDouble();

                                    status = PaymentStatus.PENDING;
                                    
                                    if (bankBalance < payableAmount) {
                                        System.out.print("Insufficiant balance! Please try again.\n");
                                    } else {
                                        OnlineBanking accBanking = new OnlineBanking(bankName, bankBalance, status);
                                        accBanking.pay();
                                        accBanking.status = PaymentStatus.PAID;
                                        paymentSuccessful = true;
                                        System.out.print("\nPayment Successful! Enjoy~~\n");


                                        System.out.print(acc.toString());
                                    }

                                    break;
                                    
                                case 3:
                                    boolean cardCondition = false;
                                    int cardSelection = 0;
                                    String cardType = " ";
                                    
                                    paymentMethodSelectionCheck = true;
                                    
                                    while (cardCondition == false) {
                                        System.out.print("\n====\nCard\n====");
                                        System.out.print("\nEnter your Card Type : ");
                                        System.out.print("\n1. Credit Card");
                                        System.out.print("\n2. Debit Card");
                                        System.out.print("\nPlease enter your selection : ");
                                            
                                        try {
                                            cardSelection = sc.nextInt();
                                        } catch (Exception e) {

                                        }

                                        sc.nextLine();
                                        
                                        if (cardSelection == 1) {
                                            cardType = "Credit Card";
                                            cardCondition = true;
                                        } else if (cardSelection == 2) {
                                            cardType = "Debit Card";
                                            cardCondition = true;
                                        } else {
                                            System.out.print("Please enter a valid selection.\n");
                                        }

                                    }
                                    
                                    System.out.print("Enter your Card Number      : ");
                                    String cardNo = sc.nextLine();

                                    System.out.print("Enter your Card Balance     : ");
                                    double cardBalance = sc.nextDouble();

                                    status = PaymentStatus.PENDING;
                                    
                                    if (cardBalance < payableAmount) {
                                        System.out.print("Insufficiant balance! Please try again.\n");
                                    } else {
                                        Card card1 =  new Card(cardType, cardNo, cardBalance, status);
                                        card1.pay();
                                        card1.status = PaymentStatus.PAID;
                                        paymentSuccessful = true;
                                        System.out.print("\nPayment Successful! Enjoy~~\n");

                                        System.out.print(card1.toString());
                                    }

                                    break;
                                    
                                case 4:  
                                    paymentMethodSelectionCheck = true;

                                    status = PaymentStatus.CANCELLED;
                                    Payment cancel = new Payment(status) {
                                        @Override
                                        public void pay() {}
                                    };
                                    
                                    System.out.print("\nOrder Cancelled! You are always welcome. \n");
                                    System.out.print(cancel.toString());

                                    break;
                                    
                                default:
                                    System.out.println("Invalid selection! Please try again.\n");
                                }
                            }
                        
                        //Check user info
                        case 5:
                            System.out.println(" ========================================");
                            System.out.printf(" || ID: %-30s || \n",((Customer) currentUser).getCustomerID());
                            System.out.printf(" ||------------                        ||\n");
                            System.out.printf(" || Name     : %-23s || \n",currentUser.getName());
                            System.out.printf(" ||                                    ||\n");                            
                            System.out.printf(" || Email    : %-23s || \n",currentUser.getEmail()); 
                            System.out.printf(" ||                                    ||\n");
                            System.out.printf(" || ContactNo: %-23s || \n",currentUser.getContactNo());
                            System.out.println(" ========================================\n\n");
                            currentUser.getName();
                            currentUser.getName();
                        case 6:
                            System.out.println("Returning to login...");
                            
                        default:
                            System.out.println("Invalid choice, try again");
                    }
                }while(choice != 6);
            }
            
            
            
            //Admin Main Menu
            if(currentUser instanceof Admin){
                Facility f = new Facility();
                ThemePark tp = new ThemePark();
                ThemePark[] newThemeParkList = new ThemePark[]{};
                Admin a = new Admin();
                Facility[] type = new Facility[] {};
                do{
                    choice = 0;
                    
                    //Main Menu
                    System.out.println("======= THEMEPARK TICKETING ======");
                    System.out.println("==================================");
                    System.out.println("||      MENU (ADMIN ACCESS)     ||");
                    System.out.println("==================================");
                    System.out.println("||  1. Add Facility             ||");
                    System.out.println("||  2. Add ThemePark            ||");
                    System.out.println("||  3. Exit                     ||");
                    System.out.println("==================================");
                    
                    // try and catch
                    try {
                        System.out.print("\n Enter choice(1-3): ");
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid Input");
                        sc.nextLine();
                    }
                    
                    int choiceAdd = 0;
                    
                    switch(choice){
                        case 1:
                            // add new facility into array
                    
                            do {
                                System.out.println("\nChoose Facility type to add new facility");
                                System.out.println("1) Water");
                                System.out.println("2) Historical");
                                System.out.println("3) Fantasy");
                                System.out.print("Enter Selection(1/2/3): ");
                                try {
                                    choiceAdd = sc.nextInt();
                                    sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println("Invalid Input");
                                    sc.nextLine();
                                }

                                switch (choiceAdd) {
                                    case 1:
                                        type = facilityList[0];
                                        break;
                                    case 2:
                                        type = (facilityList[1]);
                                        break;
                                    case 3:
                                        type = (facilityList[2]);
                                        break;
                                    default:
                                        System.out.println("Invalid Selection");
                                        break;
                                }
                            } while (choiceAdd != 1 && choice != 2 && choice != 3);

                            System.out.print("Enter new facility name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter new facility description: ");
                            String desc = sc.nextLine();
                            f = new Facility(name, desc);
                            type = a.addFacility(type, f);
                            System.out.println("New facility added successfully");
                            System.out.println("\nNew facility list: ");

                            for (int i = 0; i < type.length; i++) {
                                System.out.println(type[i].toString());
                            }

                            break;
                        case 2:

                            // add new themepark into array

                            System.out.print("\nEnter new themepark name: ");
                            String name1 = sc.nextLine();
                            System.out.print("Enter new themepark description: ");
                            String desc1 = sc.nextLine();
                            double price = 0;
                            do{
                                System.out.print("Enter new themepark price: ");
                                try {
                                    price = sc.nextDouble();
                                    sc.nextLine();
                                } catch (Exception e) {
                                    System.out.println("Invalid Input");
                                    price = -1;
                                    sc.nextLine();
                                }
                            }while(price <= 0);
                            
                            tp = new ThemePark(name1, desc1, facilityList[0], price);
                            newThemeParkList = a.addThemePark(themeparkList, tp);
                            System.out.println("New themepark added successfully");
                            System.out.println("\nNew themepark list: ");
                            for (int i = 0; i < newThemeParkList.length; i++) {
                                System.out.println(newThemeParkList[i].toString());
                            }

                            break;
                        
                        case 3:
                            System.out.println("Exit");
                            break;
                            
                        default:
                            System.out.println("Invalid Selection");
                            System.out.println("Return to login page...");
                            break;
                            
                    }
                    
                
                }while(choice != 3);
            }
        } while(choiceUser != 3);        
        

        
    }
}
