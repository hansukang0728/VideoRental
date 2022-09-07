import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VRManager {
    static Scanner scanner;
    //List<Customer> customers = new ArrayList<Customer>();
    CustomerManager customerManager = new CustomerManager();
    List<Video> videos = new ArrayList<Video>();

    public VRManager() {
        this.scanner = new Scanner(System.in);
    }

    public void clearRentals() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = customerManager.findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            System.out.println("Name: " + foundCustomer.getName() +
                    "\tRentals: " + foundCustomer.getRentals().size());
            for (Rental rental : foundCustomer.getRentals()) {
                System.out.print("\tTitle: " + rental.getVideo().getTitle() + " ");
                System.out.print("\tPrice Code: " + rental.getVideo().getPriceCode());
            }

            List<Rental> rentals = new ArrayList<Rental>();
            foundCustomer.setRentals(rentals);
        }
    }

    public void returnVideo() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = customerManager.findCustomer(customerName);
        if (foundCustomer == null) return;

        System.out.println("Enter video title to return: ");
        String videoTitle = scanner.next();

        List<Rental> customerRentals = foundCustomer.getRentals();
        for (Rental rental : customerRentals) {
            if (rental.getVideo().getTitle().equals(videoTitle) && rental.getVideo().isRented()) {
                rental.returnVideo();
                rental.getVideo().setRented(false);
                break;
            }
        }
    }

    public void getCustomerReport() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = customerManager.findCustomer(customerName);

        if (foundCustomer == null) {
            System.out.println("No customer found");
        } else {
            String result = foundCustomer.getReport();
            System.out.println(result);
        }
    }

    public void rentVideo() {
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();

        Customer foundCustomer = customerManager.findCustomer(customerName);

        if (foundCustomer == null) return;

        System.out.println("Enter video title to rent: ");
        String videoTitle = scanner.next();

        Video foundVideo = null;
        for (Video video : videos) {
            if (video.getTitle().equals(videoTitle) && video.isRented() == false) {
                foundVideo = video;
                break;
            }
        }

        if (foundVideo == null) return;

        Rental rental = new Rental(foundVideo);
        foundVideo.setRented(true);

        List<Rental> customerRentals = foundCustomer.getRentals();
        customerRentals.add(rental);
        foundCustomer.setRentals(customerRentals);
    }

    public void register(String object) {
        if (object.equals("customer")) {
            System.out.println("Enter customer name: ");
            String name = scanner.next();
            Customer customer = new Customer(name);
            customerManager.add(customer);
        } else {
            System.out.println("Enter video title to register: ");
            String title = scanner.next();

            System.out.println("Enter video type( 1 for VHD, 2 for CD, 3 for DVD ):");
            int videoType = scanner.nextInt();

            System.out.println("Enter price code( 1 for Regular, 2 for New Release ):");
            int priceCode = scanner.nextInt();

            Date registeredDate = new Date();
            Video video =  Video.VideoFactory(title, videoType, Video.PriceCode.values(priceCode), registeredDate);
    		
            videos.add(video);
        }
    }
}