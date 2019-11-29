package com.springboot.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("simple_table")
public class SimpleTableEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
	private SimpleTablePrimaryKey primaryKey;

	@Column("created_time")
	private Date createTime = new Date();

	@Column("simple_type")
	private SimpleTypeEntity simpleType;

	public SimpleTablePrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(SimpleTablePrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SimpleTypeEntity getSimpleType() {
		return simpleType;
	}

	public void setSimpleType(SimpleTypeEntity simpleType) {
		this.simpleType = simpleType;
	}

}
