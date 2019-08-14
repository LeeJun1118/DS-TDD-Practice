import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MyListTest {


    @Test
    public void testMyListNotNull(){
        MyList<String> myList = new MyList<>();
        assertNotNull(myList);
    }

    @Test
    public void testMyListAdd(){
        MyList<String> myList = new MyList();
        myList.add("Hello");
        myList.add("World");
        assertEquals(myList.size(),2);
    }


    @Test
    public void testMyListAddIndex(){
        MyList<String> myList = new MyList<String>();
        myList.add("Hello");
        myList.add("World");
        myList.add(1,"Java");
        assertEquals(myList.get(1), "Java");

    }

    @Test
    public void testMyListAddAll(){
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        MyList<String> myList = new MyList<String>();
        myList.addAll(stringList);
        assertEquals(myList.size(),2);

    }
}