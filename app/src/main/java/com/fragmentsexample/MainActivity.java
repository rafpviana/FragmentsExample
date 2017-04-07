package com.fragmentsexample;



import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

    private int showFragment = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.framelayoutid_fragment_container, new Screen1Fragment()).commit();

        Button buttonChangeFragment = (Button) findViewById(R.id.buttonid_change_fragment);
        buttonChangeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                if(showFragment == 1){
                    Screen2Fragment screen2Fragment = new Screen2Fragment();
                    fragmentTransaction.replace(R.id.framelayoutid_fragment_container, screen2Fragment);
                    showFragment = 2;
                }
                else{
                    Screen1Fragment screen1Fragment = new Screen1Fragment();
                    fragmentTransaction.replace(R.id.framelayoutid_fragment_container, screen1Fragment);
                    showFragment = 1;
                }

                fragmentTransaction.commit();

            }
        });

    }
}
