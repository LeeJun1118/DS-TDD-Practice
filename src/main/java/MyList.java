import java.util.*;

public class MyList<T> implements List<T> {

    private T[] array;
    private int size;

    public MyList() {
        this.array = (T[]) new Object[1]; //����ȯ(Casting)
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {

        return size == 0;
    }


    @Override
    public boolean add(T element) {


        if(size >= array.length){

            T[] bigger = (T[]) new Object[array.length *2];
            System.arraycopy(array,0,bigger,0,array.length);//deep Copy ���� ����
            array = bigger; //shallow copy ��ü�� �ּҸ� ���� �ݵ�� �־�� �Ѵ�.
        }
        array[size] = element;
        size++;

        return true;

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        //Collection Ÿ���̾�� �ϴµ� String�� �ȴ� String���� ���� ��Ų��
        //Collection�߿� StringŸ�Ը� �ȴٴ� ��

        boolean flag = true;

        for (T element : c){
            flag &= add(element); // &=
        }
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        //TODO: ���߿� �����غ���
        throw new UnsupportedOperationException();

    }


    @Override
    public boolean contains(Object o) {
        //�����ϴ��� �ƴ���,���Ե��ִ��� �ƴ����� �Ǵ��ϴ°Ŵ�
        //�迭 ������� �� �ϴ� �� index�� ��� �����ϴ����� �޷��ִ�.
        //index�� ����������κ��� �����Ѵ�.


        return indexOf(o) != -1;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c){
            if(!contains(element))return false;
        }

        return false;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

        size = 0;
    }


    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {

        //index ���̸� �� ���� ��� ���� üũ�� �Ѵ�.
        //�߰�
        //index ������(�迭�� �����ϰ� �����)



        //�߰�
        add(element);

        //������
        for (int i = size-1; i > index; i--){

            array[i] = array[i-1];
        }
        array[index] = element;

    }
    @Override
    public T get(int index) {

        //�������
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }

    private boolean equals(Object target, Object element){
        if (target == null){
            return element == null;
        }else{
            return target.equals(element);
        }
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        //�������� �ؾ��Ѵ�.
        //java���� == �� reference(�ּ�) �� �����̴�. �� ���Ҷ��� equals����Ѵ�.
        for (int i = 0; i < size; i++){
            if(equals(o,array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }




}
