package com.mvn_git.study.repos;

import java.sql.Timestamp;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mvn_git.study.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
//	@Query("SELECT IMM FROM (SELECT IMM.IMAGE_ID, IMM.CREATION_DATE, STATUS, USERNAME, SECURITY_GROUP, DOCTYPE, FILENAME_CRYPTED, LABEL, (SELECT MAX(SEQUENCENUMBER)+1 FROM IMAGE_ENCRYPTED IM WHERE IM.IMAGE_ID = IMM.IMAGE_ID AND IM.CREATION_DATE >= ?) AS PAGECOUNT FROM IMAGE_MASTER IMM WHERE IMM.STATUS IN (?,?) AND IMM.DOC_CASE_ID = 0 AND IMM.CASEFILEID = 0 GROUP BY IMM.IMAGE_ID, IMM.CREATION_DATE, STATUS, USERNAME, SECURITY_GROUP, DOCTYPE, FILENAME_ENCRYPTED, LABEL ORDER BY IM.CREATION_DATE) WHERE PAGECOUNT IS NOT NULL")
//	public void findTheQueryGiven(@Param("CREATION_DATE") Timestamp creation_date,
//			Pageable pg);

}
