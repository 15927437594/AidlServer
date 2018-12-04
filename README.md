# AidlServer

- 在AndroidManifest.xml中将application设置属性android:persistent="true",在任务管理器中不能杀死该应用,APP会在开机之前自启动
- 在任务管理器中杀死蓝牙音乐进程(假杀死),会马上调用service的onTaskRemoved()方法