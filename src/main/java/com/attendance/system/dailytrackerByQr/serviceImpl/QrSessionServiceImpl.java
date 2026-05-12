package com.attendance.system.dailytrackerByQr.serviceImpl;

import com.attendance.system.dailytrackerByQr.converter.SubjectConverter;
import com.attendance.system.dailytrackerByQr.dto.QrSessionDto;
import com.attendance.system.dailytrackerByQr.dao.QrSessionDao;
import com.attendance.system.dailytrackerByQr.dao.SubjectDao;
import com.attendance.system.dailytrackerByQr.entity.QrSession;
import com.attendance.system.dailytrackerByQr.service.QrSessionService;
import org.springframework.stereotype.Service;

@Service
public class QrSessionServiceImpl implements QrSessionService {

    private final SubjectDao subjectDao;

    private final QrSessionDao qrSessionDao;

    public QrSessionServiceImpl(QrSessionDao qrSessionDao, SubjectDao subjectDao) {
        this.qrSessionDao = qrSessionDao;
        this.subjectDao = subjectDao;
    }

    public QrSessionDto save(QrSessionDto qrSessionDto) {
        QrSession qrSession = new QrSession();
        qrSession.setDate(qrSessionDto.getDate());
        qrSession.setSubject(subjectDao.findById(qrSessionDto.getSubjectDto().getId()));
        qrSession.setToken(qrSessionDto.getToken());
        qrSessionDao.save(qrSession);
        qrSessionDto.setId(qrSession.getId());
        return qrSessionDto;
    }

    public QrSessionDto findByToken(String token){
        QrSessionDto qrSessionDto= new QrSessionDto();
        QrSession qrSession= qrSessionDao.findByToken(token);
         if(qrSession!=null&& qrSession.getId()!=null){
             qrSessionDto.setId(qrSession.getId());
             qrSessionDto.setDate(qrSession.getDate());
             qrSessionDto.setToken(qrSession.getToken());
             qrSessionDto.setSubjectId(qrSession.getSubject().getId());
             qrSessionDto.setSubjectDto(SubjectConverter.toDto(qrSession.getSubject()));
         }
         return qrSessionDto;
    }


}
