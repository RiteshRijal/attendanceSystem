package com.attendance.system.dailytrackerByQr.dao;

import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;

import java.util.List;

public interface UserSubjectMapDao extends GenericDao<UserSubjectMap, Long>  {

    public List<UserSubjectMap> findAllBySubjectId(Long subjectId);

}
