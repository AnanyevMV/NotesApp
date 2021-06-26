package com.ananyevmv.service;

import com.ananyevmv.dto.NoteDTO;

import java.sql.Date;
import java.util.List;


public interface NotesService {

    /**
     * Метод позволяет сохранить заметку
     * @param noteDTO объект NoteDTO
     */
    public void saveNote(NoteDTO noteDTO);

    /**
     * Метод позволяет обновить существующую заметку
     * @param noteDTO объект NoteDTO
     */
    public void updateNote(NoteDTO noteDTO);

    /**
     * Метод позволяет удалить заметку по её идентификатору
     * @param id идентификатор заметки
     */
    public void deleteNote(Long id);

    /**
     * Метод позволяет получить список заметок
     * @return список заметок
     */
    public List<NoteDTO> getNotes();

    /**
     * Метод позволяет получить список заметок с конкретной датой создания
     * @param date дата создания
     * @return список заметок с указанной датой создания
     */
    public List<NoteDTO> getNotes(Date date);

    /**
     * Метод позвволяет получить список заметок с указанным хэштегом
     * @param hashtag хэштег
     * @return список заметок с указанным хэштегом
     */
    public List<NoteDTO> getNotes(String hashtag);

    /**
     * Метод позволяет получить список заметок, содержащих указанную подстроку в тексте или<br>
     * в названии заметки.
     * @param substring подстрока
     * @return список заметок, удовлетворяющих критерию поиска
     */
    public List<NoteDTO> searchSubstring(String substring);
}
