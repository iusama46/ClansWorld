package co.usam.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static void randomAttack(World w) {
        int n = w.getNumClans();
        int clan1 = (int) (n * Math.random());
        int clan2 = (int) (n * Math.random());
        if (clan1 == clan2)
            clan2 = (clan2 + 1 + (int) ((n - 1) * Math.random())) % n;
        w.attack(clan1, clan2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        World w = new World();
        w.addClan(new Clan("Settlers", 6));
        w.addClan(new Clan("Raiders", 5));
        w.addClan(new Clan("Hordes", 7));
        //Log.d("clima",w.toString());

        while (w.getNumClans() > 1) {
            randomAttack(w);
            // Log.d("clima2",w.toString());

        }
        Log.d("clima", "over");


    }
}