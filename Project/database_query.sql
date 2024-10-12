CREATE TABLE "Club" (
	"Club_name"	TEXT NOT NULL,
	"Con_phoneno"	TEXT NOT NULL,
	"Con_name"	TEXT NOT NULL,
	"Faculty_coordinator"	TEXT NOT NULL,
	"Club_description"	TEXT NOT NULL,
	PRIMARY KEY("Club_name")
);

CREATE TABLE "Details" (
	"D_Date"	Date NOT NULL,
	"Time"	TEXT NOT NULL UNIQUE,
	"S_name"	TEXT NOT NULL,
	"S_Contact"	TEXT NOT NULL,
	"Brief_description"	TEXT NOT NULL,
	"No_of_seats"	INT NOT NULL,
	"Duration"	TEXT NOT NULL,
	"Fees"	INT NOT NULL,
	"Event_no"	INT NOT NULL
);

CREATE TABLE "Event" (
	"Event_no"	INT NOT NULL,
	"C_name"	TEXT NOT NULL,
	"C_contact"	TEXT NOT NULL,
	"Event_name"	TEXT NOT NULL,
	"Building"	TEXT NOT NULL,
	"Club_name"	TEXT NOT NULL,
	PRIMARY KEY("Event_no")
);

CREATE TABLE "Payment" (
	"Transaction_id"	INT NOT NULL,
	"Card_number"	INT NOT NULL,
	"Registration_number"	TEXT NOT NULL,
	"Event_no"	INT NOT NULL,
	PRIMARY KEY("Card_number")
);

CREATE TABLE "Student" (
	"Registration_number"	TEXT NOT NULL,
	"First_name"	TEXT NOT NULL,
	"mid_Name"	TEXT NOT NULL,
	"Last_name"	TEXT NOT NULL,
	"Contact_Number"	TEXT NOT NULL,
	PRIMARY KEY("Registration_number")
);

CREATE TABLE "Student_Transactions_history" (
	"Transactions_history"	TEXT NOT NULL,
	"Registration_number"	TEXT NOT NULL,
	PRIMARY KEY("Transactions_history")
);

CREATE TABLE "Venue" (
	"Building"	TEXT NOT NULL,
	"Room_Number"	INT NOT NULL UNIQUE,
	PRIMARY KEY("Building")
);

CREATE TABLE "card" (
	"Card_number"	INT NOT NULL,
	"Expiry_date"	INT NOT NULL,
	"CW"	INT NOT NULL,
	"Name_on_card"	TEXT NOT NULL,
	"Reg_phno"	TEXT NOT NULL,
	"Registration_number"	TEXT NOT NULL,
	PRIMARY KEY("Card_number"),
	CONSTRAINT "Card_RN_Rel" FOREIGN KEY("Registration_number") REFERENCES "Student"
);

CREATE TABLE registered_for (
Registration_number TEXT NOT NULL, 
Event_no INT NOT NULL);