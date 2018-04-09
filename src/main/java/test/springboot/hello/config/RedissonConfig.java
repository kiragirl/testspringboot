/**
* @author:liyiming
* @date:2018年3月23日
* Description:
**/
package test.springboot.hello.config;

import io.netty.channel.nio.NioEventLoopGroup;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 	Title: RedissonConfig
 *	Description:
 *	Company:pusense
 * 	@author ：lyiming
 * 	@date ：2018年3月23日
 **/
@ConfigurationProperties(prefix = "spring.redisson")
@Configuration
public class RedissonConfig{

    private String address;
    private int connectionMinimumIdleSize = 10;
    private int idleConnectionTimeout=10000;
    private int pingTimeout=1000;
    private int connectTimeout=10000;
    private int timeout=3000;
    private int retryAttempts=3;
    private int retryInterval=1500;
    private int reconnectionTimeout=3000;
    private int failedAttempts=3;
    private String password = null;
    private int subscriptionsPerConnection=5;
    private String clientName=null;
    private int subscriptionConnectionMinimumIdleSize = 1;
    private int subscriptionConnectionPoolSize = 50;
    private int connectionPoolSize = 64;
    private int database = 0;
    private boolean dnsMonitoring = false;
    private int dnsMonitoringInterval = 5000;

    private int thread = 4; //当前处理核数量 * 2

    //private String codec="org.redisson.codec.JsonJacksonCodec";

    @Bean(destroyMethod = "shutdown")
	RedissonClient redisson() throws Exception {
    	Config config = new Config();
        config.useSingleServer().setAddress(address)
                .setConnectionMinimumIdleSize(connectionMinimumIdleSize)
                .setConnectionPoolSize(connectionPoolSize)
                .setDatabase(database)
                .setDnsMonitoring(dnsMonitoring)
                .setDnsMonitoringInterval(dnsMonitoringInterval)
                .setSubscriptionConnectionMinimumIdleSize(subscriptionConnectionMinimumIdleSize)
                .setSubscriptionConnectionPoolSize(subscriptionConnectionPoolSize)
                .setSubscriptionsPerConnection(subscriptionsPerConnection)
                .setClientName(clientName)
                //.setFailedAttempts(failedAttempts)
                .setRetryAttempts(retryAttempts)
                .setRetryInterval(retryInterval)
                //.setFailedSlaveReconnectionInterval
                //.setReconnectionTimeout(reconnectionTimeout)
                .setTimeout(timeout)
                .setConnectTimeout(connectTimeout)
                .setIdleConnectionTimeout(idleConnectionTimeout)
                .setPingTimeout(pingTimeout)
                .setPassword(password);
       // Codec codec=(Codec)ClassUtils.forName(getCodec(),ClassUtils.getDefaultClassLoader()).newInstance();
        config.setCodec(new JsonJacksonCodec());
        config.setThreads(thread);
        config.setEventLoopGroup(new NioEventLoopGroup());
        //config.setUseLinuxNativeEpoll(false);
        return Redisson.create(config);
    }

	
	public String getAddress() {
		return address;
	}

	
	public int getConnectionMinimumIdleSize() {
		return connectionMinimumIdleSize;
	}

	
	public int getIdleConnectionTimeout() {
		return idleConnectionTimeout;
	}

	
	public int getPingTimeout() {
		return pingTimeout;
	}

	
	public int getConnectTimeout() {
		return connectTimeout;
	}

	
	public int getTimeout() {
		return timeout;
	}

	
	public int getRetryAttempts() {
		return retryAttempts;
	}

	
	public int getRetryInterval() {
		return retryInterval;
	}

	
	public int getReconnectionTimeout() {
		return reconnectionTimeout;
	}

	
	public int getFailedAttempts() {
		return failedAttempts;
	}

	
	public String getPassword() {
		return password;
	}

	
	public int getSubscriptionsPerConnection() {
		return subscriptionsPerConnection;
	}

	
	public String getClientName() {
		return clientName;
	}

	
	public int getSubscriptionConnectionMinimumIdleSize() {
		return subscriptionConnectionMinimumIdleSize;
	}

	
	public int getSubscriptionConnectionPoolSize() {
		return subscriptionConnectionPoolSize;
	}

	
	public int getConnectionPoolSize() {
		return connectionPoolSize;
	}

	
	public int getDatabase() {
		return database;
	}

	
	public boolean isDnsMonitoring() {
		return dnsMonitoring;
	}

	
	public int getDnsMonitoringInterval() {
		return dnsMonitoringInterval;
	}

	
	public int getThread() {
		return thread;
	}

	
	public void setAddress(String address) {
		this.address = address;
	}

	
	public void setConnectionMinimumIdleSize(int connectionMinimumIdleSize) {
		this.connectionMinimumIdleSize = connectionMinimumIdleSize;
	}

	
	public void setIdleConnectionTimeout(int idleConnectionTimeout) {
		this.idleConnectionTimeout = idleConnectionTimeout;
	}

	
	public void setPingTimeout(int pingTimeout) {
		this.pingTimeout = pingTimeout;
	}

	
	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	
	public void setRetryAttempts(int retryAttempts) {
		this.retryAttempts = retryAttempts;
	}

	
	public void setRetryInterval(int retryInterval) {
		this.retryInterval = retryInterval;
	}

	
	public void setReconnectionTimeout(int reconnectionTimeout) {
		this.reconnectionTimeout = reconnectionTimeout;
	}

	
	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public void setSubscriptionsPerConnection(int subscriptionsPerConnection) {
		this.subscriptionsPerConnection = subscriptionsPerConnection;
	}

	
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	
	public void setSubscriptionConnectionMinimumIdleSize(int subscriptionConnectionMinimumIdleSize) {
		this.subscriptionConnectionMinimumIdleSize = subscriptionConnectionMinimumIdleSize;
	}

	
	public void setSubscriptionConnectionPoolSize(int subscriptionConnectionPoolSize) {
		this.subscriptionConnectionPoolSize = subscriptionConnectionPoolSize;
	}

	
	public void setConnectionPoolSize(int connectionPoolSize) {
		this.connectionPoolSize = connectionPoolSize;
	}

	
	public void setDatabase(int database) {
		this.database = database;
	}

	
	public void setDnsMonitoring(boolean dnsMonitoring) {
		this.dnsMonitoring = dnsMonitoring;
	}

	
	public void setDnsMonitoringInterval(int dnsMonitoringInterval) {
		this.dnsMonitoringInterval = dnsMonitoringInterval;
	}

	
	public void setThread(int thread) {
		this.thread = thread;
	}

}
