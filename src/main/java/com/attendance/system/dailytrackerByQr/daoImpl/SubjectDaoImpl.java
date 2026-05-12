package com.attendance.system.dailytrackerByQr.daoImpl;

import com.attendance.system.dailytrackerByQr.dao.SubjectDao;
import com.attendance.system.dailytrackerByQr.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDaoImpl extends GenericDaoImpl<Subject, Long> implements SubjectDao {
}
