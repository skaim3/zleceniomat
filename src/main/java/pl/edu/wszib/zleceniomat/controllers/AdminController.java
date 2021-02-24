package pl.edu.wszib.zleceniomat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.edu.wszib.zleceniomat.services.IAssignmentService;
import pl.edu.wszib.zleceniomat.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AdminController {
    @Autowired
    IAssignmentService assignmentService;

    @Resource
    SessionObject sessionObject;
}
