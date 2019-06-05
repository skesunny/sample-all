package com.honcz.sample.sampleapi.dto.trade.entity.addressinfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author honc.z
 * @date 2019/5/21
 */
@Data
public class AddressInfo {
    @ApiModelProperty(value = "收件人姓名")
    private String receiveName;

    @ApiModelProperty(value = "收件人电话")
    private String receiveTel;

    @ApiModelProperty(value = "收件人省份")
    private String province;

    @ApiModelProperty(value = "收件人城市")
    private String city;

    @ApiModelProperty(value = "收件人区域")
    private String district;

    @ApiModelProperty(value = "收件人详细地址")
    private String address;

    @ApiModelProperty(value = "收件人邮编")
    private String zipCode;

}
