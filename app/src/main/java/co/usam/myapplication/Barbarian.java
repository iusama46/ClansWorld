package co.usam.myapplication;

public class Barbarian extends Fighter {

    public Barbarian() {
        currentAttack = 20;
        currentHealth = 200;
    }

    @Override
    public void gainPower() {
        super.gainPower();
        currentAttack = currentAttack + 15;
    }

    @Override
    public String toString() {
        return super.toString() + " (Barbarian)";
    }
}
