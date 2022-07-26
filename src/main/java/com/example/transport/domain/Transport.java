package com.example.transport.domain;

import com.example.transport.utils.schedule.schedulereader.excel.ExcelColumn;
import lombok.*;

import javax.persistence.*;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @Column(nullable = false)
    @ExcelColumn(name = "Номер")
    protected String id;


}