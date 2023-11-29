import java.util.Scanner;

public class Game {
    Game(Player[] players) {
        if(players.length > 4){
            System.out.println("Слишком много игроков!");
            System.exit(0);
        }else if (players.length >=2) {
            Game.players = players;
        }else {
            System.out.println("Слишком мало игроков!");
            System.exit(0);
        }
    }

    static Player[] players;

    Card[] field;

    protected void game() {
        Scanner scanner = new Scanner(System.in);

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
        // casino (русское нелегальное, при попадании автоматом в кпз)
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

        while (checkPlayers()) {
            for (Player player : players) {
                System.out.println("_________________________");
                System.out.println("Ход игрока " + player.getName());
                int choise = 0;
                while (choise != 1) {
                    try {
                        System.out.println("Чего желаете?");
                        System.out.println("1. Бросить кубики.");
                        System.out.println("2. Посмотреться в зеркало.");
                        System.out.println("_________________________");
                        choise = scanner.nextInt();
                        switch (choise) {
                            case 1 -> stepPlayer(player);
                            case 2 -> player.status();
                        }
                    } catch (Exception e) {
                        System.out.println("Введите число 1 или 2");
                    }
                }
            }
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
        int dice1 = diceThrow();
        int dice2 = diceThrow();
        System.out.println("Результаты броска: первый кубик - " + dice1 + " второй кубик - " + dice2 + ".");
        if (!player.isJailed()) player.increaseCoordinate(dice1 + dice2);
        if (player.getCoordinate() == 0) {
        } else if (player.getCoordinate() == 10) { // jail
            System.out.println("Вы в тюрьме.");
            if (player.isJailed()) {
                System.out.println("Для того чтобы выбраться отсюда, у вас должен быть дубль.");
                if (dice1 == dice2) {
                    System.out.println("Поздравляем! Вы выкинули дубль, теперь вы свободный человек!");
                    player.setJailed(false);
                } else {
                    System.out.println("Какая жалость! Вы не выкинули дубль.");
                }
            }
        } else if (player.getCoordinate() == 30) { // police
            System.out.println("Вы забрели в полицейский участок, но вашу мошенническую физиономию узнали и вы попадаете в тюрьму.");
            player.setCoordinate(10);
            player.setJailed(true);
        } else if (player.getCoordinate() == 20) { // casino
            System.out.println("Вы оказались в казино! Но это нелегальное казино, поэтому вас скрутили и увезли в тюрьму.");
            player.setCoordinate(10);
            player.setJailed(true);
        } else {
            System.out.println("Вы попадаете вот сюда.");
            Card card = field[player.getCoordinate()];

            card.action(player);
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public static boolean isBought(StockCard card) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].cardChecker(card)) return true;
        }
        return false;
    }

    public static Player whoBought(StockCard card) {
        for (int i = 0; i < players.length; i++) {
            if (players[i].cardChecker(card)) return players[i];
        }
        return null;
    }

    private int diceThrow() {
        return (int) (Math.random() * 6) + 1;
    }

    public static void breake() {
        System.exit(0);
    }
}