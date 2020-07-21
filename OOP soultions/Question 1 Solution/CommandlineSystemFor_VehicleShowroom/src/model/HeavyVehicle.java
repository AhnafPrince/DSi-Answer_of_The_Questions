package model;

/**
 *
 * @author ahnaf
 */
public class HeavyVehicle extends Vehicle{
    
    private String weight;
    
    public HeavyVehicle(String model, String engineType, String enginePower, String tireSize, String weight) {
        
        super(model, engineType, enginePower, tireSize);
        this.weight = weight;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    
}
