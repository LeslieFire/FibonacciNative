
#include "com_seefeel_android_fibonaccinative_FibLib.h"
#include <android/log.h>

static jlong fib(jlong n) {
	return n <= 0? 0 : n == 1? 1 : fib(n-1) + fib(n-2);
}

JNIEXPORT jlong JNICALL Java_com_seefeel_android_fibonaccinative_FibLib_fibNR
  (JNIEnv *env, jclass clazz, jlong n){
	__android_log_print(ANDROID_LOG_DEBUG, "fiblib.c",  "fibNR(%lld)", n);
	return fib(n);
}


JNIEXPORT jlong JNICALL Java_com_seefeel_android_fibonaccinative_FibLib_fibNI
  (JNIEnv *env, jclass clazz, jlong n){

	jlong previous = -1;
	jlong result = 1;
	jlong i;
	__android_log_print(ANDROID_LOG_DEBUG, "fiblib.c",  "fibNI(%lld)", n);
	for (i = 0; i <= n; i++) {
		jlong sum = result + previous;
		previous = result;
		result = sum;
	}
	return result;
}


