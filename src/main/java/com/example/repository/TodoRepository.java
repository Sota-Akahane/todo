package com.example.repository;

import com.example.domain.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Todosテーブルを操作するためのリポジトリクラスです.
 *
 * @author sota-akahane
 */
@Repository
public class TodoRepository {
    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final RowMapper<Todo> TODO_ROW_MAPPER = (rs, i) -> {
        Todo todo = new Todo();
        todo.setId(rs.getInt("id"));
        todo.setTitle(rs.getString("title"));
        todo.setDescription(rs.getString("description"));
        todo.setDone(rs.getBoolean("done"));
        return todo;
    };

    /**
     * タスク一覧を取得します.
     *
     * @return タスク一覧
     */
    public List<Todo> findAll() {
        String sql = """
                SELECT id, title, description, done FROM todos
                """;

        return template.query(sql, TODO_ROW_MAPPER);
    }

    /**
     * タスクを登録します.
     *
     * @param title       タスクのタイトル
     * @param description タスクの説明
     */
    public void addTodo(String title, String description) {
        String sql = """
                INSERT INTO todos(title, description, done) VALUES (:title, :description, :done)
                """;

        SqlParameterSource param
                = new MapSqlParameterSource()
                .addValue("title", title)
                .addValue("description", description)
                .addValue("done", false);

        template.update(sql, param);
    }

    /**
     * タスクを削除します.
     *
     * @param id タスクID
     */
    public void delete(Integer id) {
        String sql = """
                DELETE FROM todos WHERE id = :id
                """;

        SqlParameterSource param
                = new MapSqlParameterSource().addValue("id", id);

        template.update(sql, param);
    }
}
