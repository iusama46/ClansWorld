package co.usam.myapplication;

public abstract class Fighter extends Citizen {
     int currentHealth;
     int currentAttack;

    public Fighter() {

    }

    public String toString() {
        //return (String.format("Fighter: health=%d attacks=%d", currentHealth, currentAttack));
        return ("Fighter: health=" + currentHealth + " attacks=" + currentAttack);
    }

    protected int getCurrentHealth() {
        return currentHealth;
    }

    protected int getCurrentAttack() {
        return currentAttack;
    }

    protected int decreaseHp(int health) {
        int temp = currentHealth - health;
        if(temp<=0)
            currentHealth=0;
        else if(temp>0)
            currentHealth=temp;
        return currentHealth;
    }

    protected boolean isDead() {
        return currentHealth <= 0;
    }

    protected void gainPower() {
    }

    protected void gainPower(int power) {
        currentAttack = currentAttack + power;
    }
}
