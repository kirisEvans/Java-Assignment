package assignment5;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void addMinutes(int minutes) {
        minutes += this.minute;
        this.hour += minutes / 60;
        this.minute = minutes % 60;
    }

    @Override
    public String toString() {
        if (hour >= 10) {
            if (minute >= 10) {
                return hour + ":" + minute;
            }
            else {
                return hour + ":" + "0" + minute;
            }
        }
        else {
            if (minute >= 10) {
                return "0" + hour + ":" + minute;
            }
            else {
                return "0" + hour + ":" + "0" + minute;
            }
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }
}
