#Insert Lab4 Data
USE lab4;

INSERT INTO Bus (BusID, Model, Year)
VALUES
	("Bus1", "Blue Bird", "2000"),
    ("Bus2", "Blue Bird", "2000"),
    ("Bus3", "Chance Coach", "2001"),
    ("Bus4", "Chance Coach", "2001"),
    ("Bus5", "General Coach", "2002"),
    ("Bus6", "General Coach", "2002"),
    ("Bus7", "Astra Bus", "2003"),
    ("Bus8", "Astra Bus", "2003"),
    ("Bus9", "Express Coach", "2004"),
    ("Bus10", "Express Coach", "2004");
    
INSERT INTO Driver (DriverName, DriverTelephoneNumber)
VALUES
	("Driver1", "(909) 123-4561"),
    ("Driver2", "(909) 123-4562"),
    ("Driver3", "(909) 123-4563"),
    ("Driver4", "(909) 123-4564"),
    ("Driver5", "(909) 123-4565"),
    ("Driver6", "(909) 123-4566"),
    ("Driver7", "(909) 123-4567"),
    ("Driver8", "(909) 123-4568"),
    ("Driver9", "(909) 123-4569"),
    ("Driver10", "(909) 123-4560");
    
INSERT INTO TripOffering (TripNumber, Date, ScheduledStartTime, ScheduledArrivalTime, DriverName, BusID)
VALUES
	("Trip1", "1-1-2001", "MON 10:00AM", "MON 1:00PM", "Driver1", "Bus1"),
    ("Trip2", "1-2-2001", "TUE 10:00AM", "TUE 2:45PM", "Driver2", "Bus2"),
    ("Trip3", "1-3-2001", "WED 10:00AM", "WED 5:00PM", "Driver3", "Bus3"),
    ("Trip4", "1-4-2001", "TH 10:00AM", "TH 7:30PM", "Driver4", "Bus4"),
    ("Trip5", "1-5-2001", "FRI 10:00AM", "FRI 12:00PM", "Driver5", "Bus5"),
    ("Trip6", "1-6-2001", "FRI 10:00AM", "FRI 9:00PM", "Driver6", "Bus6"),
    ("Trip7", "1-7-2001", "SAT 10:00AM", "SAT 6:30PM", "Driver7", "Bus7"),
    ("Trip8", "1-8-2001", "SAT 10:00AM", "SAT 4:00PM", "Driver8", "Bus8"),
    ("Trip9", "1-9-2001", "SUN 10:00AM", "SUN 11:00PM", "Driver9", "Bus9"),
    ("Trip10", "1-10-2001", "SUN 10:00AM", "SUN 10:30PM", "Driver10", "Bus10");
    
INSERT INTO Trip (TripNumber, StartLocationName, DestinationName)
VALUES
	("Trip1", "Pomona", "Walnut"),
    ("Trip2", "Pomona", "Brea"),
    ("Trip3", "Pomona", "Ontario"),
    ("Trip4", "Pomona", "Los Angeles"),
    ("Trip5", "Pomona", "West Covina"),
    ("Trip6", "Pomona", "Lancaster"),
    ("Trip7", "Pomona", "Pasadena"),
    ("Trip8", "Pomona", "Irvine"),
    ("Trip9", "Pomona", "Santa Barbara"),
    ("Trip10", "Pomona", "San Diego");
    
INSERT INTO Stop (StopNumber, StopAddress)
VALUES
	("Stop1", "100 Grand Ave"),
    ("Stop2", "200  Lambert St"),
    ("Stop3", "300 Foothill Ave"),
    ("Stop4", "400 Cesar Chavez"),
    ("Stop5", "500 Cameron Ave"),
    ("Stop6", "600 Grove Dr"),
    ("Stop7", "700 Colorado Ave"),
    ("Stop8", "800 Tustin St"),
    ("Stop9", "900 Beach Lane"),
    ("Stop10", "110 La Jolla St");
    
INSERT INTO ActualTripStopInfo (TripNumber, Date, ScheduledStartTime, StopNumber, ScheduledArrivalTime, ActualStartTime, ActualArrivalTime, NumberOfPassengerIn, NumberOfPassengerOut)
VALUES	
    ("Trip1", "1-1-2001", "MON 10:00AM", "Stop1", "MON 1:00PM", "MON 10:30AM", "MON 2:00PM", "10", "10"),
    ("Trip2", "1-2-2001", "TUE 10:00AM", "Stop2", "TUE 2:45PM", "TUE 10:00AM", "TUE 2:30PM", "15", "7"),
    ("Trip3", "1-3-2001", "WED 10:00AM", "Stop3", "WED 5:00PM", "WED 10:45AM", "WED 6:00PM", "20", "18"),
    ("Trip4", "1-4-2001", "TH 10:00AM", "Stop4", "TH 7:30PM", "TH 10:10AM", "TH 7:45PM", "13", "10"),
    ("Trip5", "1-5-2001", "FRI 10:00AM", "Stop5", "FRI 12:00PM", "FRI 11:30AM", "FRI 2:00PM", "9", "9"),
    ("Trip6", "1-6-2001", "FRI 10:00AM", "Stop6", "FRI 9:00PM", "FRI 10:00AM", "FRI 9:00PM", "22", "16"),
    ("Trip7", "1-7-2001", "SAT 10:00AM", "Stop7", "SAT 6:30PM", "SAT 10:20AM", "SAT 7:00PM", "7", "4"),
    ("Trip8", "1-8-2001", "SAT 10:00AM", "Stop8", "SAT 4:00PM", "SAT 10:50AM", "SAT 5:00PM", "19", "14"),
    ("Trip9", "1-9-2001", "SUN 10:00AM", "Stop9", "SUN 11:00PM", "SUN 10:55AM", "SUN 12:30AM", "30", "21"),
    ("Trip10", "1-10-2001", "SUN 10:00AM", "Stop10", "SUN 10:30PM", "SUN 10:15AM", "SUN 10:55PM", "25", "18");
    
INSERT INTO TripStopInfo(TripNumber, StopNumber, SequenceNumber, DrivingTime)
VALUES
	("Trip1", "Stop1", "Sequence1", "200 Minutes"),
    ("Trip2", "Stop2", "Sequence2", "300 Minutes"),
    ("Trip3", "Stop3", "Sequence3", "400 Minutes"),
    ("Trip4", "Stop4", "Sequence4", "500 Minutes"),
    ("Trip5", "Stop5", "Sequence5", "250 Minutes"),
    ("Trip6", "Stop6", "Sequence6", "350 Minutes"),
    ("Trip7", "Stop7", "Sequence7", "450 Minutes"),
    ("Trip8", "Stop8", "Sequence8", "550 Minutes"),
    ("Trip9", "Stop9", "Sequence9", "260 Minutes"),
    ("Trip10", "Stop10", "Sequence10", "360 Minutes");
    
    