package com.ananyevmv.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteDTO {
    private Long id;
    private String name;
    private String note;
    private Date creationDate;
    private List<String> hashtags;

    public NoteDTO() {
        hashtags = new ArrayList<>();
    }

    public NoteDTO(Long id, String note, Date creationDate, List<String> hashtags) {
        this.id = id;
        this.note = note;
        this.creationDate = creationDate;
        this.hashtags = hashtags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", creationDate=" + creationDate +
                ", hashtags=" + hashtags +
                ", name='" + name + '\'' +
                '}';
    }
}
