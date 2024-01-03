package com.hoshi.call;

import java.util.LinkedList;
import java.util.Queue;

class Message{
	public String command;
	public String to;
	
	public Message(String command, String to) {
		this.command = command;
		this.to = to;
	}
	
}

public class Queue01 {
	public static void main(String[] args) {
		Queue<Message> messageQueue = new LinkedList<Message>();
		
		messageQueue.offer(new Message("sendMail", "홍길동"));
		messageQueue.offer(new Message("sendSMS", "김길동"));
		messageQueue.offer(new Message("sendDM", "최길동"));
		
		while(!messageQueue.isEmpty()) {
			Message msg = messageQueue.poll();
			System.out.println(msg.command+" : "+msg.to);
		}
	}
}
