package com.example.transport.dto;


import com.example.transport.domain.StopTransport;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrolleybus() {
        return trolleybus;
    }

    public void setTrolleybus(String trolleybus) {
        this.trolleybus = trolleybus;
    }

    public String getTram() {
        return tram;
    }

    public void setTram(String tram) {
        this.tram = tram;
    }
}
