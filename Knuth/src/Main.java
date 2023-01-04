import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Node start = new Node(BigDecimal.valueOf(4),"Start");
		ArrayList<ArrayList<Node> > theList = new ArrayList<ArrayList<Node> >();
		ArrayList<Node> temp = new ArrayList<Node>();
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Breadth-first search");
		System.out.print("Target number: ");
		int target = keyboard.nextInt();
		keyboard.close();
		
		temp.add(new Node(start,square(start.getValue()),"Root"));
		temp.add(new Node(start,new BigDecimal(factorial(start.getValue())),"Factorial"));
		temp.add(new Node(start,new BigDecimal(floor(start.getValue())),"Floor"));
		
		theList.add(temp);
		int i =0;
		
		while(i<14) {
			ArrayList<Node> temp2 = new ArrayList<Node>();
			for(Node n : theList.get(i)) {
				temp2.add(new Node(n,square(n.getValue()),"Root"));
				temp2.add(new Node(n,new BigDecimal(factorial(n.getValue())),"Factorial"));
				temp2.add(new Node(n,new BigDecimal(floor(n.getValue())),"Floor"));
			}
			theList.add(temp2);
			for(Node n : theList.get(i)) {
				if(n.getValue().equals(BigDecimal.valueOf(target))) {
					Node tempNode = n;
					while(tempNode.getParent() != null) {
						System.out.println(tempNode.getOperation());
						tempNode = tempNode.getParent();
					}
					System.exit(0);
				}
			}
			i++;	
		}
		System.out.println("Unable to found");
	}
	
	public static BigDecimal square (BigDecimal theNumber) {
		MathContext mc = new MathContext(10);
		return theNumber.sqrt(mc);
	}
	
	public static BigInteger floor (BigDecimal theNumber) {
		return theNumber.setScale(0, RoundingMode.FLOOR).unscaledValue();
	}
	
    public static BigInteger factorial(BigDecimal number) {
    	if(number.intValue() > 30)
    		return BigInteger.valueOf(0);
    	
        BigInteger factorial = BigInteger.ONE;

        for (int i = number.intValue(); i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

}
