package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {

    public static  String getDateTimeFormat(){
        SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy_HH-mm-ss");
        Date now = new Date();
        return  s.format(now);
    }
}
