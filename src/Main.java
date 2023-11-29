public class Main {

    public static void main(String[] args) {
        System.out.println("Monopoly start");
        Player[] players = new Player[2];
        players[0] = new Player("Трус");
        players[1] = new Player("Балбес");
        Game game = new Game(players);
        game.game();
    }

}