package org.icet.equipmentcrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "equipment")
public class EquipmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double rentalPrice;
    private Boolean availabilityStatus;
    private Date registerdDate;

    @ManyToOne
    @JoinColumn(name = "fk_category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "equipment")
    private Set<RentalEntity> rental;
}
