/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

/*
 * @author pc
 */
import BUS.NguoiDocBUS;
import DAO.MyConnection;
import DTO.NguoiDocDTO;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class nguoiDoc {

    public static void main(String[] args) throws SQLException, Exception {
        try {
            File file = new File(".");
            String currentDirFile = file.getAbsolutePath();
            currentDirFile = currentDirFile.substring(0, currentDirFile.length()-1);
   
            Connection con = MyConnection.getConnection();
            String reportPath = currentDirFile + "\\src\\main\\report\\report1.jrxml";
            System.out.println(reportPath);
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp);
            con.close();
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

}
