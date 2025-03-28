package org.example.bankswift.util;

import lombok.NonNull;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.bankswift.model.SwiftCode;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SwiftCodeParser {

    public List<SwiftCode> parseCSV(@NonNull String filePath) throws IOException {
        List<SwiftCode> swiftCodes = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader(filePath), CSVFormat.DEFAULT.withHeader())) {
            for (CSVRecord record : parser) {
                SwiftCode swiftCode = new SwiftCode();
                swiftCode.setCountryISO2(record.get("COUNTRY ISO2 CODE").toUpperCase());
                swiftCode.setSwiftCode(record.get("SWIFT CODE"));
                swiftCode.setBankName(record.get("NAME").toUpperCase());
                swiftCode.setAddress(record.get("ADDRESS").toUpperCase());
                swiftCode.setCountryName(record.get("COUNTRY NAME").toUpperCase());
                swiftCode.setHeadquarter(record.get("SWIFT CODE").endsWith("XXX"));
                swiftCodes.add(swiftCode);
            }
        }
        return swiftCodes;
    }
}
