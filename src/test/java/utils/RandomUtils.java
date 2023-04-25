package utils;

import java.util.Objects;
import java.util.Random;
import static utils.TestData.*;

public class RandomUtils {
    public static int getRandomIndex(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }

    public static String getRandomValue(String[] arrayList) {
        int index = getRandomIndex(arrayList.length);
        return arrayList[index];
    }

    public static String getRandomCity(String state) {
        String[] citiesList = new String[0];
        if(Objects.equals(state, "NCR"))
            citiesList = ncrCityList;
        if(Objects.equals(state, "Uttar Pradesh"))
            citiesList = uttarpradeshCityList;
        if(Objects.equals(state, "Haryana"))
            citiesList = haryanaCityList;
        if(Objects.equals(state, "Rajasthan"))
            citiesList = rajasthanCityList;
        int index = getRandomIndex(citiesList.length);
        return citiesList[index];
    }
}
