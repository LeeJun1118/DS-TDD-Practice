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
        return array.length;
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

        //List�� �������� �ȴٸ�
        if (size >= array.length) {

            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);//deep Copy ���� ����
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

        //������ --> �߰��� element�� �� ������ ���� ������ index��°���� �ڷ� ��ĭ�� �̵��Ͻ��� ���� Ȯ��
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        //��� �迭�� ������ ���ʴ�� �ٸ� �迭�� 0��°���� ������ ��� ���� add�ȴ�.
        //Collection Ÿ���̾�� �ϴµ� String�� �ȴ� String���� ���� ��Ų��
        //Collection�߿� StringŸ�Ը� �ȴٴ� ��

        boolean flag = true;
        // �� �迭�� add�ϴ� �ٸ� �迭�� ���� 0��°���� ������ �ϳ��� element�� �־
        // add�ϴµ� add�� �ϳ��� �����ϸ� false�� ��ȯ�Ѵ�. �ʱⰪ�� true�� �Z�� ������
        // �ϳ��� false�� ������ �׶����� �� false�̴�
        for (T element : c) {
            flag &= add(element);

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
        //ã���� �ϴ� ���� ���� �迭�� ���° �ڸ��� �ִ��� ã�� �Լ�
        //�������� �ؾ��Ѵ�.
        //java���� == �� reference(�ּ�) �� �����̴�. �� ���Ҷ��� equals����Ѵ�.
        for (int i = 0; i < size; i++) {
            if (equals(object, array[i]))
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
        for (Object element : c) {
            if (!contains(element)) return false;
        }

        return true;
    }

    @Override
    public T get(int index) {

        //�������
        if (index < 0 || index > size) {
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

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public T remove(int index) {

        //remove�� �ɶ����� size������ -- �Ǳ� ������ ��� �������� ���� �迭�� ������ �ε��� + 1 ��ŭ�� ȣ���� �ȴ�.

        //�������
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();


        T old = array[index];

        //������
        for (int i = index + 1; i < size; i++) {

            array[i - 1] = array[i];
        }

        //size�� �پ��°� ������ ���� �迭�� ũ�Ⱑ �پ��� ���� �ƴϴ�.
        size--;
        array[size] = null;

        /*if (array.length%2==0 && array.length/2 >= size){
            T[] smaller = (T[]) new Object[array.length / 2];

            System.arraycopy(array, 0, smaller, 0, array.length);//deep Copy ���� ����
            array = smaller; //shallow copy ��ü�� �ּҸ� ���� �ݵ�� �־�� �Ѵ�.
        }*/

        return old;
    }

    @Override
    public boolean remove(Object o) {
        //Object o �� ���� �� ã�Ƽ� ����

        for (int i = 0; i < size; i++) {

            if (equals(o, array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean removeAll(Collection<?> c) {

        for (Object s : c) {
            remove(s);
        }
        clear();


        return true;
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
