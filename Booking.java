import java.util.*;

public class Booking {

	public List<Taxi> createTaxis(int n) {
		
		List<Taxi> taxis = new ArrayList<>();
		
		for(int i=1;i<=n;i++) {
			Taxi t = new Taxi();
			taxis.add(t);
		}
		
		return taxis;
		
	}
	
	public static void bookTaxi(int customerID,char pickupPoint,char dropPoint,int pickupTime,List<Taxi> freeTaxis)
    {
        int min = 999;
        int distanceBetweenpickUpandDrop = 0;
        int earning = 0;
        int nextfreeTime = 0;
        char nextSpot = 'Z';

        Taxi bookedTaxi = null;
        String tripDetail = "";
        
        for(Taxi t : freeTaxis)
        {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
            if(distanceBetweenCustomerAndTaxi < min)
            {
                bookedTaxi = t;
                distanceBetweenpickUpandDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
                earning = (distanceBetweenpickUpandDrop-5) * 10 + 100;
                
                int dropTime  = pickupTime + distanceBetweenpickUpandDrop/15;
                
                nextfreeTime = dropTime;
                nextSpot = dropPoint;
                tripDetail = customerID + "               " + customerID + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;
                min = distanceBetweenCustomerAndTaxi;
            }
            
        }
        bookedTaxi.setDetails(true,nextSpot,nextfreeTime,bookedTaxi.totalEarnings + earning,tripDetail);

        System.out.println("Taxi " + bookedTaxi.id + " booked");

    }
	
	 public static List<Taxi> getFreeTaxis(List<Taxi> taxis,int pickupTime,char pickupPoint)
	    {
	        List<Taxi> freeTaxis = new ArrayList<Taxi>();
	        for(Taxi t : taxis)
	        {   
	            if(t.freeTime <= pickupTime && (Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime))
	            freeTaxis.add(t);

	        }
	        return freeTaxis;
	    }

}
