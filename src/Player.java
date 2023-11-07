import java.util.ArrayList;

public class Player {

    private int coordinate;
    private String name;
    private int money;
    private ArrayList<StockCard> bought;
    Player(String name){
        coordinate = 0;
        this.name = name;
        money = 5000;
    }
    public int getCoordinate() {
        return coordinate;
    }


    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }
    public boolean increaseCoordinate(int coordinate) {
        coordinate = this.coordinate + coordinate;
        if(coordinate >= 40){
            this.coordinate = coordinate % 40;
            return true;
        }
        this.coordinate = coordinate;
        return false;
    }
    public void addMoney(int money){
        this.money += money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
