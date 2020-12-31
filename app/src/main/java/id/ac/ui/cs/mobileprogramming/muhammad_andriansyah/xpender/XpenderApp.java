package id.ac.ui.cs.mobileprogramming.muhammad_andriansyah.xpender;

import android.app.Application;
import android.content.Context;

public class XpenderApp extends Application {
    private static Context context;

//    private final String TAG = this.getClass().getSimpleName();
//    public static final String CHANNEL_1_ID = "Channel 1";
//    public static final String REMINDER_NOTIFICATION_WORK_TAG = "notificationWork";

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        createNotificationChannel();
//        CategoriesUtils.initCategories(this);
//        PreferenceManager.setDefaultValues(this, R.xml.root_settings, false);
    }

    public static Context getContext(){
        return context;
    }

//    private void createNotificationChannel(){
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
//
//            NotificationChannel channel1 = new NotificationChannel(CHANNEL_1_ID,
//                    "Reminder Notification", NotificationManager.IMPORTANCE_HIGH);
//            channel1.setDescription("Used to remind user to enter his expenses on a pre-determined interval.");
//
//
//            NotificationManager manager = getSystemService(NotificationManager.class);
//
//            manager.createNotificationChannel(channel1);
//        }
//    }
}
