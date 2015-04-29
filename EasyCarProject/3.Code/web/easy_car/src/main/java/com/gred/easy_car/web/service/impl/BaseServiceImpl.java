/**
 * @Title: BaseServiceImpl.java   
 * @Package com.gred.easy_car.web.service.impl   
 * @Description: (此类为Service基础接口的实现类)   
 * @author WangJianbin     
 * @date 2015年4月25日 下午2:15:29   
 * @version V2.0     
 */
package com.gred.easy_car.web.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gred.easy_car.web.entity.PageEntity;
import com.gred.easy_car.web.entity.PagingResult;
import com.gred.easy_car.web.mapper.BaseMapper;
import com.gred.easy_car.web.service.BaseService;

/**
 * @ClassName: BaseServiceImpl   
 * @Description: (此类为Service基础接口的实现类)   
 * @author WangJianbin  
 * @param <M>
 * @date 2015年4月25日 下午2:15:29   
 *
 */

public class BaseServiceImpl<M,PK extends Serializable> implements BaseService<M,PK > {

	
	private BaseMapper<M,PK > baseMapper;
	
	

	/**
	 * @param baseMapper the baseMapper to set
	 */
	public void setBaseMapper(BaseMapper<M, PK> baseMapper) {
		this.baseMapper = baseMapper;
	}

	/* 
	 * <p>Title: save</p>   
	 * <p>Description: </p>   
	 * @param entity
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#save(java.lang.Object)   
	 */   
	@Override
	public int save(M entity) {
		
		return baseMapper.insertSelective(entity);
	}

	/* 
	 * <p>Title: modify</p>   
	 * <p>Description: </p>   
	 * @param entity
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#modify(java.lang.Object)   
	 */   
	@Override
	public int modify(M entity) {
		
		return baseMapper.updateByPrimaryKeySelective(entity);
	}

	/* 
	 * <p>Title: modifyParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#modifyParam(java.util.Map)   
	 */   
	@Override
	public int modifyParam(Map param) {
		
		return baseMapper.updateParam(param);
	}

	/* 
	 * <p>Title: remove</p>   
	 * <p>Description: </p>   
	 * @param primaryKey
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#remove(java.io.Serializable)   
	 */   
	@Override
	public int remove(PK primaryKey) {
		
		return baseMapper.deleteByPrimaryKey(primaryKey);
	}

	/* 
	 * <p>Title: removeParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#removeParam(java.util.Map)   
	 */   
	@Override
	public int removeParam(Map param) {
		
		return baseMapper.deleteParam(param);
	}

	/* 
	 * <p>Title: truncate</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#truncate()   
	 */   
	@Override
	public int truncate() {
		
		return baseMapper.truncate();
	}

	/* 
	 * <p>Title: count</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#count()   
	 */   
	@Override
	public int count() {
	
		return baseMapper.count();
	}

	/* 
	 * <p>Title: count</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#count(java.lang.Object)   
	 */   
	@Override
	public int count(Object param) {
		return baseMapper.count(param);
	}

	/* 
	 * <p>Title: get</p>   
	 * <p>Description: </p>   
	 * @param primaryKey
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#get(java.io.Serializable)   
	 */   
	@Override
	public M get(PK primaryKey) {
		return baseMapper.selectByPrimaryKey(primaryKey);
	}

	/* 
	 * <p>Title: listAll</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#listAll()   
	 */   
	@Override
	public List<M> listAll() {
		return baseMapper.select();
	}

	/* 
	 * <p>Title: listParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#listParam(java.util.Map)   
	 */   
	@Override
	public List<M> listParam(Map param) {
		return baseMapper.selectParam(param);
	}

	/* 
	 * <p>Title: listPagination</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#listPagination(com.gred.easy_car.web.entity.PageEntity)   
	 */   
	@Override
	public PagingResult<M> listPagination(PageEntity param) {
		return baseMapper.selectPagination(param);
	}

	/* 
	 * <p>Title: batchSave</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#batchSave(java.util.List)   
	 */   
	@Override
	public int batchSave(List<M> list) {
		return baseMapper.insertBatch(list);
	}

	/* 
	 * <p>Title: batchUpdate</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#batchUpdate(java.util.List)   
	 */   
	@Override
	public int batchUpdate(List<M> list) {
		return baseMapper.updateBatch(list);
	}

	/* 
	 * <p>Title: batchDelete</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.service.impl.BaseService#batchDelete(java.util.List)   
	 */   
	@Override
	public int batchDelete(List<PK> list) {
		return baseMapper.deleteBatch(list);
	}


}
