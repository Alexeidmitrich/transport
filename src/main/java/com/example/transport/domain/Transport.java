package com.example.transport.domain;

import com.example.transport.shedule.ExcelColumn;
import lombok.*;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @Column(nullable = false)
    @ExcelColumn(name = "Номер")
    protected String id;

}