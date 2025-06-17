package com.example.domain;

/**
 * タスクを表すドメインクラスです.
 *
 * @author sota-akahane
 */
public class Todo {
    /** タスクID */
    private Integer id;
    /** タスクのタイトル */
    private String title;
    /** タスクの説明 */
    private String description;
    /** 完了チェック */
    private Boolean done = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", done=" + done +
                '}';
    }
}
