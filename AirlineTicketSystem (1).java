package reservation;
import java.util.*;

class Passenger {
    String name;
    String id;
    String flightType;
    String destination;
    String flightTiming;
    String seatType;
    int seatNumber;
    double price;}

public class AirlineTicketSystem {
	 private static int passengerIDCounter = 1;
	 // QUEUES USED IN PROGRAM:
    static Queue<Passenger> mumbaiBangaloreFlights = new LinkedList<>();
    static Queue<Passenger> puneDelhiFlights = new LinkedList<>();
    static Queue<Passenger> mumbaiChicagoAlaskaFlights = new LinkedList<>();
    static Queue<Passenger> puneAbuDhabiDubaiFlights = new LinkedList<>();
    //FIXING SIZE OF SEATS (25-BUSSINESS ,25-ECONOMY CLASS):
    static int mumbaiBangaloreBusinessSeats = 25;
    static int mumbaiBangaloreEconomySeats = 25;
    static int puneDelhiBusinessSeats = 25;
    static int puneDelhiEconomySeats = 25;
    static int mumbaiChicagoAlaskaBusinessSeats = 25;
    static int mumbaiChicagoAlaskaEconomySeats = 25;
    static int puneAbuDhabiDubaiBusinessSeats = 25;
    static int puneAbuDhabiDubaiEconomySeats = 25;
    // COUNTERS:TO KEEP TRACK OF SEAT NUMBERS::
    static int mumbaiBangaloreBusinessSeatCounter = 1;
    static int mumbaiBangaloreEconomySeatCounter = 1;
    static int puneDelhiBusinessSeatCounter = 1;
    static int puneDelhiEconomySeatCounter = 1;
    static int mumbaiChicagoAlaskaBusinessSeatCounter = 1;
    static int mumbaiChicagoAlaskaEconomySeatCounter = 1;
    static int puneAbuDhabiDubaiBusinessSeatCounter = 1;
    static int puneAbuDhabiDubaiEconomySeatCounter = 1;
    
    public static void main(String[] args) {
        //CALLING MENU TO DISPLAY FLIGHT INFORMATION
        menu();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {// AIRLINE RESERVATION SYSTEM:
            System.out.println("\n******WELCOME TO AIRLINE RESERVATION SYSTEM****** ");
            System.out.println("--------------1. BOOK TICKET--------------------------------------------");
            System.out.println("--------------2. DISPLAY ALL BOOKED TICKET DETAILS-----------------------");
            System.out.println("--------------3. SEARCH A PASSENGER BY ID(SYSTEM GENERATED)--------------");
            System.out.println("--------------4. CANCEL A TICKET-----------------------------------------");
            System.out.println("--------------5. EXIT THE SYSTEM-----------------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookTicket(scanner);
                    break;
                case 2:
                	 displayAllBookedTickets();                      
                    break;
                case 3:
                	searchPassengerByID();
                    break;
               case 4:
            	   cancelTicket( scanner);
                    break;
                case 5:
                    System.out.println("!!!!!EXITING SYSTEM!!!!! THANKS FOR VISITING!!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 5);
    }
   // MAIN MENU TO DISPLAY FLIGHT INFORMATION:
   public static void menu() {
    	    System.out.println("***************************************************  AIRLINE RESERVATION SYSTEM  ***********************************************");
    	    System.out.println("FLIGHT TYPE         NAME OF FLIGHT          DESTINATION               TIMING                     SEATS                       PRICE     ");
    	    System.out.println("                                                                                          (BUSINESS|ECONOMY)                           ");
    	    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("INTERNATIONAL:        AIR ASIA         MUMBAI-CHICAGO-ALASKA        02:00am-03:30am             50                                         ");
    	    System.out.println("                                                                    10:00am-11:30am           (25/25)                   ECONOMY:  Rs 10000 ");
    	    System.out.println("                                                                                                                        BUSINESS: Rs 25000 ");
    	    System.out.println("                    ------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                    AIR ARABIA         PUNE-ABU DHABI-DUBAI          07:00am-09:00am             50                                          ");
    	    System.out.println("                                                                     12:00pm-02.30pm           (25/25)                  ECONOMY:  Rs 15500 ");
    	    System.out.println("                                                                                                                        BUSINESS: Rs 35000 ");
    	    System.out.println("                    ------------------------------------------------------------------------------------------------------------------------");
            System.out.println("NATIONAL:           AIR INDIA          MUMBAI-BANGLORE              12:00am-02:30am              50                                           ");
    	    System.out.println("                                                                    10:00am-11.30am             (25/25)                 ECONOMY:  Rs 18000  ");
    	    System.out.println("                                                                                                                        BUSINESS: Rs 25000  ");
    	    System.out.println("                    ------------------------------------------------------------------------------------------------------------------------");
            System.out.println("                    AIR INDIGO         PUNE-DELHI                   07:00am-09:00am               50                                        ");
    	    System.out.println("                                                                    12:00pm-02.30pm             (25/25)                 ECONOMY:  Rs 20000   ");
    	    System.out.println("                                                                                                                        BUSINESS: Rs 35000   ");
    	    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
         }
         // METHOD FOR BOOKING TICKET:
    	 public static void bookTicket(Scanner scanner) {
    	        Passenger passenger = new Passenger();
    	        passenger.id = "P" + passengerIDCounter++; // Generate a unique passenger ID
    	        scanner.nextLine(); 
                System.out.println("ENTER PASSENGER DETAIL");
    	        System.out.print("ENTER VALID NAME                        : ");
    	        passenger.name = scanner.nextLine();
    	         System.out.print("ENTER FLIGHT NAME(e.g. AIR ASIA)       : ");
    	        passenger.flightType = scanner.nextLine();
    	        System.out.print("ENTER SEAT TYPE (BUSINESS or ECONOMY)   : ");
    	        passenger.seatType = scanner.nextLine();
    	    // Depending on the flight type, assign to the appropriate queue and manage seat allocation
    	    switch (passenger.flightType) {
    	        case "AIR ASIA":
    	            if (passenger.seatType.equals("BUSINESS")) {
    	                if (mumbaiChicagoAlaskaBusinessSeatCounter <= mumbaiChicagoAlaskaBusinessSeats) {
    	                    passenger.destination   = "MUMBAI-CHICAGO-ALASKA";
    	                    passenger.flightTiming  = "02:00am-03:30am";
    	                    passenger.seatNumber    = mumbaiChicagoAlaskaBusinessSeatCounter++;
    	                    mumbaiChicagoAlaskaFlights.add(passenger);
    	                    System.out.println("Ticket booked for \"AIR ASIA\":\nDESTINATION: MUMBAI-CHICAGO-ALASKA\nCLASS: BUSINESS CLASS\nSeat Number: " + passenger.seatNumber + "\n");
    	                    
                           } else {
    	                    System.out.println("Business class seats are fully booked for AIR ASIA - MUMBAI-CHICAGO-ALASKA.");
    	                }
    	            } else if (passenger.seatType.equals("ECONOMY")) {
    	                if (mumbaiChicagoAlaskaEconomySeatCounter <= mumbaiChicagoAlaskaEconomySeats) {
    	                    passenger.destination   = "MUMBAI-CHICAGO-ALASKA";
    	                    passenger.flightTiming  = "10:00am-11:30am";
    	                    passenger.seatNumber    = mumbaiChicagoAlaskaEconomySeatCounter++;
    	                    mumbaiChicagoAlaskaFlights.add(passenger);
    	                    System.out.println("Ticket booked for \"AIR ASIA\":\nDESTINATION: MUMBAI-CHICAGO-ALASKA\nCLASS: ECONOMY CLASS\nSeat Number: " + passenger.seatNumber + "\n");
    	                    
    	                } else {
    	                    System.out.println("Economy class seats are fully booked for AIR ASIA - MUMBAI-CHICAGO-ALASKA.");
    	                }
    	            }
    	            break;
    	        case "AIR ARABIA":
    	            if (passenger.seatType.equals("BUSINESS")) {
    	                if (puneAbuDhabiDubaiBusinessSeatCounter <= puneAbuDhabiDubaiBusinessSeats) {
    	                    passenger.destination   = "PUNE-ABU DHABI-DUBAI";
    	                    passenger.flightTiming  = "07:00am-09:00am";
    	                    passenger.seatNumber    = puneAbuDhabiDubaiBusinessSeatCounter++;
    	                    puneAbuDhabiDubaiFlights.add(passenger);
    	                    System.out.println("Ticket booked for\" AIR ARABIA\": \nPUNE-ABU DHABI-DUBAI\n CLASS: BUSINESS CLASS\n Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Business class seats are fully booked for AIR ARABIA - PUNE-ABU DHABI-DUBAI.");
    	                }
    	            } else if (passenger.seatType.equals("ECONOMY")) {
    	                if (puneAbuDhabiDubaiEconomySeatCounter <= puneAbuDhabiDubaiEconomySeats) {
    	                    passenger.destination   = "PUNE-ABU DHABI-DUBAI";
    	                    passenger.flightTiming  = "12:00pm-02:30pm";
    	                    passenger.seatNumber    = puneAbuDhabiDubaiEconomySeatCounter++;
    	                    puneAbuDhabiDubaiFlights.add(passenger);
    	                    System.out.println("Ticket booked for\" AIR ARABIA\": \nPUNE-ABU DHABI-DUBAI\n CLASS: ECONOMY CLASS\n Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Economy class seats are fully booked for AIR ARABIA - PUNE-ABU DHABI-DUBAI.");
    	                }
    	            }
    	            break;

    	        case "AIR INDIA":
    	            if (passenger.seatType.equals("BUSINESS")) {
    	                if (mumbaiBangaloreBusinessSeatCounter <= mumbaiBangaloreBusinessSeats) {
    	                    passenger.destination   = "MUMBAI-BANGLORE";
    	                    passenger.flightTiming  = "12:00am-02:30am";
    	                    passenger.seatNumber    = mumbaiBangaloreBusinessSeatCounter++;
    	                    mumbaiBangaloreFlights.add(passenger);
    	                    System.out.println("Ticket booked for\" AIR INDIA\": \n MUMBAI-BANGLORE\n CLASS: BUSINESS Class\n Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Business class seats are fully booked for AIR INDIA - MUMBAI-BANGLORE.");
    	                }
    	            } else if (passenger.seatType.equals("ECONOMY")) {
    	                if (mumbaiBangaloreEconomySeatCounter <= mumbaiBangaloreEconomySeats) {
    	                    passenger.destination  = "MUMBAI-BANGLORE";
    	                    passenger.flightTiming = "10:00am-11:30am";
    	                    passenger.seatNumber   = mumbaiBangaloreEconomySeatCounter++;
    	                    mumbaiBangaloreFlights.add(passenger);
    	                    System.out.println("Ticket booked for\" AIR INDIA\": \n MUMBAI-BANGLORE\n CLASS: BUSINESS Class\n Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Economy class seats are fully booked for AIR INDIA - MUMBAI-BANGLORE.");
    	                }
    	            }
    	            break;

    	        case "AIR INDIGO":
    	            if (passenger.seatType.equals("BUSINESS")) {
    	                if (puneDelhiBusinessSeatCounter <= puneDelhiBusinessSeats) {
    	                    passenger.destination  = "PUNE-DELHI";
    	                    passenger.flightTiming = "07:00am-09:00am";
    	                    passenger.seatNumber   = puneDelhiBusinessSeatCounter++;
    	                    puneDelhiFlights.add(passenger);
    	                    System.out.println("Ticket booked for AIR INDIGO - PUNE-DELHI in BUSINESS class. Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Business class seats are fully booked for AIR INDIGO - PUNE-DELHI.");
    	                }
    	            } else if (passenger.seatType.equals("ECONOMY")) {
    	                if (puneDelhiEconomySeatCounter <= puneDelhiEconomySeats) {
    	                    passenger.destination  = "PUNE-DELHI";
    	                    passenger.flightTiming = "12:00pm-02:30pm";
    	                    passenger.seatNumber   = puneDelhiEconomySeatCounter++;
    	                    puneDelhiFlights.add(passenger);
    	                    System.out.println("Ticket booked for AIR INDIGO - PUNE-DELHI in ECONOMY class. Seat Number: " + passenger.seatNumber);
    	                } else {
    	                    System.out.println("Economy class seats are fully booked for AIR INDIGO - PUNE-DELHI.");
    	                }
    	            }
    	            break;
    	            default:
    	            System.out.println("Invalid Flight Type!");
    	            break;
    	            // PRICE OF EACH FLIGHT ACCORDING TO SEAT CLASS:
    	    }if (passenger.flightType.equals("AIR ASIA")) {
    	        if (passenger.seatType.equals("BUSINESS")) {
    	            passenger.price = 25000.0; 
    	        } else if (passenger.seatType.equals("ECONOMY")) {
    	            passenger.price = 10000.0; 
    	        }
    	    } else if (passenger.flightType.equals("AIR ARABIA")) {
    	        if (passenger.seatType.equals("BUSINESS")) {
    	            passenger.price = 35000.0;
    	        } else if (passenger.seatType.equals("ECONOMY")) {
    	            passenger.price = 15500.0;
    	        }
    	    } else if (passenger.flightType.equals("AIR INDIA")) {
    	        if (passenger.seatType.equals("BUSINESS")) {
    	            passenger.price = 25000.0; 
    	        } else if (passenger.seatType.equals("ECONOMY")) {
    	            passenger.price = 18000.0; 
    	        }
    	    } else if (passenger.flightType.equals("AIR INDIGO")) {
    	        if (passenger.seatType.equals("BUSINESS")) {
    	            passenger.price = 35000.0; 
    	        } else if (passenger.seatType.equals("ECONOMY")) {
    	            passenger.price = 20000.0; 
    	        }}}
    	 // METHOD TO CANCEL BOOKED TICKET:
    	     public static void cancelTicket(Scanner scanner) {
    	    System.out.print("Enter passenger ID to cancel the ticket: ");
    	    String passengerID = scanner.next();
    	    
    	    boolean passengerFound = false; // Flag to track if the passenger is found
    	    Passenger passengerToRemove = null;
    	    Queue<Passenger> queueToRemoveFrom = null;
            for (Passenger passenger : mumbaiBangaloreFlights) {
    	        if (passenger.id.equals(passengerID)) {
    	            passengerToRemove = passenger;
    	            queueToRemoveFrom = mumbaiBangaloreFlights;
    	            passengerFound = true;
    	            break;
    	        }
    	    }
    	    for (Passenger passenger : puneDelhiFlights) {
    	        if (passenger.id.equals(passengerID)) {
    	            passengerToRemove = passenger;
    	            queueToRemoveFrom = puneDelhiFlights;
    	            passengerFound = true;
    	            break;
    	        }
    	    }
    	    for (Passenger passenger : mumbaiChicagoAlaskaFlights) {
    	        if (passenger.id.equals(passengerID)) {
    	            passengerToRemove = passenger;
    	            queueToRemoveFrom = mumbaiChicagoAlaskaFlights;
    	            passengerFound = true;
    	            break;
    	        }
    	    }
    	    for (Passenger passenger : puneAbuDhabiDubaiFlights) {
    	        if (passenger.id.equals(passengerID)) {
    	            passengerToRemove = passenger;
    	            queueToRemoveFrom = puneAbuDhabiDubaiFlights;
    	            passengerFound = true;
    	            break;
    	        }
    	    }

    	    if (passengerFound) {
    	        queueToRemoveFrom.remove(passengerToRemove);

    	        // Calculate the refund amount and reduce it by 15%
    	        double refundAmount = passengerToRemove.price-passengerToRemove.price * 0.15;
    	        System.out.println("Ticket for passenger with ID " + passengerID + " has been canceled.");
    	        System.out.println("Refund Amount: Rs " + refundAmount);

    	        // Adjust seat counters if the ticket was canceled
    	        if (passengerToRemove.flightType.equals("AIR ASIA")) {
    	            if (passengerToRemove.seatType.equals("BUSINESS")) {
    	                mumbaiChicagoAlaskaBusinessSeatCounter--;
    	            } else if (passengerToRemove.seatType.equals("ECONOMY")) {
    	                mumbaiChicagoAlaskaEconomySeatCounter--;
    	            }
    	        } else if (passengerToRemove.flightType.equals("AIR ARABIA")) {
    	            if (passengerToRemove.seatType.equals("BUSINESS")) {
    	                puneAbuDhabiDubaiBusinessSeatCounter--;
    	            } else if (passengerToRemove.seatType.equals("ECONOMY")) {
    	                puneAbuDhabiDubaiEconomySeatCounter--;
    	            }
    	        } else if (passengerToRemove.flightType.equals("AIR INDIA")) {
    	            if (passengerToRemove.seatType.equals("BUSINESS")) {
    	                mumbaiBangaloreBusinessSeatCounter--;
    	            } else if (passengerToRemove.seatType.equals("ECONOMY")) {
    	                mumbaiBangaloreEconomySeatCounter--;
    	            }
    	        } else if (passengerToRemove.flightType.equals("AIR INDIGO")) {
    	            if (passengerToRemove.seatType.equals("BUSINESS")) {
    	                puneDelhiBusinessSeatCounter--;
    	            } else if (passengerToRemove.seatType.equals("ECONOMY")) {
    	                puneDelhiEconomySeatCounter--;
    	            }
    	        }
    	    } else {
    	        System.out.println("Invalid passenger ID: No passenger found with ID " + passengerID + ". Ticket not canceled.");
    	    }
    	}
         // METHOD TO DISPLAY ALL BOOKED TICKETS:
    	public static void displayAllBookedTickets() {
    	    System.out.println("\n===== All Booked Tickets =====");
    	    if ( mumbaiBangaloreFlights.isEmpty() && puneDelhiFlights.isEmpty() && mumbaiChicagoAlaskaFlights.isEmpty() && puneAbuDhabiDubaiFlights.isEmpty()) {
    	        System.out.println("No tickets booked yet.");
    	    } else {
    	       
    	        System.out.println("\nMumbai-Bangalore Flights:");
    	        displayBookedTickets(mumbaiBangaloreFlights);
    	        System.out.println("===============================================================================");
                System.out.println("\nPune-Delhi Flights:");
    	        displayBookedTickets(puneDelhiFlights);
                System.out.println("================================================================================");
    	        System.out.println("\nMumbai-Chicago-Alaska Flights:");
    	        displayBookedTickets(mumbaiChicagoAlaskaFlights);
                System.out.println("================================================================================");
    	        System.out.println("\nPune-Abu Dhabi-Dubai Flights:");
    	        displayBookedTickets(puneAbuDhabiDubaiFlights);
    	        System.out.println("================================================================================");
    	    }
    	}

    	public static void displayBookedTickets(Queue<Passenger> flightQueue) {
    	    if (flightQueue.isEmpty()) {
    	        System.out.println("No tickets booked for this flight.");
    	    } else {
    	        for (Passenger passenger : flightQueue) {
    	            System.out.println("Name           : " + passenger.name);
    	            System.out.println("ID             : " + passenger.id);
    	            System.out.println("Flight Type    : " + passenger.flightType);
    	            System.out.println("Destination    : " + passenger.destination);
    	            System.out.println("Flight Timing  : " + passenger.flightTiming);
    	            System.out.println("Seat Type      : " + passenger.seatType);
    	            System.out.println("Seat Number    : " + passenger.seatNumber);
    	            System.out.println("Price          : Rs " + passenger.price);
    	            //System.out.println("---------------------------------------------------");
    	        }
    	    }
    	}
        // METHOD TO SEARCH A PERSON WITH GENERATED PASSENGER ID:
    	public static void searchPassengerByID() {
    	    Scanner scanner = new Scanner(System.in);
    	    System.out.print("Enter passenger ID to search: ");
    	    String passengerID = scanner.next();
    	    boolean found = false;
            Passenger foundPassenger = null;

    	    //  Mumbai-Bangalore Flights queue
    	    for (Passenger passenger : mumbaiBangaloreFlights) {
    	        if (passenger.id.equals(passengerID)) {
    	            foundPassenger = passenger;
    	            found = true;
    	            break;
    	        }}
    	    // If not found in Mumbai-Bangalore Flights, search in the Pune-Delhi Flights queue
    	    if (!found) {
    	        for (Passenger passenger : puneDelhiFlights) {
    	            if (passenger.id.equals(passengerID)) {
    	                foundPassenger = passenger;
    	                found = true;
    	                break;
    	            }}}
    	      // If not found in Pune-Delhi Flights, search in the Mumbai-Chicago-Alaska Flights queue
    	    if (!found) {
    	        for (Passenger passenger : mumbaiChicagoAlaskaFlights) {
    	            if (passenger.id.equals(passengerID)) {
    	                foundPassenger = passenger;
    	                found = true;
    	                break;
    	            }}}
    	    // If not found in Mumbai-Chicago-Alaska Flights, search in the Pune-Abu Dhabi-Dubai Flights queue
    	    if (!found) {
    	        for (Passenger passenger : puneAbuDhabiDubaiFlights) {
    	            if (passenger.id.equals(passengerID)) {
    	                foundPassenger = passenger;
    	                found = true;
    	                break;
    	            }}}
    	        if (found) {
    	        displayPassengerInfo(foundPassenger);
    	    } else {
    	        System.out.println("Passenger with ID " + passengerID + " not found.");
    	    }}
    	// DISPLAYING INFORMATION OF PASSENGER IF PASSENGER ID IS FOUND:
    	 private static void displayPassengerInfo(Passenger passenger) {
        System.out.println("Passenger found:");
        System.out.println("Name                  : " + passenger.name);
        System.out.println("ID                    : " + passenger.id);
        System.out.println("Flight Type           : " + passenger.flightType);
        System.out.println("Destination           : " + passenger.destination);
        System.out.println("Timing                : " + passenger.flightTiming);
        System.out.println("Seat Type             : " + passenger.seatType);
        System.out.println("Seat Number           : " + passenger.seatNumber);
        System.out.println("Price                 : Rs " + passenger.price);
    }}


