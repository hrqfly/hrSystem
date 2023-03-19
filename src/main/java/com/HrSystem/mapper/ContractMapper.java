package com.HrSystem.mapper;

import com.HrSystem.entity.Contract;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hrq
 * @date 2023/03/19
 * 合同表的Mapper
 */
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {
}
