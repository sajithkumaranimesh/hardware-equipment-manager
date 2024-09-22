package org.icet.equipmentcrm.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ErrorResponse {
    String errorMessage;
    String status;
}
