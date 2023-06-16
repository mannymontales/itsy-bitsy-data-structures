package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyTreeTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyTree<Integer> list = new ItsyBitsyTree<>();

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
