/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.jms;

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

/**
 * Title: Consumer Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@Component
public class Consumer{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// 需要给topic定义独立的JmsListenerContainer
	@Bean
	public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
		DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
		bean.setPubSubDomain(true);
		bean.setConnectionFactory(activeMQConnectionFactory);
		return bean;
	}

	@JmsListener(destination = "sample.queue")
	public void receiveQueue(String text) {
		logger.debug(text);
	}

	@JmsListener(destination = "sample.topic", containerFactory="jmsListenerContainerTopic")
	public void receiveTopic(String text) {
		logger.debug(text);
	}
}
