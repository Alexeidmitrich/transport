package com.example.transport.domain;

import com.example.transport.shedule.Datetime;
import com.example.transport.shedule.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class JourneyStop {

    private Transport transport;
    private StopTransport stop;
    private Person driver;
    private Person inspector;
    private LocalTime time;


}
