package co.usam.myapplication;

public abstract class Citizen {

    public static Citizen randomCitizen() {

        Citizen[] citizenList = {new Civilian(), new Archer(), new Barbarian()};

        final Citizen citizen = citizenList[(int) (Math.random() * citizenList.length)];
        return citizen;
    }

    public String toString() {
        return "Citizen";
    }
}
