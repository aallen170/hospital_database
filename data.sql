delete from contract;
delete from sell;
delete from prescription;
delete from make_drug;
delete from pri_phy_patient;
delete from pharm_co;
delete from pharmacy;
delete from doctor;

INSERT INTO Doctor
VALUES('156188', 'Dr. Doctor', 'Doctorism', '12');
INSERT INTO Doctor 
VALUES('4354354', 'Dr. Man', 'Legs', '1');
INSERT INTO Doctor 
VALUES('453543', 'Dr. Woman', 'Arms', '5');
INSERT INTO Doctor 
VALUES('338738', 'Dr. Jim', 'Eyes', '2');
INSERT INTO Doctor 
VALUES('31387', 'Dr. Kelly', 'Noses', '45');
INSERT INTO Doctor 
VALUES('39876', 'Dr. Drake', 'Ears', '3');
INSERT INTO Doctor 
VALUES('54687', 'Dr. Blake', 'Mouths', '18');
INSERT INTO Doctor 
VALUES('345348', 'Dr. Break', 'Belly Buttons', '28');
INSERT INTO Doctor 
VALUES('3873786', 'Dr. Make', 'Toenails', '54');
INSERT INTO Doctor 
VALUES('31232137', 'Dr. Take', 'Eyelashes', '122');

INSERT INTO Pharmacy 
VALUES('1564563', 'Pharmaceutical Pharmacy', '100 Pharmacy Lane, Pharmacyville, IL', '1-800-532-6567');
INSERT INTO Pharmacy 
VALUES('43242314', 'My Dad"s Pharmacy', '505 Dad Rd, Dadville, CA', '1-800-567-8721');
INSERT INTO Pharmacy 
VALUES('654376456', 'Greenwalls', '55 Greenery Place, Greenville, SC', '1-800-789-2789');
INSERT INTO Pharmacy 
VALUES('76548654', 'SVC', '7898 VCS Rd, Acronym, WA', '1-800-676-4213');
INSERT INTO Pharmacy 
VALUES('1234231', 'Drugs Deluxe', '252 Drugs Ave, Deluxe, FL', '1-800-987-1243');
INSERT INTO Pharmacy 
VALUES('764547', 'I Love Drugs', '68 Love Lane, Drudgery, NC', '1-800-678-6859');
INSERT INTO Pharmacy 
VALUES('6543665', 'Definitely Legal Drugs', '888 Big Pharma Dr, Conspiracy, MI', '1-800-911-6572');
INSERT INTO Pharmacy 
VALUES('98769789', 'One Stop Drug Shop', '999 Default Ave, Normal, IL', '1-800-123-4567');
INSERT INTO Pharmacy 
VALUES('8768687', 'The Good Stuff', '342 Good Place, Satisfaction, MA', '1-800-258-7598');
INSERT INTO Pharmacy 
VALUES('2345464', 'Better Than Your Dealer', '222 Sus Ave, Careful, HI', '1-800-456-8797');
INSERT INTO Pharmacy 
VALUES('98769998', 'iSell Drugs', '1337 Nerd Rd, Lame, WI', '1-800-666-6969');

INSERT INTO Pharm_co
VALUES('4M', '1-800-567-3541');
INSERT INTO Pharm_co 
VALUES('Johnny & Johnny', '1-800-456-8792');
INSERT INTO Pharm_co
VALUES('Super Drugs', '1-800-987-3245');
INSERT INTO Pharm_co
VALUES('We Love Drugs', '1-800-321-6547');
INSERT INTO Pharm_co
VALUES('Drugs 4 Life', '1-800-537-8521');
INSERT INTO Pharm_co
VALUES('Drugs R Us', '1-800-678-9823');
INSERT INTO Pharm_co
VALUES('Drugs on Demand', '1-800-369-4227');
INSERT INTO Pharm_co
VALUES('Drugs Drugs Drugs!', '1-800-212-1212');
INSERT INTO Pharm_co
VALUES('pharm_co_name', '1-800-357-9512');
INSERT INTO Pharm_co
VALUES('idk', '1-800-578-6385');

INSERT INTO Pri_Phy_Patient
VALUES('1234597', 'Patty', '1994-02-23', '331 Patterson Dr, Pattington, IL', '156188');
INSERT INTO Pri_Phy_Patient
VALUES('4321432', 'Patrick', '1990-05-16', '654 Patrickson Lane, Patton, CO', '4354354');
INSERT INTO Pri_Phy_Patient
VALUES('653453', 'Pamela', '1985-07-28', '432 Pammerson Rd, Pammington, OR', '453543');
INSERT INTO Pri_Phy_Patient
VALUES('85687655', 'Peter', '1996-10-15', '123 Peterson Ave, Petertown, WA', '338738');
INSERT INTO Pri_Phy_Patient
VALUES('65353434', 'Paige', '2001-12-05', '654 Pager Rd, Pagington, VA', '31387');
INSERT INTO Pri_Phy_Patient
VALUES('09870798', 'Phoebe', '1971-04-17', '285 Phoberson Dr, Phobington, GA', '39876');
INSERT INTO Pri_Phy_Patient
VALUES('45366345', 'Pablo', '1956-01-31', '789 Pablonson Ave, Pablington, CA', '54687');
INSERT INTO Pri_Phy_Patient
VALUES('3456555', 'Parker', '1978-08-08', '369 Parkinson Rd, Parkington, MA', '345348');
INSERT INTO Pri_Phy_Patient
VALUES('234543654', 'Paul', '1945-03-30', '445 Paulerson Lane, Paulington, WI', '3873786');
INSERT INTO Pri_Phy_Patient
VALUES('765475647', 'Pearl', '1977-09-29', '159 Pearl Dr, Pearl, FL', '31232137');

INSERT INTO Make_Drug
VALUES('Madvil', '4M', 'C13H18O2');
INSERT INTO Make_Drug
VALUES('Pylenol', 'Johnny & Johnny', 'C8H9NO2');
INSERT INTO Make_Drug
VALUES('Flaritin', 'Super Drugs', 'C22H23ClN2O2');
INSERT INTO Make_Drug
VALUES('Vasacort', 'We Love Drugs', 'C24H31FO6');
INSERT INTO Make_Drug
VALUES('Baleve', 'Drugs 4 Life', 'C14H14O3');
INSERT INTO Make_Drug
VALUES('Tulcolax', 'Drugs R Us', 'C22H19NO4');
INSERT INTO Make_Drug
VALUES('Korajel', 'Drugs On Demand', 'C9H11NO2');
INSERT INTO Make_Drug
VALUES('Bepto-Pismol', 'Drugs Drugs Drugs!', 'C7H6BiO4');
INSERT INTO Make_Drug
VALUES('Jantac', 'pharm_co_name', 'C13H22N4O3S');
INSERT INTO Make_Drug
VALUES('Madvil', 'idk', 'C46H55ClN6O9');

INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('456489', 'ready', '1234597', '156188', '2017-05-15', '30', 'Madvil', '4M');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('545614', 'canceled', '1234597', '4354354', '2017-06-21', '20', 'Pylenol', 'Johnny & Johnny');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('156462', 'pending', '1234597', '453543', '2017-03-14', '15', 'Flaritin', 'Super Drugs');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('23489', 'pending', '85687655', '338738', '2017-02-01', '50', 'Vasacort', 'We Love Drugs');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('18978', 'completed', '65353434', '31387', '2017-09-30', '40', 'Baleve', 'Drugs 4 Life');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('4597847', 'canceled', '09870798', '39876', '2016-12-25', '10', 'Tulcolax', 'Drugs R Us');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('289489', 'ready', '45366345', '54687', '2017-08-05', '80', 'Korajel', 'Drugs On Demand');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('879456', 'pending', '3456555', '345348', '2017-10-20', '30', 'Bepto-Pismol', 'Drugs Drugs Drugs!');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('89751', 'completed', '234543654', '3873786', '2017-09-02', '60', 'Jantac', 'pharm_co_name');
INSERT INTO Prescription (pre_id, status, ssn, phy_ssn, pre_date, quantity, trade_name, pharm_co_name)
VALUES('489475', 'ready', '765475647', '31232137', '2017-11-26', '15', 'Madvil', 'idk');

INSERT INTO Sell
VALUES('50', '43242314', 'Madvil', '4M');
INSERT INTO Sell
VALUES('75', '1564563', 'Madvil', '4M');
INSERT INTO Sell
VALUES('30', '654376456', 'Madvil', '4M');
INSERT INTO Sell
VALUES('100', '76548654', 'Madvil', '4M');
INSERT INTO Sell
VALUES('150', '1234231', 'Madvil', '4M');
INSERT INTO Sell
VALUES('20', '764547', 'Madvil', '4M');
INSERT INTO Sell
VALUES('300', '6543665', 'Madvil', '4M');
INSERT INTO Sell
VALUES('10', '98769789', 'Madvil', '4M');
INSERT INTO Sell
VALUES('180', '8768687', 'Madvil', '4M');
INSERT INTO Sell
VALUES('120', '2345464', 'Madvil', 'idk');
INSERT INTO Sell
VALUES('200', '98769998', 'Madvil', '4M');
INSERT INTO Sell
VALUES('250', '8768687', 'Flaritin', 'Super Drugs');

INSERT INTO Contract
VALUES('1564563', '2-25-2017', '5-30-2019', 'This is a contract.', 'Sammy', '4M');
INSERT INTO Contract
VALUES('43242314', '8-10-2017', '7-15-2019', 'Wow! It"s a contract!', 'Sarah', 'Johnny & Johnny');
INSERT INTO Contract
VALUES('654376456', '3-5-2017', '7-22-2019', 'OwO what"s this?', 'Scooter', 'Super Drugs');
INSERT INTO Contract
VALUES('76548654', '6-18-2017', '4-29-2019', 'Contract.', 'Sally', 'We Love Drugs');
INSERT INTO Contract
VALUES('1234231', '1-1-2017', '12-31-2019', 'gimmie more drugs pls', 'Scotty', 'Drugs 4 Life');
INSERT INTO Contract
VALUES('764547', '2-25-2017', '5-30-2019', 'hi (sorry for bad english)', 'Saad', 'Drugs On Demand');
INSERT INTO Contract
VALUES('6543665', '9-11-2017', '7-17-2019', 'hey could you pay me back for the pizza we got a week ago thanks', 'Steven', 'Drugs Drugs Drugs!');
INSERT INTO Contract
VALUES('98769789', '6-26-2017', '2-12-2019', 'Sample Text', 'Simon', 'Drugs R Us');
INSERT INTO Contract
VALUES('8768687', '3-30-2017', '8-28-2019', 'To be fair, you have to have a very high IQ to understand Rick and Morty.', 'Sebastian', 'pharm_co_name');
INSERT INTO Contract
VALUES('2345464', '7-27-2017', '5-25-2019', 'where my money', 'Sage', '4M');