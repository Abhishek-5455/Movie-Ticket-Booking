public class Ticket {
    private String movie;
    private final int seat;
    private String status;

    public Ticket setStatus(String status){
        this.status = status;
        return this;
    }

    public int getSeat(){
        return this.seat;
    }

    public String getStatus(){ return this.status; }

    public String getMovie() {
        return this.movie;
    }

    public Ticket(int seat){
        this.seat = seat;
        this.status = "Empty";
    }

    public Ticket(String movie , int seat){
        this.movie = movie;
        this.seat = seat;
    }

    public void printTicket(){
        System.out.printf("%02d  %8s  |  ", this.seat , this.status);
    }

}
