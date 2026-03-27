package com.kiit.lms.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class APIError {
    private String message;
    private String field;
    private Object rejectedValue;
}
