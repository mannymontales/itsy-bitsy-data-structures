package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyHashTableTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyHashTable<Integer> list = new ItsyBitsyHashTable<>(value);

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
