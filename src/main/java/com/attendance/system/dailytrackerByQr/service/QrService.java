package com.attendance.system.dailytrackerByQr.service;


public interface QrService {

    byte[] generateQr(String text) throws Exception;
}
