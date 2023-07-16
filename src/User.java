import java.util.ArrayList;
import java.util.List;

public class User {
    private final String userName;
    private final String password;
    private final List<Ticket> tickets;

    public User(String userName , String password) {
        this.userName = userName;
        this.password = password;
        tickets = new ArrayList<>();
    }

    public String getUserName(){ return userName; }
    public String getPassword(){ return password; }


    public void addMovie(String name , Ticket ticket) {
        this.tickets.add(new Ticket(name , ticket.getSeat()));
    }

    public void greetings(){
        System.out.println("-".repeat(40));
        System.out.println("|  Hello " + getUserName() + "\n|  Welcome to Book My Show");
        System.out.println("-".repeat(40));
    }

    public static void userOptions(){
        System.out.println("-".repeat(30));
        System.out.printf("| %02d   %-20s |\n",1,"Book Tickets");
        System.out.printf("| %02d   %-20s |\n",2,"Ticket details");
        System.out.printf("| %02d   %-20s |\n",3,"Seats arrangement");
        System.out.printf("| %02d   %-20s |\n",0,"Exit");
        System.out.println("-".repeat(30));
    }

    public static void loginOptions() {
        System.out.println("-".repeat(24));
        System.out.printf("| %02d   %-15s |\n",1,"Create User");
        System.out.printf("| %02d   %-15s |\n",2,"User login");
        System.out.printf("| %02d   %-15s |\n",0,"Exit");
        System.out.println("-".repeat(24));
    }
    public void printTickets(){
        if(tickets.isEmpty()){
            System.out.println("No seats booked by you!!\n");

            return;
        }
        for(Ticket ticket: tickets){
            System.out.println("-".repeat(50));
            System.out.printf(" Movie : %-20s | Seat : %02d\n",ticket.getMovie(),ticket.getSeat());
            System.out.println("-".repeat(50));

        }
        System.out.println();
    }
}
