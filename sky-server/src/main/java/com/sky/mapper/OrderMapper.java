package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import com.sky.vo.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    /**
     * 订单表中插入数据
     * @param orders
     */
    void insert(Orders orders);
    /**
     * 根据订单号查询订单
     * @param orderNumber
     */
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    /**
     * 修改订单信息
     * @param orders
     */
    void update(Orders orders);

    /**
     * 获取orderid的mapper层方法，写在OrderMapper.java文件下
     * @param orderNumber
     * @return
     */
    @Select("select * from orders where number=#{orderNumber}")
    Long getorderId (String orderNumber);

    /**

     * 用于替换微信支付更新数据库状态的问题

     * @param orderStatus

     * @param orderPaidStatus

     */

    @Update("update orders set status = #{orderStatus},pay_status = #{orderPaidStatus} ,checkout_time = #{check_out_time} where id = #{id}")
    void updateStatus(Integer orderStatus, Integer orderPaidStatus, LocalDateTime check_out_time, Long id);

    @Select("select * from orders where number = #{orderNumber} and user_id= #{userId}")
    Orders getByNumberAndUserId(String orderNumber, Long userId);

    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);

    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);
    /**
     * 统计待接单数量
     * @return
     */
    @Select("select count(*) from orders where status = #{toBeConfirmed}")
    Integer countStatus(Integer status);

    @Select("select * from orders where status = #{status} and order_time < #{orderTime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status,LocalDateTime orderTime);

    /**
     * 根据动态条件获取营业额
     * @param map
     * @return
     */
    BigDecimal sumByMap(Map map);
}
