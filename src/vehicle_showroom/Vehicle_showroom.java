/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vehicle_showroom;

/**
 *
 * @author Motahar-zaman
 */
import java.util.*;
import java.lang.*;
import java.util.ArrayList;
public class Vehicle_showroom {

    static List<Object> vehiclelist = new ArrayList<Object>();
    static int visitors = 30;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        
        while(true){
            System.out.println("Want to exit? Enter 0\nWant to add vehicle? Enter 1\nWant to remove vehicle? Enter 2\nWant to see vehicle with visitor? Enter 3\nWant to see vehicle with details? Enter 4");
            int input = sc.nextInt();
            
            switch(input){
                case 0:
                    System.exit(0);
                case 1:
                    addVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    showVehicleWithVisitor();
                    break;
                case 4:
                    showVehicleWithDetails();
                    break;
                default:
                    System.out.println("You enter a wrong input\n\n");
            }
                    
        }
    }
    
    private static void addVehicle(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Want to add normal vehicle? Enter 1\nWant to add sports vehicle? Enter 2\nWant to add heavy vehicle? Enter 3\n");
        int input = sc.nextInt();

        switch(input){          
            case 1:
                addNormalVehicle();
                break;
            case 2:
                addSportsVehicle();
                break;
            case 3:
                addHeavyVehicle();
                break;               
            default:
                System.out.println("You enter a wrong input\n\n");
        }
    }
    
    private static void addNormalVehicle(){
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        
        System.out.println("Enter vehicle Model Number");
        String modelNo = sc.nextLine();
        
        System.out.println("Enter vehicle Engine Type (Oil, Gas, Diesel)"); //Should be a option to select from the 3 types
        String engineType = sc.nextLine();
        
        System.out.println("Enter vehicle Engine Power");
        String enginePower = sc.nextLine();
        
        System.out.println("Enter vehicle Tyre Size");
        String tyreSize = sc.nextLine();
        
        vehicle.setVehicle(modelNo, engineType, enginePower, tyreSize);      
        vehiclelist.add(vehicle);
        
        System.out.println("Successfully added new Vehicle\n\n");
    }
    
    private static void addSportsVehicle(){
        Scanner sc = new Scanner(System.in);
        Sports vehicle = new Sports();
        String engineType = "Oil";
        
        System.out.println("Sports vehicle engine type is Oil bydefault.\nEnter vehicle Model Number");
        String modelNo = sc.nextLine();
        
        System.out.println("Enter vehicle Turbo");
        String turbo = sc.nextLine();
        
        System.out.println("Enter vehicle Engine Power");
        String enginePower = sc.nextLine();
        
        System.out.println("Enter vehicle Tyre Size");
        String tyreSize = sc.nextLine();
        
        vehicle.setVehicle(modelNo, engineType, enginePower, tyreSize);
        vehicle.setTurbo(turbo);

        visitors += 20;
        vehiclelist.add(vehicle);
        
        System.out.println("Successfully added new Vehicle\n\n");
    }
    
    private static void addHeavyVehicle(){
        Scanner sc = new Scanner(System.in);
        Heavy vehicle = new Heavy();
        String engineType = "Diesel";
        
        System.out.println("Heavy vehicle engine type is Diesel bydefault.\nEnter vehicle Model Number");
        String modelNo = sc.nextLine();
        
        System.out.println("Enter vehicle Weight");
        String weight = sc.nextLine();
        
        System.out.println("Enter vehicle Engine Power");
        String enginePower = sc.nextLine();
        
        System.out.println("Enter vehicle Tyre Size");
        String tyreSize = sc.nextLine();
        
        vehicle.setVehicle(modelNo, engineType, enginePower, tyreSize);
        vehicle.setWeight(weight);
        
        vehiclelist.add(vehicle);
        
        System.out.println("Successfully added new Vehicle\n\n");
    }
    
    private static void removeVehicle(){
        Scanner sc = new Scanner(System.in);
        ListIterator<Object> itr = vehiclelist.listIterator();
        int i = 1;
        while(itr.hasNext()){
            Vehicle vehicle =(Vehicle) itr.next();
            System.out.println(i +" => "+vehicle.getModelNo());
            i++;
        }
        
        System.out.println("Enter the vehicle order number to remove\n");
        int rem = sc.nextInt();
         
        if(rem > 0 && rem <= vehiclelist.size()){
            if ((vehiclelist.get(rem-1) instanceof Sports)){
                 visitors -= 20;
            }
            vehiclelist.remove(rem-1);
            System.out.println("Successfully removed the Vehicle\n\n");
        }
        else{
            System.out.println("You enter a wrong order number. Try again\n\n");
        }
    }
    
    private static void showVehicleWithVisitor(){
        ListIterator<Object> itr = vehiclelist.listIterator();
        int i = 1;
        if(itr.hasNext()){
            System.out.println("Total visitors now = "+visitors);
            System.out.println("Vehicle lists..");
            while(itr.hasNext()){
                Vehicle vehicle =(Vehicle) itr.next();
                System.out.println(i +". Model no => "+vehicle.getModelNo());
                i++;
            }
        }
        else{
            System.out.print("No vehicle in the store.");
        }
        
        System.out.print("\n\n");
    }
    
    private static void showVehicleWithDetails(){
        ListIterator<Object> itr = vehiclelist.listIterator();
        int i = 0;
        
        if(itr.hasNext()){
            System.out.println("Vehicle details..");
            while(itr.hasNext()){
                if (vehiclelist.get(i) instanceof Sports){
                    Sports vehicle =(Sports) itr.next();
                    System.out.println(i+1+". Sports Vehicle => 'Model': "+vehicle.getModelNo()+", 'Engine Type': "+ vehicle.getEngineType()+", 'Engine Power': "+vehicle.getEnginePower()+", 'Tyre Size': "+ vehicle.getTyreSize()+", 'Turbo': "+vehicle.getTurbo());
                }
                else if(vehiclelist.get(i) instanceof Heavy){
                    Heavy vehicle =(Heavy) itr.next();
                    System.out.println(i+1+". Heavy Vehicle => 'Model': "+vehicle.getModelNo()+", 'Engine Type': "+ vehicle.getEngineType()+", 'Engine Power': "+vehicle.getEnginePower()+", 'Tyre Size': "+ vehicle.getTyreSize()+", 'Weight': "+vehicle.getWeight());
                }
                else{
                   Vehicle vehicle =(Vehicle) itr.next();
                   System.out.println(i+1+". Normal Vehicle => 'Model': "+vehicle.getModelNo()+", 'Engine Type': "+ vehicle.getEngineType()+", 'Engine Power': "+vehicle.getEnginePower()+", 'Tyre Size': "+ vehicle.getTyreSize());
                }
                i++;
            }
        }
        else{
            System.out.print("No vehicle in the store.");
        }
        
        System.out.print("\n\n");
    }
}
