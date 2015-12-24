/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.right.customer.util.thpool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;



/**
 *
 * @author rafaralahitsimba tiaray
 */
public class GUIExecutorImpl extends ScheduledThreadPoolExecutor{

    public GUIExecutorImpl(int corePoolSize) {
	super(corePoolSize);
    }

    public GUIExecutorImpl(int corePoolSize, ThreadFactory threadFactory) {
	super(corePoolSize, threadFactory);
    }

    public GUIExecutorImpl(int corePoolSize, RejectedExecutionHandler handler) {
	super(corePoolSize, handler);
    }

    public GUIExecutorImpl(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
	super(corePoolSize, threadFactory, handler);
    }
    
}
