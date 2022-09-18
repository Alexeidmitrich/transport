package com.example.transport.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;


import javax.persistence.*;
import java.util.*;

@Entity
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "city_lines")
public class Line {


    @Id
    @Column(nullable=false, name = "id_lines")
    private String number;

    @OneToMany(mappedBy = "line", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Journey> journeys;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "lines")
    @ToString.Exclude
    private List<StopTransport> transportStops = new LinkedList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return number.equals(line.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public void addStop(StopTransport stopTransport) {
      transportStops.add(stopTransport);
    }
}
