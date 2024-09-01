package laundry_facade;

import java.util.Map;

public class WashingMachine implements LaundryMachine {

    private final Map<Integer, WashProgram> progMap;
    private final String model;

    public WashingMachine(String model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addProgram(int code, String name, double price) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getModel() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    @Override
    public double getPrice(int prog) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getProgName(int prog) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return getModel() + "\n" + progMap + "\n";
    }


}
