package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.DepartmentDao;
import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Department;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String getAll(Model model){

        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);

        return  "emp/list";
    }


    @GetMapping("/emp")
    public String addEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("deps",departments);
        return "emp/add";
    }


    //保存操作

    @PostMapping("/emp")
    public String  addEmp(Employee employee){

        System.out.println(employee.toString());
        employeeDao.save(employee);
        return "redirect:/emps";
    }


    //删除操作
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable int id){

        System.out.println("id = " + id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
