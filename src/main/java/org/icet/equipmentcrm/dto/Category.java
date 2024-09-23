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
public class Category {
    private Long id;
    private String name;
    private String description;
    private Date registerdDate;
}
