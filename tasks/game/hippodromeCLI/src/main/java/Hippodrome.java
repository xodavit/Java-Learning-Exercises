
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    void run() throws InterruptedException {
        for (int i = 0; i < 120; i++) { //sec
            move();
            print();
            Thread.sleep(500); // обновление каждые полсекунды
        }
    }
    void move(){
        for ( Horse horse: horses
             ) {
            horse.move();
        }
    }
    void print(){
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        for (Horse horse: horses
             ) {
            horse.print();
        }
    }
    public Horse getWinner(){
        double maxDist = Double.MIN_VALUE;
        Horse winHorse = null;
        for (Horse horse: horses
             ) {
            if (horse.getDistance()>maxDist) {
                maxDist=horse.getDistance();
                winHorse = horse;
            }
        }
        return winHorse;
        //return horses.stream()
        //            .max((h1, h2) -> Double.compare(h1.getDistance(), h2.getDistance()))
        //            .get();
        //return horses.stream()
        //            .max(Comparator.comparingDouble(Horse::getDistance))
        //            .get();
        //return horses.stream().max(Comparator.comparing(Horse::getDistance)).orElse(null);
    }
    public void printWinner() {
        System.out.println(String.format("Winner is %s!",getWinner().getName()));
    }

    public static void main(String[] args) throws InterruptedException {
        Horse firstHorse = new Horse("First",3,0);
        Horse secondHorse = new Horse("Second",3,0);
        Horse thirdHorse = new Horse("Third",3,0);

        Horse fourthHorse = new Horse("Fourth",3,0);
        Horse fifthHorse = new Horse("Fifth",3,0);
        Horse sixthHorse = new Horse("Sixth",3,0);
        Horse seventhHorse = new Horse("Seventh",3,0);
        Horse eigthHorse = new Horse("Eigth",3,0);
        Horse ninthHorse = new Horse("Ninth",3,0);
        Horse tenthHorse = new Horse("Tenth",3,0);

        List<Horse> stall = new ArrayList<>(Arrays.asList(firstHorse,secondHorse,thirdHorse,fourthHorse,fifthHorse,
                sixthHorse,seventhHorse,eigthHorse,ninthHorse,tenthHorse));
        //game = new Hippodrome(Stream.of(
        //        new Horse("Billy", 3, 0),
        //        new Horse("Jelly", 3, 0),
        //        new Horse("Roadster", 3, 0)
        //).collect(Collectors.toList()));
        game = new Hippodrome(stall);
        game.run();
        game.printWinner();
    }
}
