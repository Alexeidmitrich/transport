package com.example.transport.domain;

import com.example.transport.utils.schedule.schedulereader.excel.ExcelColumn;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "stoptransport")
@Setter
@Getter
@EqualsAndHashCode
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

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "tutorial_tags",
            joinColumns = { @JoinColumn(name = "tutorial_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") })
    private Set<Line> lines = new HashSet<>();

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return "'" + id + '\'' +
                ", '" + name + '\'' +
                ' ';
    }
}
