package com.ananyevmv.service;


import com.ananyevmv.dao.NotesDAO;
import com.ananyevmv.dto.NoteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ananyevmv.entity.Note;

@Service
public class NoteServiceImpl implements NotesService{

    private final ModelMapper modelMapper;

    private final NotesDAO notesDAO;

    @Autowired
    public NoteServiceImpl(ModelMapper modelMapper, NotesDAO notesDAO) {
        this.modelMapper = modelMapper;
        this.notesDAO = notesDAO;
    }

    /**
     * Метод позволяет сохранить заметку
     *
     * @param noteDTO объект NoteDTO
     */
    @Transactional
    @Override
    public void saveNote(NoteDTO noteDTO) {
        Note note = modelMapper.map(noteDTO, Note.class);
        note.setId(null);
        notesDAO.saveNote(note);
    }

    /**
     * Метод позволяет обновить существующую заметку
     *
     * @param noteDTO объект NoteDTO
     */
    @Transactional
    @Override
    public void updateNote(NoteDTO noteDTO) {
        Note note = modelMapper.map(noteDTO, Note.class);
        notesDAO.updateNote(note);
    }

    /**
     * Метод позволяет удалить заметку по её идентификатору
     *
     * @param id идентификатор заметки
     */
    @Transactional
    @Override
    public void deleteNote(Long id) {
        notesDAO.deleteNote(id);
    }

    /**
     * Метод позволяет получить список заметок
     *
     * @return список заметок
     */
    @Transactional
    @Override
    public List<NoteDTO> getNotes() {
        return notesDAO.getNotes().stream().map(el->modelMapper.map(el, NoteDTO.class)).collect(Collectors.toList());
    }

    /**
     * Метод позволяет получить список заметок с конкретной датой создания
     *
     * @param date дата создания
     * @return список заметок с указанной датой создания
     */
    @Transactional
    @Override
    public List<NoteDTO> getNotes(Date date) {
        return notesDAO.getNotes(date).stream().map(el->modelMapper.map(el, NoteDTO.class)).collect(Collectors.toList());
    }

    /**
     * Метод позвволяет получить список заметок с указанным хэштегом
     *
     * @param hashtag хэштег
     * @return список заметок с указанным хэштегом
     */
    @Transactional
    @Override
    public List<NoteDTO> getNotes(String hashtag) {
        return notesDAO.getNotes(hashtag).stream().map(el->modelMapper.map(el, NoteDTO.class)).collect(Collectors.toList());
    }

    /**
     * Метод позволяет получить список заметок, содержащих указанную подстроку в тексте или<br>
     * в названии заметки.
     *
     * @param substring подстрока
     * @return список заметок, удовлетворяющих критерию поиска
     */
    @Transactional
    @Override
    public List<NoteDTO> searchSubstring(String substring) {
        return notesDAO.searchSubstring(substring).stream().map(el->modelMapper.map(el, NoteDTO.class)).collect(Collectors.toList());
    }
}
