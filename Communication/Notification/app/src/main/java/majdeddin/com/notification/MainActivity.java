package majdeddin.com.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String contextText = "This is the Context Text which will appear in the notification bar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void showNormalNotification(View v){

        // Build the content of the Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Content Title")
                .setContentText("This is the Context Text which will appear in the notification bar")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setTicker("will show when you run another application")
                .setAutoCancel(true);

        // Use Notification Manager to show your notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1234, notification);

    }

    public void showNormalNotificationWithIntnet(View v){

        // Build the content of the Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Content Title")
                .setContentText("This is the Context Text which will appear in the notification bar")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setTicker("will show when you run another application")
                .setAutoCancel(true);

        // Intent for Notification
        Intent intent = new Intent(this,Main2Activity.class);

        // Add back stack using TaskBuilder and set the Intent to pending Intent
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Main2Activity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);


        // Use Notification Manager to show your notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1234,notification);

    }

    public void BigTextNotification(View v){

      // Assign a style of Big Text
        NotificationCompat.BigTextStyle style = new NotificationCompat.BigTextStyle();
        style.setBigContentTitle("Big Text Example")
                .bigText(contextText);

        // Build the content of the Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_stat_name)
                .setTicker("will show when you run another application")
                .setAutoCancel(true)
                .setStyle(style);

        // Use Notification Manager to show your notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(9988, notification);
    }


    public void ShowBigPictureNotification(View v){
        // Assign Big Picture Style
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.noti_image);
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.setBigContentTitle("Big Image Title")
                .setBigContentTitle(contextText)
                .bigPicture(bitmap);


        // Build the content of the Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Big Image Notification")
                .setContentText("This is the Context Text which will appear in the notification bar")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setTicker("will show when you run another application")
                .setAutoCancel(true)
                .setStyle(bigPictureStyle);

        // Use Notification Manager to show your notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1534, notification);

    }


    public void showInboxNotification(View v){
        // Assign Inbox Style Notification
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Inbox Notification")
                .addLine("Line #1")
                .addLine("Line #2")
                .addLine("Line #3")
                .addLine("Line #4")
                .addLine("Line #5")
                .addLine("Line #6");


        // Build the content of the Notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Big Image Notification")
                .setContentText("This is the Context Text which will appear in the notification bar")
                .setSmallIcon(R.drawable.ic_stat_name)
                .setTicker("will show when you run another application")
                .setAutoCancel(true)
                .setStyle(inboxStyle);

        // Use Notification Manager to show your notification
        Notification notification = builder.build();
        NotificationManager manager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1534, notification);
    }


}
