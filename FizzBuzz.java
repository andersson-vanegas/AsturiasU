import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int numero = scanner.nextInt();

        if (numero % 3 == 0 && numero % 5 == 0) {
            System.out.println("FIZZBUZZ");
        } else if (numero % 3 == 0) {
            System.out.println("FIZZ");
        } else if (numero % 5 == 0) {
            System.out.println("BUZZ");
        } else {
            System.out.println(numero);
        }

        scanner.close();
    }
}