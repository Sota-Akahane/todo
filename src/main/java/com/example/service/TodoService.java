package com.example.service;

import com.example.domain.Todo;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * タスク関連の業務処理を行うサービスクラスです.
 *
 * @author sota-akahane
 */
@Service
@Transactional
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    /**
     * タスク一覧を取得します.
     *
     * @return タスク一覧
     */
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

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
