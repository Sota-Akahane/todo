package com.example.controller;

import com.example.domain.Todo;
import com.example.form.TodoForm;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
    public String showTodoList(TodoForm todoForm, Model model) {
        List<Todo> todoList = todoService.findAll();
        model.addAttribute("todoList", todoList);
        return "todoList";
    }

    @PostMapping("/addTodo")
    public String addTodo(@Validated TodoForm todoForm,
                          BindingResult result,
                          Model model) {

        if (result.hasErrors()) {
            return showTodoList(todoForm, model);
        }

        todoService.addTodo(todoForm.getTitle(), todoForm.getDescription());

        return "redirect:/showTodoList";
    }

    @PostMapping("/deleteTodo")
    public String delete(Integer id, TodoForm todoForm, Model model) {
        todoService.delete(id);

        return showTodoList(todoForm, model);
    }
}
