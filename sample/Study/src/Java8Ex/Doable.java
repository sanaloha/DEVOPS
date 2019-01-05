package Java8Ex;


//Functional interface
interface Doable{  
    default void doIt(){  
        System.out.println("Do it now");  
    }  
}
