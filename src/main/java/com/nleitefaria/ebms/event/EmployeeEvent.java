package com.nleitefaria.ebms.event;

import java.time.Instant;

public record EmployeeEvent(String eventType, Integer employeeId, Instant occurredAt) {

    public static EmployeeEvent saved(Integer employeeId) {
        return new EmployeeEvent("EMPLOYEE_SAVED", employeeId, Instant.now());
    }

    public static EmployeeEvent deleted(Integer employeeId) {
        return new EmployeeEvent("EMPLOYEE_DELETED", employeeId, Instant.now());
    }
}
