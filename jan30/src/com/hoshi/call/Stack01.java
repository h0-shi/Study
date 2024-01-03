package com.hoshi.call;

import java.util.Stack;

class Coin {
	 private int value;
	 
	 public Coin(int value) {
		 this.value = value;
	 }
	 
	 public int getValue() {
		 return value;
	 }
}
 
 public class Stack01{
	 public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(10));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(30));
		
		while (coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			// stack에서 뽑아서 값을 넘겨주는게 pop
			System.out.println("꺼내온 동전 : "+coin.getValue());
			
		}
	}
	 
 }
