package sg.edu.rp.c346.demonotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int requestCode = 123;
    int notificationID = 888;
    Button btnNotify1, btnNotify2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotify1 = findViewById(R.id.btnNotify1);

        btnNotify2 = findViewById(R.id.btnNotify2);

        btnNotify1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity
                        ( MainActivity.this, requestCode, intent,
                                PendingIntent.FLAG_CANCEL_CURRENT);

                // Build notification
                NotificationCompat.Builder builder = new
                        NotificationCompat.Builder(MainActivity.this, "default");
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pendingIntent);
                builder.setAutoCancel(true);

//                Uri uri= RingtoneManager.getDefaultUri
//                        (RingtoneManager.TYPE_NOTIFICATION);
//                builder.setSound(uri);
//
//                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();

                // An integer good to have, for you to programmatically cancel it
                notificationManager.notify(notificationID, n);
                finish();
            }
        });

        btnNotify2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new
                            NotificationChannel("default", "Default Channel",
                            NotificationManager.IMPORTANCE_DEFAULT);

                    channel.setDescription("This is for default notification");
                    notificationManager.createNotificationChannel(channel);
                }

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity
                        (MainActivity.this, requestCode,
                                intent, PendingIntent.FLAG_CANCEL_CURRENT);

                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.setBigContentTitle("Big Text – Long Content");
                String msg ="This is one big text" + " - A quick brown fox jumps over a lazy brown dog " + "\n Lorem ipsum dolor sit amet, sea eu quod des";
                bigText.setSummaryText("Reflection Journal?");

                // Build notification
                Notification.Builder builder = new Notification.Builder(MainActivity.this, "default");
                builder.setContentTitle("Big Text – Long Content");
                builder.setContentText("Subject");
                builder.setSmallIcon(android.R.drawable.btn_star_big_off);
                builder.setContentIntent(pendingIntent);
                builder.setStyle(new Notification.BigTextStyle().bigText(msg));
                builder.setAutoCancel(true);

                Notification n = builder.build();

                // This replaces the existing notification with the same ID
                notificationManager.notify(notificationID, n);
                finish();


                // Case 1
//                NotificationCompat.InboxStyle iStyle =  new NotificationCompat.InboxStyle();
//                iStyle.addLine("Mobile 50% off");
//                iStyle.addLine("Laptop 20% off");
//                iStyle.addLine("Tablet 20% off");
//                iStyle.addLine("Printer 30% off");
//                iStyle.addLine("Others 10% off");
//
                // Build notification
//                NotificationCompat.Builder builder =  new NotificationCompat.Builder(MainActivity.this, "default");
//                        builder.setContentTitle("Deals from top electronics retailers");
//                         builder.setContentText("Excellent deals");
//                          builder.setSmallIcon(android.R.drawable.btn_star_big_off);
//                        builder.setStyle(iStyle);
//                // Set the intent to fire when the user taps on notification.
//                Intent resultIntent = new Intent(MainActivity.this, MainActivity.class);
//                builder.setContentIntent(pendingIntent);
//                builder.setAutoCancel(true);
//                // Sets an ID for the notification
//                int notificationID = 001;
//                // It will display the notification in notification bar
////                notificationManager.notify(mNotificationId, builder.build());
//
//                Notification n = builder.build();
//
//                // This replaces the existing notification with the same ID
//                notificationManager.notify(notificationID, n);
//                finish();
            }
        });
    }
}
