package br.com.objective.jeecourse.server;

import java.io.Serializable;

public class OperationDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Operation operation;
	private String left;
	private String right;
	
	public enum Operation {
		ADD,
		SUBTRACT,
		COMPARE
	}
	
	public OperationDto(Operation operation, String left, String right) {
		this.operation = operation;
		this.left = left;
		this.right = right;
	}
	
	public Operation getOperation() {
		return operation;
	}
	public String getLeft() {
		return left;
	}
	public String getRight() {
		return right;
	}
	
}
