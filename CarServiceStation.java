import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CarService {
    private String carType;
    private List<String> serviceCodes;

    public CarService(String carType, List<String> serviceCodes) {
        this.carType = carType;
        this.serviceCodes = serviceCodes;
    }

    public String getCarType() {
        return carType;
    }

    public List<String> getServiceCodes() {
        return serviceCodes;
    }
}

class ServiceStation {
    private static final Map<String, Map<String, Integer>> servicePrices = new HashMap<>();
    static {
        // Initialize service prices for different car types
        Map<String, Integer> hatchbackPrices = new HashMap<>();
        hatchbackPrices.put("BS01", 2000);
        hatchbackPrices.put("EF01", 5000);
        hatchbackPrices.put("CF01", 2000);
        hatchbackPrices.put("BF01", 1000);
        hatchbackPrices.put("GF01", 3000);

        Map<String, Integer> sedanPrices = new HashMap<>();
        sedanPrices.put("BS01", 4000);
        sedanPrices.put("EF01", 8000);
        sedanPrices.put("CF01", 4000);
        sedanPrices.put("BF01", 1500);
        sedanPrices.put("GF01", 6000);

        Map<String, Integer> suvPrices = new HashMap<>();
        suvPrices.put("BS01", 5000);
        suvPrices.put("EF01", 10000);
        suvPrices.put("CF01", 6000);
        suvPrices.put("BF01", 2500);
        suvPrices.put("GF01", 8000);

        servicePrices.put("Hatchback", hatchbackPrices);
        servicePrices.put("Sedan", sedanPrices);
        servicePrices.put("SUV", suvPrices);
    }

    public static int calculateTotalBill(CarService carService) {
        String carType = carService.getCarType();
        List<String> serviceCodes = carService.getServiceCodes();
        
        int totalBill = 0;
        for (String serviceCode : serviceCodes) {
            if (servicePrices.containsKey(carType) && servicePrices.get(carType).containsKey(serviceCode)) {
                totalBill += servicePrices.get(carType).get(serviceCode);
            }
        }

        return totalBill;
    }

    public static String generateBill(CarService carService) {
        int totalBill = calculateTotalBill(carService);
        boolean complimentaryCleaning = totalBill > 10000;

        StringBuilder bill = new StringBuilder("Type of Car: " + carService.getCarType() + "\n");
        bill.append("Service Codes: ").append(carService.getServiceCodes()).append("\n");

        for (String serviceCode : carService.getServiceCodes()) {
            bill.append("Charges for ").append(serviceCode).append(": ₹").append(servicePrices.get(carService.getCarType()).get(serviceCode)).append("\n");
        }

        if (complimentaryCleaning) {
            bill.append("Complimentary Cleaning: Yes\n");
        }

        bill.append("Total Bill: ₹").append(totalBill);

        return bill.toString();
    }
}

public class CarServiceStation {
    public static void main(String[] args) {
        // Example usage:
        List<String> serviceCodes = new ArrayList<>();
        serviceCodes.add("BS01");
        serviceCodes.add("EF01");

        CarService carService = new CarService("Hatchback", serviceCodes);
        String bill = ServiceStation.generateBill(carService);
        System.out.println(bill);
    }
}