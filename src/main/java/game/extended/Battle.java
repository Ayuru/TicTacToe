package game.extended;

import game.Messages;

public class Battle {

    Messages message = new Messages();

    public boolean run(Monster monster, ExtendedPlayer player) {
        message.battleCard(monster);
        int damage;
        while (monster.getHp() > 0 && player.getPlayerClass().getCurrentHP() > 0) {
            System.out.println("monster HP " + monster.getHp());
            damage = player.getPlayerClass().attack();
            monster.defend(damage);
            System.out.println("monster HPa " + monster.getHp());
            if(monster.getHp() > 0) {
                System.out.println("player HP " + player.getPlayerClass().getCurrentHP());
                damage = monster.attack();
                player.getPlayerClass().defend(damage);
                System.out.println("player HPa " + player.getPlayerClass().getCurrentHP());
            }
        }

        if (monster.getHp() < 1) {
            player.getPlayerClass().levelUp();
            return true;
        } else {
            player.getPlayerClass().heal();
            return false;
        }
    }
}
