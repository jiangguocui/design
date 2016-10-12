package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *转换成PDF
 *
 * <p>Title: Module Information         </p>
 * <p>Description: Function Description </p>
 * <p>Copyright: Copyright (c) 2016     </p>
 * <p>Company: ND Co., Ltd.       </p>
 * <p>Create Time: 2016年10月12日           </p>
 * @author Administrator
 * <p>Update Time:                      </p>
 * <p>Updater:                          </p>
 * <p>Update Comments:                  </p>
 */
public class PDFUtil {
    
   public static void ToPDF(OutputStream file ,Document document){
       try {
        PdfWriter.getInstance(document, file);
           document.open();
           
           document.add(new Paragraph("Hello Kiran"));  
           document.add(new Paragraph(new Date().toString()));  

           document.close();  
           file.close();
    } catch (DocumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }  

   }
   
   public static void main(String[] args) throws FileNotFoundException {
       OutputStream file = new FileOutputStream(new File("C:\\Test.pdf"));  

       Document document = new Document(); 
       
       PDFUtil.ToPDF(file, document);
}
}
