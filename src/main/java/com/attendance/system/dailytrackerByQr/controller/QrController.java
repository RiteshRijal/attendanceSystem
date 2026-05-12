package com.attendance.system.dailytrackerByQr.controller;

import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;
import com.attendance.system.dailytrackerByQr.dto.SubjectDto;
import com.attendance.system.dailytrackerByQr.service.QrService;
import com.attendance.system.dailytrackerByQr.service.QrSessionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qr")
@CrossOrigin
public class QrController {

    private final QrService qrService;

    private final QrSessionService qrSessionService;

    public QrController(QrService qrService, QrSessionService qrSessionService) {

        this.qrService = qrService;
        this.qrSessionService= qrSessionService;
    }

    @GetMapping(produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateQr(@RequestParam String text) throws Exception {

        return qrService.generateQr(text);
    }

    @GetMapping("/{token}")
    public QrSessionDto getByToken(@PathVariable String token) {
        return qrSessionService.findByToken(token);
    }
}