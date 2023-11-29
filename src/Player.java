import java.util.ArrayList;

public class Player {

    private int coordinate;

    public String getName() {
        return name;
    }

    private String name;
    private int money;
    private int startMoney;
    private boolean jailed;

    private ArrayList<StockCard> bought = new ArrayList<>();

    Player(String name) {
        coordinate = 0;
        this.name = name;
        money = 5000;
    }

    public void status() {
        System.out.println("_________________________");
        System.out.println("Имя: " + name);
        System.out.println("Позиция: " + coordinate);
        System.out.println("Количество денег: " + money + "╒");
        System.out.println("Купленные здания: ");
        printCard();
        System.out.println("_________________________");
        System.out.println("");
    }

    public boolean increaseCoordinate(int coordinate) {
        coordinate = this.coordinate + coordinate;
        if (coordinate >= 40) {
            this.coordinate = coordinate % 40;
            System.out.println("Вы пересекли старт! На ваш счет поступило " + startMoney + "╒");
            money += startMoney;
            return true;
        }
        this.coordinate = coordinate;
        return false;
    }
    public void letsGoSell(){
        // TODO: 29.11.2023 Сделать предложение продать что то и реализовать продажу
    }

    public boolean checker() {
        if (getMoney() <= 0 && getBought().size() == 0) {
            return false;
        }
        return true;
    }

    public boolean cardChecker(StockCard card) {
        for (int i = 0; i < bought.size(); i++) {
            if (bought.get(i).equals(card)) return true;
        }
        return false;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public int getMoney() {
        return money;
    }

    public void addBought(StockCard card) {
        bought.add(card);
    }

    public ArrayList<StockCard> getBought() {
        return bought;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public int getCoordinate() {
        return coordinate;
    }

    private void printCard() {
        for (int i = 0; i < bought.size(); i++) {
            System.out.println(i + 1 + ". [" + bought.get(0).description() + "]");
        }
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }
}
