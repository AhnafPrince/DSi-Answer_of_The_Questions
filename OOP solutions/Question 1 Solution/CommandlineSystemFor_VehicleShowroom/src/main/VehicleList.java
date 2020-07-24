package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import model.HeavyVehicle;
import model.SportVehicle;
import model.Vehicle;

/**
 *
 * @author ahnaf
 */
public class VehicleList {

    Scanner sc = new Scanner(System.in);
    Administration admin = new Administration();
    
    public void showVehicles(AddVehicle v,int visitorCount) {

        System.out.println("Choose Vehicle Type to View Lists : \n1. Normal\n2. Sport\n3. Heavy\n4. Go back");
        int a;

        a = sc.nextInt();

        switch (a) {

            case 1:
                showNormalVehicles(v,visitorCount);
                break;
            case 2:
                showSportVehicles(v,visitorCount);
                break;
            case 3:
                showHeavyVehicles(v,visitorCount);
                break;
            case 4:
                admin.showIntro(v,visitorCount);
                break;
            default:
                admin.showIntro(v,visitorCount);
                break;
        }

    }
    
    public void showVehiclesWithVisitorCount(AddVehicle v,int visitorCount){
        
        System.out.println("Total Expected Visitors :"+visitorCount);
        this.showNormalVehicles(v,visitorCount);
        
    }
    

    public void showNormalVehicles(AddVehicle v,int visitorCount) {

        Iterator<Vehicle> iterator = v.getNormalVehicle().iterator();

        if (!iterator.hasNext()) {
            System.out.println("Sorry! No normal vehicle to show! ");
        } else {
            System.out.println("Normal Vehicles : ");
            while (iterator.hasNext()) {
                
                Vehicle vehicle = iterator.next();
                System.out.print("Model:" + vehicle.getModel() + " EngineType:" + vehicle.getEngineType());
                System.out.println(" EnginePower:" + vehicle.getEngineType() + " TireSize:" + vehicle.getTireSize());

            }
        }
        showVehicles(v,visitorCount);

    }

    public void showSportVehicles(AddVehicle v,int visitorCount) {

        Iterator<SportVehicle> iterator = v.getSportVehicle().iterator();

        if (!iterator.hasNext()) {
            System.out.println("Sorry! No Sport vehicle to show! ");
        } else {
            
            System.out.println("Sport Vehicles : ");
            while (iterator.hasNext()) {

                SportVehicle vehicle = iterator.next();
                System.out.print("Model:" + vehicle.getModel() + " EngineType:" + vehicle.getEngineType() + " EnginePower:" + vehicle.getEnginePower());
                System.out.println(" TireSize:" + vehicle.getTireSize() + " Turbo:" + vehicle.getTurbo());

            }
        }
        showVehicles(v,visitorCount);
    }

    public void showHeavyVehicles(AddVehicle v,int visitorCount) {

        Iterator<HeavyVehicle> iterator = v.getHeavyVehicle().iterator();

        if (!iterator.hasNext()) {
            System.out.println("Sorry! No Heavy vehicle to show! ");
        } else {
            
            System.out.println("Heavy Vehicles : ");

            while (iterator.hasNext()) {

                HeavyVehicle vehicle = iterator.next();
                System.out.print("Model:" + vehicle.getModel() + " EngineType:" + vehicle.getEngineType() + " EnginePower:" + vehicle.getEnginePower());
                System.out.println(" TireSize:" + vehicle.getTireSize() + " Weight:" + vehicle.getWeight());

            }
        }

        showVehicles(v,visitorCount);
    }

}
