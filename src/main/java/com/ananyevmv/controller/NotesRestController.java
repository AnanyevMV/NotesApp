package com.ananyevmv.controller;

import com.ananyevmv.dto.NoteDTO;
import com.ananyevmv.service.NotesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class NotesRestController {

    private final NotesService notesService;
    private final ObjectMapper objectMapper;

    /**
     * Конструктор с параметром класса NotesRestController
     * @param notesService сервис записок
     */
    @Autowired
    public NotesRestController(NotesService notesService) {
        this.notesService = notesService;
        this.objectMapper = new ObjectMapper();
    }

    /**
     * Метод обрабатывает POST-запрос для сохранения записки
     * @param noteDTO
     */
    @PostMapping("/saveNote")
    public ResponseEntity<?> saveNote(@RequestBody NoteDTO noteDTO) {
        notesService.saveNote(noteDTO);
        Map<String, String> body = Map.of("Result", "Success");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Метод обрабатывает PUT-запрос для обновления записки
     * @param noteDTO объект NoteDTO
     */
    @PutMapping("/updateNote")
    public ResponseEntity<?> updateNote(@RequestBody NoteDTO noteDTO) {
        notesService.updateNote(noteDTO);
        Map<String, String> body = Map.of("Result", "Success");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Метод обрабатывает DELETE-запрос для удаления записки по её идентификатору
     * @param id идентификатор записки
     */
    @DeleteMapping("/deleteNote/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable Long id) {
        notesService.deleteNote(id);
        Map<String, String> body = Map.of("Result", "Success");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    /**
     * Метод обрабатывает GET-запрос для получения списка всех записок
     * @return список всех записок
     */
    @GetMapping("/getNotes")
    public List<NoteDTO> getNotes() {
        return notesService.getNotes();
    }

    /**
     * Метод обрабатывает POST-запрос для получения списка записок с указанной датой
     * @param jsonMap ассоциативный массив
     * @return список записок с указанной датой
     */
    @PostMapping("/getNotesWithDate")
    public List<NoteDTO> getNotes(@RequestBody Map<String, Object> jsonMap) {
        Date date = (Date) this.convertValue(jsonMap, "date", Date.class);
        return notesService.getNotes(date);
    }

    /**
     * Метод обрабатывает POST-запрос для получения списка записок с указанным хэштегом
     * @param jsonMap ассоциативный массив
     * @return список записок с указанным хэштегом
     */
    @PostMapping("/getNotesWithHashtag")
    public List<NoteDTO> getNotesWithHashtag(@RequestBody Map<String, Object> jsonMap) {
        String hashtag = (String) this.convertValue(jsonMap, "hashtag", String.class);
        return notesService.getNotes(hashtag);
    }

    /**
     * Метод обрабатывает POST-запрос для получения списка записок с указанной подстрокой в тексте или в названии
     * @param jsonMap ассоциативный массив
     * @return список записок, удовлетворяющих критерию поиска
     */
    @PostMapping("/searchSubstring")
    public List<NoteDTO> searchSubstring(@RequestBody Map<String, Object> jsonMap) {
        String substring = (String) this.convertValue(jsonMap, "substring", String.class);
        return notesService.searchSubstring(substring);
    }

    /**
     * Вспомогательный метод для конвертации значений map'ы <br>
     * Чтобы не создавать дополнительные DTO, методы контроллера принимают Map
     * @param map ассоциативный массив
     * @param key ключ
     * @param cl класс, в который будет преобразован объект
     * @return преобразованный объект
     */
    private Object convertValue(Map<String, Object> map, String key, Class cl) {
        return objectMapper.convertValue(map.get(key), cl);
    }
}
