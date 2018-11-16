package data_structures;


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

    public void add ( T t )
    {
        if (this.size==this.capacity -1)
        {
            increaseCapacity();
        }

        elements[this.size++] = t;
    }

    public T get( int index )
    {
        if ( index >= this.size  || index < 0 )
        {
            throw new ArrayIndexOutOfBoundsException("Invalid index " + index);
        }

        return (T) this.elements[index];
    }

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

    public int size()
    {
        return this.size;
    }





}
