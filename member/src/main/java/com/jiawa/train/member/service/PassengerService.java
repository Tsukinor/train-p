package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.train.common.context.LoginMemberContext;
import com.jiawa.train.common.resp.PageResp;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.Passenger;
import com.jiawa.train.member.domain.PassengerExample;
import com.jiawa.train.member.mapper.PassengerMapper;
import com.jiawa.train.member.req.PassengerQueryReq;
import com.jiawa.train.member.req.PassengerSaveReq;
import com.jiawa.train.member.resp.PassengerQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    private static final Logger Log = LoggerFactory.getLogger(PassengerService.class);

    @Resource
    private PassengerMapper passengerMapper;

    public void save(PassengerSaveReq req){

        DateTime now = new DateTime();
        Passenger passenger = BeanUtil.copyProperties(req,Passenger.class);
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);

    }
    /**
     * 乘客信息查询
     * @param req
     * @return PassengerQueryResp乘客查询请求结果封装类。注意：开发规范是Controller不使用持久层实体类，所以不能直接返回Passenger对象
     */
   public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req){
       PassengerExample example = new PassengerExample();

       PassengerExample.Criteria criteria = example.createCriteria();

       if (ObjectUtil.isNull(req.getMemberId())){
          criteria.andMemberIdEqualTo(req.getMemberId());
       }

       Log.info("查询页码：{}", req.getStartPage());
       Log.info("每页条数：{}", req.getPageSize());
       PageHelper.startPage(req.getStartPage(), req.getPageSize());
       List<Passenger> passengerlist = passengerMapper.selectByExample(example);

       PageInfo<Passenger> pageInfo = new PageInfo<>(passengerlist);
       Log.info("总行数：{}", pageInfo.getTotal());
       Log.info("总页数：{}", pageInfo.getPages());

       List<PassengerQueryResp> list = BeanUtil.copyToList(passengerlist, PassengerQueryResp.class);
        PageResp<PassengerQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

       return pageResp;

    }


}
