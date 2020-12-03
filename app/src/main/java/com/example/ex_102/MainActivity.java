package com.example.ex_102;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static android.graphics.Color.WHITE;

/**
 * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version 1.1
 * @since 1/12/2020 short description- 5 buttons with a little explanation. every button does something different.
 */
public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    AlertDialog.Builder adb;
    final String[]colors={"red","green","blue"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adb = new AlertDialog.Builder(this);
        layout = findViewById(R.id.layout);
    }

    /**
     * description-
     * @param view the view
     */
    public void oneColor(View view) {

        int[]color= {0,0,0};

        adb = new AlertDialog.Builder(this);
        adb.setTitle("Choose one color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                color[which]=255;
                layout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * description-
     * @param view the view
     */
    public void multyC(View view) {

        int[]color={0,0,0};
        adb = new AlertDialog.Builder(this);
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Choose any color you want");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                if(isChecked) color[which]=255;
                else if(color[which]==255) color[which]=0;
                layout.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });

        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * description- Displays one button with icon.
     * @param view the view
     */
    public void defultW(View view) {
        layout.setBackgroundColor(WHITE);
    }

    /**
     * description-
     * @param view the view
     */
    public void inputD(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("input");
        final EditText eT= new EditText(this);
        eT.setHint("Type your text here");
        adb.setView(eT);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str= eT.getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Credits");
        return true;
    }

    /**
     * description- if "credits" selected: goes to the credits activity.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        adb = new AlertDialog.Builder(this);
        String st = item.getTitle().toString();

        if (st.endsWith("Credits")) {
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }
}









