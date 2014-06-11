FibonacciNative
===============

A simple way to learn android NDK.

It's the total android project created when I learned Android NDK.
When you wanna get a way into android NDK, it cannot be much easier to follow the video tutorial by Aleksandar Gargenta

It's the link here: https://thenewcircle.com/s/post/1153/introduction_to_ndk

NOTE
===============
1, This project was based on android 4.4. It's a learning outcome , and do not take version compatibility into consideration.

2, I put the following steps as a quick guide (all the command was under windows cmd):

A, (optional)
> set path=c:\Java\jdk1.5.0_02\bin
> set classpath=C:\Java\jdk1.5.0_02\lib\tools.jar;C:\Java\jdk1.5.0_02\lib\dt.jar;C:\Java\jdk1.5.0_02\bin

B, 
> md jni

C, 
> javah -jni -classpath bin\classes\ -d jni\ com.seefeel.android.fibonaccinative.FibLib 

D,
edit .h .c  and android.mk  under directory jni

E,
> ndk-build

F,
  static{ 
    System.LoadLibrary("xxx");
  }
  
G, UI/Client/Run
