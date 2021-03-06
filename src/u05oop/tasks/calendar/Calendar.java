package u05oop.tasks.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Calendar {
    private int year;
    private ArrayList<Holiday> holidays;

    public Calendar(int year) {
        this.year = year;
        this.holidays = new ArrayList<>();
        addWeekend(year);
    }

    private void addWeekend(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        while (date.getDayOfWeek() != DayOfWeek.SATURDAY
                && date.getDayOfWeek() != DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }
        while (date.getYear() == year) {
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                holidays.add(new Holiday(date, "Суббота"));
                date = date.plusDays(1);
            } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                holidays.add(new Holiday(date, "Воскресенье"));
                date = date.plusDays(6);
            } else {
                date = date.plusDays(1);
            }
        }
    }

    public void addHoliday(LocalDate holidayDate, String nameOfHoliday) {
        holidays.add(new Holiday(holidayDate, nameOfHoliday));
        holidays.sort(Comparator.comparing(Holiday::getHolidayDate).thenComparing(Holiday::getNameOfHoliday));
    }

    public Holiday removeHoliday(String nameOfHoliday) {
        Holiday removedHoliday = null;
        Iterator<Holiday> holidayIterator = holidays.iterator();
        while (holidayIterator.hasNext()) {
            Holiday nextHoliday = holidayIterator.next();
            if (nextHoliday.getNameOfHoliday().equals(nameOfHoliday)) {
                removedHoliday = nextHoliday;
                holidayIterator.remove();
            }
        }
        return removedHoliday;
    }

    public void printHolidays() {
        for (Holiday holiday : holidays) {
            System.out.println(holiday);
        }
    }

    public class Holiday {
        private LocalDate holidayDate;
        private String nameOfHoliday;

        public Holiday(LocalDate holiday, String nameOfHoliday) {
            this.holidayDate = holiday;
            this.nameOfHoliday = nameOfHoliday;
        }

        public LocalDate getHolidayDate() {
            return holidayDate;
        }

        public String getNameOfHoliday() {
            return nameOfHoliday;
        }

        @Override
        public String toString() {
            String holiday = "";
            if (nameOfHoliday == "Суббота" || nameOfHoliday == "Воскресенье")
                holiday = holidayDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - Выходной - " +
                        nameOfHoliday;
            else
                holiday = holidayDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " - Праздник - " +
                        nameOfHoliday;

            return holiday;
        }
    }
}
