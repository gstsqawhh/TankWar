package view_model;

import message.MessageType;

public class ViewObject {
	
	private MessageType messageType;

	public ViewObject(MessageType type) {
		this.messageType = type;
	}
	
	public MessageType getMessageType() {
		return messageType;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	
	

}
