package immutable;

/**
 * Notice that in my Mutable subclass, I've overridden the behavior of getValue to read a new,
 * mutable field declared in my subclass. As a result, your class, which initially looks immutable,
 * really isn't immutable. I can pass this Mutable object wherever an Immutable object is expected, 
 * which could do Very Bad Things to code assuming the object is truly immutable. Marking the base 
 * class final prevents this from happening.
 * 
 * 
 * 
 * **/

public class Mutable extends Immutable{

	private int realValue;

    public Mutable(int value) {
        super(value);

        realValue = value;
    }

    public int getValue() {
        return realValue;
    }
    public void setValue(int newValue) {
        realValue = newValue;
    }

   public static void main(String[] arg){
       Mutable obj = new Mutable(4);
       Immutable immObj = (Immutable)obj;              
       System.out.println(immObj.getValue());
       obj.setValue(8);
       System.out.println(immObj.getValue());
   }

}

/*******
 * 
 * 
 * https://stackoverflow.com/questions/12306651/why-would-one-declare-an-immutable-class-final-in-java
 * 
 * If I do Mutable m = new Mutable(4); m.setValue(5); Here, I am playing around with Mutable class object, not Immutable class object.So, I am still confused why Immutable class is not immutable – Anand Sep 6 '12 at 19:26
10
Imagine you have a function that takes an Immutable an argument. I can pass a Mutable object to that function, since Mutable extends Immutable. Inside that function, while you think your object is immutable, I could have a secondary thread that goes and changes the value as the function runs. I could also give you a Mutable object that the function stores, then later change its value externally. In other words, if your function assumes the value is immutable, it could easily break, since I could give you a mutable object and change it later on. Does that make sense?

 * For creating immutable class it is not mandatory to mark the class as final.

Let me take one of such example from java classes itself "BigInteger" class is immutable but its not final.

Actually Immutability is a concept according to which ones the object created then it can not be modified.

Let's think from JVM point of view, from JVM point of view all threads must share the same copy of the object and it is fully constructed before any thread accesses it and the state of the object doesn't change after its construction.

Immutability means there is no way yo change the state of the object once it is created and this is achieved by three thumb rules which makes the compiler to recognize that class is immutable and they are as follows :-

all non private fields should be final
make sure there is no method in the class that can change the fields of the object either directly or indirectly
any object reference defined in the class can't be modified outside from the class
 * 
 * *****/
 