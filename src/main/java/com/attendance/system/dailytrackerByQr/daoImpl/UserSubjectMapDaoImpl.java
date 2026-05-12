package com.attendance.system.dailytrackerByQr.daoImpl;

import com.attendance.system.dailytrackerByQr.dao.UserSubjectMapDao;
import com.attendance.system.dailytrackerByQr.entity.User;
import com.attendance.system.dailytrackerByQr.entity.UserSubjectMap;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserSubjectMapDaoImpl extends GenericDaoImpl<UserSubjectMap, Long>  implements UserSubjectMapDao {

    @Override
    public List<UserSubjectMap> findAllBySubjectId(Long subjectId) {

        try {
            return entityManager.createQuery("SELECT u FROM UserSubjectMap u WHERE u.subject.id = :subjectId",UserSubjectMap.class)
                    .setParameter("subjectId", subjectId)
                    .getResultList();

        } catch (Exception e) {
            return null;
        }
    }
}
