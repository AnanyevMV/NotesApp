package com.ananyevmv.dao;

import com.ananyevmv.entity.Note;

import java.sql.Date;
import java.util.List;

public interface NotesDAO {

    /**
     * Метод для сохранения заметки
     * @param note заметка
     */
    public void saveNote(Note note);

    /**
     * Метод для обновления заметки
     * @param note заметка
     */
    public void updateNote(Note note);

    /**
     * Метод для удаления заметки
     * @param id идентификатор заметки
     */
    public void deleteNote(Long id);

    /**
     * Метод для получения списка заметок
     * @return список заметок
     */
    public List<Note> getNotes();

    /**
     * Метод для получения списка заметок с конкретной датой создания
     * @param date дата создания заметки
     * @return список заметок с указанной датой создания
     */
    public List<Note> getNotes(Date date);

    /**
     * Метод для получения списка заметок с указанным хэштегом
     * @param hashtag хэштег
     * @return список заметок
     */
    public List<Note> getNotes(String hashtag);

    /**
     * Метод для получения списка заметок, содержащих указанную подстроку в тексте или<br>
     * названии заметки.
     * @param substring подстрока
     * @return список заметок, удовлетворяющих критерию поиска
     */
    public List<Note> searchSubstring(String substring);
}
