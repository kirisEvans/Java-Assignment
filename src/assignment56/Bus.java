package assignment56;

public class Bus extends Vehicle{
    private final int start_Price = 0;
    private final int increment_Price = 15;
    private final int max_Price = 100;
    private int previous_time;
    private int previous_money;

    public Bus(String plateNumber) {
        super(plateNumber);
    }

    public int calculateMoney(Time leaveTime) {
        this.leaveTime = leaveTime;
        if (!isInside) {
            return 0;
        }
        int parking_time = parking_time(leaveTime);
        int money;
        parking_time += previous_time;
        isInside = false;
        if (parking_time - previous_time < 30) {
            return 0;
        }
        else if (parking_time < 60) {
            previous_time = parking_time;
            money = increment_Price;
        }
        else if (parking_time < 120) {
            previous_time = parking_time;
            money = increment_Price * (parking_time / 60 + 1);
        }
        else {
            previous_time = parking_time;
            money = Math.min(increment_Price * (parking_time / 60 + 1), max_Price);
        }
        money -= previous_money;
        previous_money += money;
        return money;
    }

    public int parking_time(Time leaveTime) {
        return (leaveTime.getHour() * 60 + leaveTime.getMinute()) -
                (arriveTime.getHour() * 60 + arriveTime.getMinute());
    }

    public void set_count(ConcreteParkingLot concreteParkingLot) {
        concreteParkingLot.setBus_count(concreteParkingLot.getBus_count()-1);
    }

    public String record_string() {
        return String.format("Bus %s %s %s", plateNumber, arriveTime, leaveTime);
    }

    public String toString() {
        return "Bus" + " " + this.plateNumber + " " + isInside;
    }
}
