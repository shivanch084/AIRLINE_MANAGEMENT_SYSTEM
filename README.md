🧾 Project Description
The Airline Management System is a desktop-based Java application designed to automate core airline operations such as passenger registration, flight scheduling, and ticket reservations.
Developed using Java Swing for the graphical user interface and MySQL for data storage, the system enables seamless management of passenger and flight data in a structured and user-friendly manner.

This project allows airline staff to perform essential functions including adding new flights, registering customers, booking and canceling tickets, and viewing journey details. 
It eliminates the need for manual paperwork by maintaining digital records for all reservations and travelers. The system ensures accurate data storage and retrieval, supporting 
a more efficient and error-free process.

It focuses on three major modules:

Airlines & Flights

Employees/Admin

Customers/Passengers

Each module interacts with a central MySQL database, using JDBC for connectivity. The application is built in NetBeans IDE, following a modular, object-oriented design.
With a responsive and intuitive Swing-based UI, the system provides a real-time operational interface ideal for small-scale airline management or educational purposes.


## 🔍 Screenshot
-- LOGIN PAGE
Username - admin
Password - admin
![image](https://github.com/user-attachments/assets/62e945f9-2730-424e-89c3-d75bd26df6ba)


-- HOME PAGE
![image](https://github.com/user-attachments/assets/405df560-83d9-4d04-8086-5093ff20c200)

-- FLIGHT DETAILS
![image](https://github.com/user-attachments/assets/37adc076-2555-4ace-92fe-db0ea0b1686d)


-- ADD CUSTOMER DETAILS
![image](https://github.com/user-attachments/assets/10c3e5ea-2b8c-4abd-8bbd-076a0c8873b8)


-- BOOKING FLIGHT BUT BEFORE CHEKING FOR VALID USER FROM AADHAR NUMBER
![image](https://github.com/user-attachments/assets/2e77395d-4974-4497-9922-cb1fc8b91310)

-- FETCHING PNR STATUS FROM PNR NUMBER
![image](https://github.com/user-attachments/assets/b4d99bd0-6d55-41f7-b134-4d9b58f75e00)


-- GENERATING BOARDING PASS FROM PNR NUMBER
![image](https://github.com/user-attachments/assets/a26b5e7f-6b7a-4e11-80ec-d61463deb7f4)


If the user wants to cancel a ticket, they can do so from the 'Cancel Ticket' section.

![image](https://github.com/user-attachments/assets/03ef2a40-6cdd-4df0-a8f6-7f71bdd09ea7)

First, we will fetch the ticket details using the PNR number. If the ticket is booked, it will display the user's name and information; otherwise, a popup will show 'Invalid PNR number
once onr get confirm then user can cancel their ticket








