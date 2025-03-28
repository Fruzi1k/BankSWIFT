package org.example.bankswift.service;

import org.example.bankswift.model.SwiftCode;
import org.example.bankswift.repository.SwiftCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SwiftCodeService {

    private final SwiftCodeRepository swiftCodeRepository;

    @Autowired
    public SwiftCodeService(SwiftCodeRepository swiftCodeRepository) {
        this.swiftCodeRepository = swiftCodeRepository;
    }

    public Optional<SwiftCode> getSwiftCodeById(String swiftCode) {
        return swiftCodeRepository.findBySwiftCode(swiftCode);
    }

    public List<SwiftCode> getSwiftCodesByCountry(String countryISO2) {
        return swiftCodeRepository.findByCountryISO2(countryISO2);
    }

    public SwiftCode addSwiftCode(SwiftCode swiftCode) {
        return swiftCodeRepository.save(swiftCode);
    }

    public void deleteSwiftCode(String swiftCode) {
        swiftCodeRepository.deleteById(swiftCode);
    }

    public List<SwiftCode> parseAndStoreSwiftCodes(List<SwiftCode> swiftCodes) {
        return swiftCodeRepository.saveAll(swiftCodes);
    }
}