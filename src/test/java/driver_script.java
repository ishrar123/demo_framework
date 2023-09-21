import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class driver_script {

    public static int rowcount,i,rowcount1,rowcount2;
    public static String runtestcases,TCNAME,username1,password1,fname1,lname1,uname,pwd,fname,lname,company1;
    public  static WebDriver driver;
    public static Properties prop;

    public static FileInputStream fl;
    public static XSSFWorkbook workbook ;
    public static XSSFSheet sheet1;
    public static XSSFRow rowhead;
    public static OutputStream fileOut;
    public static Xls_Reader xlr;
    public static Xls_Reader xl1;
    public static  String objusername,objpassword,objlead,objlogin,objfirstname,objlastname,objcancel,objcompany,objnewcontact,objtitle,vHTMLResultFilePath;
    public static String projectnmae,runmodules,modulename,uname1,pwd1;
    public static void main(String[] args) throws Throwable {

        //setting up the webdriver
//

         //html result file
        vHTMLResultFilePath=reuauablefunction.CreateHTMLResultfile();

        //calling the html result file
        reuauablefunction.CreatecolumnHtmlResult(vHTMLResultFilePath);

        //properties file
       Properties prop=new Properties();

        FileInputStream fl=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\ObjectRepository\\or.properties");
        prop.load(fl);


        Xls_Reader xl=new Xls_Reader(System.getProperty("user.dir") + "\\src\\test\\Test Data\\vTigerModules.xlsx");

        //getting the anothor excel file
        xl1=new Xls_Reader(System.getProperty("user.dir")+ "\\src\\test\\drivers\\project_drivers.xlsx");

        //getting the rows of the driver excel file first sheet
        rowcount1=xl1.getRowCount("projects");
        System.out.println(rowcount1);

        //getting the row count of the drivel excel file  project drivers
        rowcount2=xl1.getRowCount("projectmodules");
        System.out.println(rowcount2);

        //counting the rrows in the excel





        //System.out.println(rowcount);
        //first for loop  For project name
        for(i=2;i<=rowcount1;i++) {
             projectnmae=xl1.getCellData("projects","projectname",i);
            System.out.println(projectnmae);

            //second loop for the modules name
            for(i=2;i<=rowcount2;i++) {

                runmodules=xl1.getCellData("projectmodules","Run",i);

                //geetting the codition for the running modules
                if(runmodules.equalsIgnoreCase("ON")) {


                    //getting the module name
                    modulename=xl1.getCellData("projectmodules","Modules",i);
                    System.out.println(modulename);
                    rowcount=xl.getRowCount(modulename);


                    for (i = 2; i <= rowcount; i++) {

                        //geeting the test cases which are on
                        runtestcases = xl.getCellData(modulename, "Run", i);
                        if (runtestcases.equalsIgnoreCase("ON")) {

                            //getting the particualr test name
                            TCNAME = xl.getCellData(modulename, "TCName", i);
                            System.out.println(TCNAME);

                            //getting the username for the login
                            username1 = xl.getCellData("Login", "username", i);

                            //getting the password for  the login
                            password1 = xl.getCellData("Login", "password", i);

                            //getting the username for the leads sheets

                            uname = xl.getCellData("Leads", "username", i);

                            //getting the password for the leads sheets

                            pwd = xl.getCellData("Leads", "password", i);

                            //getting the username for the contact sheets

                             uname1=xl.getCellData("Contacts", "uname", i);

                            //getting the pwd for the contact sheets
                             pwd1=xl.getCellData("Contacts","pwd",i);







                            //fetching the object from the properties file for the username
                            objusername = prop.getProperty("username");

                            //fetching the object from the properties file for the password
                            objpassword = prop.getProperty("password");

                            //fetching the object from the properties file for the login button
                            objlogin = prop.getProperty("clicklogin");

                            //fetching the object from the properties file for the first name after login
                            objfirstname = prop.getProperty("firstname");

                            //fetching the object from the properties file for the last name after login
                            objlastname = prop.getProperty("lastname");

                            //fetching the object  properrty from the properties for the cancel button
                            objcancel = prop.getProperty("cancel");

                            //entering the values in the first name
                            fname1 = xl.getCellData("Login", "firstname", i);

                            //entering the values in the last name
                            lname1 = xl.getCellData("Login", "lastname", i);

                            //fetching the object  property from the properties for the new lead button
                            objlead = prop.getProperty("newlead");

                            //fetching the object  properrty from the properties for the company button
                            objcompany = prop.getProperty("company");

                            //fetching the object  properrty from the properties for the new contact button
                            objnewcontact = prop.getProperty("newContact");

                            //fetching the object property from the properties for the new contact button
                            objtitle = prop.getProperty("title");







                            switch (TCNAME) {

                                //performing first test case: vaalidating the app title
                                case "vTiger_Login_verifyAppUrl_TC01":
                                    reuauablefunction.launchapplication("http://localhost:100/");

                                    String vtitle = driver.getTitle();
                                    if (vtitle.equals("vtiger CRM - Commercial Open Source CRM")) {
//
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath, TCNAME, "title should be present", "title is present", "PASSED");


                                    } else {
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath, TCNAME, "title should be present", "title is not  present", "FAILED");
                                    }

                                    break;




                                //performing the second test case
                                case "vTiger_Login_verifyAppLogo_TC02":

                                    // reuauablefunction.launchapplication("http://localhost:100/");

                                    //fetching the object logo from the propertiess file
                                    String objlogo = prop.getProperty("applogo");


                                    //calling the function from the reusuable keyword
                                    reusuable_keyword.verifyobject(objlogo,"app logo ");


                                    break;

                                //performing the third test case:
                                case "vTiger_Login_verifyText_KeyModule_TC03":

                                    // reuauablefunction.launchapplication("http://localhost:100/");

                                    //fetching the object from the properties file
                                    String objkeymodule = prop.getProperty("textkeymodules");


                                    //calling the function for verifying the text
                                    reusuable_keyword.verifyobject(objkeymodule,"keytextmodule");

                                    //  reuauablefunction.closebrowser();

                                    break;

                                //performing the fourth test case
                                case "vTiger_Login_withInvalid_Credentials_TC04":
                                    reuauablefunction.launchapplication("http://localhost:100/");


                                    //entering the values in the usernmae field
                                    reusuable_keyword.setvalue(objusername, username1);

                                    //entering the value in the password field
                                    reusuable_keyword.setvalue(objpassword, password1);

                                    //click on the login button
                                    reusuable_keyword.clickbutton(objlogin,"login button");
                                    //reuauablefunction.closebrowser();

                                    break;

                                case "vTiger_Login_withValid_Credentials_TC05":
                                    // reuauablefunction.launchapplication("http://localhost:100/");


                                    //entering the values in the usernmae field

                                    reusuable_keyword.setvalue(objusername, username1);


                                    //entering the value in the password field

                                    reusuable_keyword.setvalue(objpassword, password1);


                                    //click on the login button

                                    reusuable_keyword.clickbutton(objlogin,"login button");


                                    // reuauablefunction.closebrowser();


                                    break;

                                case "vTiger_createLead_TC06":
                                    //   reuauablefunction.launchapplication("http://localhost:100/");




                                    String company = xl.getCellData("Login", "company", i);

                                    reusuable_keyword.clicklinkbutton(objlead,"new lead button");
                                    reusuable_keyword.setvalueXpath(objfirstname, fname1);
                                    reusuable_keyword.setvalueXpath(objlastname, lname1);
                                    reusuable_keyword.setvalueXpath(objcompany, company);
                                    reusuable_keyword.clickxpathbutton(objcancel,"cancel button");

                                    // reuauablefunction.closebrowser();

                                    break;

                                case "vTiger_CreateContact_TC07":
                                    // reuauablefunction.launchapplication("http://localhost:100/");


                                    String title = xl.getCellData("Login", "title", i);




                                    reusuable_keyword.clicklinkbutton(objnewcontact,"new contact button");
                                    reusuable_keyword.setvalueXpath(objfirstname, fname1);
                                    reusuable_keyword.setvalueXpath(objlastname, lname1);
                                    reusuable_keyword.setvalueXpath(objtitle, title);
                                    reusuable_keyword.clickxpathbutton(objcancel,"cancel button");

                                    reuauablefunction.closebrowser();

                                    break;


                            }

                            //test cases for the lead sheets
                               switch(TCNAME)
                            {

                                case "vTiger_Leads_Create New Lead and Cancel it":

                                    reuauablefunction.launchapplication("http://localhost:100/");

                                    reusuable_keyword.setvalue(objusername, uname);


                                    //entering the value in the password field

                                    reusuable_keyword.setvalue(objpassword, pwd);


                                    //click on the login button

                                    reusuable_keyword.clickbutton(objlogin,"login button");


                                    company1 = xl.getCellData("Leads", "comp", i);
                                    fname=xl.getCellData("Leads","fname",i);
                                    lname=xl.getCellData("Leads","lname",i);






                                    reusuable_keyword.clicklinkbutton(objlead,"new lead button");

                                    reusuable_keyword.setvalueXpath(objfirstname,fname);
                                    reusuable_keyword.setvalueXpath(objlastname, lname);
                                    reusuable_keyword.setvalueXpath(objcompany, company1);
                                    reusuable_keyword.clickxpathbutton(objcancel,"cancel button");

                                    // reuauablefunction.closebrowser();

                                    break;




                                case "vTiger_Leads_Dropdown_Contain_Mr.":


                                    reusuable_keyword.clicklinkbutton(objlead,"new lead button");

                                    reusuable_keyword.setvalueXpath(objfirstname,fname);
                                    reusuable_keyword.setvalueXpath(objlastname, lname);
                                    reusuable_keyword.setvalueXpath(objcompany, company1);

                                    if(fname.equalsIgnoreCase("mr.")) {
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"Mr should be present","Mr is present","PASSED");
                                    }
                                    else{
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"Mr should be present","Mr is  not present","FAILED");

                                    }







                                    break;

                                case "vTiger_Leads_verifyText_Lead:_TC03":
                                    reusuable_keyword.clicklinkbutton(objlead,"new lead button");

                                    String s="Lead:";
                                    if(driver.getPageSource().contains(s)) {
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"lead should be present","lead is present","PASSED");
                                    }
                                    else{
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"lead should be present","lead is  not present","FAILED");

                                    }

                                    break;

                                case "vTiger_Leads_verifyText_Lead Information_TC04":

                                    reusuable_keyword.clicklinkbutton(objlead,"new lead button");


                                    String objleadinfo=prop.getProperty("Leadinfo");
                                    reusuable_keyword.verifyobject(objleadinfo,"lead information");

                                    break;
                                case "vTiger_Leads_verifyText_Description Information_TC05":
                                    //reusuable_keyword.clicklinkbutton(objlead,"new lead button");

                                    String objdescription=prop.getProperty("descriptioninfo");
                                    reusuable_keyword.verifyobject(objdescription,"description info ");
                                    break;
                            }
                            //test caess foer the contacts sheet

                            switch(TCNAME){
                                case "vTiger_Contacts_New Contact_Link_Exist":
                                    reuauablefunction.launchapplication("http://localhost:100/");


                                    reusuable_keyword.setvalue(objusername, uname1);


                                    //entering the value in the password field

                                    reusuable_keyword.setvalue(objpassword, pwd1);


                                    //click on the login button

                                    reusuable_keyword.clickbutton(objlogin,"login button");

                                   //  reusuable_keyword.verifyobject(objnewcontact,"new contact ");


                                    reusuable_keyword.verifylinkobject(objnewcontact,"new contact");


                                    break;
                                case"vTiger_Contacts_Create New Contact and Cancel it":
                                    String firstname=xl.getCellData("Contacts","firstname",i);
                                    String lastname=xl.getCellData("Contacts","lastname",i);
                                    String title1=xl.getCellData("Contacts","title",i);

                                    reusuable_keyword.clicklinkbutton(objnewcontact,"new contact");
                                    reusuable_keyword.setvalueXpath(objfirstname, firstname);
                                    reusuable_keyword.setvalueXpath(objlastname, lastname);
                                    reusuable_keyword.setvalueXpath(objtitle, title1);
                                    reusuable_keyword.clickxpathbutton(objcancel,"cancel button");



                                    break;
                                case"vTiger_Contacts_verifyText_Contact:_TC03":
                                    reusuable_keyword.clicklinkbutton(objnewcontact,"new contact");

                                    String s="Contact: ";
                                    if(driver.getPageSource().contains(s)) {
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"contact should be present","contact is present","PASSED");
                                    }
                                    else{
                                        reuauablefunction.fgInsertResult(vHTMLResultFilePath,TCNAME,"contact should be present","contact is  not present","FAILED");

                                    }

                                    break;
                                case"vTiger_Contacts_verifyText_Customer Portal:TC04":
                                   // reusuable_keyword.clicklinkbutton(objnewcontact,"new contact");



                                    String objcustomerportal=prop.getProperty("customerportal");
                                    reusuable_keyword.verifyobject(objcustomerportal,"customer portal");
                                    break;
                                case "vTiger_Contacts_verifyText_Description Information_TC05":
                                    String objdescription=prop.getProperty("descriptioninfo");
                                    reusuable_keyword.verifyobject(objdescription,"description info in the contact ");

                                    break;
                            }

                        }

                    }
                }
            }
        }

    }
}
