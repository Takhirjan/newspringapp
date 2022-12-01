package kz.narxoz.newspring.db;

import java.util.ArrayList;

public class DBManager {
  private  static ArrayList<Items> items=new ArrayList<>();

  static {
    items.add(new Items(1L,"Iphone12", 4000));
    items.add(new Items(2L,"Iphone13", 5000));
    items.add(new Items(3L,"Iphone13PRo", 8000));

    items.add(new Items(4L,"Iphone14", 6000));
  }
  private static Long id=5L;
  public static ArrayList<Items> getItems(){
    return items;
  }
  public static void addItem(Items item){
    item.setId(id);
    items.add(item);
    id++;

  }
  public static  Items getItem(Long id){
    for(Items it:items){
      if(it.getId()==id) return it;

    }
    return null;
  }
}
