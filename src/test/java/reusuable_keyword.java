import org.openqa.selenium.By;

public class reusuable_keyword {


    public static void verifyobject(String object, String objectname) {
        try {
            if (driver_script.driver.findElement(By.xpath(object)).isDisplayed())
            //  if(driver_script.driver.findElements(By.name(object)).size()==1)
            {

                driver_script.driver.findElement(By.xpath(object)).isDisplayed();
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, objectname + " should be present", objectname + " is present", "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, objectname + " should be present", objectname + " is present", "PASSED");

            }
        } catch (Throwable e) {

        }
    }

    public static void setvalue(String object, String val) {
        driver_script.driver.findElement(By.name(object)).clear();
        driver_script.driver.findElement(By.name(object)).sendKeys(val);
        try {
            if (driver_script.driver.findElement(By.name(object)).getAttribute("value").equals(val)) {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "Value Should be enter as " + val, "Values enter successfuly as " + val, "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "Value Should be enter as " + val, "Values not  enter successfuly as " + val, "FAILED");

            }
        } catch (Throwable e) {

        }

    }

    public static void clickbutton(String object, String buttonname) {
        try {
            if (driver_script.driver.findElements(By.name(object)).size() == 1) {

                driver_script.driver.findElement(By.name(object)).click();
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "should be successfully click on the " + buttonname, "successfully click on the  " + buttonname, "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "should be successfully click on the " + buttonname, " not successfully click on the" + buttonname, "FAILED");

            }
        } catch (Throwable e) {

        }
    }

    public static void clicklinkbutton(String object, String linkbutton) {
        try {
            if (driver_script.driver.findElements(By.linkText(object)).size() == 1) {
                driver_script.driver.findElement(By.linkText(object)).click();
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, " should be successfully click on the  " + linkbutton, "successfully click on the  " + linkbutton, "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, " should be successfully click on the " + linkbutton, "successfully  not click on the " + linkbutton, "FAILED");

            }
        } catch (Throwable e) {

        }

    }

    public static void setvalueXpath(String object, String val) {
        driver_script.driver.findElement(By.xpath(object)).clear();
        driver_script.driver.findElement(By.xpath(object)).sendKeys(val);
        try {
            if (driver_script.driver.findElement(By.xpath(object)).getAttribute("value").equals(val)) {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "Value Should be enter as " + val, "Values enter successfuly as " + val, "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "Value Should be enter as " + val, "Values not  enter successfuly as " + val, "FAILED");

            }
        } catch (Throwable e) {

        }

    }

    public static void clickxpathbutton(String object, String xbuttonname) {
        try {
            if (driver_script.driver.findElements(By.xpath(object)).size() != 1) {
                driver_script.driver.findElement(By.xpath(object)).click();
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "should be clicked on the  " + xbuttonname, "successfully click on the  " + xbuttonname, "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, "should be clicked on the  " + xbuttonname, " not successfully click on the  " + xbuttonname, "FAILED");

            }
        } catch (Throwable e) {

        }

    }

    public static void verifylinkobject(String object, String linkbutttonname) throws Throwable {
        try {
            if (driver_script.driver.findElement(By.linkText(object)).isDisplayed())
            //  if(driver_script.driver.findElements(By.name(object)).size()==1)
            {

                driver_script.driver.findElement(By.linkText(object)).isDisplayed();
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, linkbutttonname + " should be present", linkbutttonname + " is present", "PASSED");


            } else {
                reuauablefunction.fgInsertResult(driver_script.vHTMLResultFilePath, driver_script.TCNAME, linkbutttonname + " should be present", linkbutttonname + " is present", "PASSED");

            }
        } catch (Exception e) {

        }


    }
}
