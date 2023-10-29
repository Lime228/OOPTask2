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
            case Perfume -> {
                return "Perfume";
            }
            case Cars -> {
                return "Cars";
            }
            case Clothes -> {
                return "Clothes";
            }
            case Media -> {
                return "Media";
            }
            case Games -> {
                return "Games";
            }
            case Drinks -> {
                return "Drinks";
            }
            case Aviation -> {
                return "Aviation";
            }
            case Food -> {
                return "Food";
            }
            case Hotels -> {
                return "Hotels";
            }
            case Phones -> {
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


}
