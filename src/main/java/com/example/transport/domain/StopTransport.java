package com.example.transport.domain;

import com.example.transport.shedule.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "stoptransport")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StopTransport {
    @Id
    @ExcelColumn(name="Номер")
    private String id;
    @ExcelColumn(name = "Название")
    @Column(name = "name", nullable = false)
    private String name;
    @ExcelColumn(name = "Троллейбус")
    @Column(name = "trolleybus", nullable = false)
    private String trolleybus;
    @ExcelColumn(name = "Трамвай")
    @Column(name = "tram", nullable = false)
    private String tram;


    @ManyToMany
    @JoinColumn(name = "id_lines")
    private Set<Line> lines;

}
