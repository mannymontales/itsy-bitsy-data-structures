package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyGraphTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyGraph<Integer> list = new ItsyBitsyGraph<>();

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
