package co.usam.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Clan {
    String clanName;
    int clanSize;
    List<Citizen> citizenList;

    public Clan(String clanName, int clanSize) {
        citizenList = new ArrayList<>();
        this.clanName = clanName;
        this.clanSize = clanSize;

        boolean isFighter = true;
        for (int i = 0; i < clanSize; i++) {
            if (i == 0) {
                while (isFighter) {
                    Citizen obj = Civilian.randomCitizen();
                    String objTxt = obj.getClass().getSimpleName().toLowerCase();
                    String archerTxt = Archer.class.getSimpleName().toLowerCase();
                    String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

                    if (objTxt.equals(archerTxt) || objTxt.equals(barbarianTxt)) {
                        citizenList.add(obj);
                        isFighter = false;
                    } else {
                        isFighter = true;
                    }
                }
            } else if (i > 0) {
                citizenList.add(Civilian.randomCitizen());
            }
        }
    }

    public String getClanName() {
        return clanName;
    }

    private int totalAttackPower() {
        int totalPower = 0;
        for (Citizen obj : citizenList) {
            String objTxt = obj.getClass().getSimpleName().toLowerCase();
            String archerTxt = Archer.class.getSimpleName().toLowerCase();
            String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

            if (objTxt.equals(archerTxt) || objTxt.equals(barbarianTxt)) {
                Fighter fighter = (Fighter) obj;
                if (!((Fighter) obj).isDead()) {
                    totalPower = totalPower + fighter.getCurrentAttack();
                }
            }
        }
        return totalPower;
    }


    public boolean isDead() {
        return numFightersAlive() <= 0;
    }

    void gainPower() {
        for (Citizen obj : citizenList) {
            String objTxt = obj.getClass().getSimpleName().toLowerCase();
            String archerTxt = Archer.class.getSimpleName().toLowerCase();
            String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

            if (objTxt.equals(archerTxt)) {
                ((Archer) obj).gainPower();
            }
            if (objTxt.equals(barbarianTxt)) {
                ((Barbarian) obj).gainPower();
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Clan ").append(clanName).append(":").append("\n");
        str.append("Total attack power: ").append(String.valueOf(totalAttackPower())).append("\n");

        for (Citizen obj : citizenList) {
            str.append(obj.toString()).append("\n");
        }
        return str.toString();
    }

    private int numFightersAlive() {
        int noOfAliveFighters = 0;
        for (Citizen obj : citizenList) {
            String objTxt = obj.getClass().getSimpleName().toLowerCase();
            String archerTxt = Archer.class.getSimpleName().toLowerCase();
            String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

            if (objTxt.equals(archerTxt) || objTxt.equals(barbarianTxt)) {
                Fighter fighter = (Fighter) obj;
                if (!fighter.isDead())
                    noOfAliveFighters++;
            }
        }
        return noOfAliveFighters;
    }
    public void attack( Clan other) {
        int max = totalAttackPower()/other.numFightersAlive();
        int min =0;
        for (Citizen obj : other.citizenList) {
            String objTxt = obj.getClass().getSimpleName().toLowerCase();
            String archerTxt = Archer.class.getSimpleName().toLowerCase();
            String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

            if (objTxt.equals(archerTxt) || objTxt.equals(barbarianTxt)) {
                Fighter fighter = (Fighter) obj;
                if (!fighter.isDead()) {
                    int health = (int)(Math.random()*(max-min)+min);
                    fighter.decreaseHp(health);
                    citizenList.remove(obj);
                }
            }
        }

    }

    /*public void attack(Clan one, Clan other) {
       int max = one.totalAttackPower()/other.numFightersAlive();
        int min =0;
        for (Citizen obj : other.citizenList) {
            String objTxt = obj.getClass().getSimpleName().toLowerCase();
            String archerTxt = Archer.class.getSimpleName().toLowerCase();
            String barbarianTxt = Barbarian.class.getSimpleName().toLowerCase();

            if (objTxt.equals(archerTxt) || objTxt.equals(barbarianTxt)) {
                Fighter fighter = (Fighter) obj;
                if (!fighter.isDead()) {
                    int health = (int)(Math.random()*(max-min+1)+min);
                    fighter.decreaseHp(health);
                }
            }
        }
    }*/
}
