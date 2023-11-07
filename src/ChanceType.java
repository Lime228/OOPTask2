import java.util.Random;


public enum ChanceType {
    // ПЕРЕХОД НА
    JAIL(10, false), // Попадание в тюрьму. (2шт)
    START(0, false), // Отправляйтесь на старт.
    BACK(3, false), // Возвращайтесь назад на 3 клетки.
    DEWDROP(18, false), // Отправляйтесь на завод "Росинка", если проходите старт, получаете 2000.
    APPLE(37, false), // Вы забыли про экскурсию на завод Apple, срочно отправляйтесь туда.
    SHAURMA(27, false), // Бизнес бизнесом, а ланч по расписанию. Отправляйтесь в шаурмечную.
    VK(11, false), //Вы давно не навещали своих друзей из VK, пора это исправить. Отправляйтесь в их офис.

    // ДЕНЕЖНЫЕ ОПЕРАЦИИ
    BANKING_ERROR(1500, true), // Банковская ошибка в вашу пользу. (+)
    SHARE_SALE(500, true), // Выгодная продажа акций. (2шт) (+)
    HERITAGE(3000, true), // Вы получили наследство. (+)
    TAX_REFUND(300, true), // Возвращение налога. (+)
    INSURANCE_PAYMENT(-600, true), // Оплата страховки. (-)
    BEAUTY_CONTEST(100, true), // 2-е место в конкурсе красоты. (+)
    BOND_SALE(-750, true), // Выгодная продажа облигаций. (-)
    DENTIST_PAYMENT(-400, true), // Оплата лечения зубов. (-)
    RENT_COLLECTION(450, true), // Сбор ренты. (+)
    SPEEDING_TICKET(-475, true), // Штраф за превышение скорости. (-)
    DEBT_RECOVERY(850, true), // Возврат долга. (+)
    DRUNK_DRIVE(-666, true), // Штраф за вождение в нетрезвом виде. (-)
    BANK_DIVIDENDS(1000, true), // Банковские дивиденды. (+)
    CHESS_WIN(800, true), // Вы выиграли чемпионат по шахматам. (+)
    DRIVER_COURSES(-700, true); // Оплата курсов водителей. (-)


    private int value;

    private boolean type;
    private static final ChanceType[] VALUES = values();
    private static final int SIZE = VALUES.length;
    private static final Random RANDOM = new Random();

    ChanceType(int i, boolean type) {
        this.value = i;
        this.type = type;
    }
    public int getValue() {
        return value;
    }
    public boolean isMoney() { // TRUE - бабос FALSE - клетка
        return type;
    }
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
