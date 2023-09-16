import java.util.Scanner;

class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int money;
    private int espressoPrice = 4;
    private int lattePrice = 7;
    private int cappuccinoPrice = 6;
    private int espressoWater = 250;
    private int espressoBeans = 16;
    private int latteWater = 350;
    private int latteMilk = 75;
    private int latteBeans = 20;
    private int cappuccinoWater = 200;
    private int cappuccinoMilk = 100;
    private int cappuccinoBeans = 12;
    private int espressoCount = 0;
    private int latteCount = 0;
    private int cappuccinoCount = 0;

    public CoffeeMachine() {
        this.water = 0;
        this.milk = 0;
        this.beans = 0;
        this.money = 0;
    }

    public void buyCoffee(String type) {
        switch (type) {
            case "espresso":
                makeCoffee(espressoWater, 0, espressoBeans, espressoPrice);
                espressoCount++;
                break;
            case "latte":
                makeCoffee(latteWater, latteMilk, latteBeans, lattePrice);
                latteCount++;
                break;
            case "cappuccino":
                makeCoffee(cappuccinoWater, cappuccinoMilk, cappuccinoBeans, cappuccinoPrice);
                cappuccinoCount++;
                break;
            default:
                System.out.println("Invalid coffee type!");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded) {
            System.out.println("Dispensing coffee...");
            money += price;
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
        } else {
            System.out.println("Error: Not enough ingredients to make this coffee.");
        }
    }

    public void fillIngredients(int addedWater, int addedMilk, int addedBeans) {
        water += addedWater;
        milk += addedMilk;
        beans += addedBeans;
    }

    public void takeMoney() {
        System.out.println("Taking $" + money + " from the money box.");
        money = 0;
    }

    public void showIngredients() {
        System.out.println("Water: " + water + " ml");
        System.out.println("Milk: " + milk + " ml");
        System.out.println("Coffee Beans: " + beans + " g");
        System.out.println("Money: $" + money);
    }

    public void showAnalytics() {
        System.out.println("Coffee sold: ");
        System.out.println("Espresso: " + espressoCount);
        System.out.println("Latte: " + latteCount);
        System.out.println("Cappuccino: " + cappuccinoCount);
        System.out.println("Total money earned: $" + money);
        System.out.println("Ingredients consumed:");
        System.out.println("Water: " + (espressoCount * espressoWater + latteCount * latteWater + cappuccinoCount * cappuccinoWater) + " ml");
        System.out.println("Milk: " + (latteCount * latteMilk + cappuccinoCount * cappuccinoMilk) + " ml");
        System.out.println("Coffee Beans: " + (espressoCount * espressoBeans + latteCount * latteBeans + cappuccinoCount * cappuccinoBeans) + " g");
    }
}

public class Main {
    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOptions: buy, fill, take, show, analytics, exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "buy":
                    System.out.print("Enter coffee type (espresso/latte/cappuccino): ");
                    String coffeeType = scanner.nextLine();
                    coffeeMachine.buyCoffee(coffeeType);
                    break;
                case "fill":
                    System.out.print("Enter amount of water (ml): ");
                    int addedWater = scanner.nextInt();
                    System.out.print("Enter amount of milk (ml): ");
                    int addedMilk = scanner.nextInt();
                    System.out.print("Enter amount of coffee beans (g): ");
                    int addedBeans = scanner.nextInt();
                    coffeeMachine.fillIngredients(addedWater, addedMilk, addedBeans);
                    break;
                case "take":
                    coffeeMachine.takeMoney();
                    break;
                case "show":
                    coffeeMachine.showIngredients();
                    break;
                case "analytics":
                    coffeeMachine.showAnalytics();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
