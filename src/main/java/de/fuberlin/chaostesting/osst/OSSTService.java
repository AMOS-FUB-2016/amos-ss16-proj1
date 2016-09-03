package de.fuberlin.chaostesting.osst;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import de.fuberlin.chaostesting.model.Response;
import de.fuberlin.chaostesting.model.Test;

public class OSSTService implements Callable<List<Response>> {
	
	Collection<Test> tests;
	String url;
	
	List<Response> responses = Collections.synchronizedList(new ArrayList<>());
	ExecutorService pool;
	
	public OSSTService(Collection<Test> tests, String url) {
		this.tests = tests;
		this.url = url;
	}

	@Override
	public List<Response> call() {
		pool = Executors.newFixedThreadPool(5);
		Set<Future<Response>> set = new HashSet<Future<Response>>();
		for (Test test : tests) {
			Callable<Response> callable = new OSSTTask(test, url);
			Future<Response> future = pool.submit(callable);
			set.add(future);
		}
		
		for (Future<Response> future : set) {
			try {
				responses.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		pool.shutdown();
		
		return responses;
	}

	
	static class OSSTTask implements Callable<Response> {
		Test test;
		String url;
		
		public OSSTTask(Test test, String url) {
			this.test = test;
			this.url = url;
		}
		
		@Override
		public Response call() {
			OSSTClient osstClient = new OSSTClient();
			try {
				Response r = osstClient.executeTest(test, url);
				
				r.setTest(test);
				
				return r;
			} catch (IOException e) {
				e.printStackTrace();
			}

			return null;
		}
	}
}

