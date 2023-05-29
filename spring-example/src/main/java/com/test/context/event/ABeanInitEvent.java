package com.test.context.event;

import org.springframework.context.ApplicationEvent;

/**
 * ABean初始化完成的事件
 */
public class ABeanInitEvent extends ApplicationEvent {
	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public ABeanInitEvent(Object source) {
		super(source);
	}
}
