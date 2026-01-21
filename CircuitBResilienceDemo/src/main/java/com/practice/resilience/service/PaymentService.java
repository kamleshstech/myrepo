package com.practice.resilience.service;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkheadRegistry;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class PaymentService {
	
    private final ThreadPoolBulkhead threadPoolBulkhead;

    public PaymentService(ThreadPoolBulkheadRegistry registry) {
        // obtain the named ThreadPoolBulkhead configured in application.yml
        this.threadPoolBulkhead = registry.bulkhead("tpBulkhead");
    }

	private final AtomicInteger c = new AtomicInteger(0);
	
	//@CircuitBreaker(name = "paymentCB", fallbackMethod = "doPayFallback")
	//@Retry(name = "paymentRetry")
	//@RateLimiter(name = "paymentRateLimiter")
	//@TimeLimiter(name = "paymentTimeLimiter")
	public CompletableFuture<String> doPayment() {
		System.out.println("THREAD NAME : " +Thread.currentThread());
		return CompletableFuture.supplyAsync( () -> {
			System.out.println("THREAD NAME : " +Thread.currentThread());
			
			int n = c.incrementAndGet();
			System.out.println(n);
			
			try {
				if(n%2==0) {
					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {
				throw new RuntimeException(e); 
			}
			
			if(n % 3 != 0) {

				throw new RuntimeException("Getting Exception :: "+n);
			}
			
		return "payment of ₹ "+new Random().nextInt(100, 100000)+" is successfully completed in !!"+System.currentTimeMillis();
			
		});
		
	}
	
	@Bulkhead(name = "billGenratorBulhHead",type = Bulkhead.Type.SEMAPHORE,fallbackMethod = "doPayFallback")
	public String billGenrator() throws InterruptedException {

	System.out.println("START : "+System.currentTimeMillis()+" :: "+Thread.currentThread());
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			throw e; 
		}
		
	System.out.println("END : "+System.currentTimeMillis()+" :: "+Thread.currentThread());
		
		return "Bill Genrated...!!!";
	}
	
	//fallback must accept exact exception thrown by CB or RL
	public String doPayFallback(Throwable t) {
		System.out.println("FALLBACK RESPONSE :: "+t.getClass().getSimpleName()+" -> "+t.getMessage()); 
		return "FALLBACK RESPONSE :: "+t.getClass().getSimpleName()+" -> "+t.getMessage();
	}
}
