package data_structures;

/**
 * An implementation of an ArrayList
 * @param <T> Type of objects list stores
 */
public class CustomArrayList<T> {

    private final int DEFAULT_CAPACITY = 20;

    private Object[] elements ;

    private int size;

    private int capacity;


    public CustomArrayList()
    {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    /**
     * Adds an item to the list
     * @param t item to be added
     */
    public void add ( T t )
    {
        if (this.size==this.capacity -1)
        {
            increaseCapacity();
        }

        elements[this.size++] = t;
    }

    /**
     * Returns an object from the list
     * @param index Index of the sought object
     * @return the object that was found in index
     */
    public T get( int index )
    {
        if ( index >= this.size  || index < 0 )
        {
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        }

        return (T) this.elements[index];
    }

    /**
     * Removes an object from the list
     * @param index index of the object that is removed
     */
    public void remove(int index)
    {
        if ( index >= this.size  || index < 0 )
        {
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        }

        for (int i = index + 1; i < this.size; i++)
        {
            this.elements[i - 1] = this.elements[i];
            this.elements[this.size - 1] = null;

            this.size--;
        }


    }

    /**
     * Adds an object to the list in a specific location
     * @param index Index where the objectg will be stored
     * @param object Object that will be stored
     */
    public void put(int index, T object)
    {
        if ( index >= this.size  || index < 0 )
        {
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        }

        this.elements[index] = object;
    }

    private void increaseCapacity()
    {
        this.capacity *= 2;
        Object[] temporalArray = this.elements;

        this.elements = new Object[this.capacity];

        for (int i = 0; i < temporalArray.length; i++)
        {
            this.elements[i] = temporalArray[i];
        }
    }

    /**
     * Amount of objects stored in the list
     * @return size of the list
     */
    public int size()
    {
        return this.size;
    }





}
