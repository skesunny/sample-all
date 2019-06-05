package com.honcz.sample.sampleapi.dto.trade.entity.userinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author honc.z
 * @date 2019/5/27
 */
@Data
public class SellerInfo {
    @ApiModelProperty(value = "卖家id")
    private Long sellId;

    @ApiModelProperty(value = "卖家手机号")
    private String sellPhone;

    @ApiModelProperty(value = "卖家昵称")
    private String sellNick;

    @ApiModelProperty(value = "卖家备注")
    private String sellMemo;
}
