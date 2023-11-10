import java.util.List;

public class CalculatorTest {
	public static void main(String[] args) {
		List<Integer> numberList = Calculator.inputIntegers();
		Calculator.printAnswer(Calculator.CalculatorKind.SUM,Calculator.sumIntegers(numberList));
		Calculator.printAnswer(Calculator.CalculatorKind.PRODUCT,Calculator.productIntegers(numberList));

	}


}