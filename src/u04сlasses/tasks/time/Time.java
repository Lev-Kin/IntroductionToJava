package u04сlasses.tasks.time;

public class Time {

    private int hour;
    private int minute;
    private int second;

    public Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public Time(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public void setHour(int hour) {
        if (hour > 23 || hour < 0) {
            this.hour = 0;
            System.out.println("Введено недопустимое значение! Значение часов установлено 0");
        } else {
            this.hour = hour;
        }
    }

    public void setMinute(int minute) {
        if (minute > 59 || minute < 0) {
            this.minute = 0;
            System.out.println("Введено недопустимое значение! Значение минут установлено 0");
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second > 59 || second < 0) {
            this.second = 0;
            System.out.println("Введено недопустимое значение! Значение секунд установлено 0");
        } else {
            this.second = second;
        }
    }

    public String getTime() {

        String h = "";
        String m = "";
        String s = "";

        if (hour < 10)
            h = "0" + String.format("%d", hour);
        else
            h = String.format("%d", hour);

        if (minute < 10)
            m = "0" + String.format("%d", minute);
        else
            m = String.format("%d", minute);

        if (second < 10)
            s = "0" + String.format("%d", second);
        else
            s = String.format("%d", second);

        return h + ":" + m + ":" + s;
    }

    public void changeHour(int hour) {
        this.hour = (this.hour + hour) % 24;
        if (this.hour < 0) {
            this.hour += 24;
        }
    }

    public void changeMinute(int minute) {
        if ((this.minute + minute) < 0) {
            changeHour(minute / 60 - 1);
            this.minute = 60 + ((this.minute + minute) % 60);
        } else {
            changeHour((this.minute + minute) / 60);
            this.minute = (this.minute + minute) % 60;
        }
    }

    public void changeSecond(int second) {
        if ((this.second + second) < 0) {
            changeMinute(second / 60 - 1);
            this.second = 60 + ((this.second + second) % 60);
        } else {
            changeMinute((this.second + second) / 60);
            this.second = (this.second + second) % 60;
        }
    }
}