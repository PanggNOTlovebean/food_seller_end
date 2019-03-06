package com.res.controller;

import com.res.form.FoodForm;
import com.res.form.ResInfoForm;
import com.res.mapper.OrderDetailPaidMapper;
import com.res.object.Food;
import com.res.object.OrderDetailPaid;
import com.res.object.OrderPaid;
import com.res.object.Raw;
import com.res.result.Result;
import com.res.result.ResultCode;
import com.res.result.ResultFactory;
import com.res.service.FoodService;
import com.res.service.OrderPaidService;
import com.res.service.RawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    FoodService foodService;
    @Autowired
    OrderPaidService orderPaidService;
    @Autowired
    OrderDetailPaidMapper orderDetailPaidMapper;
    @Autowired
    RawService rawService;

    @GetMapping("/home")
    public ModelAndView list(
    ) {

        return new ModelAndView("home/home");
    }
    @PostMapping("/home")
    @ResponseBody
    public Result getAllInfo(){
        Integer todayNum=0;
         Integer todayMoney=0;
         Integer yesterdayMoney=0;
         Integer weekMoney=0;
         Integer foodNum;
         Integer rawNum;
         Integer rawLackNum=0;
         Integer yesterdayOrder=0;
         Integer weekOrder=0;
         Integer monthOrder=0;
         String bestFood="";
         String badFood="";
        ResInfoForm infoForm=new ResInfoForm();
        List<OrderPaid> orderPaids=orderPaidService.findAll();
        List<Food> foods=foodService.findAll();
        List<OrderDetailPaid> orderDetailPaids=orderDetailPaidMapper.getAll();
        List<Raw> raws=rawService.findAll();

        for(int i=0;i<orderPaids.size();i++){
            Timestamp timestamp=orderPaids.get(i).getDate();
            Period period=Period.between(LocalDate.of(timestamp.getYear(),timestamp.getMonth()+1,timestamp.getDate()), LocalDate.now());
            if(period.getDays()<1){
                todayNum++;
                todayMoney+=orderPaids.get(i).getPrice();
            }if(period.getDays()==1){
                yesterdayOrder++;
                yesterdayMoney+=orderPaids.get(i).getPrice();
            }if(period.getDays()<7){
                weekOrder++;
                weekMoney+=orderPaids.get(i).getPrice();
            }if((timestamp.getMonth()+1)==LocalDate.now().getMonthValue()){
                monthOrder++;
            }
        }
        foodNum=foods.size();
        int max=0,min=10000;

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
        for(int i=0;i<foods.size();i++){
            if(max<foodForms.get(i).getNumber()){
                max=foodForms.get(i).getNumber();
                bestFood=foodForms.get(i).getName();
            }
            if(min>foodForms.get(i).getNumber()){
                min=foodForms.get(i).getNumber();
                badFood=foodForms.get(i).getName();
            }
        }
        List<Raw> rawList=rawService.findAll();
        for(int i=0;i<rawList.size();i++){
            Raw raw=rawList.get(i);
            if (raw.getNumber()<raw.getMin()){
                rawLackNum++;
            }
        }
        rawNum=raws.size();
        infoForm.setTodayNum(todayNum);
        infoForm.setYesterdayOrder(yesterdayOrder);
        infoForm.setWeekOrder(weekOrder);
        infoForm.setTodayMoney(todayMoney);
        infoForm.setWeekMoney(weekMoney);
        infoForm.setYesterdayMoney(yesterdayMoney);
        infoForm.setMonthOrder(monthOrder);
        infoForm.setFoodNum(foodNum);
        infoForm.setRawNum(rawNum);
        infoForm.setBadFood(badFood);
        infoForm.setBestFood(bestFood);
        infoForm.setRawLackNum(rawLackNum);
        return ResultFactory.buidResult(ResultCode.SUCCESS,"success",infoForm);
    }
}
