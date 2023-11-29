import java.util.Scanner;

public class StockCard extends Card {
    private Tags tag;
    private String name;
    private int cost;
    private int[] chips_costs = new int[5];
    private int chips_count;
    private int choise = 0;

    StockCard(String name, Tags tag, int cost) {
        this.name = name;
        this.tag = tag;
        this.cost = cost;
        chips_costs[0] = (int) (this.cost * 0.75);
        chips_costs[1] = (int) (this.cost * 1.2);
        chips_costs[2] = (int) (this.cost * 1.5);
        chips_costs[3] = (int) (this.cost * 1.8);
        chips_costs[4] = (int) (this.cost * 2.2);
        chips_count = 0;
    }

    @Override
    public void action() {
        super.action();

    }

    @Override
    public void action(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(this.description());
        if (!player.cardChecker(this) && !Game.isBought(this)) {
            if (player.checker() && player.getMoney() >= cost) {
                try {
                    System.out.println("Желаете купить " + name + "?");
                    System.out.println("1. Да");
                    System.out.println("2. Нет");
                    choise = scanner.nextInt();
                    if (choise == 1) {
                        player.addMoney(-cost);
                        player.addBought(this);
                    }
                } catch (Exception e){
                    System.out.println("Введите число 1 или 2");
                }
            }
        } else if (!player.cardChecker(this) && Game.isBought(this)) {
            while (!paymentCheck(player)) {
            }
        } else { // TODO: 29.11.2023 прикрутить проверку на наличие всей недвижимости из категории
            if (chips_count < 5) {
                if (chips_count == 0) {
                    if (player.getMoney() >= chips_costs[0]) {
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if (choise == 1) {
                                player.addMoney(-chips_costs[0]);
                                cost *= 0.5;
                                cost += chips_costs[0] * 0.75;
                                chips_count++;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число 1 или 2");
                        }
                    }
                }
                if (chips_count == 1) {
                    if (player.getMoney() >= chips_costs[1]) {
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if (choise == 1) {
                                player.addMoney(-chips_costs[1]);
                                cost += chips_costs[1] * 0.75;
                                chips_count++;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число 1 или 2");
                        }
                    }
                }
                if (chips_count == 2) {
                    if (player.getMoney() >= chips_costs[2]) {
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if (choise == 1) {
                                player.addMoney(-chips_costs[2]);
                                cost += chips_costs[2] * 0.75;
                                chips_count++;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число 1 или 2");
                        }
                    }
                }
                if (chips_count == 3) {
                    if (player.getMoney() >= chips_costs[3]) {
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if (choise == 1) {
                                player.addMoney(-chips_costs[3]);
                                cost += chips_costs[3] * 0.75;
                                chips_count++;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число 1 или 2");
                        }
                    }
                }
                if (chips_count == 4) {
                    if (player.getMoney() >= chips_costs[4]) {
                        try {
                            System.out.println("Желаете поставить фишку?");
                            System.out.println("1. Да");
                            System.out.println("2. Нет");
                            choise = scanner.nextInt();
                            if (choise == 1) {
                                player.addMoney(-chips_costs[4]);
                                cost += chips_costs[4] * 0.75;
                                chips_count++;
                            }
                        } catch (Exception e) {
                            System.out.println("Введите число 1 или 2");
                        }
                    }
                }
            }
        }
    }
    private boolean paymentCheck(Player player){
        if (player.getMoney() >= this.cost) {
            player.addMoney(-cost);
            System.out.println("Вы встали на недвижимости игрока " + Game.whoBought(this).getName() + ". Вам придется заплатить " + cost + "╒");
            Game.whoBought(this).addMoney(cost);
            return true;
        } else if(player.getBought().size() != 0 && player.getMoney() < this.cost ) {
            player.letsGoSell();
            return false;
        } else if(player.getBought().size() == 0 && player.getMoney() < this.cost){
            return true;
        }
        return true;
    }

    public Tags getTag() {
        return tag;
    }

    public String getTagString() {
        switch (this.tag) {
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

    public String description() {
        String str = "Название: " + name + ", Категория: " + getTagString() + ", Стоимость покупки/посещения: " + cost + ", Количество фишек: " + chips_count + ".";
        return str;
    }


}
