package main;

import java.util.*;

/**
 *
 * @author ahnaf
 */
public class Administration {

    
    
   public Scanner sc = new Scanner(System.in);

   private int visitorCount=30;


    public void showIntro(AddVehicle v,int visitorCount) {          //Show Intro Everytime

        System.out.println("\nPress 1,2,3 etc to execute mentioned command : \n"
                + "1. add a vehicle \n2.remove a vehicle \n3.show list of vehicle with details"
                + "\n4. Show Expected Visitors with All Vehicles\n5. Exit");

        int a = sc.nextInt();
        VehicleList list = new VehicleList();
        RemoveVehicle remove = new RemoveVehicle();
        
        switch (a) {

            case 1:
                v.addVehicle(visitorCount);
                break;
            case 2:
                remove.removeVehicle(v,visitorCount);
                break;
            case 3:
                list.showVehicles(v,visitorCount);
                break;
            case 4:
                list.showVehiclesWithVisitorCount(v,visitorCount);
                break;
            
            case 5:
                   System.exit(0); 
                break;
            default:
                System.exit(0); 
        }

    }

    public void callingMethod(AddVehicle v){         
            
        this.showIntro(v,this.visitorCount);
    }

    public static void main(String args[]) {

        System.out.println("Welcome !!"); 
        Administration admin = new Administration();
        AddVehicle v = new AddVehicle();        //Initializing new instance for vehicles
        admin.callingMethod(v);
        
        
    }

}
