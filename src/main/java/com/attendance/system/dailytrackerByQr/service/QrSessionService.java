package com.attendance.system.dailytrackerByQr.service;

import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;

public interface QrSessionService  {

    QrSessionDto save(QrSessionDto qrSessionDto);

    QrSessionDto findByToken(String token);
}
