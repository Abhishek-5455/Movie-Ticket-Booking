import java.util.ArrayList;
import java.util.List;

public class Movie {
    final int COST = 1_0;
    private final String name;
    private final List<Ticket> ticketList;

    public String getName() {
        return name;
    }

    public Movie(String name){
        this.name = name;
        this.ticketList = new ArrayList<>();
        for(int i = 0 ; i < 50 ; i++){
            this.ticketList.add(new Ticket(i+1));
        }
    }

    public void printSeatArrangement(){
        System.out.printf("\nMovie Name : %10s\n",getName());
        System.out.println();
        System.out.println(" ".repeat(31)+"-".repeat(18));
        System.out.print(" ".repeat(31));
        System.out.println("|     SCREEN     |");
        System.out.println(" ".repeat(31) + "-".repeat(18));
        System.out.println();
        for(int i = 0 ; i < 50 ; i++){
            this.ticketList.get(i).printTicket();
            if((i + 1) % 5 == 0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("-".repeat(80));
    }

    public Ticket bookTicket(int seat , String username){
        Ticket ticket = this.ticketList.get(seat-1);

        if(ticket.getStatus().trim().equals("Booked")){
            System.out.printf("Seat %02d is already booked !!%n", seat);
            return null;
        }
        this.ticketList.set(seat - 1 , ticketList.get(seat-1).setStatus(username));
        System.out.println("\nSeat " + seat + " is booked by your name\nEnjoy your movie....");
        System.out.println("\nAmount to pay : $" + COST + "\n");

        return new Ticket(name , seat);
    }
}
