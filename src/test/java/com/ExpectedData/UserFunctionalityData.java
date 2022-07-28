package com.ExpectedData;

public class UserFunctionalityData {

	public static String[] users_column_names = { "//th[contains(.,'User Name')]", "//th[contains(.,'First Name')]",
			"//th[contains(.,'Last Name')]", "//th[contains(.,'Role')]", "//th[contains(.,'Created On')]",
			"//th[contains(.,'Created By')]", "//th[contains(.,'Status')]", "//th[contains(.,'Action')]" };

	public static String[] create_user = { "(//label[contains(.,'First Name*')])[1]",
			"//label[contains(.,'Middle Name')]", "//label[contains(.,'Last Name*')]",
			"//button[contains(.,'Select User Role')]", "//h4[contains(.,'Contact Information')]",
			"//label[contains(.,'Home Phone*')]", "//label[contains(.,'Work Phone')]", "//label[contains(.,'Fax')]",
			"//label[contains(.,'Email*')]", "//label[contains(.,'Mobile*')]", "//button[contains(.,'Upload Picture')]",
			"//button[contains(.,'Take Selfie')]", "(//button[contains(.,'Save')])[1]",
			"//button[contains(.,'Save & Close')]", "(//button[contains(.,'Close')])[2]",
			"(//span[contains(.,'×')])[2]" };

	public static String[] provider_create_user = { "(//label[contains(.,'First Name*')])[1]",
			"//label[contains(.,'Middle Name')]", "//label[contains(.,'Last Name*')]",
			"//button[contains(.,'Select User Role')]", "//label[contains(.,'Provider No*')]",
			"//label[contains(.,'NPI*')]", "//label[contains(.,'Taxonomy*')]",
			"//label[contains(.,'Encounter Sign Pin*')]", "//label[contains(.,'Confirm Sign Pin*')]",
			"//h4[contains(.,'Contact Information')]", "//label[contains(.,'Home Phone*')]",
			"//label[contains(.,'Work Phone')]", "//label[contains(.,'Fax')]", "//label[contains(.,'Email*')]",
			"//label[contains(.,'Mobile*')]", "//button[contains(.,'Upload Picture')]",
			"//button[contains(.,'Take Selfie')]", "(//button[contains(.,'Save')])[1]",
			"//button[contains(.,'Save & Close')]", "(//button[contains(.,'Close')])[2]",
			"(//span[contains(.,'×')])[2]" };

	public static String[] validations = { "(//span[contains(.,'Required')])[1]", "(//span[contains(.,'Required')])[2]",
			"(//span[contains(.,'Required')])[3]", "(//span[contains(.,'Required')])[4]",
			"(//span[contains(.,'Required')])[5]", "(//span[contains(.,'Required')])[6]",
			"(//div[contains(.,'Select atleast one role')])[16]" };

	public static String[] dropdown_values = { "-- select --", "Mrs", "Mr", "Miss" };

	public static String[] select_role = { "(//span[contains(.,'Admin')])[1]", "//span[contains(.,'CEO')]",
			"//span[contains(.,'Guardian')]", "//span[contains(.,'Provider')]", "//span[contains(.,'SuperAdmin')]",
			"//button[contains(.,'Ok')]", "(//span[contains(.,'×')])[3]" };

	public static String[] days_xpath = { "(//div[contains(.,'Monday')])[17]", "(//div[contains(.,'Tuesday')])[17]",
			"(//div[contains(.,'Wednesday')])[17]", "(//div[contains(.,'Thursday')])[17]",
			"(//div[contains(.,'Friday')])[17]", "(//div[contains(.,'Saturday')])[17]",
			"(//div[contains(.,'Sunday')])[17]" };

	public static String[] time_xpath = { "(//div[contains(.,'00:00 AM')])[16]", "(//div[contains(.,'00:30 AM')])[16]",
			"(//div[contains(.,'01:00 AM')])[16]", "(//div[contains(.,'01:30 AM')])[16]",
			"(//div[contains(.,'02:00 AM')])[16]", "(//div[contains(.,'02:30 AM')])[16]",
			"(//div[contains(.,'03:00 AM')])[16]", "(//div[contains(.,'03:30 AM')])[16]",
			"(//div[contains(.,'04:00 AM')])[16]", "(//div[contains(.,'04:30 AM')])[16]",
			"(//div[contains(.,'05:00 AM')])[16]", "(//div[contains(.,'05:30 AM')])[16]",
			"(//div[contains(.,'06:00 AM')])[16]", "(//div[contains(.,'06:30 AM')])[16]",
			"(//div[contains(.,'07:00 AM')])[16]", "(//div[contains(.,'07:30 AM')])[16]",
			"(//div[contains(.,'08:00 AM')])[16]", "(//div[contains(.,'08:30 AM')])[16]",
			"(//div[contains(.,'09:00 AM')])[16]", "(//div[contains(.,'09:30 AM')])[16]",
			"(//div[contains(.,'10:00 AM')])[16]", "(//div[contains(.,'10:30 AM')])[16]",
			"(//div[contains(.,'11:00 AM')])[16]", "(//div[contains(.,'11:30 AM')])[16]",
			"(//div[contains(.,'12:00 PM')])[16]", "(//div[contains(.,'12:30 PM')])[16]",
			"(//div[contains(.,'01:00 PM')])[16]", "(//div[contains(.,'01:30 PM')])[16]",
			"(//div[contains(.,'02:00 PM')])[16]", "(//div[contains(.,'02:30 PM')])[16]",
			"(//div[contains(.,'03:00 PM')])[16]", "(//div[contains(.,'03:30 PM')])[16]",
			"(//div[contains(.,'04:00 PM')])[16]", "(//div[contains(.,'04:30 PM')])[16]",
			"(//div[contains(.,'05:00 PM')])[16]", "(//div[contains(.,'05:30 PM')])[16]",
			"(//div[contains(.,'06:00 PM')])[16]", "(//div[contains(.,'06:30 PM')])[16]",
			"(//div[contains(.,'07:00 PM')])[16]", "(//div[contains(.,'07:30 PM')])[16]",
			"(//div[contains(.,'08:00 PM')])[16]", "(//div[contains(.,'08:30 PM')])[16]",
			"(//div[contains(.,'09:00 PM')])[16]", "(//div[contains(.,'09:30 PM')])[16]",
			"(//div[contains(.,'10:00 PM')])[16]", "(//div[contains(.,'10:30 PM')])[16]",
			"(//div[contains(.,'11:00 PM')])[16]", "(//div[contains(.,'11:30 PM')])[16]",
			"(//div[contains(.,'12:00 AM')])[16]" };

}
