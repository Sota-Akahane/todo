package com.example.controller;

import com.example.domain.Todo;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * タスク関連の処理の制御を行うコントローラクラスです.
 *
 * @author sota-akahane
 */
@Controller
@RequestMapping("/")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/showTodoList")
    public String showTodoList(Model model) {
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @PostMapping("/addTodo")
    public String addTodo(String title, String description, Model model) {
        todoService.addTodo(title, description);

        return "redirect:/showTodoList";
    }

    @PostMapping("/deleteTodo")
    public String delete(String id, Model model) {
        int intId = Integer.parseInt(id);
        todoService.delete(intId);

        return showTodoList(model);
    }
}
