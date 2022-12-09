package kz.narxoz.newspring.services.impl;

import kz.narxoz.newspring.entities.Categories;
import kz.narxoz.newspring.entities.Countries;
import kz.narxoz.newspring.entities.ShopItems;
import kz.narxoz.newspring.repositories.CategoryRepository;
import kz.narxoz.newspring.repositories.CountryRepository;
import kz.narxoz.newspring.repositories.ShopItemRepository;
import kz.narxoz.newspring.services.ItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemServices {
    @Autowired
    private ShopItemRepository shopItemRepository;

    @Autowired
    private CountryRepository countryRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public ShopItems addItem(ShopItems item) {
    return shopItemRepository.save(item);
  }

  @Override
  public List<ShopItems> getAllItems() {
    return shopItemRepository.findAllByAmountGreaterThanOrderByPriceDesc(0);
  }

  @Override
  public ShopItems getItem(Long id) {
    return shopItemRepository.findByIdAndAmountGreaterThan(id,0);
  }

  @Override
  public void deleteItem(ShopItems item) {
shopItemRepository.delete(item);
  }

  @Override
  public ShopItems saveItem(ShopItems item) {
    return shopItemRepository.save(item);
  }

  @Override
  public List<Countries> getAllCountries() {
    return countryRepository.findAll();
  }

  @Override
  public Countries addCountry(Countries country) {
      return countryRepository.save(country);
  }

  @Override
  public Countries saveCountry(Countries country) {
    return countryRepository.save(country);
  }

  @Override
  public Countries getCountry(Long id) {
    return countryRepository.getById(id);
  }

  @Override
  public List<Categories> getAllCategories() {
    return categoryRepository.findAll();
  }


  @Override
  public Categories getCategory(Long id) {
    return categoryRepository.getById(id);
  }

  @Override
  public Categories saveCategory(Categories category) {
    return categoryRepository.save(category);
  }

  @Override
  public Categories addCategories(Categories category) {
    return categoryRepository.save(category);
  }
}
