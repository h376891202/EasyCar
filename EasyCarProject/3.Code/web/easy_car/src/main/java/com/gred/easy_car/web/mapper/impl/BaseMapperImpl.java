/**
 * @Title: BaseMapperImpl.java   
 * @Package com.gred.easy_car.web.mapper   
 * @Description: 
 * @author WangJianbin     
 * @date 2015年4月25日 下午3:33:15   
 * @version V2.0     
 */
package com.gred.easy_car.web.mapper.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.gred.easy_car.common.enums.LogLevel;
import com.gred.easy_car.common.utils.Log4jUtils;
import com.gred.easy_car.web.entity.Page;
import com.gred.easy_car.web.entity.PagingResult;
import com.gred.easy_car.web.mapper.BaseMapper;

/**
 * @ClassName: BaseMapperImpl   
 * @Description: (此类为基础dao接口实现类)   
 * @author WangJianbin  
 * @date 2015年4月25日 下午3:33:15   
 *
 */

@Repository
public abstract class BaseMapperImpl <T, PK extends Serializable> extends SqlSessionDaoSupport implements
		BaseMapper<T, PK> {

	private static final	Log4jUtils log = new Log4jUtils(BaseMapperImpl.class);
	
	private static final String MAPPER_LOCATION ="com.gred.easy_car.web.mapper" ;
	
	private Class<T> clazz;
	
	/**sqlmap.xml定义文件中对应的sqlid**/  
    public static final String SQLID_INSERT = "insertSelective";  
    public static final String SQLID_INSERT_BATCH = "insertBatch";  
    public static final String SQLID_UPDATE = "updateByPrimaryKeySelective";  
    public static final String SQLID_UPDATE_PARAM = "updateParam";  
    public static final String SQLID_UPDATE_BATCH = "updateBatch";  
    public static final String SQLID_DELETE = "deleteByPrimaryKey";  
    public static final String SQLID_DELETE_PARAM = "deleteParam";  
    public static final String SQLID_DELETE_BATCH = "deleteBatch";  
    public static final String SQLID_TRUNCATE = "truncate";  
    public static final String SQLID_SELECT = "selectAll";  
    public static final String SQLID_SELECT_PK = "selectByPrimaryKey";  
    public static final String SQLID_SELECT_PARAM = "selectParam";  
    public static final String SQLID_SELECT_FK = "selectFk";  
    public static final String SQLID_COUNT = "count";  
    public static final String SQLID_COUNT_PARAM = "countParam";  
    
    
    @Resource(name = "sqlSessionTemplate")  
    public void setSuperSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {  
        super.setSqlSessionTemplate(sqlSessionTemplate);  
    }  
    
  
    @SuppressWarnings("unchecked")
	protected BaseMapperImpl(){
    	 //getClass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。  
        this.clazz=(Class<T>)getSuperClassGenricType(getClass(), 0);
        
        this.namespace = getDefaultNameSpace();
    }
   
	/**
     * 获取 SqlMapping 的命名空间
     */
    protected String namespace  ;
    


	/**
	 * @Title: getDefaultNameSpace   
	 * @Description: 获取mapper默认命名空间（mapper所属包+实体名+Mapper后缀）   
	 * @param @return    
	 * @return String    返回类型   
	 * @throws   
	 */
	private String getDefaultNameSpace() {
		String entityName = clazz.getSimpleName();
		
		return MAPPER_LOCATION+"."+entityName+"Mapper";
	}

    /** 
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型. 如无法找到, 返回Object.class. 
     *  
     *@param clazz 
     *            clazz The class to introspect 
     * @param index 
     *            the Index of the generic ddeclaration,start from 0. 
     * @return the index generic declaration, or Object.class if cannot be 
     *         determined 
     */  
    @SuppressWarnings({ "unchecked", "rawtypes" })  
    public static Class<Object> getSuperClassGenricType(final Class clazz, final int index) {  
          
        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。  
        Type genType = clazz.getGenericSuperclass();  
  
        if (!(genType instanceof ParameterizedType)) {  
           return Object.class;  
        }  
        //返回表示此类型实际类型参数的 Type 对象的数组。  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
  
        if (index >= params.length || index < 0) {  
                     return Object.class;  
        }  
        if (!(params[index] instanceof Class)) {  
              return Object.class;  
        }  
  
        return (Class) params[index];  
    }  
	
	
	
	
	/* 
	 * <p>Title: insert</p>   
	 * <p>Description: </p>   
	 * @param entity
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#insert(java.lang.Object)   
	 */   
	@Override
	public int insertSelective(T entity) {
		
		
		int rows = 0;  
		
        rows = getSqlSession().insert(namespace + "." + SQLID_INSERT, entity);  
        
        return rows;  
	}







	/* (非 Javadoc)   
	 * <p>Title: update</p>   
	 * <p>Description: </p>   
	 * @param entity
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#update(java.lang.Object)   
	 */   
	@Override
	public int updateByPrimaryKeySelective(T entity) {
		
		int rows = 0;  
     
        rows = getSqlSession().update(namespace + "." + SQLID_UPDATE, entity);  
      
        return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: updateParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#updateParam(java.util.Map)   
	 */   
	@Override
	public int updateParam(Map param) {
		
		int rows = 0;  
       
        rows = getSqlSession().update(namespace + "." + SQLID_UPDATE_PARAM,   param);  
       
        return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: delete</p>   
	 * <p>Description: </p>   
	 * @param primaryKey
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#delete(java.io.Serializable)   
	 */   
	@Override
	public int deleteByPrimaryKey(PK primaryKey) {
		
		int rows = 0;  
	        
	    rows = getSqlSession().delete(namespace + "." + SQLID_DELETE,  primaryKey);  
	        
	    return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: deleteParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#deleteParam(java.util.Map)   
	 */   
	@Override
	public int deleteParam(Map param) {
		
		int rows = 0;  
        
        rows = getSqlSession().delete(namespace + "." + SQLID_DELETE_PARAM,param);  
       
        return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: truncate</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#truncate()   
	 */   
	@Override
	public int truncate() {
		
		int rows = 0;  
        
        rows = getSqlSession().delete(namespace + "." + SQLID_TRUNCATE);  
       
        return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: count</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#count()   
	 */   
	@Override
	public int count() {
		
		int result = 0;  
        
        result = getSqlSession().selectOne(namespace + "." + SQLID_COUNT);  
      
        return result;  
	}




	/* (非 Javadoc)   
	 * <p>Title: count</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#count(java.lang.Object)   
	 */   
	@Override
	public int count(Object param) {
		
		int result = 0;  
       
       result = getSqlSession().selectOne(namespace + "." + SQLID_COUNT_PARAM,param);  
       
        return result;  
	}




	/* (非 Javadoc)   
	 * <p>Title: get</p>   
	 * <p>Description: </p>   
	 * @param primaryKey
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#get(java.io.Serializable)   
	 */   
	@Override
	public T selectByPrimaryKey(PK primaryKey) {
		
	            return getSqlSession().selectOne(namespace + "." + SQLID_SELECT_PK,primaryKey);  
	        
	}




	/* (非 Javadoc)   
	 * <p>Title: select</p>   
	 * <p>Description: </p>   
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#select()   
	 */   
	@Override
	public List<T> selectAll() {
		
            return getSqlSession().selectList(namespace + "." + SQLID_SELECT);  
      
	}




	/* (非 Javadoc)   
	 * <p>Title: selectParam</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#selectParam(java.util.Map)   
	 */   
	@Override
	public List<T> selectParam(Map param) {
		
	
            return getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM,param);  
        
	}




	/* (非 Javadoc)   
	 * <p>Title: selectPagination</p>   
	 * <p>Description: </p>   
	 * @param param
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#selectPagination(com.gred.easy_car.web.entity.PageEntity)   
	 */   
	@Override
	public PagingResult<T> selectPagination(Page pageEntity) {
		
            int page = pageEntity.getPage() == null || "".equals(pageEntity.getPage()) ? 1 : pageEntity.getPage(); //默认为第一页  
            int size = pageEntity.getSize() == null || "".equals(pageEntity.getSize()) ? 15 : pageEntity.getSize();; //默认每页15个  
              
            RowBounds rowBounds = new RowBounds((page-1)*size, size);  
              
            Map param = pageEntity.getParams();  
            if (param != null) {  
                param.put("orderColumn", pageEntity.getOrderColumn());  
                param.put("orderTurn", pageEntity.getOrderTurn());  
            }else {  
                param = new HashMap();  
                param.put("orderColumn", pageEntity.getOrderColumn());  
                param.put("orderTurn", pageEntity.getOrderTurn());  
            }  
              
            List<T> resultList = getSqlSession().selectList(namespace + "." + SQLID_SELECT_PARAM,param,rowBounds);  
            int totalSize = count(pageEntity.getParams());  
              
            PagingResult<T> pagingResult = new PagingResult<T>();  
            pagingResult.setCurrentPage(page);  
            pagingResult.setTotalSize(totalSize);  
            pagingResult.setResultList(resultList);  
            return pagingResult;  
              
        
	}




	/* (非 Javadoc)   
	 * <p>Title: insertBatch</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#insertBatch(java.util.List)   
	 */   
	@Override
	public int insertBatch(List<T> list) {
		
	
	            return getSqlSession().insert(namespace + "." + SQLID_INSERT_BATCH,list);  
	    
	}




	/* (非 Javadoc)   
	 * <p>Title: updateBatch</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#updateBatch(java.util.List)   
	 */   
	@Override
	public int updateBatch(List<T> list) {
		
		int rows = 0;  
       
            for (T t : list) {  
                rows = rows + getSqlSession().update(namespace + "." + SQLID_UPDATE, t);  
            }  
       
        return rows;  
	}




	/* (非 Javadoc)   
	 * <p>Title: deleteBatch</p>   
	 * <p>Description: </p>   
	 * @param list
	 * @return   
	 * @see com.gred.easy_car.web.mapper.BaseMapper#deleteBatch(java.util.List)   
	 */   
	@Override
	public int deleteBatch(List<PK> list) {
		
            return getSqlSession().delete(namespace + "." + SQLID_DELETE_BATCH,list);  
       
	}
	
	/** 
     * 日志打印 
     * @param sqlId 
     * @param param 
     */  
    public void printLog(String sqlId,Object param){  
        Configuration configuration = getSqlSession().getConfiguration();  
        //sqlId为配置文件中的sqlid  
        MappedStatement mappedStatement = configuration.getMappedStatement(sqlId);  
        //param为传入到sql语句中的参数  
        BoundSql boundSql = mappedStatement.getBoundSql(param);  
        //得到sql语句  
        String sql = boundSql.getSql().trim();  
        log.log(LogLevel.INFO, sql);
    }  
    
}
