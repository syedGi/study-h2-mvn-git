package com.mvn_git.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvn_git.study.dto.DepartmentDTO;
import com.mvn_git.study.model.Department;
import com.mvn_git.study.repos.DepartmentRepository;
import com.mvn_git.study.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department createDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    // Using NamedNativeQuery + Constructor DTO
//    @Override
//    public List<DepartmentDTO> getDepartmentDTOs() {
//        return repository.findDepartmentDTOs();
//    }

    // Using Interface-based DTO (recommended)
//    @Override
//    public List<DepartmentDTOView> getDepartmentDTOView() {
//        return repository.findDepartmentDTOView();
//    }

    // Update using native query
    @Override
    @Transactional
    public Department updateEmployeeCount(Long id, Integer count) {
        repository.updateEmployeeCount(id, count);
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}
