package com.ananyevmv.entity;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {

    /**
     * id заметки
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Текст заметки
     */
    @Column(name = "note", nullable = false)
    private String note;

    /**
     * Дата создания заметки
     */
    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    /**
     * Хэштеги заметки
     */
    @ElementCollection
    @CollectionTable(name = "hashtags",
    joinColumns = {
            @JoinColumn(name = "note_id")
    })
    @Column(name = "hashtag", nullable = true)
    private List<String> hashtags;

    /**
     * Название заметки
     */
    @Column(name = "name", nullable = true)
    private String name;

    /**
     * Конструктор по-умолчанию заметки
     */
    public Note() {
        hashtags = new ArrayList<>();
    }

    /**
     * Конструктор с параметрами класса Note
     * @param note текст заметки
     * @param creationDate дата создания
     * @param hashtags список хэштегов (может быть null)
     * @param name название заметки (может быть null)
     */
    public Note(String note, Date creationDate, List<String> hashtags, String name) {
        this.note = note;
        this.creationDate = creationDate;
        this.hashtags = hashtags;
        this.name = name;
    }

    /**
     * Геттер для id заметки
     * @return идентификатор заметки
     */
    public Long getId() {
        return id;
    }

    /**
     * Сеттер для id заметки
     * @param id идентификатор заметки
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Геттер для текста заметки
     * @return текст заметки
     */
    public String getNote() {
        return note;
    }

    /**
     * Сеттер для текста заметки
     * @param note текст заметки
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Геттер для даты создания заметки
     * @return дата создания заметки
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Сеттер для даты создания заметки
     * @param creationDate дата создания заметки
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Геттер для списка хэштегов
     * @return список хэштегов
     */
    public List<String> getHashtags() {
        return hashtags;
    }

    /**
     * Сеттер для списка хэштегов
     * @param hashtags список хэштегов
     */
    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    /**
     * Геттер для имени заметки
     * @return имя заметки
     */
    public String getName() {
        return name;
    }

    /**
     * Сеттер для имени заметки
     * @param name имя заметки
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Переопределение метода toString()
     * @return Строковое представвление заметки
     */
    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", creationDate=" + creationDate +
                ", hashtags=" + hashtags +
                ", name='" + name + '\'' +
                '}';
    }

}
