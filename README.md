# Car Service Station & Find Sum Zero Elements

## Car Service Station Software

### Introduction
This Java program simulates a car service station with the following features:
- Caters to different types of cars: Hatchback, Sedan, SUV.
- Provides services like Basic Service, Engine Fixing, Clutch Fixing, Gear Fixing, and Brake Fixing.
- Calculates the total amount for each service request based on the type of car and requested service codes.
- Offers complimentary cleaning if the total service bill is more than ₹10,000.

### Features
- Supports Hatchback, Sedan, and SUV car types.
- Calculates service charges based on selected service codes and car type.
- Includes complimentary cleaning for bills exceeding ₹10,000.

### Usage
1. Run the `CarServiceStation.java` file to execute the program.
2. Customize the `serviceCodes` list and `carType` variable to specify the desired services and car type.
3. The program will generate a detailed bill, including the total amount and complimentary cleaning status.

#  Find Elements with Sum Zero 

### Introduction
This Java program finds elements in an array of positive and negative numbers whose sum equals zero. It returns a combination of elements with a sum of zero or "No Elements found" if no such combination exists.

### Features
- Handles arrays with positive and negative numbers.
- Finds combinations of elements with a sum of zero.
- Returns "No Elements found" if no valid combination exists.

### Usage
1. Run the `FindSumZeroElements.java` file to execute the program.
2. Customize the `inputArray` variable to include your desired array of numbers.
3. The program will find and display a combination of elements whose sum is zero or "No Elements found" if none exists.

### Example 1 & 2
```java
int[] inputArray = {-4, 1, 3, -2, -1};
List<Integer> result = findElementsSumToZero(inputArray);

if (result.get(0) == 0) {
    System.out.println("No Elements found");
} else {
    System.out.println("Elements whose sum is 0: " + result);
}



List<String> serviceCodes = new ArrayList<>();
serviceCodes.add("BS01");
serviceCodes.add("EF01");

CarService carService = new CarService("Hatchback", serviceCodes);
String bill = ServiceStation.generateBill(carService);
System.out.println(bill); ```
