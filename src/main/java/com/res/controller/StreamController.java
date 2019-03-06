package com.res.controller;

import com.res.form.FoodForm;
import com.res.mapper.FoodMapper;
import com.res.mapper.OrderDetailPaidMapper;
import com.res.object.Food;
import com.res.object.OrderDetailPaid;
import com.res.object.OrderPaid;
import com.res.result.Result;
import com.res.result.ResultCode;
import com.res.result.ResultFactory;
import com.res.service.OrderPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/stream")
public class StreamController {
    @Autowired
    FoodMapper foodMapper;
    @Autowired
    OrderDetailPaidMapper orderDetailPaidMapper;
    @Autowired
    OrderPaidService orderPaidService;
    @GetMapping("/food")
    public ModelAndView foodStream(Map<String, Object> map){
        List<Food> foods=new ArrayList<>();
        foods=foodMapper.getAll();
        map.put("foods",foods);
        return new ModelAndView("/stream/food",map);
    }
    @PostMapping("/food")
    @ResponseBody
    public Result foodRankList(){
        List<Food> foods;
        foods=foodMapper.getAll();
        List<OrderDetailPaid> orderDetailPaids;
        orderDetailPaids=orderDetailPaidMapper.getAll();
        List<FoodForm> foodForms=new ArrayList<>();
        for(int i=0;i<foods.size();i++){
            FoodForm foodForm=new FoodForm();
            foodForm.setId(foods.get(i).getId());
            foodForm.setName(foods.get(i).getName());
            foodForm.setNumber(0);
            foodForms.add(foodForm);
        }
        for(int i=0;i<orderDetailPaids.size();i++){
            for(int j=0;j<foodForms.size();j++){
                if(orderDetailPaids.get(i).getName().equals(foodForms.get(j).getName()))
                    foodForms.get(j).setNumber(foodForms.get(j).getNumber()+1);
            }
        }
        return ResultFactory.buidResult(ResultCode.SUCCESS,"success",foodForms);
    }

    @GetMapping("/order")
    public ModelAndView orderStream(Map<String, Object> map){
        List<OrderPaid> orderPaids=orderPaidService.findAll();
        int[] moneys=new int[12];
        for(int i=0;i<orderPaids.size();i++){
            int month=orderPaids.get(i).getDate().getMonth();
            moneys[month]+=orderPaids.get(i).getPrice();
        }
        map.put("moneys",moneys);
        return new ModelAndView("/stream/order",map);
    }
}
