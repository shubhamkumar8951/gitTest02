package testGitUpload04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test02 {
	ExcelOperation eo = new ExcelOperation();

	public void getData01() throws IOException {
		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " +
		// val3);
		System.out.println("executing getData01");
	}

	public void getData02() throws IOException {
		String val1 = eo.getData("Sheet1", "TC01", "Header");
		String val2 = eo.getData("Sheet1", "TC02", "Header");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing getData02");
	}

	public void getData03() throws IOException {
		String val1 = eo.getData("Sheet1", "TC04", "Header");
		String val2 = eo.getData("Sheet1", "TC05", "Header");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing getData03");
	}

	public void getData04() throws IOException {
		String val1 = eo.getData("Sheet1", "TC06", "Val");
		String val2 = eo.getData("Sheet1", "TC07", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " +
		// val3);
		System.out.println("executing getData04");
	}

	public void getData05() throws IOException {
		String val1 = eo.getData("Sheet1", "TC06", "Header");
		String val2 = eo.getData("Sheet1", "TC07", "Header");
		String val3 = eo.getData("Sheet1", "TC03", "Header");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " +
		// val3);
		System.out.println("executing getData05");
	}

	public void putData01() throws IOException {
		eo.putData("Sheet1", "TC01", "Val", "testing011");
		eo.putData("Sheet1", "TC02", "Val", "testing021");
		eo.putData("Sheet1", "TC03", "Val", "testing031");

		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		String val3 = eo.getData("Sheet1", "TC03", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 + " val 3 " +
		// val3);
		System.out.println("executing putData01");
	}

	public void putData02() throws IOException {
		eo.putData("Sheet1", "TC01", "Header", "test01");
		eo.putData("Sheet1", "TC02", "Header", "test02");

		String val1 = eo.getData("Sheet1", "TC01", "Val");
		String val2 = eo.getData("Sheet1", "TC02", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing putData02");
	}

	public void putData03() throws IOException {
		eo.putData("Sheet1", "TC03", "Header", "test0111");
		eo.putData("Sheet1", "TC04", "Header", "test0222");

		String val1 = eo.getData("Sheet1", "TC03", "Val");
		String val2 = eo.getData("Sheet1", "TC04", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing putData03");
	}

	public void putData04() throws IOException {
		eo.putData("Sheet1", "TC05", "Val", "test0111");
		eo.putData("Sheet1", "TC06", "Val", "test0222");

		String val1 = eo.getData("Sheet1", "TC05", "Val");
		String val2 = eo.getData("Sheet1", "TC06", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing putData04");
	}

	public void putData05() throws IOException {
		eo.putData("Sheet1", "TC05", "Val", "test0111");
		eo.putData("Sheet1", "TC06", "Val", "test0222");
		eo.putData("Sheet1", "TC07", "Val", "test0222");

		String val1 = eo.getData("Sheet1", "TC05", "Val");
		String val2 = eo.getData("Sheet1", "TC06", "Val");
		// System.out.println("val 1 " + val1 + " val 2 " + val2 );
		System.out.println("executing putData05");
	}

	public static void main(String args[]) throws IOException, InterruptedException {
		final Test02 t02 = new Test02();

		t02.getData02();
		t02.getData03();
		t02.getData04();
		t02.getData05();
		t02.putData01();
		t02.putData02();
		t02.putData03();
		t02.putData04();
		t02.putData05();

		ExecutorService es = Executors.newFixedThreadPool(5);

		Runnable task1 = new Runnable() {

			public void run() {
				try {
					t02.getData01();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable task2 = new Runnable() {

			public void run() {
				try {
					t02.getData02();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable task3 = new Runnable() {

			public void run() {
				try {
					t02.putData01();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable task4 = new Runnable() {

			public void run() {
				try {
					t02.putData02();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Runnable task5 = new Runnable() {

			public void run() {
				try {
					t02.putData03();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		es.execute(task1);
		es.execute(task2);
		es.execute(task3);
		es.execute(task4);
		es.execute(task5);
//		es.shutdown();
		
		//To wait for certain time for child threads. Main thread will wait until max time out reaches
		es.awaitTermination(150, TimeUnit.SECONDS);
		

	}

}
