package concepts.inheritance;

class TwoWheeler extends Roadways{
    private String name;
    TwoWheeler(){
    	super("Display this message");
        System.out.println("TwoWHeeler");
    }
    
    public void printDetails() {
    	System.out.println("2 Wheeler method was called");
    }
}