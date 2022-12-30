package com.qa.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.IllegalFormatException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Base.TestBase;


public class TestUtil extends TestBase {
	public TestUtil() throws IOException {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "/src/main/java/com/qa/testData/testDATA.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTextData(String sheetName)
			throws EncryptedDocumentException, IOException, IllegalFormatException {
		FileInputStream file = null;
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	public static String getScreenshots() throws Exception {		
		try {
			File file = new File(System.getProperty("user.dir") + "/test-output/extentReport/snapshot");
			file.mkdir();

			String dateName = new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);

			String destination = file.getAbsolutePath() + "\\"
					+ Paths.get(Paths.get("").toAbsolutePath().toString()).getFileName() + "_" + dateName + ".png";

			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);

			destination = "./snapshot/" + Paths.get(Paths.get("").toAbsolutePath().toString()).getFileName() + "_"
					+ dateName + ".png";

			return destination;

		} catch (Exception e) {
			throw e;
		}

	}
}
