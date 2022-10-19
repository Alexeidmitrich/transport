package com.example.transport.dto;


import com.example.transport.domain.StopTransport;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StopTransportDTO {

    private String id;
    private String name;
    private String trolleybus;
    private String tram;

    public StopTransportDTO(StopTransport stopTransport){
        this.id = stopTransport.getId();
        this.name = stopTransport.getName();
        this.trolleybus = stopTransport.getTrolleybus();
        this.tram = stopTransport.getTram();
    }
}
