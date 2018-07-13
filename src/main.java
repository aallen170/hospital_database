import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class main {
	
	static String url = "jdbc:mysql://localhost:3306/cs430_project2"
			+ "?autoReconnect=true&useSSL=false&"
			+ "zeroDateTimeBehavior=convertToNull";
	static String user = "root";
	static String pass = "qqqqq";
	static String selectDoctor = "select * from doctor";
	static String selectPharm = "select * from pharmacy";
	static String selectPharmCo = "select * from pharm_co";
	static String selectPatient = "select * from pri_phy_patient";
	static String selectDrug = "select * from make_drug";
	static String selectPresc = "select * from prescription";
	static String selectContract = "select * from contract";
	static String selectSell = "select * from sell";
	
	/*public boolean compareThroughColumn(
	 * String s, ResultSet RS, String column) {
		boolean result = false;
		try {
			while (RS.next()) {
				if (s == RS.getString(column)) {
					result = true;
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}*/
	
	public static String getPatientNames() {
		String output = "";
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectPatient);
			
			patientRS.beforeFirst();
			while (patientRS.next()) {
				output += "Patient name: " + patientRS.getString(
						"name") + System.lineSeparator();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static Vector<String> getPatients() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectPatient);
			
			int count = 0;
			while(patientRS.next()) {
				count++;
				String str = "Patient #" + count + ":\n"
						+ "SSN: " + patientRS.getString("ssn")
						+ "\n"
						+ "Name: " + patientRS.getString("name")
						+ "\n"
						+ "Birth date: " + patientRS.getString(
								"birth_date") + "\n"
						+ "Address: " + patientRS.getString(
								"address") + "\n"
						+ "Physician SSN: " + patientRS.getString(
								"phy_ssn") + "\n"
						+ "-----------------------"
						+ "----------------------" + "\n";
				output.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Vector<String> getPresc() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement prescStat = myConn.createStatement();
			
			ResultSet prescRS = prescStat.executeQuery(
					selectPresc);
			
			int count = 0;
			while(prescRS.next()) {
				count++;
				String str = "Prescription #" + count + ":\n"
						+ "pre_id: " + prescRS.getString("pre_id")
						+ "\n"
						+ "status: " + prescRS.getString("status")
						+ "\n"
						+ "ssn: " + prescRS.getString(
								"ssn") + "\n"
						+ "phy_ssn: " + prescRS.getString(
								"phy_ssn") + "\n"
						+ "pre_date: " + prescRS.getString(
								"pre_date") + "\n"
						+ "quantity: " + prescRS.getString(
								"quantity") + "\n"
						+ "trade_name: " + prescRS.getString(
								"trade_name") + "\n"
						+ "pharm_co_name: " + prescRS.getString(
								"pharm_co_name") + "\n"
						+ "-----------------------"
						+ "----------------------" + "\n";
				output.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Vector<String> getDoctors() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectDoctor);
			
			int count = 0;
			while(patientRS.next()) {
				count++;
				String str = "Doctor #" + count + ":\n"
						+ "SSN: " + patientRS.getString("ssn")
						+ "\n"
						+ "Name: " + patientRS.getString("name")
						+ "\n"
						+ "Speciality: " + patientRS.getString(
								"specialty") + "\n"
						+ "exp: " + patientRS.getString(
								"yearsOfExperience") + "\n"
						+ "-----------------------"
						+ "----------------------" + "\n";
				output.add(str);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Vector<String> getPatientSSNs() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectPatient);
			
			while(patientRS.next())
				output.add(patientRS.getString("ssn"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Vector<String> getPrescIDs() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement prescStat = myConn.createStatement();
			
			ResultSet prescRS = prescStat.executeQuery(
					selectPresc);
			
			while(prescRS.next())
				output.add(prescRS.getString("pre_id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static Vector<String> getDoctorSSNs() {
		Vector<String> output = new Vector<String>();
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectDoctor);
			
			while(patientRS.next())
				output.add(patientRS.getString("ssn"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public void getDoctorNames() {
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement doctorStat = myConn.createStatement();
			
			ResultSet doctorRS = doctorStat.executeQuery(
					selectDoctor);
			
			doctorRS.beforeFirst();
			while (doctorRS.next()) {
				System.out.println("Doctor name: "
			+ doctorRS.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getPrescNames() {
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement prescStat = myConn.createStatement();
			
			ResultSet prescRS = prescStat.executeQuery(
					selectPresc);
			
			prescRS.beforeFirst();
			while (prescRS.next()) {
				System.out.println("Prescription phy_ssn: "
			+ prescRS.getString("phy_ssn"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String getPatientPresc() {
		String output = "";
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			Statement prescStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectPatient);
			ResultSet prescRS = prescStat.executeQuery(selectPresc);
			
			patientRS.beforeFirst();
			while (patientRS.next()) {
				output += "Patient name: "
			+ patientRS.getString("name") + "\n";
				
				prescRS.beforeFirst();
				while (prescRS.next()) {
					if(prescRS.getString("ssn") != null) {
						if (patientRS.getString("ssn").equals(
								prescRS.getString("ssn"))) {
							output += "Patient prescription: "
							+ prescRS.getString("trade_name") + "\n";
							break;
						}
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static String getPrescStatus(String name, String bday) {
		String output = "";
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			String patientSSNQuery = "select ssn "
					+ "from pri_phy_patient "
					+ "where name = '" + name + "';";
			String patientSSNQuery2 = "select ssn "
					+ "from pri_phy_patient "
					+ "where birth_date = '" + bday + "';";
			
			Statement patientSSNStat = myConn.createStatement();
			Statement patientSSNStat2 = myConn.createStatement();
			Statement prescStat = myConn.createStatement();
			
			ResultSet patientSSNRS = patientSSNStat.executeQuery(
					patientSSNQuery);
			ResultSet patientSSNRS2 = patientSSNStat2.executeQuery(
					patientSSNQuery2);
			//ResultSet patientRS = patientStat.executeQuery(
					//selectPatient);
			ResultSet prescRS = prescStat.executeQuery(selectPresc);
			
			if(patientSSNRS.next()) {
				String ssn = patientSSNRS.getString("ssn");
				while(prescRS.next()) {
					if(prescRS.getString("ssn").equalsIgnoreCase(ssn))
						output += "Drop-off time: "
								+ prescRS.getTimestamp(
										"drop_off_time")
								+ "\n" + "Pick-up time: "
								+ prescRS.getTimestamp("pick_up_time")
								+ "\n" + "Status: "
								+ prescRS.getString("status") + "\n";
				}
			} else if(patientSSNRS2.next()) {
				String ssn2 = patientSSNRS2.getString("ssn");
				while(prescRS.next()) {
					if(prescRS.getString("ssn").equalsIgnoreCase(
							ssn2))
						output += "Drop-off time: "
								+ prescRS.getTimestamp(
										"drop_off_time")
								+ "\n" + "Pick-up time: "
								+ prescRS.getTimestamp("pick_up_time")
								+ "\n" + "Status: "
								+ prescRS.getString("status") + "\n";
				}
			}
			
			/*patientRS.beforeFirst();
			while (patientRS.next()) {
				System.out.println("Patient name: "
			+ patientRS.getString("name"));
				
				prescRS.beforeFirst();
				while (prescRS.next()) {
					if((patientRS.getString("ssn") != null) &&
							(prescRS.getString("ssn") != null)) {
						if (patientRS.getString("ssn").equals(
								prescRS.getString("ssn"))) {
							System.out.println(
									"Patient prescription: "
							+ prescRS.getString("trade_name"));
							System.out.println(
									"Drop-off time: "
							+ prescRS.getString("drop_off_time"));
							System.out.println(
									"Pick-up time: "
							+ prescRS.getString("pick_up_time"));
							System.out.println(
									"Status: "
							+ prescRS.getString("status"));
							break;
						}
					}
				}
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public static boolean insertPatient(String ssn, String name, String age, 
			String address, String phy_ssn) {
		boolean success = false;
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			
			String insert = "insert into pri_phy_patient "
					+ "values('" + ssn + "', '" + name + "', '"
					+ age + "', '" + address + "', '"
					+ phy_ssn + "');";
			
			patientStat.executeUpdate(insert);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean insertPresc(String pre_id, String status, 
			String ssn, String phy_ssn, String pre_date, 
			String quantity, String trade_name, 
			String pharm_co_name) {
		boolean success = false;
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement prescStat = myConn.createStatement();
			
			String insert = "insert into prescription (pre_id, "
					+ "status, ssn, phy_ssn, pre_date, quantity, "
					+ "trade_name, pharm_co_name) "
					+ "values('" + pre_id + "', '" + status + "', '"
					+ ssn + "', '" + phy_ssn + "', '" 
					+ pre_date + "', '" + quantity +  "', '"
					+ trade_name + "', '" + pharm_co_name + "');";
			
			prescStat.executeUpdate(insert);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean insertDoctor(String ssn, String name, 
			String specialty, String exp) {
		boolean success = false;
		try {
			
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement doctorStat = myConn.createStatement();
			
			String insert = "insert into doctor "
					+ "values('" + ssn + "', '" + name + "', '"
					+ specialty + "', '" + exp + "');";
			
			doctorStat.executeUpdate(insert);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean deletePatient(String ssn) {
		boolean success = false;
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement patientStat = myConn.createStatement();
			Statement prescStat = myConn.createStatement();
			
			ResultSet prescRS = prescStat.executeQuery(selectPresc);
			
			prescRS.beforeFirst();
			while(prescRS.next()) {
				if(prescRS.getString("ssn") != null) {
					if(prescRS.getString("ssn").equals(ssn)) {
						updateData("prescription", "ssn",
								prescRS.getString("ssn"), "NULL");
					}
				}
			}
			
			String delete = "delete from pri_phy_patient "
					+ "where ssn = '" + ssn + "';";
			
			patientStat.executeUpdate(delete);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean deletePresc(String pre_id) {
		boolean success = false;
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement prescStat = myConn.createStatement();
			
			String delete = "delete from prescription "
					+ "where pre_id = '" + pre_id + "';";
			
			prescStat.executeUpdate(delete);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static boolean deleteDoctor(String ssn) {
		boolean success = false;
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement doctorStat = myConn.createStatement();
			Statement patientStat = myConn.createStatement();
			Statement prescStat = myConn.createStatement();
			
			ResultSet patientRS = patientStat.executeQuery(
					selectPatient);
			ResultSet prescRS = prescStat.executeQuery(selectPresc);
			
			patientRS.beforeFirst();
			while(patientRS.next()) {
				if(patientRS.getString("phy_ssn") != null) {
					if(patientRS.getString("phy_ssn").equals(ssn)) {
						updateData("patient", "phy_ssn",
								patientRS.getString("phy_ssn"),
								"NULL");
					}
				}
			}
			
			prescRS.beforeFirst();
			while(prescRS.next()) {
				if(prescRS.getString("phy_ssn") != null) {
					if(prescRS.getString("phy_ssn").equals(ssn)) {
						updateData("prescription", "phy_ssn",
								prescRS.getString("phy_ssn"), "NULL");
					}
				}
			}
			
			String delete = "delete from doctor "
					+ "where ssn = '" + ssn + "';";
			
			doctorStat.executeUpdate(delete);
			
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public static String getPendingPresc() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRS = myStat.executeQuery(selectPresc);
			
			myRS.beforeFirst();
			while(myRS.next()) {
				if(myRS.getString("status") != null) {
					if(myRS.getString("status").equals("pending"))
						str +="pending: "
							+ myRS.getString("trade_name") + "\n";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getCompletedPresc() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRS = myStat.executeQuery(selectPresc);
			
			myRS.beforeFirst();
			while(myRS.next()) {
				if(myRS.getString("status") != null) {
					if(myRS.getString("status").equals("completed"))
						str += "completed: "
							+ myRS.getString("trade_name") + "\n";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getReadyPresc() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRS = myStat.executeQuery(selectPresc);
			
			myRS.beforeFirst();
			while(myRS.next()) {
				if(myRS.getString("status") != null) {
					if(myRS.getString("status").equals("ready"))
						str += "ready: "
							+ myRS.getString("trade_name") + "\n";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getDrugs() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRS = myStat.executeQuery(selectDrug);
			
			myRS.beforeFirst();
			while(myRS.next())
				str += "trade_name: "
						+ myRS.getString("trade_name") + "\n"
						+ "pharm_co_name: "
						+ myRS.getString("pharm_co_name") + "\n"
						+ "formula: "
						+ myRS.getString("formula") + "\n"
						+ "--------------------------------" + "\n";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getMostExpensive() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			ResultSet myRS = myStat.executeQuery(selectSell);
			
			myRS.beforeFirst();
			int max = 0;
			int tmp;
			String drug = null;
			String pharm_co = null;
			while(myRS.next()) {
				tmp = myRS.getInt("price");
				if(tmp > max) {
					max = tmp;
					drug = myRS.getString("trade_name");
					pharm_co = myRS.getString("pharm_co_name");
				}
			}
			
			str += "Most expensive drug: " + drug + "\n"
					+ "Priced at: $" + max + "\n"
					+ "Pharmacy company that sells this drug: "
					+ pharm_co;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static String getContracts() {
		String str = "";
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement contractStat = myConn.createStatement();
			Statement pharmStat = myConn.createStatement();
			Statement pharmCoStat = myConn.createStatement();
			
			String pharmID = "";
			String selectPharmRow = "select * from pharmacy "
					+ "where pharm_id = '" + pharmID + "';";
			String pharmCoName = "";
			String selectPharmCoRow = "select * from pharm_co "
					+ "where name = '" + pharmCoName + "';";
			
			ResultSet contractRS = contractStat.executeQuery(
					selectContract);
			
			String contract = "";
			String pharm = "";
			String pharmCo = "";
			int count = 0;
			while(contractRS.next()) {
				count++;
				contract = "pharm_id: "
				+ contractRS.getString("pharm_id") + "\n"
				+ "start_date: "
				+ contractRS.getString("start_date") + "\n"
				+ "end_date: "
				+ contractRS.getString("end_date") + "\n"
				+ "text: "
				+ contractRS.getString("text") + "\n"
				+ "supervisor: "
				+ contractRS.getString("supervisor") + "\n"
				+ "pharm_co_name: "
				+ contractRS.getString("pharm_co_name");
				pharmID = contractRS.getString("pharm_id");
				ResultSet pharmRS = pharmStat.executeQuery(
						selectPharmRow);
				System.out.println(pharmID);
				if(!pharmRS.next())
					System.out.println("pharmRS is empty");
				pharm = "Pharmacy name: "
				+ pharmRS.getString("name") + "\n"
				+ "Pharmacy address: "
				+ pharmRS.getString("address") + "\n"
				+ "Pharmacy phone: "
				+ pharmRS.getString("phone");
				pharmCoName = contractRS.getString("pharm_co_name");
				ResultSet pharmCoRS = pharmCoStat.executeQuery(
						selectPharmCoRow);
				pharmCoRS.next();
				pharmCo = "PharmCo name: "
				+ pharmCoRS.getString("name") + "\n"
				+ "PharmCo phone: "
				+ pharmCoRS.getString("phone");
				str += "Contract #" + count + ":" + "\n"
				+ contract + "\n"
				+ pharm + "\n"
				+ pharmCo + "\n"
				+ "---------------------------------------" + "\n";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	/*public void soldByAll() {
		try {
			/*What can I do here?
			 * I am trying to figure out a function that
			 * lists the drugs that are sold by all pharmacies.
			 * 
			 * Currently, I have my database set where
			 * I have every pharmacy selling madvil. I also
			 * have one pharmacy also selling flaritin just to
			 * test if my code will only identify madvil.
			 * 
			 * How would I go about identifying which drug is
			 * sold by all pharmacies?
			 * 
			 * I could take a list of all the drugs sold,
			 * then take a list of all the pharmacies I have
			 * in my database, then take a list of all the drugs
			 * in my database. From that point, I can then take
			 * each drug one-by-one and identify which pharmacies
			 * sell them. If every pharmacy sells them, then I
			 * will present that drug.
			 * 
			 * In order to identify which pharmacy sells a drug, */
			
			/*Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement sellStat = myConn.createStatement();
			Statement pharmStat = myConn.createStatement();
			Statement drugStat = myConn.createStatement();
			
			ResultSet sellRS = sellStat.executeQuery(selectSell);
			ResultSet pharmRS = pharmStat.executeQuery(selectPharm);
			ResultSet drugRS = drugStat.executeQuery(selectDrug);
			
			Vector<String> drugNames = getColumnData(
					drugRS, "trade_name");
			Vector<String> pharmIDs = getColumnData(
					pharmRS, "pharm_id");
			Vector<String> checked = new Vector<String>();
			
			/*What's to be done now?
			 * 
			 * I am trying to take one drug, and see if it
			 * is made by all pharmacies?
			 * 
			 * How will I take a drug and see if it's sold by all
			 * pharmacies?
			 * 
			 * I will look at the first entry in the sell table,
			 * and see which drug trade_name it corresponds to.
			 * I will then put that drug name in the checked
			 * vector. Then I will check in the sell table
			 * to see how many pharmacies sell it. If the
			 * number of pharmacies that sell it is the same as
			 * the size of pharmIDs, then that drug is sold by
			 * all pharmacies.*/
			
			/*for(int i = 0; i < drugNames.size(); i++) {
				for(int j = i; j < i; j++) {
					sellRS.next();
					if(sellRS.getString("trade_name"
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public Vector<String> getColumnData(ResultSet rs, String column) {
		Vector<String> output = new Vector<String>();
		try {
			while(rs.next())
				output.add(rs.getString(column));
			rs.beforeFirst();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	/*public void getSimilarPharm() {
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement drugStat = myConn.createStatement();
			Statement pharmCoStat = myConn.createStatement();
			
			ResultSet drugRS = drugStat.executeQuery(selectDrug);
			ResultSet pharmCoRS = pharmCoStat.executeQuery(
					selectPharmCo);
			
			Vector<String> drugNames = new Vector();
			Vector<String> pharmCoNames = new Vector();
			
			while(drugRS.next()) {
				drugNames.add(drugRS.getString("trade_name"));
				pharmCoNames.add(drugRS.getString("pharm_co_name"));
			}
			
			Vector<String> samePharm1 = new Vector();
			Vector<String> samePharm2 = new Vector();
			Vector<String> drugMatch = new Vector();
			
			for(int i = 0; i < drugNames.size(); i++) {
				for(int j = 0; j < i; j++) {
					if(drugNames.get(i).equalsIgnoreCase(
							drugNames.get(j))) {
						drugMatch.add(drugNames.get(i));
						drugRS.beforeFirst();
						drugRS.absolute(i);
						samePharm1.add(drugRS.getString(
								"pharm_co_name"));
						drugRS.absolute(j);
						samePharm2.add(drugRS.getString(
								"pharm_co_name"));
					}
				}
			}
			
			for(int i = 0; i < samePharm1.size(); i++) {
				System.out.println(samePharm.get(i) + " sells "
						+ drugMatch.get(i));
				System.out.println(");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public static void updateData(String table, String column,
			String oldData, String newData) {
		try {
			Connection myConn = DriverManager.getConnection(
					url, user, pass);
			
			Statement myStat = myConn.createStatement();
			
			String update = "update " + table + " set "
					+ column + " = " + newData + " where "
					+ column + " = " + oldData + ";";
			
			myStat.executeUpdate(update);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static JFrame mainFrame;
	//private static JLabel headerLabel;
	private static JTextArea statusLabel;
	private static JPanel controlPanel;
	private static JPanel outputPanel;
	
	private static void GUI() {
		mainFrame = new JFrame("CS430 Project");
		mainFrame.setSize(1600,800);
		mainFrame.setLayout(new GridLayout(3, 0));
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		//headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JTextArea();
		
		statusLabel.setLineWrap(true);
		statusLabel.setEditable(false);
		statusLabel.setVisible(true);
		
		controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(3,0));
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new GridLayout(3,0));
		
		JScrollPane scroll = new JScrollPane(statusLabel);
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(outputPanel);
		mainFrame.add(scroll);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void comboBox() {
		final DefaultComboBoxModel<String> logins =
				new DefaultComboBoxModel<String>();
		
		logins.addElement("as admin");
		logins.addElement("as staff");
		logins.addElement("as customer");
		
		/*final JComboBox<String> loginList = 
				new JComboBox<String>(logins);
		loginList.setSelectedIndex(0);*/
		
		//JScrollPane loginListScrollPane = new JScrollPane(loginList);
		JButton listPatients = new JButton("list patients");
		JButton listPatientPresc = new JButton("list patient presc");
		JButton findPresc = new JButton("find presc");
		JButton addPatient = new JButton("add patient");
		JButton addPresc = new JButton("add presc");
		JButton addDoctor = new JButton("add doctor");
		JButton removePatient = new JButton("remove patient");
		JButton removePresc = new JButton("remove presc");
		JButton removeDoctor = new JButton("remove doctor");
		JButton listPendingPresc = new JButton("list pending presc");
		JButton listCompletedPresc = new JButton(
				"list completed presc");
		JButton listReadyPresc = new JButton("list ready presc");
		JButton listDrugs = new JButton("list drugs");
		JButton getMostExpensive = new JButton(
				"get most expensive drug");
		JButton listContracts = new JButton("list contracts");
		
		/*listPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t1, t2;
				t1 = new JTextField("Welcome");
				t1.setBounds(50,100,200,30);
				t2 = new JTextField("xd");
				t2.setBounds(50,150,200,30);
				mainFrame.add(t1);
				mainFrame.add(t2);
			}
		});*/
		
		listPatients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getPatientNames();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		listPatientPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getPatientPresc();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		findPresc.addActionListener(new ActionListener() {
			String nameOutput;
			String bdayOutput;
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				JTextField name, bday;
				name = new JTextField("Name");
				bday = new JTextField("Bday");
				outputPanel.add(name);
				outputPanel.add(bday);
				outputPanel.setVisible(true);
				outputPanel.revalidate();
				outputPanel.repaint();
				name.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nameOutput = name.getText();
						bdayOutput = bday.getText();
						String data = getPrescStatus(
								nameOutput, bdayOutput);
						statusLabel.setText(data);
					}
				});
				bday.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nameOutput = name.getText();
						bdayOutput = bday.getText();
						String data = getPrescStatus(
								nameOutput, bdayOutput);
						statusLabel.setText(data);
					}
				});
			}
		});
		
		addPatient.addActionListener(new ActionListener () {
			String ssnOutput;
			String nameOutput;
			String bdayOutput;
			String addrOutput;
			String phySSNOutput;
			public void action(JTextField ssn, JTextField name,
					JTextField bday, JTextField addr,
					JTextField phySSN) {
				ssnOutput = ssn.getText();
				nameOutput = name.getText();
				bdayOutput = bday.getText();
				addrOutput = addr.getText();
				phySSNOutput = phySSN.getText();
				boolean data = insertPatient(ssnOutput, nameOutput,
						bdayOutput, addrOutput, phySSNOutput);
				if(data)
					statusLabel.setText("Successfully added "
							+ "patient!"
							+ "\n" + "SSN: " + ssnOutput + "\n"
							+ "Name: " + nameOutput + "\n"
							+ "Birth date: " + bdayOutput + "\n"
							+ "Address: " + addrOutput + "\n"
							+ "Physician SSN: " + phySSNOutput);
				else
					statusLabel.setText("Unable to add patient");
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				JTextField ssn, name, bday, addr, phySSN;
				ssn = new JTextField("ssn");
				name = new JTextField("name");
				bday = new JTextField("bday");
				addr = new JTextField("addr");
				phySSN = new JTextField("phy ssn");
				outputPanel.add(ssn);
				outputPanel.add(name);
				outputPanel.add(bday);
				outputPanel.add(addr);
				outputPanel.add(phySSN);
				outputPanel.setVisible(true);
				outputPanel.revalidate();
				outputPanel.repaint();
				ssn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, bday, addr, phySSN);
					}
				});
				name.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, bday, addr, phySSN);
					}
				});
				bday.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, bday, addr, phySSN);
					}
				});
				addr.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, bday, addr, phySSN);
					}
				});
				phySSN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, bday, addr, phySSN);
					}
				});
			}
		});
		
		addPresc.addActionListener(new ActionListener () {
			String preIDOutput;
			String statusOutput;
			String ssnOutput;
			String phySSNOutput;
			String preDateOutput;
			String quantityOutput;
			String tradeNameOutput;
			String pharmCoNameOutput;
			public void action(JTextField preID, JTextField status,
					JTextField ssn, JTextField phySSN,
					JTextField preDate, JTextField quantity,
					JTextField tradeName, JTextField pharmCoName) {
				preIDOutput = preID.getText();
				statusOutput = status.getText();
				ssnOutput = ssn.getText();
				phySSNOutput = phySSN.getText();
				preDateOutput = preDate.getText();
				quantityOutput = quantity.getText();
				tradeNameOutput = tradeName.getText();
				pharmCoNameOutput = pharmCoName.getText();
				boolean data = insertPresc(preIDOutput, statusOutput,
						ssnOutput, phySSNOutput, preDateOutput,
						quantityOutput, tradeNameOutput,
						pharmCoNameOutput);
				if(data)
					statusLabel.setText("Successfully added "
							+ "prescription!"
							+ "\n" + "preID: " + preIDOutput + "\n"
							+ "status: " + statusOutput + "\n"
							+ "ssn: " + ssnOutput + "\n"
							+ "phySSN: " + phySSNOutput + "\n"
							+ "preDate: " + preDateOutput + "\n"
							+ "quantity: " + quantityOutput + "\n"
							+ "tradeName: " + tradeNameOutput + "\n"
							+ "pharmCoName: " + pharmCoNameOutput);
				else
					statusLabel.setText(
							"Unable to add prescription");
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				JTextField preID, status, ssn, phySSN, preDate,
				quantity, tradeName, pharmCoName;
				preID = new JTextField("preID");
				status = new JTextField("status");
				ssn = new JTextField("ssn");
				phySSN = new JTextField("phySSN");
				preDate = new JTextField("preDate");
				quantity = new JTextField("quantity");
				tradeName = new JTextField("tradeName");
				pharmCoName = new JTextField("pharmCoName");
				outputPanel.add(preID);
				outputPanel.add(status);
				outputPanel.add(ssn);
				outputPanel.add(phySSN);
				outputPanel.add(preDate);
				outputPanel.add(quantity);
				outputPanel.add(tradeName);
				outputPanel.add(pharmCoName);
				outputPanel.setVisible(true);
				outputPanel.revalidate();
				outputPanel.repaint();
				preID.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				status.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				ssn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				phySSN.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				preDate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				quantity.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				tradeName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
				pharmCoName.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(preID, status, ssn, phySSN, preDate,
								quantity, tradeName, pharmCoName);
					}
				});
			}
		});
		
		addDoctor.addActionListener(new ActionListener () {
			String ssnOutput;
			String nameOutput;
			String specOutput;
			String expOutput;
			public void action(JTextField ssn, JTextField name,
					JTextField spec, JTextField exp) {
				ssnOutput = ssn.getText();
				nameOutput = name.getText();
				specOutput = spec.getText();
				expOutput = exp.getText();
				boolean data = insertDoctor(ssnOutput, nameOutput,
						specOutput, expOutput);
				if(data)
					statusLabel.setText("Successfully added doctor!"
							+ "\n" + "SSN: " + ssnOutput + "\n"
							+ "Name: " + nameOutput + "\n"
							+ "spec: " + specOutput + "\n"
							+ "exp: " + expOutput);
				else
					statusLabel.setText("Unable to add doctor");
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				JTextField ssn, name, spec, exp;
				ssn = new JTextField("ssn");
				name = new JTextField("name");
				spec = new JTextField("spec");
				exp = new JTextField("exp");
				outputPanel.add(ssn);
				outputPanel.add(name);
				outputPanel.add(spec);
				outputPanel.add(exp);
				outputPanel.setVisible(true);
				outputPanel.revalidate();
				outputPanel.repaint();
				ssn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, spec, exp);
					}
				});
				name.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, spec, exp);
					}
				});
				spec.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, spec, exp);
					}
				});
				exp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						action(ssn, name, spec, exp);
					}
				});
			}
		});
		
		removePatient.addActionListener(new ActionListener() {
			Vector<String> patients = getPatients();
			Vector<String> patientSSNs = getPatientSSNs();
			public JButton createButton(int i) {
				JButton button = new JButton("Delete Patient #"
			+ Integer.toString(i + 1));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(deletePatient(patientSSNs.get(i))) {
							statusLabel.setText("Successfully"
									+ " deleted patient #"
									+ Integer.toString(i+1));
						}
					}
				});
				return button;
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				outputPanel.revalidate();
				statusLabel.setText("");
				for(int i = 0; i < patients.size(); i++) {
					JButton button = createButton(i);
					int location = 100;
					button.setBounds(50,location,100,30);
					location += 50;
					outputPanel.add(button);
					statusLabel.append(patients.get(i));
					outputPanel.setVisible(true);
					outputPanel.revalidate();
					outputPanel.repaint();
				}
				mainFrame.setVisible(true);
				mainFrame.revalidate();
				mainFrame.repaint();
				
			}
		});
		
		removePresc.addActionListener(
				new ActionListener() {
			Vector<String> presc = getPresc();
			Vector<String> prescIDs = getPrescIDs();
			public JButton createButton(int i) {
				JButton button = new JButton("Delete Prescription #"
			+ Integer.toString(i + 1));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(deletePresc(prescIDs.get(i))) {
							statusLabel.setText("Successfully"
									+ " deleted Prescription #"
									+ Integer.toString(i+1));
						}
					}
				});
				return button;
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				outputPanel.revalidate();
				statusLabel.setText("");
				for(int i = 0; i < presc.size(); i++) {
					JButton button = createButton(i);
					int location = 100;
					button.setBounds(50,location,100,30);
					location += 50;
					outputPanel.add(button);
					statusLabel.append(presc.get(i));
					outputPanel.setVisible(true);
					outputPanel.revalidate();
					outputPanel.repaint();
				}
				mainFrame.setVisible(true);
				mainFrame.revalidate();
				mainFrame.repaint();
				
			}
		});
		
		removeDoctor.addActionListener(
				new ActionListener() {
			Vector<String> doctors = getDoctors();
			Vector<String> doctorSSNs = getDoctorSSNs();
			public JButton createButton(int i) {
				JButton button = new JButton("Delete Doctor #"
			+ Integer.toString(i + 1));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(deleteDoctor(doctorSSNs.get(i))) {
							statusLabel.setText("Successfully"
									+ " deleted Doctor #"
									+ Integer.toString(i+1));
						}
					}
				});
				return button;
			}
			public void actionPerformed(ActionEvent e) {
				outputPanel.removeAll();
				outputPanel.revalidate();
				statusLabel.setText("");
				for(int i = 0; i < doctors.size(); i++) {
					JButton button = createButton(i);
					int location = 100;
					button.setBounds(50,location,100,30);
					location += 50;
					outputPanel.add(button);
					statusLabel.append(doctors.get(i));
					outputPanel.setVisible(true);
					outputPanel.revalidate();
					outputPanel.repaint();
				}
				mainFrame.setVisible(true);
				mainFrame.revalidate();
				mainFrame.repaint();
				
			}
		});
		
		listPendingPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getPendingPresc();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		listCompletedPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getCompletedPresc();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		listReadyPresc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getReadyPresc();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		listDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getDrugs();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		getMostExpensive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getMostExpensive();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		listContracts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = getContracts();
				statusLabel.setText(data);
				outputPanel.removeAll();
				outputPanel.repaint();
			}
		});
		
		//controlPanel.add(loginListScrollPane);
		controlPanel.add(listPatients);
		controlPanel.add(listPatientPresc);
		controlPanel.add(findPresc);
		controlPanel.add(addPatient);
		controlPanel.add(addPresc);
		controlPanel.add(addDoctor);
		controlPanel.add(removePatient);
		controlPanel.add(removePresc);
		controlPanel.add(removeDoctor);
		controlPanel.add(listPendingPresc);
		controlPanel.add(listCompletedPresc);
		controlPanel.add(listReadyPresc);
		controlPanel.add(listDrugs);
		controlPanel.add(getMostExpensive);
		controlPanel.add(listContracts);
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws SQLException {
		
		/*main test = new main();
		
		test.deletePatient("3243242");
		test.insertPatient("3243242", "dudebro", "1994-02-02", 
				"street", "156188");
		test.deleteDoctor("38290183");
		test.insertDoctor("38290183", "xd", "memes", "69");
		test.deletePresc("156456");
		test.insertPresc("156456", "completed", "3243242", 
				"38290183", "2017-06-25", "30", "Madvil", "4M");
		test.getPatientNames();
		test.getDoctorNames();
		test.getPrescNames();
		test.getPendingPresc();
		test.getCompletedPresc();
		test.getReadyPresc();
		test.getDrugs();
		test.getMostExpensive();*/
		
		GUI();
		comboBox();
		
	}

}
