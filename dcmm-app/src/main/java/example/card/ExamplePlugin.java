package example.card;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

//ExamplePlugin.java
@Intercepts({ @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class}) })
public class ExamplePlugin implements Interceptor {
	private Properties properties = new Properties();

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// implement pre-processing if needed
		Object returnObject = invocation.proceed();
		// implement post-processing if needed
		return returnObject;
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
}