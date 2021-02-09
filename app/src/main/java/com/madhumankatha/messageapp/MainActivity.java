package com.madhumankatha.messageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnMsg);
        editText = findViewById(R.id.edMsg);

        btnSend.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0 , intent, 0);

            Notification notification = new Notification.Builder(this)
                    .setContentTitle(editText.getText().toString())
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pendingIntent)
                    .build();

            NotificationManager manager = (NotificationManager) MainActivity.this.getSystemService(NOTIFICATION_SERVICE);
            manager.notify(0,notification);
        });
    }
}