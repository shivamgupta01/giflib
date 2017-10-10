package com.thymeleaf.giflib.Controller;

import com.thymeleaf.giflib.data.CategoryRepository;
import com.thymeleaf.giflib.data.GifRepository;
import com.thymeleaf.giflib.model.Category;

import com.thymeleaf.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepositorycategory;

    private GifRepository gifRepository;

    @RequestMapping(value = "/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories= categoryRepositorycategory.getAllCategories();
        modelMap.put("categories",categories);
        return "categories";
    }

    @RequestMapping(value = "/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap)
    {
        Category category = categoryRepositorycategory.findByID(id);
        modelMap.put("category",category);

        List<Gif> gifs = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifs);

        return "category";

    }


}
