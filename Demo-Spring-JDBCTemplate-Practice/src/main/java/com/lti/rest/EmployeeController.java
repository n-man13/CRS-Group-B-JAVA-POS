package com.lti.rest;
import javax.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dao.EmployeeDAO;
import com.lti.dto.Employee;


@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO employeeDAO;
    @RequestMapping(
            produces = MediaType.APPLICATION_JSON, 
            method = RequestMethod.GET,
            value = "/employeedetails/{id}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployee(
            @PathVariable("id") int id) 
    {
        Employee employee = employeeDAO.getEmployee(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);           
    }
}