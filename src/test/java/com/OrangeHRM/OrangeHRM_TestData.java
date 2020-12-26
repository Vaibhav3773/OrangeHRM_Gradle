package com.OrangeHRM;

import org.testng.annotations.DataProvider;

import readDataFromExcel.ReadExcel;

public class OrangeHRM_TestData {

    @DataProvider(name = "Login", parallel=true)
    public Object[][] getDataforLogin() {
    // Multidimensional Object
    // 3X3 or 4X3 or 4X5
    return new Object[][] {

    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "Admin", "admin123" },
    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "dixit5", "admin123" },
    { "https://opensource-demo.orangehrmlive.com/index.php/auth/login", "kumar", "admin123" }
    };

    }
    
    @DataProvider(name = "LoginScenario")
    public Object[][] getDataforLoginDifferentScenarios() {
    return new Object[][] {
    { "admin", "", "Password cannot be empty"},
    { "", "admin123", "Username cannot be empty" },
    { "AdminWrong", "admin123", "Invalid credentials" },
    { "admin", "admin", "Invalid credentials" },
    { "admin", "admin123", "Dashboard" } };

    }
    
    //-------------------------------------------- This is to read Excel Data------------

    @DataProvider(name = "LoginExcelData")
    public Object[][] Authentication() throws Exception{
        ReadExcel excel = new ReadExcel();
        System.getProperty("user.dir");
        Object[][] testObjArray = excel.getExcelData("C:\\Users\\ghan01\\excel.xls","SignIn");
       // Object[][] testObjArray = excel.getExcelData(RelativePath+"\\OrangeHRM_TestData.xls","SignIn");
        System.out.println(testObjArray);
        return testObjArray;

    }
}
