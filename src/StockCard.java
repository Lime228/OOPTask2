import java.util.Scanner;

public class StockCard extends Card {


    private Tags tag;
    private String name;
    private int cost;

    private int[] chips_costs;
    private int chips_count;
    private int choise = 0;
    Scanner scanner = new Scanner(System.in);
    StockCard(String name, Tags tag, int cost){
        this.name = name;
        this.tag = tag;
        this.cost = cost;
        chips_costs[0] = (int) (this.cost *0.75);
        chips_costs[1] = (int) (this.cost *1.2);
        chips_costs[2] = (int) (this.cost *1.5);
        chips_costs[3] = (int) (this.cost *1.8);
        chips_costs[4] = (int) (this.cost *2.2);
        chips_count = 0;
    }
    public Tags getTag() {
        return tag;
    }
    public String getTagString() {
        switch (this.tag){
            case PERFUME -> {
                return "Perfume";
            }
            case CARS -> {
                return "Cars";
            }
            case CLOTHES -> {
                return "Clothes";
            }
            case MEDIA -> {
                return "Media";
            }
            case GAMES -> {
                return "Games";
            }
            case DRINKS -> {
                return "Drinks";
            }
            case AVIATION -> {
                return "Aviation";
            }
            case FOOD -> {
                return "Food";
            }
            case HOTELS -> {
                return "Hotels";
            }
            case PHONES -> {
                return "Phones";
            }
            default -> {
                return "Unknown";
            }
        }
    }
    public String getInfo(){
        String str = "Название: " + name + ", Категория: " + getTagString() + ", Стоимость покупки/посещения: " + cost + ", Количество чипов: " + chips_count + ".";
        return str;
    }

    @Override
    public void action() {
        super.action();

    }

    @Override
    public void action(Player player) {
        // TODO: 27.11.2023 Описать случай если эта клетка принадлежит другому игроку
        if (!player.cardChecker(this)) {
            if (player.checker() && player.getMoney() >= cost) {
                player.addBought(this);
            }
        }else{
            this.getInfo();
            if(chips_count < 5){
                if(chips_count == 0){
                    if (player.getMoney() >= chips_costs[0]){
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if(choise == 1){
                                player.addMoney(-chips_costs[0]);
                                cost *= 0.5;
                                cost += chips_costs[0]*0.75;
                                chips_count++;
                            }
                        }catch (Exception e){
                            System.out.println("Введите число");
                        }
                    }
                }
                if(chips_count == 1){
                    if (player.getMoney() >= chips_costs[1]){
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if(choise == 1){
                                player.addMoney(-chips_costs[1]);
                                cost += chips_costs[1]*0.75;
                                chips_count++;
                            }
                        }catch (Exception e){
                            System.out.println("Введите число");
                        }
                    }
                }
                if(chips_count == 2){
                    if (player.getMoney() >= chips_costs[2]){
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if(choise == 1){
                                player.addMoney(-chips_costs[2]);
                                cost += chips_costs[2]*0.75;
                                chips_count++;
                            }
                        }catch (Exception e){
                            System.out.println("Введите число");
                        }
                    }
                }
                if(chips_count == 3){
                    if (player.getMoney() >= chips_costs[3]){
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if(choise == 1){
                                player.addMoney(-chips_costs[3]);
                                cost += chips_costs[3]*0.75;
                                chips_count++;
                            }
                        }catch (Exception e){
                            System.out.println("Введите число");
                        }
                    }
                }
                if(chips_count == 4){
                    if (player.getMoney() >= chips_costs[4]){
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if(choise == 1){
                                player.addMoney(-chips_costs[4]);
                                cost += chips_costs[4]*0.75;
                                chips_count++;
                            }
                        }catch (Exception e){
                            System.out.println("Введите число");
                        }
                    }
                }
            }
        }

    }


}
