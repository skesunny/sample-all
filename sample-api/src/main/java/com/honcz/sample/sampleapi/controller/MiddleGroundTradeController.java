package com.honcz.sample.sampleapi.controller;

import com.honcz.sample.sampleapi.dto.trade.entity.orderinfo.OrderInfo;
import com.honcz.sample.sampleapi.dto.trade.req.TradeCreateReqDTO;
import com.honcz.sample.sampleapi.dto.trade.req.TradeReqDTO;
import com.honcz.sample.sampleapi.dto.trade.resp.TradeRespDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author honc.z
 * @date 2019/5/14
 * <p>
 * 中台交易api
 */
@RestController
public class MiddleGroundTradeController {


    @ApiOperation(value = "创建交易单", notes = "根据下游的交易创建交易单")
    @PostMapping("/trade.create")
    public TradeRespDTO createTrade(@RequestBody TradeCreateReqDTO tradeReqDTO) {
        return null;
    }

    @ApiOperation(value = "获取交易列表", notes = "获取交易列表/分页")
    @GetMapping("/trade.list.page")
    public TradeRespDTO[] listTrades(@RequestBody TradeReqDTO tradeReqDTO) {
        return null;
    }

    @ApiOperation(value = "获取单个交易", notes = "获取单个交易")
    @GetMapping("/trade.get")
    public TradeReqDTO getSingleTrade(@RequestParam("tradeId") String tradeId) {
        return null;
    }


    @ApiOperation(value = "修改子订单金额", notes = "修改子订单金额")
    @PutMapping("/trade.amount.update")
    public void updateAmount(@RequestBody OrderInfo orderInfo) {

    }

    @ApiOperation(value = "修改子订单", notes = "修改子订单")
    @PutMapping("/trade.order.update")
    public void updateOrder(@RequestBody OrderInfo orderInfo) {

    }

    @ApiOperation(value = "更新交易单", notes = "更新交易单")
    @PutMapping("/trade.update")
    public void tradeUpdate(@RequestBody TradeReqDTO tradeReqDTO) {

    }

    @ApiOperation(value = "更新/新增交易备注", notes = "更新/新增交易备注")
    @PutMapping("/trade.memo.update")
    public void tradeUpdateMemo(@RequestBody TradeReqDTO tradeReqDTO) {

    }

    @ApiOperation(value = "卖家关闭交易", notes = "卖家关闭交易")
    @PutMapping("/trade.close")
    public void tradeClose(@RequestBody TradeReqDTO tradeReqDTO){

    }

    @ApiOperation(value = "更新订单SKU", notes = "更新订单SKU")
    @PutMapping("/trade.ordersku.update")
    public void orderSkuUpdate(@RequestBody OrderInfo orderInfo) {

    }

    @ApiOperation(value = "更新收货地址", notes = "更新收货地址")
    @PutMapping("/trade.deliveryaddress.update")
    public void deliveryAddressUpdate(@RequestBody TradeReqDTO tradeReqDTO) {

    }

    @ApiOperation(value = " 查询卖家已卖出的交易数据（根据创建时间）", notes = " 查询卖家已卖出的交易数据（根据创建时间）")
    @GetMapping("/trade.saleinfo.get")
    public List<TradeReqDTO> getSaleInfo(@RequestParam("pageNo")Integer pageNo, @RequestParam("pageSize")Integer pageSize) {
        return null;
    }
}
