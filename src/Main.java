public class Main {
    public static void main(String[] args) {
        System.out.println("Monopoly start");
    }
    public void game(){
        Card[] field = new Card[40];
//        for(int i =0; i < 42; i++){
//            field[i] = new Card();
//        }
        field[1] = new StockCard("A V O N", Tags.PERFUME, 1200);

        field[3] = new StockCard("Chanel", Tags.PERFUME, 1550);

        field[5] = new StockCard("Ford", Tags.CARS, 1400);
        field[6] = new StockCard("Puma", Tags.CLOTHES, 1370);

        field[8] = new StockCard("Adidas", Tags.CLOTHES, 1680);
        field[9] = new StockCard("Termite", Tags.CLOTHES, 1950);

        field[11] = new StockCard("VK", Tags.MEDIA, 1150);
        field[12] = new StockCard("Saber Interactive", Tags.GAMES, 2000);
        field[13] = new StockCard("Ru-tube", Tags.MEDIA, 1000);
        field[14] = new StockCard("Mail.ru", Tags.MEDIA, 1700);
        field[15] = new StockCard("Nissan", Tags.CARS, 1840);
        field[16] = new StockCard("Coca-Cola", Tags.DRINKS, 2500);

        field[18] = new StockCard("Dewdrop", Tags.DRINKS, 1970);
        field[19] = new StockCard("Pepsi", Tags.DRINKS, 1150);

        field[21] = new StockCard("S7 Airlines", Tags.AVIATION, 1880);

        field[23] = new StockCard("Azimuth", Tags.AVIATION, 1480);
        field[24] = new StockCard("Ural Airlines", Tags.AVIATION, 1680);
        field[25] = new StockCard("Toyota", Tags.CARS, 1760);
        field[26] = new StockCard("Freddy Fazbear's Pizza", Tags.FOOD, 1987);
        field[27] = new StockCard("Shaurma", Tags.FOOD, 1910);
        field[28] = new StockCard("Lesta Games", Tags.MEDIA, 2400);
        field[29] = new StockCard("Old man Khinkalych", Tags.FOOD, 2300);

        field[31] = new StockCard("Maquis", Tags.HOTELS, 1200);
        field[32] = new StockCard("Mariott", Tags.HOTELS, 1790);

        field[34] = new StockCard("Diamond", Tags.HOTELS, 2100);
        field[35] = new StockCard("BMW", Tags.CARS, 2100);

        field[37] = new StockCard("Apple", Tags.PHONES, 2700);

        field[39] = new StockCard("Xiaomi", Tags.PHONES, 2540);
    }
}