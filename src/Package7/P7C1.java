package Package7;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class P7C1 {

	public static void main(String[] args) throws IOException {
		
		// ======== DRIVING DATA FROM EXCEL ========
		
		String root = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(root+"/excel.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String TCName = "Purchase";	
	
		System.out.println(getTCData(workbook,TCName));
	
	}
	
	
	// --------------------------------------------------------------------------------
	
	
	// Function to Get Test Cases From Excel 
	
	public static ArrayList<String> getTCData(Workbook workbook, String TCName) {
		
		int sheets = workbook.getNumberOfSheets();
		ArrayList<String> values = new ArrayList<String>();
		
		for (int i=0; i<sheets; i++)
		{
			XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(i);	// Sheet = Collection of Rows.
			String sheetName = sheet.getSheetName();
			
			if ( sheetName.equalsIgnoreCase("Sample") )
			{
				Iterator<Row> rows = sheet.iterator();	// Row = Collection of Cells.
				// Get First Row
				Row firstRow = rows.next();
				Iterator<Cell> firstRowCells = firstRow.cellIterator();
				int colIndexTC = 0;
				int rowIndexP = 0;
				
				// Loop Over First Row & Get Column Index Of "Test Cases" Cell 
				while (firstRowCells.hasNext()) 
				{
					Cell cell = firstRowCells.next();
					if (cell.getStringCellValue().equalsIgnoreCase("Test Cases"))
						colIndexTC = cell.getColumnIndex();
				}
				
				// Loop Over All Rows To Get Row Index Of "Purchase" Cell
				while (rows.hasNext())
				{
					Row row = rows.next();
					Cell cell = row.getCell(colIndexTC);
					if (cell.getStringCellValue().equalsIgnoreCase(TCName))
						rowIndexP = cell.getRowIndex();
				}	
				
				// Store Cells Of "Purchase" Row In ArrayList
			 	Iterator<Cell> purchase =  sheet.getRow(rowIndexP).cellIterator();
			 	purchase.next();	// Move to next Cell.
			 	
			 	while (purchase.hasNext()) 
			 	{
			 		Cell purchaseCell = purchase.next();
		 			if (purchaseCell.getCellType() == CellType.STRING)
		 			{
		 				String value = purchaseCell.getStringCellValue();
		 				values.add(value);
		 			}
		 			else
		 			{
		 				String value = NumberToTextConverter.toText(purchaseCell.getNumericCellValue());
		 				values.add(value);
		 			}
			 	}
			}
		}
		return values;
	}

}
