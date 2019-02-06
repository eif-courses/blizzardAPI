import java.util.*;


class Deze{
  int svoris;
  String pavadinimas;

  public Deze(int svoris, String pavadinimas) {
    this.svoris = svoris;
    this.pavadinimas = pavadinimas;
  }

  public int getSvoris() {
    return svoris;
  }

  public void setSvoris(int svoris) {
    this.svoris = svoris;
  }

  public String getPavadinimas() {
    return pavadinimas;
  }

  public void setPavadinimas(String pavadinimas) {
    this.pavadinimas = pavadinimas;
  }

  @Override
  public String toString() {
    return "Deze{" +
        "svoris=" + svoris +
        ", pavadinimas='" + pavadinimas + '\'' +
        '}';
  }

}

public class Main<E> implements List<E>{


  public static void perdidele(int svoris) throws DezePerDideleException{
    if(svoris == 0){
      throw new DezePerDideleException("Nera tokiu deziu su svoriu 0");
    }
  }
  public static void dezePermaza(int dydis){
    if(dydis ==12){
      throw new DezePerMazaRuntimeException("Per maza deze");
    }

  }
  public static void main(String[] args) {

    List<Deze> dezes = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      dezes.add(new Deze(i*20, "popierine"+i));
      dezes.add(new Deze(i*15, "stikline"+i));
      dezes.add(new Deze(i*12, "kartonine"+i));
    }


    for (Deze d: dezes){

      dezePermaza(d.getSvoris());

      try {
        perdidele(d.getSvoris());
      } catch (DezePerDideleException | NumberFormatException e) {
        System.out.println(e.getMessage());
        //e.printStackTrace();
      }
    }


    Collections.sort(dezes, new Comparator<Deze>() {
      @Override
      public int compare(Deze o1, Deze o2) {
        return 0;
      }
    });



    dezes.sort(new Comparator<Deze>() {
      @Override
      public int compare(Deze o1, Deze o2) {
        return o2.getSvoris() - o1.getSvoris();
      } // 0==, -1 <, 1 >
    });
    for(Deze elem: dezes){
      System.out.println(elem);
    }

    //Collections.sort();




    List<String> list = new ArrayList<>();
    List<String> vector = new Vector<>();
    List<String> main = new Main<>();
    main.add("waeawe");

    list.add("Labas");
    List<String> list2 = new ArrayList<>();
    list2.add("viso gero");

    list= vector;
    vector = list;



  }

  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<E> iterator() {
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
  public boolean add(E e) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends E> c) {
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

  }

  @Override
  public E get(int index) {
    return null;
  }

  @Override
  public E set(int index, E element) {
    return null;
  }

  @Override
  public void add(int index, E element) {

  }

  @Override
  public E remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<E> listIterator() {
    return null;
  }

  @Override
  public ListIterator<E> listIterator(int index) {
    return null;
  }

  @Override
  public List<E> subList(int fromIndex, int toIndex) {
    return null;
  }
}
