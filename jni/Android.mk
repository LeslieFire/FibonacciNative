LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := com_seefeel_android_fibonaccinative_FibLib.c
LOCAL_MODULE := com_seefeel_android_fibonaccinative_FibLib
LOCAL_LDLIBS += -llog
include $(BUILD_SHARED_LIBRARY)