package com.miner525xuan.telegame.dao;

import java.util.List;

public interface BaseDao<T extends BasePrimaryFetch<PK>, PK> {

	public int insert(T t);

	public int update(T t);

	/**
	 * 使用主键删除一条记录
	 * 
	 * @param pk
	 * @return
	 */
	public int deleteByPK(PK pk);

	public int selectCount(T t);

	public List<T> selectList(T t);

	/**
	 * 使用主键查询一条记录
	 * 
	 * @param pk
	 * @return
	 */
	public T selectOneByPK(PK pk);
}
