package com.watchthisnext.backend.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

public class AppUtils {

    public static String dateFormatter(String date, String language) {
        try {
            // EExtract date on yyyy-MM-dd format
            String newDate = date.length() > 10 ? date.substring(0, 10) : date;

            // Convert String to LocalDate
            LocalDate localDate = LocalDate.parse(newDate);

            // Define language
            Locale locale = language.equalsIgnoreCase("pt") ? new Locale("pt", "BR") : Locale.ENGLISH;

            // Format date based on user language
            if (language.equalsIgnoreCase("pt")) {
                String month = localDate.getMonth().getDisplayName(TextStyle.FULL, locale);
                return String.format("%d de %s de %d", localDate.getDayOfMonth(), month, localDate.getYear());
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", locale);
                return localDate.format(formatter);
            }
        } catch (Exception e) {
            return null; // Return null if invalid
        }
    }


    public static String getReleaseYear(String date) {
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

        return dateArray[0];
    }

    public static String voteAverageFormatter(double voteAverage) {
        Locale.setDefault(Locale.of("en", "US"));
        NumberFormat formatter = new DecimalFormat("#0.0");
        return formatter.format((Math.round((voteAverage/2) * 10.0)/ 10.0));
    }

    public static String imageLinkFormatter(String imageSrc) {
        return "https://image.tmdb.org/t/p/w500" + imageSrc;
    }

    public static String imageLinkOriginalFormatter(String imageSrc) {
        return "https://image.tmdb.org/t/p/original" + imageSrc;
    }

    public static String dinamicImageLinkFormatter(String imageSrc, String size) {
        return "https://image.tmdb.org/t/p/w" + size + imageSrc;
    }
}
