package com.example.transport.domain;

import com.example.transport.shedule.ExcelColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(nullable = false)
   @ExcelColumn(name = "Номер")
   private String id;
   @Column(nullable = false, length = 55)
   @ExcelColumn(name = "ФИО")
   private String FIO;
   @Column(nullable = false,length = 8)
   @ExcelColumn(name = "Дата рождения")
   private String date;
   @Column(nullable = false, length = 100)
   @ExcelColumn(name = "Адрес")
   private String address;
   @Column(nullable = false,length = 16)
   @ExcelColumn(name = "Телефон")
   private String phone;
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
              ", FIO='" + FIO + '\'' +
              ", date='" + date + '\'' +
              ", address='" + address + '\'' +
              ", phone='" + phone + '\'' +
              ", email='" + email + '\'' +
              ", title='" + title + '\'' +
              ", access='" + access + '\'' +
              '}';
   }
}
