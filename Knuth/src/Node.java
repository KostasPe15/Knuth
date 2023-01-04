import java.math.BigDecimal;

public class Node {
	private Node parent;
	private BigDecimal value;
	private String operation;
	
	public Node(Node parent, BigDecimal value, String operation) {
		super();
		this.parent = parent;
		this.value = value;
		this.operation = operation;
	}
	
	public Node(BigDecimal value, String operation) {
		super();
		this.parent = null;
		this.value = value;
		this.operation = operation;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	

}
