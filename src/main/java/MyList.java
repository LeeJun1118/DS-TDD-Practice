import java.util.*;

public class MyList<T> implements List<T> {

    private T[] array;
    private int size;

    //생성자는 필드에 초기값을 할당하기 위해 사용한다
    public MyList() {
        this.array = (T[]) new Object[1]; //형변환(Casting)
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

        //List가 가득차게 된다면
        if (size >= array.length) {

            T[] bigger = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, bigger, 0, array.length);//deep Copy 값을 복사
            array = bigger; //shallow copy 객체의 주소를 복사 반드시 있어야 한다.
        }
        array[size] = element;
        size++;

        return true;

    }


    @Override
    public void add(int index, T element) {

        //index 보이면 젤 먼저 경계 조건 체크를 한다.
        //추가
        //index 재정렬(배열을 촘촘하게 맞춘다)

        //경계조건
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //추가
        add(element);

        //재정렬 --> 추가할 element가 들어갈 공간을 위해 기존의 index번째부터 뒤로 한칸씩 이동하시켜 공간 확보
        for (int i = size - 1; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        //어떠한 배열의 끝부터 차례대로 다른 배열의 0번째부터 끝까지 모든 값이 add된다.
        //Collection 타입이어야 하는데 String만 된다 String으로 한정 시킨다
        //Collection중에 String타입만 된다는 말

        boolean flag = true;
        // 내 배열에 add하는 다른 배열의 원소 0번째부터 끝까지 하나씩 element에 넣어서
        // add하는데 add가 하나라도 실패하면 false를 반환한다. 초기값을 true로 줫기 때문에
        // 하나라도 false가 나오면 그때부터 다 false이다
        for (T element : c) {
            flag &= add(element);

        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {

        //TODO: 나중에 구현해보자
        throw new UnsupportedOperationException();

    }

    @Override
    public int indexOf(Object object) {
        //찾고자 하는 것이 값이 배열의 몇번째 자리에 있는지 찾는 함수
        //생각많이 해야한다.
        //java에서 == 은 reference(주소) 랑 동격이다. 값 비교할때는 equals써야한다.
        for (int i = 0; i < size; i++) {
            if (equals(object, array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        //존재하는지 아닌지,포함되있는지 아닌지를 판단하는거다
        //배열 기반으로 뭘 하는 건 index를 어떻게 조작하는지에 달려있다.
        //index는 경계조건으로부터 시작한다.

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

        //경계조건
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

        //remove가 될때마다 size변수가 -- 되기 때문에 경계 조건으로 인해 배열에 마지막 인덱스 + 1 만큼만 호출이 된다.

        //경계조건
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();


        T old = array[index];

        //재정렬
        for (int i = index + 1; i < size; i++) {

            array[i - 1] = array[i];
        }

        //size는 줄어드는게 맞지만 실제 배열의 크기가 줄어드는 것은 아니다.
        size--;
        array[size] = null;

        /*if (array.length%2==0 && array.length/2 >= size){
            T[] smaller = (T[]) new Object[array.length / 2];

            System.arraycopy(array, 0, smaller, 0, array.length);//deep Copy 값을 복사
            array = smaller; //shallow copy 객체의 주소를 복사 반드시 있어야 한다.
        }*/

        return old;
    }

    @Override
    public boolean remove(Object o) {
        //Object o 와 같은 값 찾아서 삭제

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
