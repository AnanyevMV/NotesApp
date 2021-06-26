package com.ananyevmv.dao;

import com.ananyevmv.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Repository
public class NotesDAOImpl implements NotesDAO {

    private final EntityManager entityManager;

    @Autowired
    public NotesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Метод для сохранения заметки
     *
     * @param note заметка
     */
    @Override
    public void saveNote(Note note) {
        note.setId(null);
        entityManager.persist(note);
    }

    /**
     * Метод для обновления заметки
     *
     * @param note заметка
     */
    @Override
    public void updateNote(Note note) {
        Note persistedNote = entityManager.find(Note.class, note.getId());
        if (Objects.isNull(persistedNote)) {
            throw new RuntimeException("This note id " + note.getId() + " does not exists");
        }
        if (note.getName() != null) {
            persistedNote.setName(note.getName());
        }
        if (note.getCreationDate() != null) {
            persistedNote.setCreationDate(note.getCreationDate());
        }
        if (note.getNote() != null) {
            persistedNote.setNote(note.getNote());
        }
        if (note.getHashtags() != null) {
            persistedNote.setHashtags(note.getHashtags());
        }
    }

    /**
     * Метод для удаления заметки
     *
     * @param id идентификатор заметки
     */
    @Override
    public void deleteNote(Long id) {
        Note note = entityManager.find(Note.class, id);
        if (Objects.isNull(note)) {
            throw new RuntimeException("This note id " + id + " does not exists");
        } else {
            entityManager.remove(note);
        }
    }

    /**
     * Метод для получения списка заметок
     *
     * @return список заметок
     */
    @Override
    public List<Note> getNotes() {
        TypedQuery<Note> query = entityManager.createQuery("select distinct n from Note n left join fetch n.hashtags order by n.id", Note.class);
        return query.getResultList();
    }

    /**
     * Метод для получения списка заметок с конкретной датой создания
     *
     * @param date дата создания заметки
     * @return список заметок с указанной датой создания
     */
    @Override
    public List<Note> getNotes(Date date) {
        TypedQuery<Note> query = entityManager.createQuery("select distinct n from Note n left join fetch n.hashtags where n.creationDate = :date order by n.id", Note.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    /**
     * Метод для получения списка заметок с указанным хэштегом
     *
     * @param hashtag хэштег
     * @return список заметок
     */
    @Override
    public List<Note> getNotes(String hashtag) {
        TypedQuery<Note> query = entityManager.createQuery("select distinct n from Note n left join fetch n.hashtags as h where :hashtag in (h) order by n.id", Note.class);
        query.setParameter("hashtag", hashtag);
        return query.getResultList();
    }

    /**
     * Метод для получения списка заметок, содержащих указанную подстроку в тексте или<br>
     * названии заметки.
     *
     * @param substring подстрока
     * @return список заметок, удовлетворяющих критерию поиска
     */
    @Override
    public List<Note> searchSubstring(String substring) {
        TypedQuery<Note> query = entityManager.createQuery("select distinct n from Note n left join n.hashtags where n.name like concat('%',:substring,'%') or n.note like concat('%',:substring,'%') order by n.id", Note.class);
        query.setParameter("substring", substring);
        return query.getResultList();
    }
}
