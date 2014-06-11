package com.seefeel.android.fibonaccinative;

import android.util.Log;

public class FibLib {
	private static final String TAG = "Fiblib";
	
	private static long fib(long n){
		return n <= 0? 0 : n == 1? 1 : fib(n-1) + fib(n-2);
	}
	
	public static long fibJR(long n) {
		Log.d(TAG, "fibJR(" + n + ")");
		return fib(n);
	}
	
	public native static long fibNR(long n);
	
	public static long fibJI(long n) {
		Log.d(TAG, "fibJI(" + n + ")");
		long previous = -1;
		long result = 1;
		for (long i = 0; i <= n; i++) {
			long sum = result + previous;
			previous = result;
			result = sum;	
		}
		return result;
	}
	
	public native static long fibNI(long n);
	
	static {
		System.loadLibrary("com_seefeel_android_fibonaccinative_FibLib");
	}
}

