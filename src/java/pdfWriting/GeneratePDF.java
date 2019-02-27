package pdfWriting;

import clearance_management.StudentBean;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.read;

/**
 * First iText example: Hello World.
 */
public class GeneratePDF {

    public static void main(String[] args)
            throws DocumentException, IOException, NullPointerException, ClassNotFoundException, SQLException {

        GeneratePDF.createPdf("BDU0800027UR");

    }

    public static void createQrPdf(String id) {
    String hold="";
        try {
            StudentBean sb = read.getStudent(id);
            hold="Name  :  "+sb.getFirstName()+" "+sb.getLastname();
            hold="\nID   : "+sb.getId();
            hold="\nProgram   : "+sb.getProgram();
            hold="\nDepartment  : "+sb.getDepartment();
            hold="\nInitiator   : "+read.getAUser(read.getClearance(id).getInitiator()).getFirstName()+" "+read.getAUser(read.getClearance(id).getInitiator()).getLastName();
            hold="\nReason   : "+read.getClearance(id).getReason();
            hold="\nID   : "+sb.getId();
               
            
        } catch (NullPointerException | ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }

    public static void createPdf(String id)
            throws DocumentException, IOException, NullPointerException, ClassNotFoundException, SQLException {
        GeneratePDF gp = new GeneratePDF();
// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(id + ".pdf"));
        // step 3
        document.open();
        // step 4
        Font f1 = new Font(FontFamily.COURIER, 18.0f, Font.UNDERLINE, BaseColor.BLUE);
        Font f2 = new Font(FontFamily.TIMES_ROMAN, 7.0f, Font.UNDERLINE, BaseColor.BLACK);

        StudentBean sb = read.getStudent(id);
        Paragraph paragraph1 = new Paragraph(" BAHIR DAR UNIVERSITY OFFICE OF REGISTRAR " + gp.program(sb.getProgram().toUpperCase()) + " STUDENT CLEARANCE SHEET", f1);

        paragraph1.setIndentationLeft(30);
        paragraph1.setIndentationRight(80);
        paragraph1.setAlignment(Element.ALIGN_CENTER);
        paragraph1.setSpacingAfter(15);
//                               
        Paragraph i = new Paragraph("Id Number  - " + sb.getId());
        i.setSpacingBefore(15);
        i.setAlignment(Element.ALIGN_LEFT);
        Paragraph fn = new Paragraph(" Name - " + sb.getFirstName().toUpperCase() + " " + sb.getLastname().toUpperCase());
        fn.setSpacingBefore(14);
        fn.setAlignment(Element.ALIGN_LEFT);

        Paragraph prog = new Paragraph("Program - " + sb.getProgram() + "/ department - " + sb.getDepartment() + "/   year - " + sb.getYear() + " / section - " + sb.getSection());
        prog.setSpacingBefore(15);
        prog.setAlignment(Element.ALIGN_LEFT);

        Paragraph init = new Paragraph("Initiator  - " + read.getAUser(read.getClearance(id).getInitiator()).getFirstName()+" "+read.getAUser(read.getClearance(id).getInitiator()).getLastName());
        init.setSpacingBefore(15);
        init.setAlignment(Element.ALIGN_LEFT);
        Paragraph res = new Paragraph("Reason For Clearnace  - " + read.getClearance(id).getReason());
        res.setSpacingBefore(15);
        Font bold = new Font(FontFamily.TIMES_ROMAN, 26, Font.BOLD);
        res.setFont(bold);
        res.setAlignment(Element.ALIGN_LEFT);

        Paragraph re = new Paragraph("Reason For Clearnace  - ");
        re.setSpacingBefore(15);
        re.setAlignment(Element.ALIGN_LEFT);

        PdfPTable table = new PdfPTable(new float[]{2, 1, 2});
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("office    ");
        table.addCell("approved by  ");
        table.addCell("approval date ");
        table.setHeaderRows(1);
        PdfPCell[] cells = table.getRow(0).getCells();
        for (int j = 0; j < cells.length; j++) {
            cells[j].setBackgroundColor(BaseColor.GRAY);
        }
        ApprovalInfo af[] = null;
        try {
            af = FetchClearanceInfo.fetchAll(id);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        for (int ii = 1; ii < af.length; ii++) {
            table.addCell(af[ii].getOffice());
            table.addCell(af[ii].getApprover());
            table.addCell(String.valueOf(af[ii].getApprovalDate()));
        }

        Chunk sigUnderline = new Chunk("                                            ");
        sigUnderline.setUnderline(0.7f, -9f);
        Calendar c = new GregorianCalendar();
        java.util.Date d = c.getTime();
        Font f = new Font(FontFamily.TIMES_ROMAN, 15.0f, Font.UNDERLINE, BaseColor.RED);

        //Paragraph p=new Paragraph("New PdF",f);
        Paragraph g = new Paragraph("GENERATED BY CMS " + String.valueOf(d), f);
        g.setAlignment(Element.ALIGN_RIGHT);

        //paragraph1.add(sigUnderline);
        document.add(paragraph1);
        //document.add(paragraph2);
        document.add(Chunk.NEWLINE);
        //  document.add(paragraph3);
        document.add(i);
        document.add(fn);
        document.add(prog);
        document.add(init);
        document.add(res);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);

        document.add(table);
        document.add(Chunk.NEWLINE);
        document.add(Chunk.NEWLINE);
        document.add(g);
        // step 5
        document.close();
    }

    public String program(String p) {
        String msg = "";
        switch (p.toLowerCase()) {
            case "ur":
                msg = "Regular";
                break;
            case "us":
                msg = "Regular";
                break;
            case "pr":
            case "ps":
                msg = "Post Graduate";
                break;
            case "ue":
                msg = "Extension";
                break;
            default:
                break;
        }
        return msg.toUpperCase();
    }
}
