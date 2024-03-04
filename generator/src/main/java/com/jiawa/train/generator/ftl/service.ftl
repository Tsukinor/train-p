package com.jiawa.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.train.common.context.LoginMemberContext;
import com.jiawa.train.common.resp.PageResp;
import com.jiawa.train.common.util.SnowUtil;
import com.jiawa.train.member.domain.${Domain};
import com.jiawa.train.member.domain.${Domain}Example;
import com.jiawa.train.member.mapper.${Domain}Mapper;
import com.jiawa.train.member.req.${Domain}QueryReq;
import com.jiawa.train.member.req.${Domain}SaveReq;
import com.jiawa.train.member.resp.${Domain}QueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ${Domain}Service {
    private static final Logger Log = LoggerFactory.getLogger(${Domain}Service.class);

    @Resource
    private ${Domain}Mapper ${domain}Mapper;

    public void save(${Domain}SaveReq req){

        DateTime now = new DateTime();
        ${Domain} ${domain} = BeanUtil.copyProperties(req,${Domain}.class);
        //判断是修改还是新增
        if (ObjectUtil.isNull(${domain}.getId())){
            ${domain}.setId(SnowUtil.getSnowflakeNextId());
            ${domain}.setMemberId(LoginMemberContext.getId());
            ${domain}.setCreateTime(now);
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.insert(${domain});
        }else {
            ${domain}.setUpdateTime(now);
            ${domain}Mapper.updateByPrimaryKey(${domain});
        }


    }
    /**
     * 乘客信息查询
     * @param req
     * @return ${Domain}QueryResp乘客查询请求结果封装类。注意：开发规范是Controller不使用持久层实体类，所以不能直接返回${Domain}对象
     */
   public PageResp<${Domain}QueryResp> queryList(${Domain}QueryReq req){
       ${Domain}Example example = new ${Domain}Example();

       // 查询结果按照id升序排列
       example.setOrderByClause("id asc");

       ${Domain}Example.Criteria criteria = example.createCriteria();

       if (ObjectUtil.isNull(req.getMemberId())){
          criteria.andMemberIdEqualTo(req.getMemberId());
       }

       Log.info("查询页码：{}", req.getPage());
       Log.info("每页条数：{}", req.getSize());
       PageHelper.startPage(req.getPage(), req.getSize());
       List<${Domain}> ${domain}list = ${domain}Mapper.selectByExample(example);

       PageInfo<${Domain}> pageInfo = new PageInfo<>(${domain}list);
       Log.info("总行数：{}", pageInfo.getTotal());
       Log.info("总页数：{}", pageInfo.getPages());

       List<${Domain}QueryResp> list = BeanUtil.copyToList(${domain}list, ${Domain}QueryResp.class);
        PageResp<${Domain}QueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);

       return pageResp;

    }

    public void delete(Long id){
       ${domain}Mapper.deleteByPrimaryKey(id);
    }

}
