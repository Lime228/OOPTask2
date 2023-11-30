
public class ChanceCard extends Card {
    ChanceCard() {

    }

    @Override
    public void action(Player player) {
        super.action();
        ChanceType type = ChanceType.getRandomType();
        if (type.isMoney()) {
            player.addMoney(type.getValue());
        } else {
            player.setCoordinate(type.getValue());
        }
        print(type);
    }

    private void print(ChanceType type) {
        System.out.println(type.getDescription());
    }
}
