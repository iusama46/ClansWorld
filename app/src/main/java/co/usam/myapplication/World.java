package co.usam.myapplication;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class World {

    List<Clan> clanList;

    public World() {
        clanList = new ArrayList<>();
    }

    public void addClan(Clan c) {
        clanList.add(c);
    }

    public int getNumClans() {
        return clanList.size();
    }

    void attack(int clan1, int clan2) {
        //System.out.println("Clan " + clanList.get(clan1).getClanName() + " attacks " + clanList.get(clan2).getClanName());
        clanList.get(clan1).attack(clanList.get(clan2));
        if (clanList.get(clan1).isDead()) {
            String txt = "Clan " + clanList.get(clan1).getClanName() + " is wiped out!!";
          //  System.out.println(txt);
            clanList.remove(clan1);
        }
        if (clanList.get(clan2).isDead()) {
            String txt = "Clan " + clanList.get(clan2).getClanName() + " is wiped out!!";
            //Log.d("climaar", txt);
            clanList.remove(clan2);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("There are ").append(getNumClans()).append(" clans in the world.").append("\n");
        for (Clan c : clanList) {
            str.append("-----").append("\n");
            str.append(c.toString());
        }
        return str.toString();
    }
}
