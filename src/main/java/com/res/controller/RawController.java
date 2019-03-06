package com.res.controller;

import com.res.object.Raw;
import com.res.result.Result;
import com.res.result.ResultCode;
import com.res.result.ResultFactory;
import com.res.service.RawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/raw")
public class RawController {
    @Autowired
    RawService rawService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map
    ) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Raw> foodPage = rawService.findAll(request);
        map.put("rawPage", foodPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("raw/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "rawId",required = false) Integer id,
                              Map<String,Object> map)
    {
        if(!StringUtils.isEmpty(id))
        {
            Raw raw=rawService.getById(id);
            map.put("raw",raw);
        }
        return new ModelAndView("raw/index",map);
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid Raw raw, BindingResult bindingResult, Map<String,Object> map)
    {
        if(bindingResult.hasErrors())
        {
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/res/raw/list");
            return new ModelAndView("common/error",map);
        }
        try{
          rawService.save(raw);
        }
        catch (Exception e)
        {
            map.put("msg",e.getMessage());
            map.put("url","/res/raw/list");
            return new ModelAndView("common/error",map);
        }
        map.put("url","/res/raw/list");
        return new ModelAndView("common/success",map);
    }
    @GetMapping("/import")
    public ModelAndView inputList(){
        return new ModelAndView("raw/import");
    }
    @PostMapping("/import")
    @ResponseBody
    public Result rawImportList(){
        List<Raw> rawImportList=new ArrayList<>();
        List<Raw> rawList=rawService.findAll();
        for(int i=0;i<rawList.size();i++){


            Raw raw=rawList.get(i);

            if (raw.getNumber()<raw.getMin()){
                Raw rawImport=raw;
                rawImport.setNumber(raw.getMax()-raw.getNumber());
                rawImportList.add(rawImport);
            }
        }
        return ResultFactory.buidResult(ResultCode.SUCCESS,"success",rawImportList);
    }
}
