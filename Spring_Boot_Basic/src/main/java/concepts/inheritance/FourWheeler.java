package concepts.inheritance;

class FourWheeler extends Roadways{
    private String name;
    FourWheeler(){
        System.out.println("FourWheeler");
    }
    
    public void printDetails() {
    	System.out.println("4 Wheeler method was called");
    }
}