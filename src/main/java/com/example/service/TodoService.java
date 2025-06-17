package com.example.service;

import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * タスク関連の業務処理を行うサービスクラスです.
 *
 * @author sota-akahane
 */
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    /**
     * タスクを登録します.
     *
     * @param title       タスクのタイトル
     * @param description タスクの説明
     */
    public void addTodo(String title, String description) {
        todoRepository.addTodo(title, description);
    }
}
