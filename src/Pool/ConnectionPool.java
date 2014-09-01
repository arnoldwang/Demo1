package Pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接池接口
 * 
 * @author Arnold
 * 
 */
public interface ConnectionPool {

	// 获得连接
	public Connection getConnection();

	// 获得当前连接
	public Connection getCurrentConnection();

	// 回收连接
	public void releaseConn(Connection conn) throws SQLException;

	// 销毁清空
	public void destroy();

	// 连接池是活动状态
	public boolean isActive();

	// 定时器，检查连接池
	public void checkPool();
}
