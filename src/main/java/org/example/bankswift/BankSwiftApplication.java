package org.example.bankswift;

import org.example.bankswift.model.SwiftCode;
import org.example.bankswift.service.SwiftCodeService;
import org.example.bankswift.util.SwiftCodeParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication

public class BankSwiftApplication implements CommandLineRunner {

    @Autowired
    private SwiftCodeService swiftCodeService;

    public static void main(String[] args) {
        SpringApplication.run(BankSwiftApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String filePath = "src/main/resources/swift_code.csv";

        try {
            SwiftCodeParser parser = new SwiftCodeParser();
            List<SwiftCode> swiftCodes = parser.parseCSV(filePath);
            swiftCodeService.parseAndStoreSwiftCodes(swiftCodes);
            System.out.println("SWIFT codes have been successfully parsed and stored in the database.");
        } catch (IOException e) {
            System.err.println("Error parsing the CSV file: " + e.getMessage());
        }
    }
}
