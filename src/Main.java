public class Main {
    public static void main(String[] args) {
        System.out.println("Monopoly start");
    }
    public void game(){
        Card[] field = new Card[40];
        for(int i =0; i < 42; i++){
            field[i] = new Card();
        }
        field[1] = new StockCard("A V O N", Tags.Perfume, 1200);

        field[3] = new StockCard("Chanel", Tags.Perfume, 1550);

        field[5] = new StockCard("Ford", Tags.Cars, 1400);
        field[6] = new StockCard("Puma", Tags.Clothes, 1370);

        field[8] = new StockCard("Adidas", Tags.Clothes, 1680);
        field[9] = new StockCard("Termite", Tags.Clothes, 1950);

        field[11] = new StockCard("VK", Tags.Media, 1150);
        field[12] = new StockCard("Saber Interactive", Tags.Games, 2000);
        field[13] = new StockCard("Ru-tube", Tags.Media, 1000);
        field[14] = new StockCard("Mail.ru", Tags.Media, 1700);
        field[15] = new StockCard("Nissan", Tags.Cars, 1840);
        field[16] = new StockCard("Coca-Cola", Tags.Drinks, 2500);

        field[18] = new StockCard("Dewdrop", Tags.Drinks, 1970);
        field[19] = new StockCard("Pepsi", Tags.Drinks, 1150);

        field[21] = new StockCard("S7 Airlines", Tags.Aviation, 1880);

        field[23] = new StockCard("Azimuth", Tags.Aviation, 1480);
        field[24] = new StockCard("Ural Airlines", Tags.Aviation, 1680);
        field[25] = new StockCard("Toyota", Tags.Cars, 1760);
        field[26] = new StockCard("Freddy Fazbear's Pizza", Tags.Food, 1987);
        field[27] = new StockCard("Shaurma", Tags.Food, 1910);
        field[28] = new StockCard("Lesta Games", Tags.Media, 2400);
        field[29] = new StockCard("Old man Khinkalych", Tags.Food, 2300);

        field[31] = new StockCard("Maquis", Tags.Hotels, 1200);
        field[32] = new StockCard("Mariott", Tags.Hotels, 1790);

        field[34] = new StockCard("Diamond", Tags.Hotels, 2100);
        field[35] = new StockCard("BMW", Tags.Cars, 2100);

        field[37] = new StockCard("Apple", Tags.Phones, 2700);

        field[39] = new StockCard("Xiaomi", Tags.Phones, 2540);
    }
}