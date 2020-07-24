package model;
/**
 *
 * @author ahnaf
 */

public class Vehicle {
           private String model;
           private String engineType;
           private String enginePower;
           private String tireSize;

    public Vehicle(String model, String engineType, String enginePower, String tireSize) {
        this.model = model;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public String getTireSize() {
        return tireSize;
    }

    public void setTireSize(String tireSize) {
        this.tireSize = tireSize;
    }
           
           
}
