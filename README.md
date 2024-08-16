# Airline-Ticket-Booking-System

Project Details:

The provided Java program, "AirlineTicketSystem," is an Airline Reservation System that allows users to book, display, search, and cancel flight tickets for different airline routes. The program maintains passenger information, such as name, ID, flight type, destination, flight timing, seat type, seat number, and price. It uses queues to manage passenger bookings for four different airline routes and two seat classes: Business and Economy.


Key Features:

1.Booking Tickets:
The program allows users to book flight tickets by entering their details, including name, flight name, and seat type (Business or Economy).
Depending on the selected flight and seat type, the program assigns a seat number and calculates the ticket price.
It manages seat availability for different flights and classes, preventing overbooking.

2.Displaying Booked Tickets:
Users can view the details of all booked tickets for different flights and classes.
The program organizes the ticket information by flight, displaying passenger details, seat number, and price.
Searching for Passengers by ID:
Users can search for a specific passenger's information using their unique system-generated ID.
The program searches for the passenger across all flights and classes and displays their details when found.

3.Cancelling Tickets:
Users can cancel a booked ticket by providing the passenger's ID.
The program calculates and displays a refund amount (15% of the ticket price) and adjusts the seat counters accordingly.

4.Flight Information Menu:
The program displays detailed flight information, including flight type, flight name, destination, timing, seat availability (Business and Economy), and ticket prices.
Queue-Based Management:
The program uses separate queues to manage bookings for four different flight routes: Mumbai-Bangalore, Pune-Delhi, Mumbai-Chicago-Alaska, and Pune-Abu Dhabi-Dubai.
It tracks seat availability and assigns seat numbers based on the selected flight and seat type.



Data Structures Used:

Queue<Passenger>:

The Queue data structure is a linear collection of elements that follows the First-In-First-Out (FIFO) principle. In Java, it is part of the Java Collections Framework.
In the program, there are four different Queue<Passenger> instances, each representing a specific flight route and its associated passenger bookings. These queues are:
mumbaiBangaloreFlights: Queue for passengers on the Mumbai-Bangalore route.
puneDelhiFlights: Queue for passengers on the Pune-Delhi route.
mumbaiChicagoAlaskaFlights: Queue for passengers on the Mumbai-Chicago-Alaska route.
puneAbuDhabiDubaiFlights: Queue for passengers on the Pune-Abu Dhabi-Dubai route.
These queues are used to store Passenger objects for each flight route and seat class (Business or Economy). Passengers are enqueued when they book tickets and dequeued when their tickets are canceled.


Project Structure:

Helper Methods:
The class contains several helper methods that perform specific tasks and functionalities:
a. menu():
This method displays a detailed menu that provides information about flight options, destinations, timings, seat availability, and ticket prices. It serves as a guide for users to make informed decisions when booking tickets.
b. bookTicket(Scanner scanner):
This method allows users to book flight tickets. Users provide their details, and the program assigns them a unique ID, seat number, and calculates the ticket price based on the selected flight and seat type (Business or Economy).
c. cancelTicket(Scanner scanner):
Users can cancel a booked ticket by providing their passenger ID. The method searches for the passenger across all flight queues, removes the booking, calculates a refund amount (15% of the ticket price), and adjusts seat counters.
d. displayAllBookedTickets():
This method displays the details of all booked tickets, organized by flight and class. It iterates through all flight queues and passengers to display the information.
e. displayBookedTickets(Queue<Passenger> flightQueue):
A sub-method used to display booked tickets for a specific flight queue (flight and class). It iterates through passengers within the specified queue.
f. searchPassengerByID():
This method allows users to search for a passenger by providing their unique system-generated ID. It searches for the passenger across all flight queues and displays their details if found.
g. displayPassengerInfo(Passenger passenger):
This sub-method is used to display the information of a found passenger. It prints the passenger's attributes, including name, ID, flight details, seat information, and price.

Time Complexity of Methods:
1.bookTicket(Scanner scanner):
Time Complexity: O(1)
The time complexity for booking a ticket is constant because the operations performed (e.g., seat assignment, adding to the queue, and price calculation) do not depend on the number of existing passengers.

2.cancelTicket(Scanner scanner):
Time Complexity: O(N)
The time complexity for canceling a ticket is linear, where N is the total number of passengers. The method searches for a specific passenger in each of the four flight queues, and the time complexity depends on the total number of passengers.

3.displayAllBookedTickets():
Time Complexity: O(N)
The time complexity for displaying all booked tickets is linear, as it iterates through all passengers across different flights and classes.

4.displayBookedTickets(Queue<Passenger> flightQueue):
Time Complexity: O(M), where M is the number of passengers in the given flight queue.
The time complexity for displaying booked tickets for a specific flight queue is linear, as it iterates through the passengers in that queue.

5.searchPassengerByID():
Time Complexity: O(N)
The time complexity for searching a passenger by their ID is linear because it searches for the passenger in all flight queues, and the time complexity depends on the total number of passengers.

6.displayPassengerInfo(Passenger passenger):
Time Complexity: O(1)
Displaying passenger information for a found passenger has a constant time complexity, as it involves printing the passenger's attributes.

