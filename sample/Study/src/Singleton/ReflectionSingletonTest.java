package Singleton;

import java.lang.reflect.Constructor;

public class ReflectionSingletonTest {

	public static void main(String[] args) {
		
		Singleton instanceOne = Singleton.getInstance();
		
		Singleton instanceTwo = null;
		try{
			
			Constructor[] constructors = Singleton.class.getDeclaredConstructors();
			
			for(Constructor constructor : constructors){
				constructor.setAccessible(true);
				instanceTwo =  (Singleton) constructor.newInstance();
				break;
				
			}
				
		}catch (Exception e) {
            e.printStackTrace();
        }
		System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());

	}

}
