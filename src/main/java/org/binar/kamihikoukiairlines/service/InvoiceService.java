package org.binar.kamihikoukiairlines.service;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.binar.kamihikoukiairlines.model.Booking;
import org.binar.kamihikoukiairlines.model.Passenger;
import org.binar.kamihikoukiairlines.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class InvoiceService {
    @Autowired
    BookingRepository bookingRepository;

    public byte[] generateTicket(Long bookingId) throws Exception {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new Exception("Booking not found"));

        InputStream reportTemplate = getClass().getResourceAsStream("/ticket/kamihikouki.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("bookingId", bookingId);
        List<Passenger> passengers = booking.getPassengersList();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(passengers);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        log.info("Has successfully  generate ticket for booking id: " + bookingId);
        return pdfBytes;
    }
}
