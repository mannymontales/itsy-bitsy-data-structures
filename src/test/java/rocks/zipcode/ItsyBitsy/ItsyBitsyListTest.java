package rocks.zipcode.ItsyBitsy;

import static org.junit.Assert.*;  
import org.junit.Test;  
  
public class ItsyBitsyListTest {  
  
    @Test  
    public void TestList(){
		Integer value = 5;
		ItsyBitsyList<Integer> list = new ItsyBitsyList<>(value);

		list.push(value);
		Integer result = list.pop();
        assertEquals(value, result);  
    } 
    
    @Test  
    public void TestUnshiftShift(){
		Integer value = 5;
		ItsyBitsyList<Integer> list = new ItsyBitsyList<>(value);

		list.unshift(value);
		//list.unshift(value+1);

		Integer result = list.shift();
        //result = list.shift();
        assertEquals(value, result);  
    }  
}  