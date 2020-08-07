package com.apigeesample;

import com.apigee.flow.execution.ExecutionContext;
import com.apigee.flow.execution.ExecutionResult;
import com.apigee.flow.execution.spi.Execution;
import com.apigee.flow.message.MessageContext;


public class HelloJava implements Execution {

	public ExecutionResult execute(MessageContext messageContext, ExecutionContext executionContext) {
		
		try {

			String name = messageContext.getMessage().getHeader("username");

			if (name != null && name.length()>0) {
					messageContext.getMessage().setContent("Hello, " + name + "!");
					messageContext.getMessage().removeHeader("username");
			} else {
					messageContext.getMessage().setContent("Hello, whatever!");
			}
            
            return ExecutionResult.SUCCESS;

		} catch (Exception e) {
			return ExecutionResult.ABORT;
		}
	}
}