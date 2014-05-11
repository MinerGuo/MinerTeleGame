package com.miner525xuan.telegame.dao.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.miner525xuan.telegame.dao.BaseDao;
import com.miner525xuan.telegame.dao.BasePrimaryFetch;
import com.miner525xuan.telegame.utils.ReflectUtil;

@Repository
public class BaseDaoImpl<T extends BasePrimaryFetch<PK>, PK> extends SqlSessionDaoSupport implements BaseDao<T, PK> {

	protected String insert;
	protected String update;
	protected String deleteByPK;
	protected String selectList;
	protected String selectCount;
	protected String selectOneByPK;

	private Class<T> entityClass;
	protected String entityClassName;

	/**
	 * 这个表示在对象的生命周期开始时，也就是在初始化之前，执行一次
	 */
	@PostConstruct
	public void init() {
		entityClass = ReflectUtil.getSuperClassGenericType(getClass());
		entityClassName = entityClass.getSimpleName();
		insert = String.format("%0$s.add", entityClassName);
		update = String.format("%0$s.updateByModel", entityClassName);
		deleteByPK = String.format("%0$s.deleteByPK", entityClassName);
		selectList = String.format("%0$s.queryByModel", entityClassName);
		selectOneByPK = String.format("%0$s.queryOneByPK", entityClassName);
		selectCount = String.format("%0$s.count", entityClassName);
	}

	public int insert(T t) {
		return this.getSqlSession().insert(insert, t);
	}

	public int update(T t) {
		return this.getSqlSession().update(update, t);
	}

	public int deleteByPK(PK pk) {
		return this.getSqlSession().delete(deleteByPK, pk);
	}

	public int selectCount(T t) {
		return this.getSqlSession().selectOne(selectCount, t);
	}

	public List<T> selectList(T t) {
		return this.getSqlSession().selectList(selectList, t);
	}

	public T selectOneByPK(PK pk) {
		return this.getSqlSession().selectOne(selectOneByPK, pk);
	}

	/**
	 * 这点非常重要
	 */
	@Override
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
