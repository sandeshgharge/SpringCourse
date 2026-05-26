package concepts.inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		TwoWheeler obj = new TwoWheeler(); System.out.println("");
		Roadways obj2 = new TwoWheeler();System.out.println("");
		Vehicle obj3 = new TwoWheeler();System.out.println("");
		Vehicle obj4 = new Roadways();System.out.println("");
		Vehicle obj5 = new Vehicle();System.out.println("");
		
		obj.printDetails();System.out.println("");
		obj2.printDetails();System.out.println("");
		obj3.printDetails();System.out.println("");
		obj4.printDetails();System.out.println("");
		obj5.printDetails();System.out.println("");
		
		
		System.out.println();
		obj2.printDetails();
		obj5.printDetails();System.out.println("");
		
	}

}
