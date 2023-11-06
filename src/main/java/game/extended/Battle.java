package game.extended;

import game.Messages;



public class Battle {
    Wait wait = new Wait();

    Messages message = new Messages();

    public boolean run(Monster monster, ExtendedPlayer player) {

        message.monsterBattleCard(monster);
        System.out.println("\nVS\n");
        message.playerBattleCard(player);
        wait.wait(2);
        int damage;
        while (monster.getHp() > 0 && player.getPlayerClass().getCurrentHP() > 0) {
            damage = player.getPlayerClass().attack();
            monster.defend(damage);
            System.out.println("Monster HP: " + monster.getHp());
            wait.wait(1);
            if(monster.getHp() > 0) {
                damage = monster.attack();
                player.getPlayerClass().defend(damage);
                System.out.println("pPlayer HP: " + player.getPlayerClass().getCurrentHP());
                wait.wait(1);
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
