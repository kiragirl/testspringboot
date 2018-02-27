/**
 * @author:liyiming
 * @date:2018年2月27日
 * Description:
 **/
package test.springboot.hello.jms;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

/**
 * Title: SendMessage Description: Company:pusense
 * 
 * @author ：lyiming
 * @date ：2018年2月27日
 **/
@Component
public class SendMessage{

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Bean
	public Queue getQueue() {
		return new ActiveMQQueue("sample.queue");
	}
	
	@Bean
	public Topic getTopic() {
		return new ActiveMQTopic("sample.topic");
	}
	public void sendMessageByQueue(String content) {
		this.jmsMessagingTemplate.convertAndSend(getQueue(), content);
	}
	
	public void sendMessageByTopic(String content) {
		this.jmsMessagingTemplate.convertAndSend(getTopic(), content);
	}
}
