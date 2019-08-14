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
            System.arraycopy(array,0,bigger,0,array.length);//deep Copy 값을 복사
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

        //재정렬
        for (int i = size-1; i > index; i--){

            array[i] = array[i-1];
        }
        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        //Collection 타입이어야 하는데 String만 된다 String으로 한정 시킨다
        //Collection중에 String타입만 된다는 말

        boolean flag = true;

        for (T element : c){
            flag &= add(element); // &= addAll을 다 넣을 건데
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
        //생각많이 해야한다.
        //java에서 == 은 reference(주소) 랑 동격이다. 값 비교할때는 equals써야한다.
        for (int i = 0; i < size; i++){
            if(equals(object,array[i]))
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
        for (Object element : c){
            if(!contains(element))return false;
        }

        return false;
    }
    @Override
    public T get(int index) {

        //경계조건
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

        //재정렬
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
