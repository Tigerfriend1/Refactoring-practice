import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public enum CalculatorKind{SUM,PRODUCT}

    public static List<Integer> inputIntegers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer ( 0 or minus for Exit)");
        List<Integer> numberList = new ArrayList<>();
        while (true) {
            int number = scanner.nextInt();
            if (isNaturalNum(number))
                numberList.add(number);
            else
                break;
        }
        scanner.close();
        return numberList;
    }

    private static boolean isNaturalNum(int number) {
        return number > 0;
    }

    public static int sumIntegers(List<Integer> numList){
        int sum=0;
        for(int num : numList){
            sum += num;
        }
        return sum;
    }

    public static int productIntegers(List<Integer> numList){
        int product=1;
        for(int num : numList){
            product *= num;
        }
        return product;

    }

    public static void printAnswer(CalculatorKind kind, int answer){
        switch (kind){
            case SUM -> {
                System.out.println("Sum: "+answer);
            }
            case PRODUCT -> {
                System.out.println("Product: "+answer);
            }
            default -> {
                System.out.println("Not supported Calculator");
            }
        }
    }
}
