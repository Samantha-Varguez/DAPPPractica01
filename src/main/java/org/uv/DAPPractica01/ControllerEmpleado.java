
package org.uv.DAPPractica01;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/employees")
public class ControllerEmpleado {

    @GetMapping()
    public List<DTOEmpleado> list() {
        List<DTOEmpleado> employeeDtoList = new ArrayList<>();

        DTOEmpleado employeeDto = new DTOEmpleado();
        employeeDto.setId(10L);
        employeeDto.setName("Gerson");
        employeeDto.setAddress("Av 1");
        employeeDto.setPhoneNumber("1111");

        employeeDtoList.add(employeeDto);

        return employeeDtoList;
    }

    @GetMapping("/{id}")
    public DTOEmpleado get(@PathVariable Long id) {
        if (id == 10) {
            DTOEmpleado employeeDto = new DTOEmpleado();

            employeeDto.setId(10L);
            employeeDto.setName("Gerson");
            employeeDto.setAddress("Av 1");
            employeeDto.setPhoneNumber("1111");

            return employeeDto;
        } else {
            DTOEmpleado employeeDto2 = new DTOEmpleado();

            employeeDto2.setId(11L);
            employeeDto2.setName("Alejandra");
            employeeDto2.setAddress("Av 2");
            employeeDto2.setPhoneNumber("2222");

            return employeeDto2;
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTOEmpleado> put(@PathVariable Long id, @RequestBody DTOEmpleado employeeToUpdate) {
        if (id == 100) {
            DTOEmpleado employeeDto = new DTOEmpleado();

            employeeDto.setId(10L);
            employeeDto.setName(employeeToUpdate.getName());
            employeeDto.setAddress(employeeToUpdate.getAddress());
            employeeDto.setPhoneNumber(employeeToUpdate.getPhoneNumber());

            return ResponseEntity.ok(employeeDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<DTOEmpleado> post(@RequestBody DTOEmpleado newEmployee) {
        DTOEmpleado employee = new DTOEmpleado();
        employee.setId(100L);
        employee.setName(newEmployee.getName());
        employee.setAddress(newEmployee.getAddress());
        employee.setPhoneNumber(newEmployee.getPhoneNumber());

        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public void handleError() {
    
}
}