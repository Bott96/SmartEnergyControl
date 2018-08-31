package it.unical.smartenergycontroll.logic;

public class MyMessage extends net.tinyos.message.Message {
	
	  /** The default size of this message type in bytes. */
    public static final int DEFAULT_MESSAGE_SIZE = 2;

    /** The Active Message type associated with this message. */
    public static final int AM_TYPE = 3;
	
    
    int getNodeId() {
    	
    	return (int)getUIntBEElement(0, 16);
    }
    
    int getCounter() {
    	
    	return (int)getUIntBEElement(16, 16);
    }
    
    void setCounter(int start, int size, int value) {
    	setUIntBEElement(start, size, value);
    }
    
    public MyMessage() {
    	super(DEFAULT_MESSAGE_SIZE);
        amTypeSet(AM_TYPE);
    }

    /** Create a new PayLoadMsg of the given data_length. */
    public MyMessage(int data_length) {
        super(data_length);
        amTypeSet(AM_TYPE);
    }
    /**
     * Create a new PayLoadMsg using the given byte array
     * as backing store.
     */
    public MyMessage(byte[] data) {
        super(data);
        amTypeSet(AM_TYPE);
    }
    
    
   /** Create a new PayLoadMsg using the given byte array
    * as backing store, with the given base offset.
    */
   public MyMessage(byte[] data, int base_offset) {
       super(data, base_offset);
       amTypeSet(AM_TYPE);
   }
   
   
   /**
    * Create a new PayLoadMsg embedded in the given message
    * at the given base offset.
    */
   public MyMessage(net.tinyos.message.Message msg, int base_offset) {
       super(msg, base_offset, DEFAULT_MESSAGE_SIZE);
       amTypeSet(AM_TYPE);
   }
   
   @Override
public String toString() {
	
	return dataGet().toString();
}

	

}
