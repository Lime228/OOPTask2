public class StockCard extends Card {


    private Tags tag;
    private String name;
    private int cost;
    private int chip_one_cost;
    private int chip_two_cost;
    private int chip_three_cost;
    private int chip_four_cost;
    private int chip_star_cost;
    private int chips_count;
    StockCard(String name, Tags tag, int cost){
        this.name = name;
        this.tag = tag;
        this.cost = cost;
        chip_one_cost = (int) (this.cost *0.75);
        chip_two_cost = (int) (this.cost *1.2);
        chip_three_cost = (int) (this.cost *1.5);
        chip_four_cost = (int) (this.cost *1.8);
        chip_star_cost = (int) (this.cost *2.2);
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

    @Override
    public void action() {
        super.action();

    }

    @Override
    public void action(Player player) {

    }


}
