package com.nleitefaria.ebms.event;

import com.nleitefaria.ebms.entity.Titles;

import java.time.Instant;
import java.time.LocalDate;

public record TitleEvent(
        String eventType,
        Integer employeeId,
        String title,
        LocalDate fromDate,
        LocalDate toDate,
        Instant occurredAt) {

    public static TitleEvent saved(Titles title) {
        return new TitleEvent(
                "TITLE_SAVED",
                title.getId().getEmpNo(),
                title.getId().getTitle(),
                title.getId().getFromDate(),
                title.getToDate(),
                Instant.now());
    }

    public static TitleEvent deleted(Titles.Id id) {
        return new TitleEvent(
                "TITLE_DELETED",
                id.getEmpNo(),
                id.getTitle(),
                id.getFromDate(),
                null,
                Instant.now());
    }
}
