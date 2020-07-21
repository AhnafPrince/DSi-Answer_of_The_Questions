package main;

import java.util.Iterator;
import java.util.Scanner;
import model.HeavyVehicle;
import model.SportVehicle;
import model.Vehicle;

/**
 *
 * @author ahnaf
 */
public class RemoveVehicle {
    
     public Scanner sc = new Scanner(System.in);
     Administration admin = new Administration();
    
    public void removeVehicle(AddVehicle v,int visitorCount){
        
        System.out.println("Choose Vehicle Type to remove : \n1. Normal\n2. Sport\n3. Heavy\n4. Go back");
        int a;
        
        a = sc.nextInt();

        switch (a) {

            case 1:
                removeNormalVehicle(v,visitorCount);
                break;
            case 2:
                removeSportVehicle(v,visitorCount);
                break;
            case 3:
                removeHeavyVehicle(v,visitorCount);
                break;
            case 4:
                admin.showIntro(v,visitorCount);
                break;
            default:
                admin.showIntro(v,visitorCount);
                break;
        }
    }
    
    public void removeNormalVehicle(AddVehicle v,int visitorCount){
        
        System.out.print("Model : ");
        String model = sc.next();
        
        Iterator<Vehicle> iterator = v.normalVehicle.iterator();
        while(iterator.hasNext()){
            Vehicle normalVehicle = iterator.next();
            if(normalVehicle.getModel().equals(model)){
                iterator.remove();
                System.out.println(model+" Vehicle Removed Successfully");
            }
        }
        this.removeVehicle(v,visitorCount);
    }
    
    public void removeSportVehicle(AddVehicle v,int visitorCount){
        
        System.out.print("Model : ");
        String model = sc.next();
        
        Iterator<SportVehicle> iterator = v.sportVehicle.iterator();
        while(iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if(vehicle.getModel().equals(model)){
                iterator.remove();
                System.out.println(model+" Vehicle Removed Successfully");
                visitorCount-=20;
            }
        }
        this.removeVehicle(v,visitorCount);
    }
    
    public void removeHeavyVehicle(AddVehicle v,int visitorCount){
        
        System.out.print("Model : ");
        String model = sc.next();
        
        Iterator<HeavyVehicle> iterator = v.heavyVehicle.iterator();
        while(iterator.hasNext()){
            Vehicle vehicle = iterator.next();
            if(vehicle.getModel().equals(model)){
                iterator.remove();
                System.out.println(model+" Vehicle Removed Successfully");
            }
        }
        this.removeVehicle(v,visitorCount);
    }
    
}
