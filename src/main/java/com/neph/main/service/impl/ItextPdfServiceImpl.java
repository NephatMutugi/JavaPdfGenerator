package com.neph.main.service.impl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.neph.main.service.ItextPdfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ Author Nephat Muchiri
 * Date 31/07/2023
 */
@Slf4j
@Component
public class ItextPdfServiceImpl implements ItextPdfService {
    @Override
    public void createPdf() {

        try{
            Document document =  new Document();
            PdfWriter.getInstance(document, new FileOutputStream("pdf/iTextHelloWorld.pdf"));
            document.open();
            Font font = FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("PDF CREATOR", font);
            document.add(chunk);

            log.info("New Document");

            font = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.BLUE);
            chunk = new Chunk("This is my new pdf", font);
            document.add(chunk);

            log.info("Document 2");
            document.close();

        } catch (FileNotFoundException ex){
            log.error("------\tFileNotFoundException\t----- {}", ex.getMessage());
        } catch (DocumentException e) {
            log.error("------\tDocumentException\t----- {}", e.getMessage());
        }
    }
}
