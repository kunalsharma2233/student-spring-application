package com.student.studentmanagement.student;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.naming.Binding;
import java.util.List;

@Controller
@SessionAttributes("name")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "list-students")
    public String listAllStudents(ModelMap model) {
        String userName = getLoggedInUsername(model);
        List<Student> student = studentService.findByUserName(userName);
        model.addAttribute("student", student);
        return "listStudents";
    }

    @RequestMapping(value = "add-student", method = RequestMethod.GET)
    public String showAddStudentPage(ModelMap model) {
        String userName = getLoggedInUsername(model);
        Student student = new Student(0, userName, "", "");
        model.put("student", student);
        return "addStudent";
    }

    @RequestMapping(value = "add-student", method = RequestMethod.POST)
    public String addNewStudent(ModelMap model, @Valid Student student, BindingResult result) {
        if(result.hasErrors()) {
            return "addStudent";
        }
        String userName = getLoggedInUsername(model);
        studentService.addStudent(userName, student.getStudentname(), student.getStandard());
        return "redirect:list-students";
    }

    @RequestMapping(value = "delete-student")
    public String deleteStudent(@RequestParam int id) {
        studentService.deleteById(id);
        return "redirect:list-students";
    }

    @RequestMapping(value = "update-student", method = RequestMethod.GET)
    public String showUpdateStudentPage(@RequestParam int id, ModelMap model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "addStudent";
    }

    @RequestMapping(value = "update-student", method = RequestMethod.POST)
    public String updateStudent(ModelMap model, @Valid Student student, BindingResult result) {
        if(result.hasErrors()) {
            return "addStudent";
        }
        String username = getLoggedInUsername(model);
        student.setUsername(username);
        studentService.updateStudent(student);
        return "redirect:list-students";
    }

    private String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

}
