package uz.hamrohtech.medical_dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.RequiresApi;

public class AboutApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        changeStatusBarColor(getResources().getColor(R.color.your_color));

//        ImageView homeActivity = findViewById(R.id.homeActivity);
//        homeActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(AboutApp.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });

        LinearLayout google_play = findViewById(R.id.google_play);
        LinearLayout instagram = findViewById(R.id.instagram);
        LinearLayout telegram = findViewById(R.id.telegram);

        instagram.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                // URLni o'zgartiring
                String url = "https://www.instagram.com/kimyoviy_atamalar/";

                // URL ochish uchun implicit Intent yaratish
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    startActivity(intent);

            }
        });
        google_play.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                // URLni o'zgartiring
                String url = "https://play.google.com/store/apps/details?id=uz.hamrohtech.kimyoviy_atamalar";

                // URL ochish uchun implicit Intent yaratish
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    startActivity(intent);

            }
        });
        telegram.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("QueryPermissionsNeeded")
            @Override
            public void onClick(View v) {
                // URLni o'zgartiring
                String url = "https://t.me/kimyoviy_atamalar";

                // URL ochish uchun implicit Intent yaratish
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                    startActivity(intent);

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changeStatusBarColor(int color) {
        Window window = getWindow();

        // Qora rangni o'chirish
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // Yangi foni rangini o'rnating
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

        // Foni rangini o'zgartirish
        window.setStatusBarColor(color);
    }
}