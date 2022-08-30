package com.example.transport.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class JourneyStop {

    private Transport transport;
    private StopTransport stop;
    private Person driver;
    private Person inspector;
    private String time;


}
