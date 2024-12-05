package org.icet.equipmentcrm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Rental")
public class RentalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private Double totalPrice;

    @ManyToOne
    @JoinColumn(name = "fk_person_id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "fk_equipment_id")
    private EquipmentEntity equipment;
}
