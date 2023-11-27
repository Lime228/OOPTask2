import java.util.ArrayList;

public class Player {

    private int coordinate;
    private String name;
    private int money;
    private int startMoney;

    public boolean isJailed() {
        return jailed;
    }

    public void setJailed(boolean jailed) {
        this.jailed = jailed;
    }

    private boolean jailed;

    public ArrayList<StockCard> getBought() {
        return bought;
    }

    private ArrayList<StockCard> bought = new ArrayList<>();
    Player(String name){
        coordinate = 0;
        this.name = name;
        money = 5000;
    }
    public int getCoordinate() {
        return coordinate;
    }
    public void status(){
        System.out.println("_________________________");
        System.out.println("Имя: " + name);
        System.out.println("Позиция: " + coordinate);
        System.out.println("Количество денег: " + money + "╒");
        System.out.println("Купленные здания: ");
        printCard();
        System.out.println("_________________________");
        System.out.println("");
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
    public boolean increaseCoordinate(int coordinate) {
        coordinate = this.coordinate + coordinate;
        if(coordinate >= 40){
            this.coordinate = coordinate % 40;
            money += startMoney;
            return true;
        }
        this.coordinate = coordinate;
        return false;
    }
    public void addMoney(int money){
        this.money += money;
    }
    public void addBought(StockCard card){
        bought.add(card);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    private void printCard(){
        for (int i = 0; i < bought.size(); i++){
            System.out.println(i+1+". ["+bought.get(0).getInfo()+"]");
        }
    }
    public boolean checker(){
        if(getMoney() !=0 && getBought().size() !=0){
            return true;
        }
        return false;
    }
    public boolean cardChecker(StockCard card){
        for (int i = 0; i < bought.size(); i++){
            if (bought.get(i).equals(card)) return true;
        }
        return false;
    }
}
