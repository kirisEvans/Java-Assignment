package assignment56;

public abstract class Vehicle {
    protected String plateNumber;
    protected boolean isInside = false;
    protected Time arriveTime;
    protected Time leaveTime;

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

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public abstract int calculateMoney(Time leaveTime);

    public abstract void set_count(ConcreteParkingLot concreteParkingLot);

    public abstract String record_string();
}
