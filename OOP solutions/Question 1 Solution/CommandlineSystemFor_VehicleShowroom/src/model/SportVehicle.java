/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ahnaf
 */
public class SportVehicle extends Vehicle{
    
    private String turbo; 
    
    public SportVehicle(String model, String engineType, String enginePower, String tireSize, String turbo) {
        
        super(model, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }

    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }
    
}
