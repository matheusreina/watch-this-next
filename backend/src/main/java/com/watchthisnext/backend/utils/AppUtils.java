package com.watchthisnext.backend.utils;

import java.util.ArrayList;
import java.util.List;

public class AppUtils {
    public static String dateFormatter(String date, String language) {
        String[] dateArray;
        String newDate;

        if (date.length() > 10) {
            newDate = date.substring(0,10);
        } else {
            newDate = date;
        }
        dateArray = newDate.split("-");

        if (language.equalsIgnoreCase("pt")) {
            switch (dateArray[1]) {
                case "01":
                    newDate = String.join(" ", dateArray[2], "de janeiro de", dateArray[0]);
                    break;
                case "02":
                    newDate = String.join(" ", dateArray[2], "de fevereiro de", dateArray[0]);
                    break;
                case "03":
                    newDate = String.join(" ", dateArray[2], "de março de", dateArray[0]);
                    break;
                case "04":
                    newDate = String.join(" ", dateArray[2], "de abril de", dateArray[0]);
                    break;
                case "05":
                    newDate = String.join(" ", dateArray[2], "de maio de", dateArray[0]);
                    break;
                case "06":
                    newDate = String.join(" ", dateArray[2], "de junho de", dateArray[0]);
                    break;
                case "07":
                    newDate = String.join(" ", dateArray[2], "de julho de", dateArray[0]);
                    break;
                case "08":
                    newDate = String.join(" ", dateArray[2], "de agosto de", dateArray[0]);
                    break;
                case "09":
                    newDate = String.join(" ", dateArray[2], "de setembro de", dateArray[0]);
                    break;
                case "10":
                    newDate = String.join(" ", dateArray[2], "de outubro de", dateArray[0]);
                    break;
                case "11":
                    newDate = String.join(" ", dateArray[2], "de novembro de", dateArray[0]);
                    break;
                case "12":
                    newDate = String.join(" ", dateArray[2], "de dezembro de", dateArray[0]);
                    break;
            }
        } else {

            switch (dateArray[1]) {
                // January 20, 2008
                // January, February, March, April, May, June, July, August, September, October, November, December
                case "01":
                    dateArray[1] = "de janeiro de";
                    break;
                case "02":
                    dateArray[1] = "de fevereiro de";
                    break;
                case "03":
                    dateArray[1] = "de março de";
                    break;
                case "04":
                    dateArray[1] = "de abril de";
                    break;
                case "05":
                    dateArray[1] = "de maio de";
                    break;
                case "06":
                    dateArray[1] = "de junho de";
                    break;
                case "07":
                    dateArray[1] = "de julho de";
                    break;
                case "08":
                    dateArray[1] = "de agosto de";
                    break;
                case "09":
                    dateArray[1] = "de setembro de";
                    break;
                case "10":
                    dateArray[1] = "de outubro de";
                    break;
                case "11":
                    dateArray[1] = "de novembro de";
                    break;
                case "12":
                    dateArray[1] = "de dezembro de";
                    break;
            }

        }

        return newDate;
    }
}
