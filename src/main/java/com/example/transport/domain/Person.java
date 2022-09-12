package com.example.transport.domain;

import com.example.transport.shedule.ExcelColumn;
import lombok.*;

import javax.persistence.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
   @Id
   @Column(nullable = false)
   @ExcelColumn(name = "Номер")
   private String id;
   @Column(nullable = false, length = 55)
   @ExcelColumn(name = "ФИО")
   protected String fio;
   @Column(nullable = false, length = 8)
   @ExcelColumn(name = "Дата рождения")
   protected String date;
   @Column(nullable = false, length = 100)
   @ExcelColumn(name = "Адрес")
   protected String address;
   @Column(nullable = false, length = 16)
   @ExcelColumn(name = "Телефон")
   protected String phone;
   @Column(nullable = false, length = 55)
   @ExcelColumn(name = "email")
   private String email;
   @Column(nullable = false)
   @ExcelColumn(name = "Должность")
   private String title;
   @Column(nullable = false)
   @ExcelColumn(name = "Допуск")
   private String access;


   @Override
   public String toString() {
      return "Person{" +
              "id='" + id + '\'' +
              ", fio='" + fio + '\'' +
              ", date='" + date + '\'' +
              ", address='" + address + '\'' +
              ", phone='" + phone + '\'' +
              ", email='" + email + '\'' +
              ", title='" + title + '\'' +
              ", access='" + access + '\'' +
              '}';
   }
}
