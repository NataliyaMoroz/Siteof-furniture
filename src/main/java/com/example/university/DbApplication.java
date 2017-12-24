package com.example.university;

import com.example.university.redis.messaging.MessagePublisher;
import com.example.university.redis.messaging.MessagePublisherImpl;
import com.example.university.redis.messaging.MessageSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@SpringBootApplication
public class DbApplication {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		template.setConnectionFactory(jedisConnectionFactory());
		template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
		return template;
	}

	@Bean
	MessagePublisher redisPublisher() {
		return new MessagePublisherImpl(redisTemplate(), topic());
	}

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new MessageSubscriber());
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic("pubsub:queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(DbApplication.class, args);
	}
}
