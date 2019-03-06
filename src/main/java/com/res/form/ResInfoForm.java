package com.res.form;

import lombok.Data;

@Data
public class ResInfoForm {
    private Integer todayNum;
    private Integer todayMoney;
    private Integer yesterdayMoney;
    private Integer weekMoney;
    private Integer foodNum;
    private Integer rawNum;
    private Integer rawLackNum;
    private Integer yesterdayOrder;
    private Integer weekOrder;
    private Integer monthOrder;
    private String bestFood;
    private String badFood;
}
