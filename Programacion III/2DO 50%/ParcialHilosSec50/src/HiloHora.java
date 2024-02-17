import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
 public class HiloHora implements Runnable {
     private JLabel horaLabel;
     private String timeZoneId;

     public HiloHora(JLabel horaLabel, String timeZoneId) {
         this.horaLabel = horaLabel;
         this.timeZoneId = timeZoneId;
     }

     @Override
     public void run() {
         try {
             while (true) {
                 SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                 TimeZone timeZone = TimeZone.getTimeZone(timeZoneId);
                 sdf.setTimeZone(timeZone);
                 Date date = new Date();
                 horaLabel.setText(sdf.format(date) + " - " + timeZoneId);
                 Thread.sleep(1000);
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
 }