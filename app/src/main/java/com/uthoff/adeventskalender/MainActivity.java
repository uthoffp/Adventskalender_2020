package com.uthoff.adeventskalender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_STABLE;

public class MainActivity extends AppCompatActivity {
    ArrayList<AlertTexts> alertTexts = new ArrayList<>();
    private Button btn00, btn01, btn02, btn03, btn04, btn05,
            btn06, btn07, btn08, btn09, btn10, btn11,
            btn12, btn13, btn14, btn15, btn16, btn17,
            btn18, btn19, btn20, btn21, btn22, btn23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(
                SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
        setContentView(R.layout.activity_main);
        initButtons();
        setButtonNumbers();
        setAlertTexts();

        btn01.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (validDay(25)) {
                    Intent intent = new Intent(getApplicationContext(), PresentActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });
    }

    public void onBtnClick(View view) {
        Button pressdBtn = (Button) view;
        int index = Integer.parseInt(pressdBtn.getText().toString());

        if (validDay(index)) {
            Intent intent = new Intent(this, DoorActivity.class);
            intent.putExtra("door_index", index);
            startActivity(intent);
        } else {
            Random rnd = new Random();
            int text_index = rnd.nextInt(alertTexts.size());
            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            alertDialog.setMessage(alertTexts.get(text_index).getText());
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, alertTexts.get(text_index).getButton(),
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    // Prevent dialog close on back press button
                    return keyCode == KeyEvent.KEYCODE_BACK;
                }
            });
            alertDialog.show();
        }

    }

    public boolean validDay(int index) {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        return (index <= day && month == 11) || year == 2020;
    }

    public void setAlertTexts() {
        alertTexts.add(new AlertTexts("Sind wir mal wieder zu neugierig?", "Ja :("));
        alertTexts.add(new AlertTexts("Für dieses Türchen musst du dich noch etwas gedulden", "Ich werde mich besser im Griff haben"));
        alertTexts.add(new AlertTexts("Ich sehe alles!", "Tut mir leid großer Meister"));
        alertTexts.add(new AlertTexts("Schon wieder?? Wirklich?", "Ich kann nicht anders"));
        alertTexts.add(new AlertTexts("Wirf mal einen Blick in den Kalender", "Ich kann nicht lesen"));
        alertTexts.add(new AlertTexts("Bevor du dieses Türchen vorzeitig öffnen kannst hat ein Monat 40 Tage :D", "Ok :("));
    }

    private void initButtons() {
        View view = getWindow().getDecorView().getRootView();

        btn00 = view.findViewById(R.id.main_btn_00);
        btn01 = view.findViewById(R.id.main_btn_01);
        btn02 = view.findViewById(R.id.main_btn_02);
        btn03 = view.findViewById(R.id.main_btn_03);
        btn04 = view.findViewById(R.id.main_btn_04);
        btn05 = view.findViewById(R.id.main_btn_05);
        btn06 = view.findViewById(R.id.main_btn_06);
        btn07 = view.findViewById(R.id.main_btn_07);
        btn08 = view.findViewById(R.id.main_btn_08);
        btn09 = view.findViewById(R.id.main_btn_09);
        btn10 = view.findViewById(R.id.main_btn_10);
        btn11 = view.findViewById(R.id.main_btn_11);
        btn12 = view.findViewById(R.id.main_btn_12);
        btn13 = view.findViewById(R.id.main_btn_13);
        btn14 = view.findViewById(R.id.main_btn_14);
        btn15 = view.findViewById(R.id.main_btn_15);
        btn16 = view.findViewById(R.id.main_btn_16);
        btn17 = view.findViewById(R.id.main_btn_17);
        btn18 = view.findViewById(R.id.main_btn_18);
        btn19 = view.findViewById(R.id.main_btn_19);
        btn20 = view.findViewById(R.id.main_btn_20);
        btn21 = view.findViewById(R.id.main_btn_21);
        btn22 = view.findViewById(R.id.main_btn_22);
        btn23 = view.findViewById(R.id.main_btn_23);
    }

    private void setButtonNumbers() {
        Random rnd = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int[] rnd_nr = new int[24];
        for (int i = 1; i < 25; i++) {
            numbers.add(i);
        }

        for (int i = 0; !numbers.isEmpty(); i++) {
            int index = rnd.nextInt(numbers.size());
            rnd_nr[i] = numbers.get(index);
            numbers.remove(index);
        }

        btn00.setText(Integer.toString(rnd_nr[0]));
        btn01.setText(Integer.toString(rnd_nr[1]));
        btn02.setText(Integer.toString(rnd_nr[2]));
        btn03.setText(Integer.toString(rnd_nr[3]));
        btn04.setText(Integer.toString(rnd_nr[4]));
        btn05.setText(Integer.toString(rnd_nr[5]));
        btn06.setText(Integer.toString(rnd_nr[6]));
        btn07.setText(Integer.toString(rnd_nr[7]));
        btn08.setText(Integer.toString(rnd_nr[8]));
        btn09.setText(Integer.toString(rnd_nr[9]));
        btn10.setText(Integer.toString(rnd_nr[10]));
        btn11.setText(Integer.toString(rnd_nr[11]));
        btn12.setText(Integer.toString(rnd_nr[12]));
        btn13.setText(Integer.toString(rnd_nr[13]));
        btn14.setText(Integer.toString(rnd_nr[14]));
        btn15.setText(Integer.toString(rnd_nr[15]));
        btn16.setText(Integer.toString(rnd_nr[16]));
        btn17.setText(Integer.toString(rnd_nr[17]));
        btn18.setText(Integer.toString(rnd_nr[18]));
        btn19.setText(Integer.toString(rnd_nr[19]));
        btn20.setText(Integer.toString(rnd_nr[20]));
        btn21.setText(Integer.toString(rnd_nr[21]));
        btn22.setText(Integer.toString(rnd_nr[22]));
        btn23.setText(Integer.toString(rnd_nr[23]));
    }
}