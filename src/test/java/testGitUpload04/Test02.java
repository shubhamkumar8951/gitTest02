package testGitUpload04;

import java.io.IOException;

public class Test02 {
	ExcelOperation eo = new ExcelOperation();
	
	public void getData01() throws IOException{
		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " + val3);
	}
	
	public void getData02() throws IOException{
		String val1 = eo.getData("Sheet1", "TC01", "Header");
		String val2 = eo.getData("Sheet1", "TC02", "Header");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}
	
	public void getData03() throws IOException{
		String val1 = eo.getData("Sheet1", "TC04", "Header");
		String val2 = eo.getData("Sheet1", "TC05", "Header");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}
	
	public void getData04() throws IOException{
		String val1 = eo.getData("Sheet1", "TC06", "Val");
		String val2 = eo.getData("Sheet1", "TC07", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " + val3);
	}
	
	public void getData05() throws IOException{
		String val1 = eo.getData("Sheet1", "TC06", "Header");
		String val2 = eo.getData("Sheet1", "TC07", "Header");
		String val3 = eo.getData("Sheet1", "TC03", "Header");
		System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " + val3);
	}
	
	public void putData01() throws IOException {
		eo.putData("Sheet1", "TC01", "Val", "testing011");
		eo.putData("Sheet1", "TC02", "Val", "testing021");
		eo.putData("Sheet1", "TC03", "Val", "testing031");

		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " + val3);
	}
	
	public void putData02() throws IOException {
		eo.putData("Sheet1", "TC01", "Header", "test01");
		eo.putData("Sheet1", "TC02", "Header", "test02");

		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}
	
	public void putData03() throws IOException {
		eo.putData("Sheet1", "TC03", "Header", "test0111");
		eo.putData("Sheet1", "TC04", "Header", "test0222");

		String val1 = eo.getData("Sheet1", "TC03", "Val");
		String val2 = eo.getData("Sheet1", "TC04", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}
	
	public void putData04() throws IOException {
		eo.putData("Sheet1", "TC05", "Val", "test0111");
		eo.putData("Sheet1", "TC06", "Val", "test0222");

		String val1 = eo.getData("Sheet1", "TC05", "Val");
		String val2 = eo.getData("Sheet1", "TC06", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}
	
	public void putData05() throws IOException {
		eo.putData("Sheet1", "TC05", "Val", "test0111");
		eo.putData("Sheet1", "TC06", "Val", "test0222");
		eo.putData("Sheet1", "TC07", "Val", "test0222");

		String val1 = eo.getData("Sheet1", "TC05", "Val");
		String val2 = eo.getData("Sheet1", "TC06", "Val");
		System.out.println("val 1 " + val1 + " val 2 " + val2 );
	}

	public static void main(String args[]) throws IOException {
		Test02 t02 = new Test02();
		t02.getData01();
		t02.getData02();
		t02.getData03();
		t02.getData04();
		t02.getData05();
		t02.putData01();
		t02.putData02();
		t02.putData03();
		t02.putData04();
		t02.putData05();
		
		
	}

}
