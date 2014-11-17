import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.swing.*;
import java.io.*;

public class ScoreList {
    int[] scores;
    String[] players;

    ScoreList(String fileName) {
        File file = new File(fileName);
        scores = new int[5];
        players = new String[5];
        try {

            if (!file.exists()){
                try {
                    HSSFWorkbook wb = new HSSFWorkbook();
                    FileOutputStream fileOut = new FileOutputStream(file);
                    wb.createSheet("new sheet");
                    wb.write(fileOut);
                    fileOut.close();

                } catch (IOException e) {

                    throw new IllegalStateException(e.getMessage());
                }
            }
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows;
            rows = sheet.getPhysicalNumberOfRows();
            int i = 0;

            for(int j = 0; j < 5 && j < rows; j++) {
                row = sheet.getRow(j);
                cell  = row.getCell(0);
                players[i] = cell.toString();
                cell  = row.getCell(1);
                scores[i++] = (int)cell.getNumericCellValue();
            }

        } catch(IOException e) {
            throw new RuntimeException(e);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Incorrect score list.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void writeNewList() {
        FileOutputStream writer = null;
        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("new sheet");

            int i = 0;
            for (String user : players) {
                if (user == null) {
                    break;
                }
                Row row = sheet.createRow((short)i);
                row.createCell(0).setCellValue(user);
                row.createCell(1).setCellValue(scores[i++]);
            }

            writer = new FileOutputStream("ScoreList.xls");
            wb.write(writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
