package com.example.csvoperation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeZoneDto {

    @JsonFormat(pattern = "HH:mm")
    private LocalDate time;

    private Date bitmask;
}
