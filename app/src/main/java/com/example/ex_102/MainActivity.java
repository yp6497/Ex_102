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
 * The type Main activity.
 *
 * @author Yulia Piavka <yp6497@bs.amalnet.k12.il>
 * @version 1.1
 * @since 13 /11/2020 short description- 5 buttons with a little explanation. every button does something different.
 */
public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    AlertDialog.Builder adb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adb = new AlertDialog.Builder(this);
        layout = findViewById(R.id.layout);
    }

    /**
     * description- Displays message only.
     * @param view the view
     */
    public void onlyMes(View view) {

        //adb = new AlertDialog.Builder(this);
        adb.setTitle("only text");
        adb.setMessage("This is a simple alert");

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * description- Displays message with icon.
     * @param view the view
     */
    public void noBwI(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setTitle("text with icon");
        adb.setMessage("This is a simple alert with icon");
        //adb.setIcon(R.drawable.androidlogo);

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * description- Displays one button with icon.
     * @param view the view
     */
    public void oneB(View view) {

        //adb = new AlertDialog.Builder(this);
        adb.setTitle("one button");
        adb.setMessage("This is a one button alert");
        //adb.setIcon(R.drawable.androidlogo);
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * description- Displays two buttons.
     * @param view the view
     */
    public void inputD(View view) {

        //adb = new AlertDialog.Builder(this);
        adb.setTitle("two buttons");
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

        String st = item.getTitle().toString();

        if (st.endsWith("Credits")) {
            Intent si = new Intent(this, creditsActivity.class);
            startActivity(si);
        }
        return true;
    }
}







