package com.res.controller;

import com.res.mapper.OrderDetailPaidMapper;
import com.res.object.Food;
import com.res.object.OrderDetailPaid;
import com.res.object.OrderPaid;
import com.res.service.OrderDetailPaidService;
import com.res.service.OrderPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderDetailPaidService orderDetailPaidService;
    @Autowired
    OrderPaidService orderPaidService;
    @Autowired
    OrderDetailPaidMapper orderDetailPaidMapper;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map
    ) {
        PageRequest request = PageRequest.of(page - 1, size);
        Page<OrderPaid> foodPage = orderPaidService.findAll(request);
        map.put("orderPage", foodPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "orderId",required = false) String id,
                              Map<String,Object> map)
    {
        if(!StringUtils.isEmpty(id))
        {
            List<OrderDetailPaid> orderDetailPaids=orderDetailPaidMapper.getByOrderId(id);
            map.put("detailInfo",orderDetailPaids);
        }
        return new ModelAndView("order/index",map);
    }
}
