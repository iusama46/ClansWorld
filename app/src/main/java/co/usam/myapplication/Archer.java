package co.usam.myapplication;

public class Archer extends Fighter {

    public Archer() {
        super();
        currentAttack = 15;
        currentHealth = 100;
    }

    @Override
    public String toString() {
        return super.toString() + " (Archer)";
    }


    @Override
    public void gainPower() {
        super.gainPower();
        currentAttack = currentAttack + 10;
    }
}
