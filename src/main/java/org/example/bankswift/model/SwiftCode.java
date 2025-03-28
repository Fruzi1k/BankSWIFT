package org.example.bankswift.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bank_swift_codes")
public class SwiftCode {
    @Id
    private String swiftCode;
    private String address;
    private String bankName;
    private String countryISO2;
    private String countryName;
    private boolean isHeadquarter;

}
