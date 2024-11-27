package com.example.reboot;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout main;
    Dialog firstDialog, secondDialog, thirdDialog;
    NotificationHelper notificationHelper = new NotificationHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstDialog = new Dialog(MainActivity.this);
        secondDialog = new Dialog(MainActivity.this);
        thirdDialog = new Dialog(MainActivity.this);

        main = findViewById(R.id.main);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fDialog();
            }
        });

    }

    public void fDialog(){
        firstDialog.setContentView(R.layout.first_wnd);
        firstDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        firstDialog.show();

        ConstraintLayout noF = firstDialog.findViewById(R.id.noF);
        ConstraintLayout yesF = firstDialog.findViewById(R.id.yesF);

        noF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstDialog.cancel();
            }
        });

        yesF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sDialog();
            }
        });
    }

    public void sDialog(){
        secondDialog.setContentView(R.layout.second_wind);
        secondDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        secondDialog.show();

        ConstraintLayout noS = secondDialog.findViewById(R.id.noS);
        ConstraintLayout yesS = secondDialog.findViewById(R.id.yesS);

        noS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondDialog.cancel();
                firstDialog.cancel();
            }
        });

        yesS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tDialog();
            }
        });
    }

    public void tDialog(){
        thirdDialog.setContentView(R.layout.third_wind);
        thirdDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        thirdDialog.show();

        ConstraintLayout noS = thirdDialog.findViewById(R.id.noT);
        ConstraintLayout yesS = thirdDialog.findViewById(R.id.yesT);

        noS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdDialog.cancel();
                secondDialog.cancel();
                firstDialog.cancel();
            }
        });

        yesS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdDialog.cancel();
                secondDialog.cancel();
                firstDialog.cancel();
                TextView text = findViewById(R.id.TextView1);
                text.setText("3... 2... 1...");
                Toast.makeText(MainActivity.this, "Ну ты и долбаёб...", Toast.LENGTH_SHORT).show();
                notificationHelper.sendNotification("Ну ты и долбаёб...", "Ну ты и долбаёб...");
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}