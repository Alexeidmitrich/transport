package com.example.transport.shedule;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {
    String name();
    String numberFormat() default "General";
}