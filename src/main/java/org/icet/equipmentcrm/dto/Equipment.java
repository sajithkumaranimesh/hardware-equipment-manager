package org.icet.equipmentcrm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Equipment {
    private Long id;
    private String name;
    private String description;
    private Double rentalPrice;
    private Boolean availabilityStatus;
    private Date registerdDate;
    private Long categoryId;
}
