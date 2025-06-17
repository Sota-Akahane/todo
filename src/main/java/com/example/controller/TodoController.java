package com.example.controller;

import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * タスク関連の処理の制御を行うコントローラクラスです.
 *
 * @author sota-akahane
 */
@Controller
@RequestMapping("")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/showTodoList")
    public String showTodoList() {
        return "todoList";
    }

    @PostMapping("/addTodo")
    public String addTodo(String title, String description) {
        todoService.addTodo(title, description);

        return "todoList";
    }
}
