package com.delivery.service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

@Component
public class OTPProcess {

	private static final Integer EXPIRE_MIN = 1;
	private LoadingCache<String, Integer> otpCache;

	public OTPProcess() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					@Override
					public Integer load(String s) throws Exception {
						return 0;
					}
				});
	}

	public String generateOTP(String key) {
		Random random = new Random();
		int OTP = 100000 + random.nextInt(900000);
		otpCache.put(key, OTP);
		return "" + OTP;
	}

	public String getOPTByKey(String key) {

		return "" + otpCache.getIfPresent(key);
	}

	public void clearOTPFromCache(String key) {
		otpCache.invalidate(key);
	}

}
