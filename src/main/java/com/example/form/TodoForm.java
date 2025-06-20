package com.example.form;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * タスク登録時に使用するフォームクラスです.
 *
 * @author sota-akahane
 */
public class TodoForm {
    /**
     * タスクのタイトル
     */
    @NotBlank(message = "タスクを入力してください。")
    private String title;
    /**
     * タスクの説明
     */
    @Length(min = 0, max = 150, message = "説明は150文字以内で入力してください。")
    private String description;

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

    @Override
    public String toString() {
        return "TodoForm{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
