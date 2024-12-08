package com.EmployeeTest.repo;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmployeeTest.Entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
