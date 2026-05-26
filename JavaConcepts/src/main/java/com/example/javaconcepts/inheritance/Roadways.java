package concepts.inheritance;

class Roadways extends Vehicle{
    private int tireNo; // 2,4,8, 10
    Roadways(){
        System.out.println("Roadways");
    }
    Roadways(String msg){
        System.out.println(msg);
    }
    
    public void printDetails() {
    	System.out.println("Roadways method was called");
    }
}
