package game.extended;

import game.Player;


public class ExtendedPlayer extends Player {

    private PlayerClass playerClass;

    public ExtendedPlayer(String name, String mark) {
        super(name, mark);
    }

    public void addClass(String code){
        if (code.equals("1")) {
            playerClass = new Mage();
        } else {
            playerClass = new Fighter();
        }

    }

    public PlayerClass getPlayerClass() {
        return playerClass;
    }
}
