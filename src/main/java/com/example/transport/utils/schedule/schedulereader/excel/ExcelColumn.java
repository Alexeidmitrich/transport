package com.example.transport.utils.schedule.schedulereader.excel;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelColumn {
    String name();
    String numberFormat() default "General";
}