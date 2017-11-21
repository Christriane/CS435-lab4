DROP DATABASE lab4;
CREATE DATABASE lab4;
USE lab4;

CREATE TABLE Bus (
    BusID VARCHAR(18),
	Model VARCHAR(18),
    Year VARCHAR(18),
    PRIMARY KEY (BusID)
);

CREATE TABLE Driver (
    DriverName VARCHAR(18),
    DriverTelephoneNumber VARCHAR(18),
    PRIMARY KEY (DriverName)
);

CREATE TABLE TripOffering (
	TripNumber VARCHAR(18),
    Date VARCHAR(18),
    ScheduledStartTime VARCHAR(18),
	ScheduledArrivalTime VARCHAR(18),
    DriverName VARCHAR(18),
    BusID VARCHAR(18),
	PRIMARY KEY(Date, ScheduledStartTime, TripNumber),
    FOREIGN KEY(BusID) REFERENCES Bus(BusID)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(DriverName) REFERENCES Driver(DriverName)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Trip (
	TripNumber VARCHAR(18) PRIMARY KEY,
    StartLocationName VARCHAR(18),
    DestinationName VARCHAR(18)
);

CREATE TABLE Stop (
	StopNumber VARCHAR(18) PRIMARY KEY,
	StopAddress VARCHAR(18)
);

CREATE TABLE ActualTripStopInfo (
	TripNumber VARCHAR(18),
    Date VARCHAR(18),
    ScheduledStartTime VARCHAR(18),
    StopNumber VARCHAR(18),
    ScheduledArrivalTime VARCHAR(18),
    ActualStartTime VARCHAR(18),
    ActualArrivalTime VARCHAR(18),
    NumberofPassengerIn VARCHAR(18),
    NumberofPassengerOut VARCHAR(18),
    PRIMARY KEY(StopNumber, Date, ScheduledStartTime, TripNumber),
	FOREIGN KEY(Date, ScheduledStartTime, TripNumber) REFERENCES TripOffering(Date, ScheduledStartTime, TripNumber)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(StopNumber) REFERENCES Stop(StopNumber)
		ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE TripStopInfo (
    TripNumber VARCHAR(18),
    StopNumber VARCHAR(18),
	SequenceNumber VARCHAR(18),
    DrivingTime VARCHAR(18),
    PRIMARY KEY(StopNumber, TripNumber),
	FOREIGN KEY(StopNumber) REFERENCES Stop(StopNumber)
		ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(TripNumber) REFERENCES Trip(TripNumber)
		ON DELETE CASCADE ON UPDATE CASCADE
);


