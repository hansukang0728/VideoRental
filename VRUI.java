import java.util.Date;

public class VRUI {
	private final VRManager VRManager = new VRManager();

	public static void main(String[] args) {
		VRUI ui = new VRUI() ;

		boolean quit = false ;
		while ( ! quit ) {
			int command = ui.showCommand() ;
			switch ( command ) {
				case 0: quit = true ; break ;
				case 1: ui.listCustomers() ; break ;
				case 2: ui.listVideos() ; break ;
				case 3: ui.register("customer") ; break ;
				case 4: ui.register("video") ; break ;
				case 5: ui.rentVideo() ; break ;
				case 6: ui.returnVideo() ; break ;
				case 7: ui.getCustomerReport() ; break;
				case 8: ui.clearRentals() ; break ;
				case -1: ui.init() ; break ;
				default: break ;
			}
		}
		System.out.println("Bye");
	}

	public void clearRentals() {

		VRManager.clearRentals();
	}

	public void returnVideo() {

		VRManager.returnVideo();
	}

	private void init() {
		Customer james = new Customer("James") ;
		Customer brown = new Customer("Brown") ;
		VRManager.customerManager.add(james) ;
		VRManager.customerManager.add(brown) ;

		//Video v1 = new Video("v1", Video.CD, Video.REGULAR, new Date()) ;
		//Video v2 = new Video("v2", Video.DVD, Video.NEW_RELEASE, new Date()) ;
		Video v1 = Video.VideoFactory("v1", Video.CD, Video.PriceCode.Regular, new Date()) ;
		Video v2 = Video.VideoFactory("v2", Video.DVD, Video.PriceCode.New_Release, new Date());

		VRManager.videos.add(v1) ;
		VRManager.videos.add(v2) ;

		Rental r1 = new Rental(v1) ;
		Rental r2 = new Rental(v2) ;

		james.addRental(r1) ;
		james.addRental(r2) ;
	}

	public void listVideos() {
		System.out.println("List of videos");

		for ( Video video: VRManager.videos) {
			System.out.println("Price code: " + video.getPriceCode() +"\tTitle: " + video.getTitle()) ;
		}
		System.out.println("End of list");
	}

	public void listCustomers() {
		System.out.println("List of customers");
		VRManager.customerManager.printCustomers();
		System.out.println("End of list");
	}

	public void getCustomerReport() {

		VRManager.getCustomerReport();
	}

	public void rentVideo() {

		VRManager.rentVideo();
	}

	public void register(String object) {
		VRManager.register(object);
	}

	public int showCommand() {
		System.out.println("\nSelect a command !");
		System.out.println("\t 0. Quit");
		System.out.println("\t 1. List customers");
		System.out.println("\t 2. List videos");
		System.out.println("\t 3. Register customer");
		System.out.println("\t 4. Register video");
		System.out.println("\t 5. Rent video");
		System.out.println("\t 6. Return video");
		System.out.println("\t 7. Show customer report");
		System.out.println("\t 8. Show customer and clear rentals");

		int command = VRManager.scanner.nextInt() ;

		return command ;

	}
}
