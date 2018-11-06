package data_structures;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CustomArrayListTest {


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testAddToArrayList()
    {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Duck");
        list.add("Goose");

        assertEquals(2, list.size());
    }


    @Test
    public void testGetFromArrayList()
    {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Duck");
        list.add("Goose");

        String value = list.get(0);

        assertEquals("Duck", value);
    }

    @Test
    public void testGetFromArrayListWithInvalidIndex()
    {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Duck");
        list.add("Goose");

        thrown.expect( ArrayIndexOutOfBoundsException.class );
        list.get(10);

    }

    @Test
    public void testRemoveFromArrayList()
    {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Duck");
        list.add("Goose");
        list.add("Cockatiel");
        assertEquals(3, list.size());

        list.remove(1);
        assertEquals(2, list.size());

        assertEquals("Cockatiel", list.get(1));
    }

    @Test
    public void testRemoveFromArrayListWithInvalidIndex()
    {
        CustomArrayList<String> list = new CustomArrayList<>();

        list.add("Duck");
        list.add("Goose");

        thrown.expect( ArrayIndexOutOfBoundsException.class );
        list.remove(10);
    }

    @Test
    public void testAddMoreItemsThanDefaultCapacity()
    {
        CustomArrayList<Integer> list = new CustomArrayList<>();

        for (int i = 0; i < 50; i++) {
            list.add(i);
        }

        assertEquals(50, list.size());

    }

}
