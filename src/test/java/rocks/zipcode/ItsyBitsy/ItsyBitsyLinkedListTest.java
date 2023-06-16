package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyLinkedListTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyLinkedList<Integer> list = new ItsyBitsyLinkedList<>();

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
