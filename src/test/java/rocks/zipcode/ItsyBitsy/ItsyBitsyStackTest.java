package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyStackTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyStack<Integer> list = new ItsyBitsyStack<>(value);

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
