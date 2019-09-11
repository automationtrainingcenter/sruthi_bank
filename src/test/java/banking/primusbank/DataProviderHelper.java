package banking.primusbank;

import org.testng.annotations.DataProvider;

import utitlities.ExcelHelper;

public class DataProviderHelper {

	@DataProvider(name = "employeeDP")
	public Object[][] getEmpData() {
		ExcelHelper excel = new ExcelHelper();
		return excel.getExcelData("resources", "data.xls", "empdata");
	}
	
	@DataProvider(name="roleDP")
	public Object[][] getRoleData(){
		ExcelHelper excel = new ExcelHelper();
		return excel.getExcelData("resources", "data.xls", "roledata");
	}

}
