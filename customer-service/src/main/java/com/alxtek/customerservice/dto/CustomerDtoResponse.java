package com.alxtek.customerservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDtoResponse {
    private String firstName;
    private String lastName;
    private String email;
}
