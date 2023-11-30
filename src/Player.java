import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private int coordinate;

    public String getName() {
        return name;
    }

    private String name;
    private int money;
    private int startMoney = 2000;
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

    public void letsGoSell() {
        Scanner scanner = new Scanner(System.in);
        int choise = 0;
        while (choise != -1) {
            System.out.println("_________________________");
            System.out.println("Ваши приобретения:");
            printCard();
            System.out.println("Что хотите продать?");
            System.out.println("_________________________");
            System.out.print("Введите номер здания: ");
            try {
                choise = scanner.nextInt();
                if (choise <= 0) {
                    throw new Exception();
                } else {
                    System.out.print("\n");
                    System.out.println("Вы продали здание: " + this.getBought().get(choise - 1).getName() + ". Стоимость его продажи: " + this.getBought().get(choise - 1).getCost() + "╒");
                    this.addMoney(this.getBought().get(choise - 1).getCost());
                    this.bought.remove(this.getBought().get(choise - 1));
                    choise = -1;
                }
            } catch (Exception e) {
                System.out.println("Выберите число из списка.");
            }
        }
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

    public int tagChecker(Tags tag) {
        int i = 0;
        for (StockCard card : bought) {
            if (tag == card.getTag()) {
                i++;
            }
        }
        return i;

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
            System.out.println(i + 1 + ". [" + bought.get(i).description() + "]");
        }
    }

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }
}
