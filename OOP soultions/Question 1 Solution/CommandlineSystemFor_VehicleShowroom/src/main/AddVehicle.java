package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.HeavyVehicle;
import model.SportVehicle;
import model.Vehicle;

/**
 *
 * @author ahnaf
 */
public class AddVehicle {
    
    public List<Vehicle> normalVehicle = new ArrayList<>();
    public List<SportVehicle> sportVehicle = new ArrayList<>();
    public List<HeavyVehicle> heavyVehicle = new ArrayList<>();
    
    public Scanner sc = new Scanner(System.in);
    Administration admin = new Administration();
    
    public void addVehicle(int visitorCount) {

        System.out.println("Choose Vehicle Type : \n1. Normal\n2. Sport\n3. Heavy\n4. Go back");
        int a;
        
        a = sc.nextInt();
        

        switch (a) {

            case 1:
                addNormalVehicle(visitorCount);
                break;
            case 2:
                addSportVehicle(visitorCount);
                break;
            case 3:
                addHeavyVehicle(visitorCount);
                break;
            case 4:
                admin.showIntro(this,visitorCount);
                break;
            default:
                admin.showIntro(this,visitorCount);
                break;

        }

    }

    public void addNormalVehicle(int visitorCount) {

        System.out.print("Model : ");
        String model = sc.next();

        System.out.print("Engine Type : ");
        String engineType = sc.next();

        System.out.print("Engine Power : ");       
        String enginePower = sc.next();
             
        System.out.print("Tire Size : ");
        String tireSize = sc.next();

        normalVehicle.add(new Vehicle(model, engineType, enginePower, tireSize));
        
        System.out.println("Successfully Added ! ");
        
        addVehicle(visitorCount);
        
    }

    public void addSportVehicle(int visitorCount) {

        System.out.print("Model : ");
        String model = sc.next();

        String engineType = "oil";

        System.out.print("Engine Power : ");
        String enginePower = sc.next();

        System.out.print("Tire Size : ");
        String tireSize = sc.next();

        System.out.print("Turbo(yes/no) : ");
        String turbo = sc.next();

        sportVehicle.add(new SportVehicle(model, engineType, enginePower, tireSize, turbo));
        System.out.println("Successfully Added ! ");
        visitorCount+=20;
        
        addVehicle(visitorCount);

    }

    public void addHeavyVehicle(int visitorCount) {

        System.out.print("Model : ");
        String model = sc.next();

        String engineType = "diesel";

        System.out.print("Engine Power : ");
        String enginePower = sc.next();

        System.out.print("Tire Size : ");
        String tireSize = sc.next();

        System.out.print("Weight : ");
        String weight = sc.next();

        heavyVehicle.add(new HeavyVehicle(model, engineType, enginePower, tireSize, weight));
        System.out.println("Successfully Added ! ");
        
        addVehicle(visitorCount);

    }
    
    
     public List<Vehicle> getNormalVehicle() {
        return normalVehicle;
    }

    public List<SportVehicle> getSportVehicle() {
        return sportVehicle;
    }

    public List<HeavyVehicle> getHeavyVehicle() {
        return heavyVehicle;
    }
    
}
