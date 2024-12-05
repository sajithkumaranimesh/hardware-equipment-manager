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
    private Date startDate;
    private Date endDate;
    private Double totalPrice;
}
