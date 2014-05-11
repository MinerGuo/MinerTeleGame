package com.miner525xuan.telegame.dao;


/**
 * 返回对象的主键
 * @author Miner
 *
 * @param <T>
 * @param <R>
 */
public interface BasePrimaryFetch<R> {

	public R getPrimaryKey();
}
