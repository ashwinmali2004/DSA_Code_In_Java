package HPE;

import java.util.*;

public class IPRegionChecker {
    private static boolean isValidPart(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        try {
            int num = Integer.parseInt(s);
            return (num >= 0 && num <= 255);
        } catch (NumberFormatException e) {
            return false; 
        }
    }
    
    public static List<String> checkIPRegion(String ip) {
        List<String> result = new ArrayList<>();
        if (ip == null || ip.isEmpty()) {
            result.add("Not Valid");
            return result;
        }
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            result.add("Not Valid");
            return result;
        }
        for (String part : parts) {
            if (!isValidPart(part)) {
                result.add("Not Valid");
                return result;
            }
        }
        int firstOctet = Integer.parseInt(parts[0]);
        if (firstOctet <= 127) {
            result.add("Region 1");
        } else if (firstOctet <= 191) {
            result.add("Region 2");
        } else if (firstOctet <= 223) {
            result.add("Region 3");
        } else if (firstOctet <= 239) {
            result.add("Region 4");
        } else {
            result.add("Not Valid");
        }
        return result;
    }
    
    // Comprehensive test method
    public static void runTests() {
        System.out.println("=== IP REGION VALIDATION TESTS ===\n");
        
        String[] testIPs = {
            // Valid IPs
            "127.0.0.1",           // Region 1
            "192.168.1.1",         // Region 3  
            "10.0.0.1",            // Region 1
            "172.16.0.1",          // Region 2
            "224.0.0.1",           // Region 4
            "0.0.0.0",             // Region 1 (edge case)
            "255.255.255.255",     // Not Valid (>239)
            
            // Invalid IPs - Format issues
            "",                    // Empty
            "192.168.1",           // Missing octet
            "192.168.1.1.1",       // Extra octet
            "192.168.1.",          // Trailing dot
            ".192.168.1.1",        // Leading dot
            "192..168.1.1",        // Double dot
            
            // Invalid IPs - Value issues
            "256.1.1.1",           // First octet > 255
            "1.256.1.1",           // Second octet > 255
            "1.1.256.1",           // Third octet > 255
            "1.1.1.256",           // Fourth octet > 255
            "01.1.1.1",            // Leading zero
            "1.01.1.1",            // Leading zero in middle
            "1.1.1.01",            // Leading zero at end
            
            // Invalid IPs - Non-numeric
            "abc.1.1.1",           // Letters
            "1.1.1.1a",            // Mixed alphanumeric
            "1.1.1.-1",            // Negative number
            "1.1.1.1.2.3",         // Too many parts
            
            // Boundary cases
            "240.1.1.1",           // Region 5 (invalid)
            "239.255.255.255",     // Max valid Region 4
            "128.0.0.1",           // Min Region 2
            "191.255.255.255",     // Max Region 2
            "192.0.0.1",           // Min Region 3
            "223.255.255.255"      // Max Region 3
        };
        
        for (int i = 0; i < testIPs.length; i++) {
            String ip = testIPs[i];
            List<String> result = checkIPRegion(ip);
            
            System.out.printf("Test %2d: %-20s -> %s%n", 
                            i + 1, 
                            ip.isEmpty() ? "\"\"" : ip, 
                            result.get(0));
        }
        
        // Performance test
        System.out.println("\n=== PERFORMANCE TEST ===");
        
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            checkIPRegion("192.168.1." + (i % 256));
        }
        long end = System.nanoTime();
        
        System.out.printf("Processed 100,000 IPs in %.2f ms%n", (end - start) / 1e6);
    }

    public static void main(String[] args) {
        runTests();
        
        // Quick demo
        System.out.println("\n=== QUICK DEMO ===");
        String[] demoIPs = {"127.0.0.1", "192.168.1.1", "invalid.ip", "256.1.1.1"};
        
        for (String ip : demoIPs) {
            System.out.println(ip + " -> " + checkIPRegion(ip).get(0));
        }
    }
}

/*
KEY IMPROVEMENTS FROM C++ TO JAVA:

✅ ROBUSTNESS:
- Proper null checking for input strings
- Exception handling for parseInt overflow
- Edge case handling for empty strings and malformed input

✅ JAVA-SPECIFIC OPTIMIZATIONS:
- Uses split() with -1 flag to handle empty parts correctly
- Character.isDigit() for digit validation
- ArrayList for dynamic result collection
- NumberFormatException handling

✅ PERFORMANCE FEATURES:
- O(1) space complexity (excluding input/output)
- O(n) time complexity where n = length of IP string
- Minimal object allocation
- Efficient string processing

✅ EDGE CASES HANDLED:
- Null/empty input
- Leading zeros (01.1.1.1 -> invalid)
- Out of range values (256.1.1.1 -> invalid)
- Missing octets (192.168.1 -> invalid)
- Extra octets (192.168.1.1.1 -> invalid)
- Non-numeric characters
- Boundary values (0, 127, 128, 191, 192, 223, 224, 239, 240+)

*/