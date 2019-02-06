package com.company.eif.viko.lt.anotacijos.Main;


import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Method;




class Objektas {
  private int a;
  private String d;


}

class Save{
  private void save(Objektas o){

  }
}







@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.PARAMETER})
@interface Test{
  boolean test()default false;
  int [] parameters();
  String type() default "Unit test";
}



class O{
  @Test(test=true, parameters = {10, 20, 30})
  private void k(){

  }

  /**
   * aweaweaweaweaweaweawe
   */
  @Test(test=true, parameters = {10, 20, 30})
  static void print(){
    System.out.println("printing...");
  }
}

public class Main {

  /**
   * @deprecated pakeiteme kitu
   */
  @Deprecated
  @Test(test=true, parameters = {10, 20, 30})
  private static void atgyvenes(int a, int c){
    System.out.println("printing...");
  }


  @Test(test=true, parameters = {10, 20, 30})
  static void print2(){
    System.out.println("printing...");
  }

  /**
   * Sis metodas yra skirtas isvesti i ekrana tuscia teksta
   * <h1>Naudojame tuo atveju kai....</h1>
   * @deprecated sis metoas yra pakeistas nauju optimizuotu kiekDabarValandu() {@link javaapplication3.JavaApplication3}
   *
   */
  @Deprecated
  static void print(){ System.out.println("");}

  /**
   * @since 1.5
   * @param rgb perduodame rgb spalvos koda
   @throws NumberFormatException tuo atveju kai ivestiss yra neteisinga pvz: nera # priekyje aaddff -> #aaddff
   */
  static void piesti(int rgb) throws NumberFormatException{}



  public static void main(String[] args) {



    Method methods[] = O.class.getMethods();

    for (Method method : methods) {
      if(method.isAnnotationPresent(Test.class)){
        Test t = method.getAnnotation(Test.class);
        System.out.println("aweawe"+t.test()+t.parameters());
      }else{
        System.out.println("waeaweawea$aaa weaweaweweaawe");
      }
    }
    String sql="select * from universitetas";

    String html="<html>\n" +
        "<head>\n" +
        "<body>\n" +
        "<table>\n" +
        "    <td>\n" +
        "        <tr></tr>\n" +
        "    </td>\n" +
        "</table>\n" +
        "</body>\n" +
        "</head></html>";




    int a = 10;
  }
}
