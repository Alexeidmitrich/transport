package com.example.transport.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@DiscriminatorValue("trolleybus")
@Data
public class Trolleybus extends Transport{

}
