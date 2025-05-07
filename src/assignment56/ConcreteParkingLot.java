package assignment56;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteParkingLot implements ParkingLot{
    private List<Vehicle> vehicles;
    private Time currentTime;
    private final int CAR_CAPACITY;
    private final int BUS_CAPACITY;
    private int car_count;
    private int bus_count;
    private int parking_fee;

    public ConcreteParkingLot(int carCapacity, int busCapacity) {
        vehicles = new ArrayList<>();
        currentTime = new Time(0, 0);
        CAR_CAPACITY = carCapacity;
        BUS_CAPACITY = busCapacity;
    }

    public Time getTime() {
        return currentTime;
    }

    public void minutesPassed(int minutes) {
        currentTime.addMinutes(minutes);
    }

    public String parkingLotStatus() {
        return String.format("car:%d/%d bus:%d/%d", car_count, CAR_CAPACITY, bus_count, BUS_CAPACITY);
    }

    public int currentIncome() {
        return parking_fee;
    }

    public void driveInto(int type, String... plateNumbers) {
        int n = 0;
        currentTime.addMinutes(-1);
        if (type == 0) {
            while (car_count < CAR_CAPACITY && n < plateNumbers.length) {
                minutesPassed(1);
                Vehicle vehicle = getVehicleByPlateNumber(plateNumbers[n]);
                if (vehicle != null) {
                    vehicle.setArriveTime(new Time(currentTime.getHour(), currentTime.getMinute()));
                }
                else {
                    Car car = new Car(plateNumbers[n]);
                    car.setArriveTime(new Time(currentTime.getHour(), currentTime.getMinute()));
                    vehicles.add(car);
                }
                n++;
                car_count++;
            }
        }
        else if (type == 1) {
            while (bus_count < BUS_CAPACITY && n < plateNumbers.length) {
                minutesPassed(1);
                Vehicle vehicle = getVehicleByPlateNumber(plateNumbers[n]);
                if (vehicle != null) {
                    vehicle.setArriveTime(new Time(currentTime.getHour(), currentTime.getMinute()));
                }
                else {
                    Bus bus = new Bus(plateNumbers[n]);
                    bus.setArriveTime(new Time(currentTime.getHour(), currentTime.getMinute()));
                    vehicles.add(bus);
                }
                n++;
                bus_count++;
            }
        }
    }

    public void driveOut(String... plateNumbers) {
        for (String plateNumber : plateNumbers) {
            Vehicle vehicle = getVehicleByPlateNumber(plateNumber);
            if (vehicle != null) {
                parking_fee += vehicle.calculateMoney(new Time(currentTime.getHour(), currentTime.getMinute()));
                vehicle.set_count(this);
            }
        }
    }

    public void setCar_count(int count) {
        this.car_count = count;
    }

    public void setBus_count(int bus_count) {
        this.bus_count = bus_count;
    }

    public int getCar_count() {
        return car_count;
    }

    public int getBus_count() {
        return bus_count;
    }

    public Vehicle getVehicleByPlateNumber(String plateNumber) {
        for (Vehicle vehicle : vehicles) {
            if (plateNumber.equals(vehicle.getPlateNumber())) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Vehicle> getVehiclesByNumber() {
        vehicles.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return o1.getPlateNumber().compareTo(o2.getPlateNumber());
            }
        });
        return vehicles;
    }

    public List<String> getParkingRecordByArriveTime(Time start, Time end) {
        List<String> result_list = new ArrayList<>();
        List<Vehicle> my_list = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.arriveTime.extend() >= start.extend()) {
                my_list.add(vehicle);
            }
        }
        my_list.sort(new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle o1, Vehicle o2) {
                return Integer.compare(o1.arriveTime.extend(), o2.arriveTime.extend());
            }
        });
        for (Vehicle vehicle : my_list) {
            result_list.add(vehicle.record_string());
        }
        return result_list;
    }
}

