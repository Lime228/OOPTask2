public class Main {
    Player[] players;

    Card[] field;

    public void main(String[] args) {
        System.out.println("Monopoly start");
        game();
    }

    private void game() {
        players[0] = new Player("Крум");
        players[1] = new Player("Волог");

        field = new Card[40];
        //start
        field[1] = new StockCard("A V O N", Tags.PERFUME, 1200);
        field[2] = new ChanceCard();
        field[3] = new StockCard("Chanel", Tags.PERFUME, 1550);
        field[4] = new ChanceCard();
        field[5] = new StockCard("Ford", Tags.CARS, 1400);
        field[6] = new StockCard("Puma", Tags.CLOTHES, 1370);
        field[7] = new ChanceCard();
        field[8] = new StockCard("Adidas", Tags.CLOTHES, 1680);
        field[9] = new StockCard("Termite", Tags.CLOTHES, 1950);
        //jail
        field[11] = new StockCard("VK", Tags.MEDIA, 1150);
        field[12] = new StockCard("Saber Interactive", Tags.GAMES, 2000);
        field[13] = new StockCard("Ru-tube", Tags.MEDIA, 1000);
        field[14] = new StockCard("Mail.ru", Tags.MEDIA, 1700);
        field[15] = new StockCard("Nissan", Tags.CARS, 1840);
        field[16] = new StockCard("Coca-Cola", Tags.DRINKS, 2500);
        field[17] = new ChanceCard();
        field[18] = new StockCard("Dewdrop", Tags.DRINKS, 1970);
        field[19] = new StockCard("Pepsi", Tags.DRINKS, 1150);
        // casino
        field[21] = new StockCard("S7 Airlines", Tags.AVIATION, 1880);
        field[22] = new ChanceCard();
        field[23] = new StockCard("Azimuth", Tags.AVIATION, 1480);
        field[24] = new StockCard("Ural Airlines", Tags.AVIATION, 1680);
        field[25] = new StockCard("Toyota", Tags.CARS, 1760);
        field[26] = new StockCard("Freddy Fazbear's Pizza", Tags.FOOD, 1987);
        field[27] = new StockCard("Shaurma", Tags.FOOD, 1910);
        field[28] = new StockCard("Lesta Games", Tags.MEDIA, 2400);
        field[29] = new StockCard("Old man Khinkalych", Tags.FOOD, 2300);
        //police
        field[31] = new StockCard("Maquis", Tags.HOTELS, 1200);
        field[32] = new StockCard("Mariott", Tags.HOTELS, 1790);
        field[33] = new ChanceCard();
        field[34] = new StockCard("Diamond", Tags.HOTELS, 2100);
        field[35] = new StockCard("BMW", Tags.CARS, 2100);
        field[36] = new ChanceCard();
        field[37] = new StockCard("Apple", Tags.PHONES, 2700);
        field[38] = new ChanceCard();
        field[39] = new StockCard("Xiaomi", Tags.PHONES, 2540);

//        player1.addBought((StockCard) field[1]);
//        player1.status();
//        player2.status();

        while (checkPlayers()) {

        }
    }

    private boolean checkPlayers() {
        int check = 0;
        for (int i = 0; i < players.length; i++) {
            if (players[i] != null && players[i].checker() == true) check++;
        }

        if (check == players.length) {
            return true;
        }
        return false;
    }

    private void stepPlayer(Player player) {
        if (!player.isJailed()) player.increaseCoordinate(diceThrow() + diceThrow());
        if (player.getCoordinate() == 0) { // start
            // TODO: 27.11.2023 Придумать че нибудь для старта а то чет кринж
        } else if (player.getCoordinate() == 10) { // jail
            if (player.isJailed()) {
                if (diceThrow() == diceThrow()) {
                    player.setJailed(false);
                }
            }
        } else if (player.getCoordinate() == 30) { // police
            player.setCoordinate(10);
            player.setJailed(true);
        } else if (player.getCoordinate() == 20) { // casino
            // TODO: 27.11.2023 Сделай казино пеж а то чет лень сегодня
        } else{
            Card card = field[player.getCoordinate()];
            card.action(player);
        }
    }

    private int diceThrow() {
        return (int) (Math.random() * 6) + 1;
    }
}