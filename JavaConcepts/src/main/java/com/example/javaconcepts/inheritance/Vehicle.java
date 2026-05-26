package concepts.inheritance;

public class Vehicle{
    private String model;
    private String id;
    private String fuel;
    private String category;
    protected String category2;
    
    

	public Vehicle(){
        System.out.println("Vehicle");
    }
    
    public Vehicle(String model, String id, String fuel, String category) {
		super();
		this.model = model;
		this.id = id;
		this.fuel = fuel;
		this.category = category;
	}
    public Vehicle(int model, String id, String fuel, String category) {

	}

	public void printDetails() {
    	System.out.println("Vehicle method was called: Model : " + this.model);
    	return;
    }
    
    public void addValues() {
    	this.category2 = "";
    	System.out.println("Vehicle method was called");
    }
    
    public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		// Logic to save value
		this.category = category;
	}
}