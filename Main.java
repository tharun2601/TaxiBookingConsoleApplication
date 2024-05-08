import java.util.*;

public class Main{
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no:of Taxis - ");
		int N = sc.nextInt();
		
		Booking B = new Booking();
		
		List<Taxi> taxis = B.createTaxis(N);
		
		int id = 1;
		char ans;
		
		do {
			System.out.print("Welcome to Taxi Booking Application\n\n1 - Book Taxi\n2 - Print Taxi Details\n\nYour Choice - ");
			int ch = sc.nextInt();
			
			switch(ch) {
				case 1:
					int customerID = id;
					System.out.print("Enter Pickup point - ");
					char pickUpPoint = sc.next().charAt(0);
					
					System.out.print("Enter Drop point - ");
					char dropPoint = sc.next().charAt(0);
					
					System.out.print("Enter Pickup time - ");
					char pickUpTime = sc.next().charAt(0);
					
					if(pickUpPoint < 'A' || dropPoint > 'F' || pickUpPoint > 'F' || dropPoint < 'A' ) {
						System.out.print("Enter a valid response ( A, B, C, D, E, F)");
						return;
					}
					
					List<Taxi> freeTaxis = B.getFreeTaxis(taxis,pickUpTime,pickUpPoint);

				    if(freeTaxis.size() == 0){
				    	System.out.println("No Taxi can be alloted. Exitting");
				        return;
				    }
				    
				    Collections.sort(freeTaxis,(a,b)->a.totalEarnings - b.totalEarnings); 
			    
			        B.bookTaxi(id,pickUpPoint,dropPoint,pickUpTime,freeTaxis);
			        id++;
			        break;
			        
				case 2:
					for(Taxi t : taxis)
		                t.printTaxiDetails();
					System.out.println("\n");
		             for(Taxi t : taxis)
		                t.printDetails();
		             System.out.println("\n");
		            break;
		        default:
		        	System.out.print("Enter a proper choice!\n");
		        	break;
					
			}
			System.out.print("Do you want to continue(Y/N) - ");
			ans = sc.next().charAt(0);
		}while(ans == 'Y');
	}
}