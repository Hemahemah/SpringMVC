package com.zlh.mvc.controller;

import com.zlh.mvc.bean.Employee;
import com.zlh.mvc.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public ModelAndView getAllEmployee(){
        Collection<Employee> employees = employeeDao.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("employees",employees);
        modelAndView.setViewName("employee_list");
        return modelAndView;
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";//重定向
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String getEmployeeById(@PathVariable Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }


}
