

public class DecoratorSingleAttendance {
    private String date;
    private float minutes;

    public DecoratorSingleAttendance(String date, float minutes) {
        this.date = date;
        this.minutes = minutes;
    }

    public float getMinutes() {
        return minutes;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Decorator12SingleGrade{" +
                "Date = '" + date + '\'' +
                ", Minutes present = " + minutes +
                '}';
    }
}