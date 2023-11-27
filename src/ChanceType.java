import java.util.Random;


public enum ChanceType {
    // ПЕРЕХОД НА
    JAIL1(10, false,"Вас уличили в банковских махинациях. Отправляйтесь в тюрьму."),
    JAIL2(10, false,"Вас уличили в продаже просроченных талонов на бензин. Отправляйтесь в тюрьму."),
    START(0, false, "Вы проходили мимо марафона, и вас заставили участвовать. Отправляйтесь на старт."),
    BACK(3, false, "Кажется, вы выронили телефон. Возвращайтесь на 3 клетки назад"),
    DEWDROP(18, false, "У вас новая идея для газировки. Отправляйтесь на завод 'Росинка'. Если проходите старт, получаете 2000"),
    APPLE(37, false, "Вы забыли про экскурсию на завод Apple, срочно отправляйтесь туда."),
    SHAURMA(27, false, "Бизнес бизнесом, а ланч по расписанию. Отправляйтесь в шаурмечную."),
    VK(11, false, "Вы давно не навещали своих друзей из VK, пора это исправить. Отправляйтесь в их офис."),

    // ДЕНЕЖНЫЕ ОПЕРАЦИИ
    BANKING_ERROR(1500, true, "Банковская ошибка в вашу пользу."),
    SHARE_SALE1(500, true,"Выгодная продажа акций"),
    SHARE_SALE2(500, true,"Выгодная продажа акций"),
    HERITAGE(3000, true, "Вы получили наследство от вашей троюродной тётушки."),
    TAX_REFUND(300, true, "Возвращение налога."),
    INSURANCE_PAYMENT(-600, true, "Пришло время оплатить страховку."),
    BEAUTY_CONTEST(100, true, "Вы заняли второе место в конкурсе красоты. Ничего страшного, в следующий раз займете первое."),
    BOND_SALE(-750, true, "Выгодная продажа облигаций."),
    DENTIST_PAYMENT(-400, true, "Оплатите лечение зубов."),
    RENT_COLLECTION(450, true, "Вы собрали ренту."),
    SPEEDING_TICKET(-475, true, "Оплатите штраф за превышение скорости."),
    DEBT_RECOVERY(850, true, "Ваш друг Александр наконец вернул вам долг."),
    DRUNK_DRIVE(-666, true, "Оплатите штраф за вождение в нетрезвом виде."),
    BANK_DIVIDENDS(1000, true, "Пришли банковские дивиденды."),
    CHESS_WIN(800, true, "Вы выиграли чемпионат по шахматам. Вам даже дали кубок в виде коня."),
    DRIVER_COURSES(-700, true, "Оплата курсов водителей.");


    private int value;

    private boolean type;
    private String description;
    private static final ChanceType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    ChanceType(int i, boolean type, String description) {
        this.value = i;
        this.type = type;
        this.description = description;
    }
    public int getValue() {
        return value;
    }
    public boolean isMoney() { // TRUE - бабос FALSE - клетка
        return type;
    }
    public String getDescription(){return description;}
    public static ChanceType getRandomType(){
        return VALUES[RANDOM.nextInt(SIZE)];
    }
    @Override
    public String toString() {
        return "ChanceType{" +
                "value='" + value + '\'' +
                '}';
    }
}
