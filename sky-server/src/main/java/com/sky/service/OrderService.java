package com.sky.service;

import com.sky.dto.*;
import com.sky.entity.Orders;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OrderService {

    /**
     * 用户下单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);
    /**
     * 历史订单分页查询
     * @param page
     * @param pageSize
     * @param status
     * @return
     */
    PageResult page(int page, int pageSize, Integer status);
    /**
     * 根据id查询订单详细数据
     * @param id
     * @return
     */
    OrderVO details(Long id);
    /**
     * 取消订单
     * @param id
     * @return
     */
    void cancelOrder(Long id);

    void repetitionOrder(Long id);

    /**
     * 订单搜索
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 统计各个订单状态
     */
    OrderStatisticsVO orderStatistice();

    /**
     * 接单
     * @param ordersConfirmDTO
     */
    void updateOrder(OrdersConfirmDTO ordersConfirmDTO);

    /**\
     *派送订单
     * @param id
     */
    void deliveryOrder(Long id);

    /**
     * 完成订单
     * @param id
     */
    void completeOrder(Long id);

    void rejection(OrdersRejectionDTO ordersRejectionDTO) throws Exception;
    void cancel(OrdersCancelDTO OrdersCancelDTO) throws Exception;

    void reminder(Long id);
}
