package com.model.dtogroups;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.BLOB)
public class AllTypeHandler extends BaseTypeHandler<Blob> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Blob parameter, JdbcType jdbcType)
			throws SQLException {
		// TODO Auto-generated method stub
		ps.setBlob(i, parameter);
	}

	@Override
	public Blob getNullableResult(ResultSet rs, String columnName) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getBlob(columnName);
	}

	@Override
	public Blob getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return rs.getBlob(columnIndex);
	}

	@Override
	public Blob getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return cs.getBlob(columnIndex);
	}

}
