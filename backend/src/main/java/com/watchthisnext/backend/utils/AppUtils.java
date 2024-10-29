package com.watchthisnext.backend.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class AppUtils {
    public static String dateFormatter(String date, String language) {
        String[] dateArray;
        String newDate;

        try {
            if (date.length() > 10) {
                newDate = date.substring(0, 10);
            } else {
                newDate = date;
            }

            dateArray = newDate.split("-");
        } catch (Exception e) {
            return null;
        }

        if (language.equalsIgnoreCase("pt")) {
            newDate = switch (dateArray[1]) {
                case "01" -> String.join(" ", dateArray[2], "de janeiro de", dateArray[0]);
                case "02" -> String.join(" ", dateArray[2], "de fevereiro de", dateArray[0]);
                case "03" -> String.join(" ", dateArray[2], "de março de", dateArray[0]);
                case "04" -> String.join(" ", dateArray[2], "de abril de", dateArray[0]);
                case "05" -> String.join(" ", dateArray[2], "de maio de", dateArray[0]);
                case "06" -> String.join(" ", dateArray[2], "de junho de", dateArray[0]);
                case "07" -> String.join(" ", dateArray[2], "de julho de", dateArray[0]);
                case "08" -> String.join(" ", dateArray[2], "de agosto de", dateArray[0]);
                case "09" -> String.join(" ", dateArray[2], "de setembro de", dateArray[0]);
                case "10" -> String.join(" ", dateArray[2], "de outubro de", dateArray[0]);
                case "11" -> String.join(" ", dateArray[2], "de novembro de", dateArray[0]);
                case "12" -> String.join(" ", dateArray[2], "de dezembro de", dateArray[0]);
                default -> String.join("/", dateArray[2], dateArray[1], dateArray[0]);
            };
        } else {
            newDate = switch (dateArray[1]) {
                case "01" -> String.join(" ", "January", dateArray[2] + ",", dateArray[0]);
                case "02" -> String.join(" ", "February", dateArray[2] + ",", dateArray[0]);
                case "03" -> String.join(" ", "March", dateArray[2] + ",", dateArray[0]);
                case "04" -> String.join(" ", "April", dateArray[2] + ",", dateArray[0]);
                case "05" -> String.join(" ", "May", dateArray[2] + ",", dateArray[0]);
                case "06" -> String.join(" ", "June", dateArray[2] + ",", dateArray[0]);
                case "07" -> String.join(" ", "July", dateArray[2] + ",", dateArray[0]);
                case "08" -> String.join(" ", "August", dateArray[2] + ",", dateArray[0]);
                case "09" -> String.join(" ", "September", dateArray[2] + ",", dateArray[0]);
                case "10" -> String.join(" ", "October", dateArray[2] + ",", dateArray[0]);
                case "11" -> String.join(" ", "November", dateArray[2] + ",", dateArray[0]);
                case "12" -> String.join(" ", "December", dateArray[2] + ",", dateArray[0]);
                default -> String.join("/", dateArray[1], dateArray[2], dateArray[0]);
            };
        }
        return newDate;
    }

    public static String voteAverageFormatter(double voteAverage) {
        Locale.setDefault(Locale.of("en", "US"));
        NumberFormat formatter = new DecimalFormat("#0.0");
        return formatter.format((Math.round((voteAverage/2) * 10.0)/ 10.0));
    }

    public static String imageLinkFormatter(String imageSrc) {
        return "https://image.tmdb.org/t/p/original" + imageSrc;
    }
}
