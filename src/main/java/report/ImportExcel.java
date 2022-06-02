package report;

import DAO.MyConnection;
import DTO.NguoiDocDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ImportExcel {
    public static void main(String[] args) throws IOException {
        final String excelFilePath = "C:\\Users\\pc\\Desktop\\nguoiDoc.xlsx";
        ArrayList<NguoiDocDTO> listNguoiDoc = readExcel(excelFilePath);
        listNguoiDoc.forEach(System.out::println);
    }

    public static ArrayList<NguoiDocDTO> readExcel(String excelFilePath) throws IOException, IOException {
        ArrayList<NguoiDocDTO> listNguoiDoc = new ArrayList<>();
        // Get file
        InputStream inputStream = new FileInputStream(new File(excelFilePath));

        // Get workbook
        Workbook workbook = new XSSFWorkbook(inputStream);

        // Get sheet
        Sheet sheet = workbook.getSheetAt(0);

        // Get all rows
        Iterator<Row> iterator = sheet.iterator();
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            if (nextRow.getRowNum() == 0) {
                // Ignore header
                continue;
            }

            // Get all cells
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            // Read cells and set value for book object
            ArrayList<Object> cellsValue = new ArrayList<>();
            while (cellIterator.hasNext()) {
                //Read cell
                Cell cell = cellIterator.next();
                Object cellValue = getCellValue(cell);
                if (cellValue == null || cellValue.toString().isEmpty()) {
                    continue;
                }
                cellsValue.add(cellValue);
            }
            String stringValues = cellsValue.toString();
            // VD: "[1, 33, ads]" -> [1, 33, ads]
            String[] list = stringValues.replaceAll("[\\[\\]]", "").split(", ");
            NguoiDocDTO nguoiDocDTO = new NguoiDocDTO();
            nguoiDocDTO.create(list);
            System.out.println(nguoiDocDTO);
            listNguoiDoc.add(nguoiDocDTO);
        }

        workbook.close();
        inputStream.close();

        return listNguoiDoc;
    }

    // Get cell value
    private static Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
                break;
            default:
                break;
        }

        return cellValue;
    }
}

