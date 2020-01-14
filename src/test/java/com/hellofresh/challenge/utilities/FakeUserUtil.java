package com.hellofresh.challenge.utilities;

import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static com.hellofresh.challenge.tests.BaseTest.testDataExcelFileName;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 *
 * Generate fake user utility class to handle fake user operations
 * https://github.com/DiUS/java-faker
 */

public class FakeUserUtil {

    Faker faker = new Faker(new Locale("en-GB"));

    //Main Directory of the project
    public static final String currentDir = System.getProperty("user.dir");

    //Location of Test data excel file
    public static String testDataExcelPath = null;


    /***
     * Create fake users to fulfill the sign in page
     */
    public ArrayList<String> createUser() throws Exception {

        ArrayList<String> userDataList = new ArrayList<String>(16);
        String date[] = dateHandling(18, 90);

        userDataList.add(faker.internet().emailAddress());
        userDataList.add(faker.name().firstName());
        userDataList.add(faker.name().lastName());
        userDataList.add(faker.internet().password());
        userDataList.add(date[0]);
        userDataList.add(date[1]);
        userDataList.add(date[2]);
        userDataList.add(faker.company().name());
        userDataList.add(faker.address().fullAddress());
        userDataList.add(faker.address().fullAddress());
        userDataList.add(faker.address().city());
        userDataList.add(faker.numerify("#####")); //faker.address().zipCode()
        userDataList.add(faker.phoneNumber().phoneNumber());
        userDataList.add(faker.phoneNumber().cellPhone());

        return userDataList;
    }

    /***
     * Helper method to handle date, month and year
     * @param
     *      minAge minimum age
     * @param
     *      maxAge maximum age
     * @return array consists of date, month and year
     */
    public String[] dateHandling(int minAge, int maxAge) {
        String dateString;
        String[] strArray;
        Date birthday = faker.date().birthday(18, 90);
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy", Locale.ENGLISH);
        dateString = sdf.format(birthday);
        strArray = dateString.split("/");
        return strArray;
    }

    public void addUsersTestData() throws Exception {

        try {
            testDataExcelPath = currentDir + "\\src\\test\\resources\\";
            XSSFWorkbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("SigninData");
            Row headerRow = sheet.createRow(0);

            ArrayList<String> userData = createUser();

            for (int i = 0; i < userData.size(); i++) {
                System.out.println("User data:" + userData.get(i));

                Cell cell = headerRow.createCell(i);
                cell.setCellValue(userData.get(i));
            }
            // Write the output to a file
            FileOutputStream fileOut = new FileOutputStream(testDataExcelPath + testDataExcelFileName);
            workbook.write(fileOut);
            fileOut.close();

            // Closing the workbook
            workbook.close();

            LogUtil.info("Fake user data created");
        } catch (Exception ex) {
            LogUtil.error("Fake user could not be written into excel!");
            ex.printStackTrace();
        }

    }
}
