import java.util.*;

public class MyList<T> implements List<T> {

    private T[] array;
    private int size;

    //�����ڴ� �ʵ忡 �ʱⰪ�� �Ҵ��ϱ� ���� ����Ѵ�
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
    public void clear() {
        size = 0;
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
    public void add(int index, T element) {

        //index ���̸� �� ���� ��� ���� üũ�� �Ѵ�.
        //�߰�
        //index ������(�迭�� �����ϰ� �����)


        //�������
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //�߰�
        add(element);

        //������
        for (int i = size-1; i > index; i--){

            array[i] = array[i-1];
        }
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        //Collection Ÿ���̾�� �ϴµ� String�� �ȴ� String���� ���� ��Ų��
        //Collection�߿� StringŸ�Ը� �ȴٴ� ��

        boolean flag = true;

        for (T element : c){
            flag &= add(element); // &= addAll�� �� ���� �ǵ�
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        //TODO: ���߿� �����غ���
        throw new UnsupportedOperationException();

    }
    @Override
    public int indexOf(Object object) {
        //�������� �ؾ��Ѵ�.
        //java���� == �� reference(�ּ�) �� �����̴�. �� ���Ҷ��� equals����Ѵ�.
        for (int i = 0; i < size; i++){
            if(equals(object,array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        //�����ϴ��� �ƴ���,���Ե��ִ��� �ƴ����� �Ǵ��ϴ°Ŵ�
        //�迭 ������� �� �ϴ� �� index�� ��� �����ϴ����� �޷��ִ�.
        //index�� ����������κ��� �����Ѵ�.


        return indexOf(object) != -1;
    }
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c){
            if(!contains(element))return false;
        }

        return false;
    }
    @Override
    public T get(int index) {

        //�������
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        return array[index];
    }


    @Override
    public T set(int index, T element) {
        T old = get(index);
        array[index] = element;
        return null;
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

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        T old = get(index);

        //������
        for (int i = size-1; i > index; i--){

            array[i-1] = array[i];
        }

        return old;
    }

    @Override
    public boolean remove(Object o) {
        if (!o.equals(array[0]))
            return false;

        for (int i = size-1; i > 0; i--){

            array[i-1] = array[i];
        }
        return true;
    }



    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
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


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }




}
