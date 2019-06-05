package com.honcz.sample.sampleapi.dto.trade.entity.userinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author honc.z
 * @date 2019/5/27
 */
@Data
public class BuyerInfo {
    @ApiModelProperty(value = "买家id")
    private Long buyerId;

    @ApiModelProperty(value = "买家手机号")
    private String buyerPhone;

    @ApiModelProperty(value = "买家昵称")
    private String buyerNick;

    @ApiModelProperty(value = "买家备注")
    private String buyerMemo;
}
