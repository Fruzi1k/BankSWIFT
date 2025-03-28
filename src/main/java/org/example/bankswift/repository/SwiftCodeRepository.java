package org.example.bankswift.repository;

import org.example.bankswift.model.SwiftCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SwiftCodeRepository extends JpaRepository<SwiftCode, String> {
    List<SwiftCode> findByCountryISO2(String countryISO2);
}
