package assignment56;

public class Car extends Vehicle{
    private final int start_Price = 15;
    private final int increment_Price = 5;
    private final int max_Price = 60;
    private int previous_time;
    private int previous_money;


    public Car(String plateNumber) {
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
            money = start_Price;
        }
        else if (parking_time < 120) {
            previous_time = parking_time;
            money = start_Price + increment_Price * (parking_time / 60);
        }
        else {
            previous_time = parking_time;
            money =  Math.min(start_Price + increment_Price * (parking_time / 60), max_Price);
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
        concreteParkingLot.setCar_count(concreteParkingLot.getCar_count()-1);
    }

    public String record_string() {
        return String.format("Car %s %s %s", plateNumber, arriveTime, leaveTime);
    }

    public String toString() {
        return "Car" + " " + this.plateNumber + " " + isInside;
    }
}
