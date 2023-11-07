
public class ChanceCard extends Card{
    ChanceCard(){

    }
    int g_CardTypeToMoney[] = {10, 1500, 500};

    @Override
    public void action(Player player) {
        super.action();
        ChanceType type = ChanceType.getRandomType();
        if(type.isMoney()){
            player.addMoney(type.getValue());
        }else {
            player.increaseCoordinate(type.getValue());
        }

    }



}
