package org.example.bankswift.controller;

import lombok.RequiredArgsConstructor;
import org.example.bankswift.model.SwiftCode;
import org.example.bankswift.service.SwiftCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/swift-codes")
public class SwiftCodeController {
    private final SwiftCodeService swiftCodeService;

    @Autowired  // Автоматическое внедрение зависимости
    public SwiftCodeController(SwiftCodeService swiftCodeService) {
        this.swiftCodeService = swiftCodeService;
    }

    @GetMapping("/{swiftCode}")
    public ResponseEntity<SwiftCode> getSwiftCode(@PathVariable("swiftCode") String swiftCode) {
        return swiftCodeService.getSwiftCode(swiftCode).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/country/{countryISO2}")
    public ResponseEntity<List<SwiftCode>> getSwiftCodesByCountry(@PathVariable("countryISO2") String countryISO2) {
        return ResponseEntity.ok(swiftCodeService.getAllSwiftCodesByCountry(countryISO2));
    }

    @PostMapping("/country/{countryISO2}")
    public ResponseEntity<SwiftCode> addSwiftCode(@PathVariable("countryISO2") String countryISO2, @RequestBody SwiftCode swiftCode) {
        return  ResponseEntity.ok(swiftCodeService.addSwiftCode(swiftCode));
    }

    @DeleteMapping("/{swiftCode}")
    public ResponseEntity<String> deleteSwiftCode(@PathVariable("swiftCode") String swiftCode) {
        swiftCodeService.deleteSwiftCode(swiftCode);
        return ResponseEntity.ok("Swift code deleted");
    }
}
