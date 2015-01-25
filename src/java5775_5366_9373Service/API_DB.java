/**
 * 
 */
package java5775_5366_9373Service;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//import model.datasource.SQLNAME;
import entities.*;
import entities.enums.*;
import entities.json.*;

/**
 * @author Yurisho
 *
 */
@Path("/db/")
public class API_DB
{
	
	
	public static final String URL = "jdbc:mysql://db4free.net:3306/java53669373";
	public static final String USER = "yurisho";
	public static final String PASSWORD = "312345366";

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	private static Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

	@Path("/addAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addAllergy(Allergy allergy) throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_ALLERGY + " VALUES ('"
					+ allergy.getAllergyID() + "', '"
					+ allergy.getAllergyName() + "', '"
					+ allergy.getAllergyNotes() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addDoctor")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addDoctor(Doctor doctor) throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO " + SQLNAME.TABLE_DOCTOR
					+ " VALUES ('" + doctor.getDoctorID() + "', '"
					+ doctor.getDoctorFirstName() + "', '"
					+ doctor.getDoctorLastName() + "', '"
					+ doctor.getDoctorGender().name() + "', '"
					+ dateFormat.format(doctor.getDoctorDoB()) + "', '"
					+ doctor.getDoctorEmailAdress() + "', '"
					+ dateFormat.format(doctor.getDoctorDoJ()) + "', '"
					+ doctor.getDoctorSalary() + "', '"
					+ doctor.getDoctorPhoneNumber() + "', '"
					+ doctor.getDoctorSpecialization().name() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addMedicine")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addMedicine(Medicine medicine) throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_MEDICINE + " VALUES ('"
					+ medicine.getMedicineID() + "', '"
					+ medicine.getMedicineName() + "', '"
					+ medicine.getMedicineIngredients() + "', '"
					+ medicine.getMedicineActiveIngredients() + "', '"
					+ medicine.getMedicineType().name() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addMedicineAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY + " VALUES ('"
					+ medicineAllergy.getMedicineID() + "', '"
					+ medicineAllergy.getAllergyID() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addPassword")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addPassword(Password password) throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_PASSWORD + " VALUES ('"
					+ password.getPasswordUserID() + "', '"
					+ password.getPasswordWord() + "', '"
					+ password.getPasswordPermit() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addPatient")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addPatient(Patient patient) throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_PATIENT + " VALUES ('"
					+ patient.getPatientID() + "', '"
					+ patient.getPatientFirstName() + "', '"
					+ patient.getPatientLastName() + "', '"
					+ patient.getPatientGender().name() + "', '"
					+ dateFormat.format(patient.getPatientDoB()) + "', '"
					+ patient.getPatientEmailAdress() + "', '"
					+ patient.getPatientServiceClass().name() + "', '"
					+ patient.getPatientPhoneNumber() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addPatientAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addPatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_PATIENT_ALLERGY + " VALUES ('"
					+ patientAllergy.getPatientID() + "', '"
					+ patientAllergy.getAllergyID() + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addPrescription")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addPrescription(Prescription prescription)
			throws Exception
	{
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_PRESCRIPTION
					+ " VALUES ('"
					+ prescription.getPrescriptionTreatmentID()
					+ "', '"
					+ prescription.getPrescriptionMedicineID()
					+ "', '"
					+ dateFormat.format(prescription
							.getPrescriptionMedicineExperationDate()) + "')");
			query.executeUpdate();
			returnString = "success";
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/addTreatment")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public static String addTreatment(Treatment treatment) throws Exception
	{
		PreparedStatement query = null;
		Connection conn = null;
		String returnString = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("INSERT INTO "
					+ SQLNAME.TABLE_TREATMENT + " VALUES ('"
					+ treatment.getTreatmentID() + "', '"
					+ treatment.getTreatmentDoctorID() + "', '"
					+ treatment.getTreatmentPatientID() + "', '"
					+ dateFormat.format(treatment.getTreatmentDate()) + "', '"
					+ treatment.getTreatmentLocation() + "', '"
					+ treatment.getTreatmentSummary() + "', '"
					+ ((treatment.isTreatmentDone()) ? 1 : 0) + "')",
					Statement.RETURN_GENERATED_KEYS);
			query.executeUpdate();
			ResultSet rs = query.getGeneratedKeys();
			
			rs.next();
			
			returnString = Long.toString(rs.getLong(1));
			
			query.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();
		}

		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteAllergyByID")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteAllergy(@QueryParam("allergyID") long allergyID)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_ALLERGY + " WHERE "
					+ SQLNAME.KEY_ALLERGY_ID + "='" + allergyID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteDoctorByID")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletDoctor(@QueryParam("doctorID") long doctorID)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn
					.prepareStatement("DELETE FROM " + SQLNAME.TABLE_DOCTOR
							+ " WHERE " + SQLNAME.KEY_DOCTOR_ID + "='"
							+ doctorID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteMedicineByID")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMedicine(@QueryParam("medicineID") long medicineID)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_MEDICINE + " WHERE "
					+ SQLNAME.KEY_MEDICINE_ID + "='" + medicineID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deletePatientByID")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(@QueryParam("patientID") long patientID)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_PATIENT + " WHERE "
					+ SQLNAME.KEY_PATIENT_ID + "='" + patientID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteTreatmentByID")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteTreatment(@QueryParam("treatmentID") long treatmentID)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_TREATMENT + " WHERE "
					+ SQLNAME.KEY_TREATMENT_ID + "='" + treatmentID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteMedicineAllergyByAllergy")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMedicineAllergyByAllergy(
			@QueryParam("allergyID") long allergyID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY + " WHERE "
					+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID + "='"
					+ allergyID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deleteMedicineAllergyByMedicine")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteMedicineAllergyByMedicine(
			@QueryParam("medicineID") long medicineID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY + " WHERE "
					+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + "='"
					+ medicineID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deletePatientAllergyByPatient")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatientAllergyByPatient(
			@QueryParam("patientID") long patientID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_PATIENT_ALLERGY + " WHERE "
					+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + "='" + patientID
					+ "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deletePatientAllergyByAllergy")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatientAllergyByAllergy(
			@QueryParam("allergyID") long allergyID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_PATIENT_ALLERGY + " WHERE "
					+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + "='" + allergyID
					+ "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deletePrescriptionByMedicine")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePrescriptionByMedicine(
			@QueryParam("medicineID") long medicineID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_PRESCRIPTION + " WHERE "
					+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + "='" + medicineID
					+ "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/deletePrescriptionByTreatment")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePrescriptionByTreatment(
			@QueryParam("treatmentID") long treatmentID) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			conn = getConnection();
			query = conn.prepareStatement("DELETE FROM "
					+ SQLNAME.TABLE_PRESCRIPTION + " WHERE "
					+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + "='"
					+ treatmentID + "'");
			query.execute();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updateAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAllergy(Allergy allergy) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_ALLERGY
					+ " SET " + SQLNAME.KEY_ALLERGY_NAME + "='"
					+ allergy.getAllergyName() + "'" + ","
					+ SQLNAME.KEY_ALLERGY_NOTES + "='"
					+ allergy.getAllergyNotes() + "'" + " WHERE "
					+ SQLNAME.KEY_ALLERGY_ID + "='" + allergy.getAllergyID()
					+ "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updateDoctor")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateDoctor(Doctor doctor) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn
					.prepareStatement("UPDATE " + SQLNAME.TABLE_DOCTOR
							+ " SET " + SQLNAME.KEY_DOCTOR_FIRST_NAME + "='"
							+ doctor.getDoctorFirstName() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_LAST_NAME + "='"
							+ doctor.getDoctorLastName() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_GENDER + "='"
							+ doctor.getDoctorGender().name() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_DOB + "='"
							+ dateFormat.format(doctor.getDoctorDoB()) + "'" + ","
							+ SQLNAME.KEY_DOCTOR_EMAIL_ADDRESS + "='"
							+ doctor.getDoctorEmailAdress() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_DOJ + "='"
							+ dateFormat.format(doctor.getDoctorDoJ()) + "'" + ","
							+ SQLNAME.KEY_DOCTOR_SALARY + "='"
							+ doctor.getDoctorSalary() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_PHONE_NUMBER + "='"
							+ doctor.getDoctorPhoneNumber() + "'" + ","
							+ SQLNAME.KEY_DOCTOR_SPECIALIZATION + "='"
							+ doctor.getDoctorSpecialization().name() + "'"
							+ " WHERE " + SQLNAME.KEY_DOCTOR_ID + "='"
							+ doctor.getDoctorID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updateMedicine")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateMedicine(Medicine medicine) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_MEDICINE
					+ " SET " + SQLNAME.KEY_MEDICINE_NAME + "='"
					+ medicine.getMedicineName() + "'" + ","
					+ SQLNAME.KEY_MEDICINE_INGREDIENTS + "='"
					+ medicine.getMedicineIngredients() + "'" + ","
					+ SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS + "='"
					+ medicine.getMedicineActiveIngredients() + "'" + ","
					+ SQLNAME.KEY_MEDICINE_TYPE + "='"
					+ medicine.getMedicineType().name() + "'" + " WHERE "
					+ SQLNAME.KEY_MEDICINE_ID + "='" + medicine.getMedicineID()
					+ "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updateMedicineAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateMedicineAllergy(MedicineAllergy medicineAllergy)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY
					// add updated attributes here, if any
					// + " SET " + SQLNAME.KEY + "='" + medicineAllergy.get() +
					// "'" + ","
					+ " WHERE " + SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID
					+ "='" + medicineAllergy.getAllergyID() + "'" + " AND "
					+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + "='"
					+ medicineAllergy.getMedicineID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}
	
	@Path("/updatePassword")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePassword(UpdatePasswordArgs args)
			throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		if (checkPassword(args.oldPassword.getPasswordUserID(),
				args.oldPassword.getPasswordWord()) == Permit.DENIED)
			throw new Exception("סיסמה שגויה");

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_PASSWORD
					+ " SET " + SQLNAME.KEY_PASSWORD_WORD + "='" + args.newPassword
					+ "'" + " WHERE " + SQLNAME.KEY_PASSWORD_USER_ID
					+ "='" + args.oldPassword.getPasswordUserID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updatePasswordAndPermit")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePassword(UpdatePasswordPermitArgs args) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		if (checkPassword(args.oldPassword.getPasswordUserID(),
				args.oldPassword.getPasswordWord()) == Permit.DENIED)
			throw new Exception("סיסמה שגויה");

		try
		{

			conn = getConnection();
			if (args.oldPassword.getPasswordPermit() == Permit.ADMIN || // do not
																	// allow
																	// change to
																	// admin's
																	// premision.
					args.permit == Permit.ADMIN) // do not allow other users to turn
											// admins.
				throw new Exception("שינוי הרשאות (ל)אדמין אסור.");
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_PASSWORD
					+ " SET " + SQLNAME.KEY_PASSWORD_WORD + "='" + args.newPassword
					+ "'" + "," + SQLNAME.KEY_PASSWORD_PERMIT + "='"
					+ args.permit.name() + "'" + " WHERE "
					+ SQLNAME.KEY_PASSWORD_USER_ID + "='"
					+ args.oldPassword.getPasswordUserID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updatePatient")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePatient(Patient patient) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_PATIENT
					+ " SET " + SQLNAME.KEY_PATIENT_FIRST_NAME + "='"
					+ patient.getPatientFirstName() + "'" + ","
					+ SQLNAME.KEY_PATIENT_LAST_NAME + "='"
					+ patient.getPatientLastName() + "'" + ","
					+ SQLNAME.KEY_PATIENT_GENDER + "='"
					+ patient.getPatientGender().name() + "'" + ","
					+ SQLNAME.KEY_PATIENT_DOB + "='"
					+ dateFormat.format(patient.getPatientDoB()) + "'" + ","
					+ SQLNAME.KEY_PATIENT_EMAIL_ADDRESS + "='"
					+ patient.getPatientEmailAdress() + "'" + ","
					+ SQLNAME.KEY_PATIENT_SERVICE_CLASS + "='"
					+ patient.getPatientServiceClass().name() + "'" + ","
					+ SQLNAME.KEY_PATIENT_PHONE_NUMBER + "='"
					+ patient.getPatientPhoneNumber() + "'" + " WHERE "
					+ SQLNAME.KEY_PATIENT_ID + "='" + patient.getPatientID()
					+ "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updatePatientAllergy")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePatientAllergy(PatientAllergy patientAllergy)
			throws Exception
	{

		@SuppressWarnings("unused")
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			/*
			conn = getConnection();
			query = conn.prepareStatement("UPDATE "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY
					// add updated attributes here, if any
					 + " SET " + SQLNAME.KEY + "='" + medicineAllergy.get() +
					 "'" + ","
					+ " WHERE " + SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + "='"
					+ patientAllergy.getPatientID() + "'" + " AND "
					+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID + "='"
					+ patientAllergy.getAllergyID() + "'"
					);
			query.executeUpdate();
			query.close();
			returnString = "success";
			*/
			returnString = "no fields to update, unused function";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updatePrescription")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updatePrescription(Prescription prescription)
			throws Exception
	{

		@SuppressWarnings("unused")
		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{
			/*
			conn = getConnection();
			query = conn.prepareStatement("UPDATE "
					+ SQLNAME.TABLE_PRESCRIPTION
					// add updated attributes here, if any
					// + " SET " + SQLNAME.KEY + "='" + medicineAllergy.get() +
					// "'" + ","
					+ " WHERE " + SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + "='"
					+ prescription.getPrescriptionMedicineID() + "'" + " AND "
					+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID + "='"
					+ prescription.getPrescriptionTreatmentID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
			*/
			returnString = "no fields to update, unused function";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/updateTreatment")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateTreatment(Treatment treatment) throws Exception
	{

		PreparedStatement query = null;
		String returnString = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("UPDATE " + SQLNAME.TABLE_TREATMENT
					+ " SET " + SQLNAME.KEY_TREATMENT_DOCTOR_ID + "='"
					+ treatment.getTreatmentDoctorID() + "'" + ","
					+ SQLNAME.KEY_TREATMENT_PATIENT_ID + "='"
					+ treatment.getTreatmentPatientID() + "'" + ","
					+ SQLNAME.KEY_TREATMENT_DATE + "='"
					+ dateFormat.format(treatment.getTreatmentDate()) + "'" + ","
					+ SQLNAME.KEY_TREATMENT_LOCATION + "='"
					+ treatment.getTreatmentLocation() + "'" + ","
					+ SQLNAME.KEY_TREATMENT_SUMMARY + "='"
					+ treatment.getTreatmentSummary() + "'" + ","
					+ SQLNAME.KEY_TREATMENT_DONE + "='"
					+ ((treatment.isTreatmentDone()) ? 1 : 0) + "'" + " WHERE "
					+ SQLNAME.KEY_TREATMENT_ID + "='"
					+ treatment.getTreatmentID() + "'");
			query.executeUpdate();
			query.close();
			returnString = "success";
		}
		catch (Exception e)
		{
			e.printStackTrace();
			returnString = e.getMessage();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return returnString;
	}

	@Path("/getAllergyList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Allergy> getAllergyList() throws Exception
	{

		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_ALLERGY);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(rs.getInt(SQLNAME.KEY_ALLERGY_ID));
				allergy.setAllergyName(rs.getString(SQLNAME.KEY_ALLERGY_NAME));
				allergy.setAllergyNotes(rs.getString(SQLNAME.KEY_ALLERGY_NOTES));

				allergyList.add(allergy);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return allergyList;
	}
	
	@Path("/getAllergyByPatientList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Allergy> getAllergyByPatientList(@QueryParam("patientID") long patientID) throws Exception
	{

		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM " + SQLNAME.TABLE_ALLERGY
					+ " tAllergy, " + SQLNAME.TABLE_PATIENT + " tPatient, "
					+ SQLNAME.TABLE_PATIENT_ALLERGY + " tAllergyPatient "
					+ "WHERE tPatient." + SQLNAME.KEY_PATIENT_ID + " = '"
					+ patientID + "'" + " AND tPatient." + SQLNAME.KEY_PATIENT_ID
					+ " = " + "tAllergyPatient."
					+ SQLNAME.KEY_PATIENT_ALLERGY_PATIENT_ID + " AND tAllergy."
					+ SQLNAME.KEY_ALLERGY_ID + " = " + "tAllergyPatient."
					+ SQLNAME.KEY_PATIENT_ALLERGY_ALLERGY_ID);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(rs.getInt(SQLNAME.KEY_ALLERGY_ID));
				allergy.setAllergyName(rs.getString(SQLNAME.KEY_ALLERGY_NAME));
				allergy.setAllergyNotes(rs.getString(SQLNAME.KEY_ALLERGY_NOTES));

				allergyList.add(allergy);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return allergyList;
	}
	
	@Path("/getAllergyByMedicineList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Allergy> getAllergyByMedicineList(@QueryParam("medicineID") long medicineID) throws Exception
	{

		ArrayList<Allergy> allergyList = new ArrayList<Allergy>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM " + SQLNAME.TABLE_ALLERGY
					+ " tAllergy, " + SQLNAME.TABLE_MEDICINE + " tMedicine, "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY + " tAllergyMedicine "
					+ "WHERE tMedicine." + SQLNAME.KEY_MEDICINE_ID + " = '"
					+ medicineID + "'" + " AND tMedicine."
					+ SQLNAME.KEY_MEDICINE_ID + " = " + "tAllergyMedicine."
					+ SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID + " AND tAllergy."
					+ SQLNAME.KEY_ALLERGY_ID + " = " + "tAllergyMedicine."
					+ SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Allergy allergy = new Allergy();

				allergy.setAllergyID(rs.getInt(SQLNAME.KEY_ALLERGY_ID));
				allergy.setAllergyName(rs.getString(SQLNAME.KEY_ALLERGY_NAME));
				allergy.setAllergyNotes(rs.getString(SQLNAME.KEY_ALLERGY_NOTES));

				allergyList.add(allergy);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return allergyList;
	}
	
	@Path("/getDoctorList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Doctor> getDoctorList() throws Exception
	{

		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_DOCTOR);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Doctor doctor = new Doctor();

				doctor.setDoctorID(rs.getInt(SQLNAME.KEY_DOCTOR_ID));
				doctor.setDoctorFirstName(rs.getString(SQLNAME.KEY_DOCTOR_FIRST_NAME));
				doctor.setDoctorLastName(rs.getString(SQLNAME.KEY_DOCTOR_LAST_NAME));
				doctor.setDoctorGender(Gender.valueOf(rs.getString(SQLNAME.KEY_DOCTOR_GENDER)));
				doctor.setDoctorDoB(dateFormat.parse(rs.getString(SQLNAME.KEY_DOCTOR_DOB)));
				doctor.setDoctorEmailAdress(rs.getString(SQLNAME.KEY_DOCTOR_EMAIL_ADDRESS));
				doctor.setDoctorDoJ(dateFormat.parse(rs.getString(SQLNAME.KEY_DOCTOR_DOJ)));
				doctor.setDoctorSalary(rs.getFloat(SQLNAME.KEY_DOCTOR_SALARY));
				doctor.setDoctorPhoneNumber(rs.getString(SQLNAME.KEY_DOCTOR_PHONE_NUMBER));
				doctor.setDoctorSpecialization(Specialization.valueOf(rs.getString(SQLNAME.KEY_DOCTOR_SPECIALIZATION)));

				doctorList.add(doctor);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return doctorList;
	}
	
	@Path("/getMedicineList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Medicine> getMedicineList() throws Exception
	{

		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_MEDICINE);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Medicine medicine = new Medicine();

				medicine.setMedicineID(rs.getInt(SQLNAME.KEY_MEDICINE_ID));
				medicine.setMedicineName(rs.getString(SQLNAME.KEY_MEDICINE_NAME));
				medicine.setMedicineIngredients(rs.getString(SQLNAME.KEY_MEDICINE_INGREDIENTS));
				medicine.setMedicineActiveIngredients(rs.getString(SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS));
				medicine.setMedicineType(MedicineType.valueOf(rs.getString(SQLNAME.KEY_MEDICINE_TYPE)));

				medicineList.add(medicine);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return medicineList;
	}
	
	@Path("/getMedicineByTreatmentList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Medicine> getMedicineByTreatmentList(@QueryParam("treatmentID") long treatmentID) throws Exception
	{

		ArrayList<Medicine> medicineList = new ArrayList<Medicine>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_MEDICINE+ " tMedicine, " + SQLNAME.TABLE_TREATMENT + " tTreatment, "
					+ SQLNAME.TABLE_PRESCRIPTION + " tPrescription "
					+ "WHERE tTreatment." + SQLNAME.KEY_TREATMENT_ID + " = '"
					+ treatmentID + "'" + " AND tMedicine."
					+ SQLNAME.KEY_MEDICINE_ID + " = " + "tPrescription."
					+ SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID + " AND tTreatment."
					+ SQLNAME.KEY_TREATMENT_ID + " = " + "tPrescription."
					+ SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Medicine medicine = new Medicine();

				medicine.setMedicineID(rs.getInt(SQLNAME.KEY_MEDICINE_ID));
				medicine.setMedicineName(rs.getString(SQLNAME.KEY_MEDICINE_NAME));
				medicine.setMedicineIngredients(rs.getString(SQLNAME.KEY_MEDICINE_INGREDIENTS));
				medicine.setMedicineActiveIngredients(rs.getString(SQLNAME.KEY_MEDICINE_ACTIVE_INGREDIENTS));
				medicine.setMedicineType(MedicineType.valueOf(rs.getString(SQLNAME.KEY_MEDICINE_TYPE)));

				medicineList.add(medicine);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return medicineList;
	}
	
	@Path("/getPatientList")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Patient> getPatientList() throws Exception
	{

		ArrayList<Patient> patientList = new ArrayList<Patient>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_PATIENT);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Patient patient = new Patient();

				patient.setPatientID(rs.getInt(SQLNAME.KEY_PATIENT_ID));
				patient.setPatientFirstName(rs.getString(SQLNAME.KEY_PATIENT_FIRST_NAME));
				patient.setPatientLastName(rs.getString(SQLNAME.KEY_PATIENT_LAST_NAME));
				patient.setPatientGender(Gender.valueOf(rs.getString(SQLNAME.KEY_PATIENT_GENDER)));
				patient.setPatientDoB(dateFormat.parse(rs.getString(SQLNAME.KEY_PATIENT_DOB)));
				patient.setPatientEmailAdress(rs.getString(SQLNAME.KEY_PATIENT_EMAIL_ADDRESS));
				patient.setPatientServiceClass(ServiceClass.valueOf(rs.getString(SQLNAME.KEY_PATIENT_SERVICE_CLASS)));
				patient.setPatientPhoneNumber(rs.getString(SQLNAME.KEY_PATIENT_PHONE_NUMBER));

				patientList.add(patient);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return patientList;
	}
	
	@Path("/getConectorMedicineAllergy") 
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	public MedicineAllergy getConectorMedicineAllergy(@QueryParam("medicineID") long medicineID,
			@QueryParam("allergyID") long allergyID) throws Exception
	{
		ArrayList<MedicineAllergy> medicineAllergies = getMedicineAllergyList();

		for (MedicineAllergy medicineAllergyItem : medicineAllergies)
			if (medicineAllergyItem.getAllergyID() == allergyID
					&& medicineAllergyItem.getMedicineID() == medicineID)
				return medicineAllergyItem;

		throw new Exception("אין קישור בין תרופה זו ואלרגיה זו!");

	}
	
	private ArrayList<MedicineAllergy> getMedicineAllergyList() throws Exception
	{

		ArrayList<MedicineAllergy> medicineAllergyList = new ArrayList<MedicineAllergy>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_MEDICINE_ALLERGY);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				MedicineAllergy medicineAllergy = new MedicineAllergy();

				medicineAllergy.setAllergyID(rs.getInt(SQLNAME.KEY_MEDICINE_ALLERGY_ALLERGY_ID));
				medicineAllergy.setMedicineID(rs.getInt(SQLNAME.KEY_MEDICINE_ALLERGY_MEDICINE_ID));

				medicineAllergyList.add(medicineAllergy);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return medicineAllergyList;
	}
	
	@Path("/getConectorPrescription") 
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	public Prescription getConectorPrescription(@QueryParam("treatmentID") long treatmentID,
			@QueryParam("medicineID") long medicineID) throws Exception
	{
		ArrayList<Prescription> prescriptions = getPrescriptionList();

		for (Prescription prescriptionItem : prescriptions)
			if (prescriptionItem.getPrescriptionTreatmentID() == treatmentID
					&& prescriptionItem.getPrescriptionMedicineID() == medicineID)
				return prescriptionItem;

		throw new Exception("אין קישור בין תרופה זו וטיפול זה!");
	}
	
	private ArrayList<Prescription> getPrescriptionList() throws Exception
	{

		ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_PRESCRIPTION);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Prescription prescription = new Prescription();

				prescription.setPrescriptionMedicineID(rs.getInt(SQLNAME.KEY_PRESCRIPTION_MEDICINE_ID));
				prescription.setPrescriptionTreatmentID(rs.getInt(SQLNAME.KEY_PRESCRIPTION_TREATMENT_ID));
				prescription.setPrescriptionMedicineExperationDate(dateFormat
						.parse(rs.getString(SQLNAME.KEY_PRESCRIPTION_MEDICINE_EXPERATION_DATE)));

				prescriptionList.add(prescription);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return prescriptionList;
	}
	
	@Path("/checkPassword") 
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public Permit checkPassword(@QueryParam("loginID") long loginID, @QueryParam("password") String password) throws Exception
	{
		ArrayList<Password> passwords = getPasswordList();

		for (Password passwordItem : passwords)
			if (passwordItem.getPasswordUserID() == loginID
					&& passwordItem.getPasswordWord().equals(password))
				return passwordItem.getPasswordPermit();

		throw new Exception("שם משתמש או סיסמה שגויה!");
	}
	
	private ArrayList<Password> getPasswordList() throws Exception
	{

		ArrayList<Password> passwordList = new ArrayList<Password>();
		PreparedStatement query = null;
		Connection conn = null;

		try
		{

			conn = getConnection();
			query = conn.prepareStatement("SELECT  * FROM "
					+ SQLNAME.TABLE_PASSWORD);
			ResultSet rs = query.executeQuery();

			while (rs.next())
			{
				Password password = new Password();

				password.setPasswordUserID(rs.getInt(SQLNAME.KEY_PASSWORD_USER_ID));
				password.setPasswordWord(rs.getString(SQLNAME.KEY_PASSWORD_WORD));
				password.setPasswordPermit(Permit.valueOf(rs.getString(SQLNAME.KEY_PASSWORD_PERMIT)));

				passwordList.add(password);
			}

			query.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
		finally
		{
			if (conn != null)
				conn.close();
		}

		return passwordList;
	}
	
	@Path("/isEmpty") 
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
	public boolean isEmpty() throws Exception
	{
		PreparedStatement query = null;
		Connection conn = null;
		
		conn = getConnection();
		query = conn.prepareStatement("SELECT * FROM " + SQLNAME.TABLE_DOCTOR);
		ResultSet rs = query.executeQuery();
		
		return !rs.next();
	}
}
