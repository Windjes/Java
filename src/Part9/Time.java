package Part9;

import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Time {
    String date = "";
    public void getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MMM dd HH:mm");
        date = dateFormat.format(calendar.getTime());
        System.out.println(date);
    }
}