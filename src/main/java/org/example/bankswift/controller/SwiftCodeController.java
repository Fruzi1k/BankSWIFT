package org.example.bankswift.controller;

import org.example.bankswift.model.SwiftCode;
import org.example.bankswift.service.SwiftCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/swift-codes")
public class SwiftCodeController {

    private final SwiftCodeService swiftCodeService;


    @Autowired
    public SwiftCodeController(SwiftCodeService swiftCodeService) {
        this.swiftCodeService = swiftCodeService;
    }

    @GetMapping("/{swiftCode}")
    public ResponseEntity<SwiftCode> getSwiftCode(@PathVariable String swiftCode) {
        Optional<SwiftCode> result = swiftCodeService.getSwiftCodeById(swiftCode);
        return result.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/country/{countryISO2code}")
    public List<SwiftCode> getSwiftCodesByCountry(@PathVariable String countryISO2code) {
        return swiftCodeService.getSwiftCodesByCountry(countryISO2code);
    }

    @PostMapping
    public ResponseEntity<String> addSwiftCode(@RequestBody SwiftCode swiftCode) {
        swiftCodeService.addSwiftCode(swiftCode);
        return ResponseEntity.ok("SWIFT code added successfully");
    }

    @DeleteMapping("/{swiftCode}")
    public ResponseEntity<String> deleteSwiftCode(@PathVariable String swiftCode) {
        swiftCodeService.deleteSwiftCode(swiftCode);
        return ResponseEntity.ok("SWIFT code deleted successfully");
    }
}