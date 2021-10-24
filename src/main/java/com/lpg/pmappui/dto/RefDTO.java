package com.lpg.pmappui.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RefDTO {
    private String keys;
    private String value;

    public RefDTO(String keys, String value) {
        this.keys = keys;
        this.value = value;
    }

    public RefDTO() {
    }
}
