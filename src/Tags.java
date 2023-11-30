public enum Tags {
    PERFUME(2),
    CARS(4),
    CLOTHES(3),
    MEDIA(3),
    GAMES(2),
    DRINKS(3),
    AVIATION(3),
    FOOD(3),
    HOTELS(3),
    PHONES(2);

    public int getValue() {
        return value;
    }

    private int value;

    Tags(int i) {
        this.value = i;
    }

}
