USE lab4;

#1. Display the schedule of all trips for a given StartLocationName and Destination Name, and Date. 
#	  In addition to these attributes, the schedule includes: Scheduled StartTime,  ScheduledArrivalTime , DriverID, and BusID.
-- "SELECT TO.ScheduledStartTime, TO.ScheduledArrivalTime, TO.DriverName, TO.BusID
-- FROM TripOffering TO, Trip T
-- WHERE T.StartLocationName = ' " + startLocationName + " ' AND T.DestinationName = ' " + DestinationName + " ' AND T.Date = ' " + date " '

#2. Edit the schedule i.e. edit the table of Trip Offering as follows:
		#a. Delete a trip offering specified by Trip#, Date, and ScheduledStartTime;
		#b. Add a set of trip offerings assuming the values of all attributes are given (the software asks if you have more trips to enter) ;
		#c. Change the driver for a given Trip offering (i.e given TripNumber, Date, ScheduledStartTime);
		#d. Change the bus for a given Trip offering.
DELETE FROM TripOffering
WHERE TripNumber = ' " +  tripNumber + " ' AND Date = ' " + date + " ' AND ScheduleStartTime = ' " + scheduleStartTime " ';

INSERT INTO TripOffering (TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime, DriverName, BusID)
VALUES
	("tripNumber", "date", "scheduledStartTime", "scheduledArrivalTime", "driverName, busID");
    
UPDATE TripOffering
SET DriverName = 'driverName'
WHERE TripNumber = 'tripNumber' AND Date = 'date' AND ScheduledStartTime = 'scheduledStartTime';

UPDATE TripOffering
SET TO.BusID = 'busID'
WHERE TripNumber = 'tripNumber' AND Date = 'date' AND ScheduledStartTime = 'scheduledStartTime'; 

#3. Display the stops of a given trip ( i.e. the attributes of the table TripStopInfo).
SELECT T.TripNumber, T.StopNumber, T.SequenceNumber, T.DrivingTime
FROM TripStopInfo T;


#4. Display the weekly schedule of a given driver and date.
SELECT TO.TripNumber, TO.Date, TO.ScheduledStartTime, TO.ScheduledArrivalTime, TO.DriverName, TO.BusID
FROM Driver D, TripOffering TO
WHERE TO.DriverName = 'driverName' AND TO.Date = 'date';

#5. Add a drive.
INSERT INTO Driver (DriverName, DriverTelephoneNumber)
VALUES
	("driverName", "driver", "driverTelephoneNumber");


#6. Add a bus.
INSERT INTO Bus (BusID, Model, Year)
VALUES
	("busID", "model", "year");

#7. Delete a bus.
DELETE FROM Bus B
WHERE B.BusID = 'busID';

#8. Record (insert) the actual data of a given trip offering specified by its key. 
#The actual data include the attributes of the table ActualTripStopInfo.
INSERT INTO ActualTripStopInfo (TripNumber, Date, ScheduledStartTime, StopNumber, ScheduledArrivalTime, ActualStartTime, ActualArrivalTime, NumberOfPassengerIn, NumberOfPassengerOut)
VALUES
	("tripNumber", "date", "scheduledStartTime", "stopNumber", "scheduledArrivalTime", "actualStartTime", "actualArrivalTime", "numberOfPassengerIn", "numberOfPassengerOut");




