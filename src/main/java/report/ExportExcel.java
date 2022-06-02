package report;

import BUS.NguoiDocBUS;
import DTO.NguoiDocDTO;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;

public class ExportExcel {

        public static void main(String[] args) throws IOException {

            NguoiDocBUS nguoiDocBUS = new NguoiDocBUS();
            nguoiDocBUS.findAll();
            final String excelFilePath = "C:\\Users\\pc\\Desktop\\nguoiDoc.xlsx";
            String[] columnsHeader = {"ID", "Họ tên", "SDT", "Ngày sinh", "Địa chỉ", "CMND", "Hạn sử dụng", "Số lượng mượn cho phép", "Trạng thái vi phạm"};
            writeExcel(nguoiDocBUS.getListNguoiDoc(), excelFilePath, "Người ", columnsHeader);
        }

        public static void writeExcel(ArrayList<NguoiDocDTO> list, String excelFilePath, String sheetName, String[] columnsHeader) throws IOException {
            // Create Workbook
            Workbook workbook = getWorkbook(excelFilePath);

            // Create sheet
            Sheet sheet = workbook.createSheet(sheetName); // Create sheet with sheet name

            int rowIndex = 0;

            // Write header
            writeHeader(sheet, rowIndex, columnsHeader);

            // Write data
            rowIndex++;
            for (NguoiDocDTO nguoiDocDTO : list) {
                // Create row
                Row row = sheet.createRow(rowIndex);
                // Write data on row
                writeBook(nguoiDocDTO, row, columnsHeader);
                rowIndex++;
            }

            // Auto resize column witdth
            int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
            autosizeColumn(sheet, numberOfColumn);

            // Create file excel
            createOutputFile(workbook, excelFilePath);
            System.out.println("Done!!!");
        }

        // Create workbook
        private static Workbook getWorkbook(String excelFilePath) throws IOException {
            XSSFWorkbook workbook = new XSSFWorkbook();
            return workbook;
        }

        // Write header with format
        private static void writeHeader(Sheet sheet, int rowIndex, String[] columnsHeader) {
            // create CellStyle
            CellStyle cellStyle = createStyleForHeader(sheet);

            // Create row
            Row row = sheet.createRow(rowIndex);

            // Create cells
            for (int i = 0; i < columnsHeader.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellStyle(cellStyle);
                cell.setCellValue(columnsHeader[i]);
            }
        }

        // Write data
        private static void writeBook(NguoiDocDTO nguoiDocDTO, Row row, String[] columnsHeader) {
            String dto[] = nguoiDocDTO.toString().split(",");
            for (int i = 0; i < columnsHeader.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(dto[i]);
            }

        }

        // Create CellStyle for header
        private static CellStyle createStyleForHeader(Sheet sheet) {
            // Create font
            Font font = sheet.getWorkbook().createFont();
            font.setFontName("Times New Roman");
            font.setBold(true);
            font.setFontHeightInPoints((short) 14); // font size

            // Create CellStyle
            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            cellStyle.setFont(font);
            return cellStyle;
        }

        // Auto resize column width
        private static void autosizeColumn(Sheet sheet, int lastColumn) {
            for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
                sheet.autoSizeColumn(columnIndex);
            }
        }

        // Create output file
        private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
            try (OutputStream os = new FileOutputStream(excelFilePath)) {
                workbook.write(os);
            }
        }



}
