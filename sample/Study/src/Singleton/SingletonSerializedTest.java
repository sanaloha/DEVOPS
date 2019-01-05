package Singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class SingletonSerializedTest {
	
	//So it destroys the singleton pattern, to overcome this scenario all we need to do it
	//provide the implementation of readResolve() method.
	
	/*protected Object readResolve() {
	    return getInstance();
	}*/

	public static void main(String[] args)  throws FileNotFoundException, IOException, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		SerializedSingleton instanceOne = SerializedSingleton.getInstance();
		
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                "filename.ser"));
		out.writeObject(instanceOne);
        out.close();
        
        //deserailize from file to object
        ObjectInput in = new ObjectInputStream(new FileInputStream(
                "filename.ser"));
        SerializedSingleton instanceTwo = (SerializedSingleton) in.readObject();
        in.close();
        
        System.out.println("instanceOne hashCode="+instanceOne.hashCode());
        System.out.println("instanceTwo hashCode="+instanceTwo.hashCode());

	}

}
