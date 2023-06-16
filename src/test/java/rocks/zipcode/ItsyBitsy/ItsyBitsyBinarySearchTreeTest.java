package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyBinarySearchTreeTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
        Integer result = 0;
		ItsyBitsyBinarySearchTree<Integer> list = new ItsyBitsyBinarySearchTree<>();

		// list.push(value);
		// Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
}
