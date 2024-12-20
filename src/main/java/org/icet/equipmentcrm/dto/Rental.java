package org.icet.equipmentcrm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rental {
    private Long id;
    private Date endDate;
    private Double totalPrice;
    private String personName;
    private String equipmentName;
}
