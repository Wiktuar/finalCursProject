package ru.wintuar.notebook.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "header")
    private String header;
    @Column(name = "body")
    private String body;
    @Column(name = "date_time")
    private String dateTime;

}
