package laundry_facade;

public class TumbleDryer implements LaundryMachine {

    private final double pricePerMinute;
    private final String model;

    public TumbleDryer(String model) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setPrice(double pricePerMinute) {
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
        return getModel() + " Minutpris: " + pricePerMinute + "\n";
    }

}
