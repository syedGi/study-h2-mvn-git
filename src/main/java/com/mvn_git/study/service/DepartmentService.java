package com.mvn_git.study.service;

import java.util.List;

import com.mvn_git.study.dto.DepartmentDTO;
import com.mvn_git.study.model.Department;

public interface DepartmentService {

    Department createDepartment(Department department);

    List<Department> getAllDepartments();

//    List<DepartmentDTO> getDepartmentDTOs();

//    List<DepartmentDTOView> getDepartmentDTOView();

    Department updateEmployeeCount(Long id, Integer count);
}
