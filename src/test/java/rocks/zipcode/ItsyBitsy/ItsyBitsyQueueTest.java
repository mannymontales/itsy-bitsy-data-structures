package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyQueueTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyQueue<Integer> list = new ItsyBitsyQueue<>(value);

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
