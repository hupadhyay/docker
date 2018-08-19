import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test{

    public static void main(String args[])throws InterruptedException{
        while(true){
            System.out.println("The Date and Time is : " +  new Date());
            TimeUnit.SECONDS.sleep(3);
        }
        
    }

}