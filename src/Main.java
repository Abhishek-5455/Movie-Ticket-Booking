import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    static HashMap<String ,User> users = new HashMap<>();
    static Movie[] movie = {new Movie("Avatar 2") , new Movie("Fast and furious 9") , new Movie("Who am I") , new Movie("Extraction 2") , new Movie("Gravity")};

    public static void main(String[] args) {

        User.loginOptions();
        User currentUser = null;
        System.out.print("Enter your choice : ");
        int choice = scan.nextInt();
        while(choice != 0){
            switch (choice){
                case 1 -> currentUser = createUser();
                case 2 -> currentUser = login();
            }
            if(currentUser != null)bookMovieTickets(currentUser);
            User.loginOptions();
            System.out.print("Enter your choice : ");
            choice = scan.nextInt();
        }

    }
    public static Movie movieList(){
        System.out.println("Select Movie : ");
        for(int i = 1 ; i <= movie.length ; i++){
            System.out.println(i + " " + movie[i-1].getName());
        }
        System.out.print("Enter your choice : ");
        int choice = scan.nextInt();
        movie[choice-1].printSeatArrangement();
        return movie[choice-1];

    }
    public static User createUser(){
        System.out.print("Enter user name : ");
        String userName = scan.next();

        while(users.containsKey(userName)){
            System.out.println("User name already exist, Try another username!!");
            System.out.print("User Name : ");
            userName = scan.next();
        }
        System.out.print("Password : ");
        String password = scan.next();
        System.out.print("Re-Enter password : ");
        String rePass = scan.next();
        while(!password.equals(rePass)){
            System.out.println("Password doesn't match\tPlease re enter the password\n");
            System.out.println("Re-Enter password : ");
            rePass = scan.next();
        }
        User user = new User(userName , password);
        users.put(userName , user);
        return user;
    }

    public static User login(){
        System.out.print("User Name : ");
        String userName = scan.next();
        if(!users.containsKey(userName)){
            System.out.println("User not found");
            userName = scan.next();
        } else {
            System.out.print("Enter password : ");
            String password = scan.next();
            while(!users.get(userName).getPassword().equals(password)){
                System.out.println("Wrong password\nEnter password again");
                System.out.print("Password : ");
                password = scan.next();
            }
        }

        return users.get(userName);
    }

    public static void bookMovieTickets(User user){
        Movie movie = null;
        Ticket ticket;
        user.greetings();
        User.userOptions();
        System.out.print("Enter your choice : ");
        int choice = scan.nextInt();
        while(choice != 0){
            switch (choice){
                case 1 -> {
                    movie = movieList();
                    System.out.print("\nEnter seat : ");
                    int seat = scan.nextInt();
                    while(seat > 50 || seat < 1){
                        System.out.print("\nNo seat available with this seat number\nEnter another seat number : ");
                        seat = scan.nextInt();
                    }
                    ticket = movie.bookTicket(seat , user.getUserName());
                    user.addMovie(movie.getName() , ticket);
                }
                case 2 -> user.printTickets();
                case 3 -> { if(movie != null) movie.printSeatArrangement(); }
            }
            User.userOptions();
            System.out.print("Enter your choice : ");
            choice = scan.nextInt();
        }
    }
}
