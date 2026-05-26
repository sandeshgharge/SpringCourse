package concepts.inheritance;

class Waterways extends Vehicle{
    private String type; // Ship, Boat, 
    Waterways(){
        System.out.println("WaterWays");
    }
    
    public void printDetails() {
    	System.out.println("Vehicle method was called: Model : " );
    	return;
    }
}