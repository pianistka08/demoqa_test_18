package utils;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DataUtils {

    public static String getDate() {
       Faker faker = new Faker(new Locale("en"));
        String pattern = "dd-MMMM-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, Locale.ENGLISH);
        String date = simpleDateFormat.format(faker.date().birthday());
        String[] subStr;
        String delimeter = "-";
        subStr = date.split(delimeter);

        String day = subStr[0],
                month = subStr[1],
                year = subStr[2];

        return (day + " " + month + "," + year);
    }
}
