package backend;

public class Node {
	
	private Environment environtment;
	private Node father;
	private Integer deep;
	private Integer cost;
	private String operator;
	
	public Node(Environment environtment, Node father, String operator, Integer deep, Integer cost) {
		this.environtment = environtment;
		this.father = father;
		this.deep = deep;
		this.cost = cost;
		this.operator = operator;
	}
	public Environment getEnvirontment() {
		return environtment;
	}
	public Node getFather() {
		return father;
	}
	public Integer getDeep() {
		return deep;
	}
	public Integer getCost() {
		return cost;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
