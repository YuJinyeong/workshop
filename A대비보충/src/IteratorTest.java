import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {

	    ArrayList<String> list = new ArrayList<String>();
	    list.add("a");
	    list.add("b");
	    list.add("c");
	    
	    Iterator<String> it = list.iterator();
	    list.add("d"); //java.util.ConcurrentModificationException
	    
	    while(it.hasNext()) {
	        System.out.println(it.next());
	    }
	}
}
