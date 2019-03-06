package com.res.controller;

import com.res.object.Food;
import com.res.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/food")
public class FoodController {
    @Autowired
    FoodService foodService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map
    ) {
        PageRequest request=PageRequest.of(page-1,size);
        Page<Food> foodPage = foodService.findAll(request);
        map.put("foodPage", foodPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("food/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "foodId",required = false) Integer id,
                              Map<String,Object> map)
    {
        if(!StringUtils.isEmpty(id))
        {
            Food food=foodService.getById(id);
            map.put("food",food);
        }
        return new ModelAndView("food/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid Food food, BindingResult bindingResult, Map<String,Object> map)
    {
        if(bindingResult.hasErrors())
        {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/product/list");
            return new ModelAndView("common/error",map);
        }
        try{

            Food updatedFood =foodService.getById(food.getId());
            updatedFood.setPrice(food.getPrice());
            updatedFood.setIntroduction(food.getIntroduction());
            foodService.save(updatedFood);

        }
        catch (Exception e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/res/food/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/res/food/list");
        return new ModelAndView("common/success",map);
    }
}
