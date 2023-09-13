import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        printBonusDatesBetween(2010, 2015);
    }

    private static void printBonusDatesBetween(int fromYear, int toYear) {
        if (fromYear > 999 && toYear <= 9290) {
            LocalDate start = LocalDate.of(fromYear, 1, 1);
            LocalDate end = LocalDate.of(toYear - 1, 12, 31);
            LocalDate next = start.minusDays(1);

            while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
                if (next.getDayOfMonth() != 10 && next.getDayOfMonth() != 20 && next.getDayOfMonth() != 30) {

                    printIfPalindrome(next.getYear(), next.getMonthValue(), next.getDayOfMonth());
                }

            }

        }

    }

    private static void printIfPalindrome(int year, int month, int day) {

        String monthString = String.valueOf(month);
        String dayString = String.valueOf(day);
        if (getOriginalDateInt(year, month, day) == getReversedDateInt(year, month, day)) {

            if (month < 10) {
                monthString = "0" + monthString;
            }
            if (day < 10) {
                dayString = "0" + dayString;
            }

            System.out.println(year + "-" + monthString + "-" + dayString);

        }
    }

    private static int getReversedDateInt(int year, int month, int day) {

        int dayReversed = day * 10;
        if (day > 10) {
            dayReversed = (day % 10 * 10) + day / 10;
        }

        int monthReversed = 1;
        if (month <= 9) {
            monthReversed = month * 10;
        } else if (month > 10) {
            monthReversed = (month % 10 * 10) + month / 10;
        }

        return (dayReversed * 1000000) + (monthReversed * 10000) + getReversedYear(year);

    }


    private static int getReversedYear(int year) {

        int firstDigit = year / 1000;
        int secondDigit = (year - (firstDigit * 1000)) / 100;
        int thirdDigit = (year - (firstDigit * 1000) - (secondDigit * 100)) / 10;
        int fourthDigit = (year - (firstDigit * 1000) - (secondDigit * 100) - thirdDigit * 10);

        return (fourthDigit * 1000) + (thirdDigit * 100) + (secondDigit * 10) + firstDigit;

    }

    private static int getOriginalDateInt(int year, int month, int day) {

        return (year * 10000) + (month * 100) + day;

    }
}

