package com.example.transport.domain;

import com.example.transport.shedule.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transport {
    @Id
    @Column(nullable = false)
    @ExcelColumn(name = "Номер")
    protected String id;

}