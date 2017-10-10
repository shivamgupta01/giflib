package com.thymeleaf.giflib.Controller;

import com.thymeleaf.giflib.data.GifRepository;
import com.thymeleaf.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GifController {

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value = "/")
    public String listGif(ModelMap modelMap){
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";

    }
    @RequestMapping(value = "/gif/{name}")
    public String GifDetails(@PathVariable String name, ModelMap modelMap)
    {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif",gif);
        return "gif-details";

    }
}
