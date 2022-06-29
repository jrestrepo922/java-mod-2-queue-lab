import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // instantiate the restaurant class and add the 2 tables and set them equals to false; 
        Restaurant restaurant = new Restaurant(); 
        restaurant.getTable().put("Table 1", ""); 
        restaurant.getTable().put("Table 2", ""); 

        try (Scanner scanner = new Scanner(System.in)) {
            // create a while loop
            while(true){
                // get users input
                String checkinOrCheckout = Main.checkingInOrOutInput(scanner);
                if(checkinOrCheckout.equals("1")){
                    String userName = Main.getName(scanner);
                    Main.checkin(restaurant, userName);
                } else if(checkinOrCheckout.equals("2")){
                    // check to see if any of the tables are taken
                    String table1 = restaurant.getTable().get("Table 1");
                    String table2 = restaurant.getTable().get("Table 2"); 
                    if(table1.equals("") && table2.equals("")){
                        System.out.println("Can not checkout if no one is using the tables");
                        continue; 
                    } else {
                        Main.checkout(restaurant);
                    }

                } else { 
                    System.out.println("Thank you for bussiness");
                    break; 
                }

            } 
        
            System.out.println("Tables: " + restaurant.getTable());
            System.out.println("Queue: " + restaurant.getWaitList());
        } catch (Exception e) {
            System.out.println("Something when wrong");
        }
    }

    private static String checkingInOrOutInput(Scanner scanner){
        System.out.println("Please select from the following options");
        System.out.println("To check in type: 1");
        System.out.println("To check out type 2");
        System.out.println("To exit the restaurant type 3");
        String userInput = scanner.nextLine();
        return userInput; 
    } 

    private static String getName(Scanner scanner){
        System.out.println("Please Provide me your name");
        String userName = scanner.nextLine();
        return userName;
    } 


    private static void checkin(Restaurant restaurant, String newCustomerName){
        // needs to check if a table is avaliable 
        String table1 = restaurant.getTable().get("Table 1");
        String table2 = restaurant.getTable().get("Table 2"); 
        if(table1.equals("")){
            restaurant.getTable().put("Table 1", newCustomerName); 
        } else if(table2.equals("")){
            restaurant.getTable().put("Table 2", newCustomerName); 
        } else { // not avaliable so need to add to the queue. 
            restaurant.getWaitList().add(newCustomerName);
        }
        System.out.println("Tables: " + restaurant.getTable());
        System.out.println("Queue: " + restaurant.getWaitList());
    }

    private static void checkout(Restaurant restaurant){
        // needs to check if a table is avaliable 
        String table1 = restaurant.getTable().get("Table 1");
        String table2 = restaurant.getTable().get("Table 2"); 
        // free a table that is currently being use
        if(!table1.equals("")){
            restaurant.getTable().put("Table 1", ""); 
            String customerToBeSeated = restaurant.getWaitList().remove();
            restaurant.getTable().put("Table 1", customerToBeSeated);

        } else if(!table2.equals("")){
            restaurant.getTable().put("Table 2", ""); 
            String customerToBeSeated = restaurant.getWaitList().remove();
            restaurant.getTable().put("Table 2", customerToBeSeated);
        }
        System.out.println("Tables: " + restaurant.getTable());
        System.out.println("Queue: " + restaurant.getWaitList()); 
    }
}

// Instructions
// Let's create a lightweight, simplified, restaurant reservation system:

// Our restaurant has 2 tables
// In an input loop, ask the user if they want to check someone in or check someone out
// If they want to check someone in, check if a table is available.
// If a table is available, check them in
// If a table is not available, put them on a waiting list
// If they want to check someone out:
// Free one of the table that is taken
// Immediately assign the table to the next person on the waiting list
// Hints:

// You can use an array, a list, a map or a queue for your tables - each data structure has pros and cons, but you can make each one work for the list of tables
// Use a queue for your wait list, as that's the most natural data structure for this type of scenario
// You may want to use a class named Restaurant that holds both your table list and your waitlist
// Your Restaurant class will have a method you might call checkin and a method called checkout that will be responsible for implementing the logic we described above