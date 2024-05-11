package com.satvik.flightreservation.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.satvik.flightreservation.entities.Reservation;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class PDFGenerator {

    public void generateItinary(Reservation reservation, String filePath) {

        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(generateTable(reservation));
        } catch (DocumentException  | FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            document.close();
        }
    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Flight Itinary"));
        cell.setColspan(2);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Flight Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Airlines");
        table.addCell(reservation.getFlight().getOperatingAirlines());


        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight Number");
        table.addCell(reservation.getFlight().getFlightNumber());

        table.addCell("Departure Date");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());

        table.addCell("Departure Time");
        table.addCell(reservation.getFlight().getDateOfDeparture().toString());


        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("first Name");
        table.addCell(reservation.getPassenger().getFirstName());

        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLastName());

        table.addCell("Email Id");
        table.addCell(reservation.getPassenger().getEmail());

        table.addCell("Departure Date");
        table.addCell(reservation.getPassenger().getPhone());

        return table;
    }
}
