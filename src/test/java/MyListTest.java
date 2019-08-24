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

    @Test
    public void testMyListRemoveObject(){
        MyList<String> myList = new MyList<>();
        myList.add("a");
        myList.add("b");
        myList.add("c");

        myList.remove("c");

        assertEquals(myList.get(1),"b");
        assertEquals(myList.get(2),null);
        assertNotEquals(myList.get(2),"c");
        assertEquals(myList.size(),4);

    }

    @Test
    public void testMyListRemoveIndex(){
        MyList<String> myList = new MyList<>();
        myList.add("World0");
        myList.add("World1");
        myList.add("World2");
        myList.add("World3");

        myList.remove(0);
        myList.remove(2);

        assertEquals(myList.get(0),"World1");
        assertEquals(myList.get(1),"World2");

        //assertEquals(myList.get(2),null);
        assertEquals(myList.size(),4);

        System.out.println(myList.get(0));
        System.out.println(myList.get(1));
        System.out.println(myList.get(2));
        //System.out.println(myList.get(3));

        System.out.println(myList.size());
    }

    @Test
    public void testMyListRemoveAll(){
        MyList<String>  myList = new MyList<>();

        myList.add("World0");
        myList.add("World1");
        myList.add("World2");
        myList.add("World3");

        myList.removeAll(myList);

        myList.isEmpty();

    }

    @Test
    public void testMyListContainsAll(){

        MyList<String> myList = new MyList<>();
        List<String> list = new ArrayList<>();

        myList.add("World0");
        myList.add("World1");
        myList.add("World2");
        myList.add("World3");


        list.add("World0");
        list.add("World1");
        list.add("World2");
        list.add("World3");


        myList.containsAll(list);

        //list 는 최상위 List ContainsAll이 없고 ArrayList에는 있다.
        //객체가 생성이 안되도 NullPointException이 난다.

        //list.containsAll(myList); //  --에러 => 이건 왜 에러가 나는지 모르겠다. 자료형 문제인 것으로 어렴풋이 추측된다.

        assertEquals(myList.get(0),list.get(0));
        assertEquals(myList.get(1),list.get(1));
        assertEquals(myList.get(2),list.get(2));

        //assertEquals(myList.get(3),list.get(3));

    }

}