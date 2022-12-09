package kz.narxoz.newspring.services;

import kz.narxoz.newspring.entities.Categories;
import kz.narxoz.newspring.entities.Countries;
import kz.narxoz.newspring.entities.ShopItems;

import java.util.List;

public interface ItemServices {
  ShopItems addItem(ShopItems item);
  List<ShopItems> getAllItems();
  ShopItems getItem(Long id);
  void deleteItem(ShopItems item);
  ShopItems saveItem(ShopItems item);

  List<Countries> getAllCountries();
  Countries addCountry(Countries country);
  Countries saveCountry(Countries country);
  Countries getCountry(Long id);

  List<Categories> getAllCategories();
  Categories getCategory(Long id);
  Categories saveCategory(Categories category);
  Categories addCategories(Categories category);
}
