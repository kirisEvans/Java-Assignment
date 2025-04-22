package assignment5;

public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside = false;
    protected Time arriveTime;

    public Vehicle(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public abstract String toString();

    public void setArriveTime(Time arriveTime) {
        this.arriveTime = arriveTime;
        this.isInside = true;
    }

    public Time getArriveTime() {
        return this.arriveTime;
    }

    public abstract int calculateMoney(Time leaveTime);
}
