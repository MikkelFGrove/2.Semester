package writing.Exercise3;

public class Flower {

    private int Id;
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String species;

    public Flower(int id, double sepalLength, double sepalWidth, double petalLength, double petalWidth, String species) {
        Id = id;
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }


    public int getId() {
        return Id;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getSpecies() {
        return species;
    }


    @Override
    public String toString() {
        return String.format(" %d \t \t %.2f \t \t %.2f \t \t %.2f \t \t %.2f \t \t %s \n", getId(), getSepalLength(), getSepalWidth(), getPetalLength(), getPetalWidth(), getSpecies());
    }

}
