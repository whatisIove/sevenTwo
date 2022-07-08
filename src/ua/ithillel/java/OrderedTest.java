package ua.ithillel.java;

public class OrderedTest {

    public static void main(String[] args) {
        Restrictions cs = new Restrictions();

        cs.limitAge = 18;
        cs.quantityStock = 100;
        cs.creditMonth = 36;

        Customer client = new Customer();

        client.name = "Musk Elon";
        client.gender = "Female";
        client.age = 19;
        client.balance = 100000;
        client.buyCredit = false;

        Car carOrder = new Car();
        carOrder.mark = "Tesla";
        carOrder.model = "Model X";
        carOrder.value = 10;
        carOrder.price = 99999;
        carOrder.sum = carOrder.value * carOrder.price;

        if (client.age >= cs.limitAge) {
            System.out.println("\n" + client.name + " welcome to the salon, choose a car.");
        } else {
            cs.afterMuch = cs.limitAge - client.age;
            System.out.println("\n" + client.name + " come through " + cs.afterMuch + " year.");
            return;
        }
        if (client.balance >= carOrder.price * carOrder.value) {
            client.balance -= carOrder.price * carOrder.value;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on your purchase. Your balance "
                    + client.balance);
        } else {
            cs.muchMissing = carOrder.price * carOrder.value - client.balance;
            System.out.println("\n" + client.name + " you are missing " + cs.muchMissing + " money.");
            System.out.println("\nWe have loan services up to 36 months, would you like to take a look?");
        }

        if (client.buyCredit && client.age >= cs.limitAge) {
            System.out.print(client.name + ". Chosen for how many months you plan to take a loan?");
            int creditSum = carOrder.sum - client.balance;
            int sumMonth = creditSum / cs.creditMonth;
            cs.quantityStock -= carOrder.value;
            System.out.println("\n" + client.name + " congratulations on buying a car on credit. Monthly " +
                    "payment for " + "36 months is " + sumMonth);
        } else {
            System.out.print("\nIf you are not ready for taking credit, thank you for coming, "
                    + client.name + ". See you later." + "\n");
        }
    }
}






