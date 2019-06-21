package com.craigecomputing.dtos;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileDto {
    private String name;
}
