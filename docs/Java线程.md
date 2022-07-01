# Java 线程

## 本章内容

- 创建和运行线程
- 查看线程
- 线程 API
- 线程状态

## 创建和运行线程

### 方法一：直接使用 Thread

### 方法二：使用 Runnable 配合 Thread

#### Thread 与 Runnable 的关系

​ 分析 Thread 的源码，理清它与 Runnable 的关系



> **小结**
>
> - 方法1 是把线程和任务合并在了一起，方法2 是把线程和任务分开了
> - 用 Runnable 更容易与线程池等高级 API 配合
> - 用 Runnable 让任务类脱离了 Thread 继承体系，更灵活

### 方法三：FutureTask 配合 Thread

​ FutureTask 能够接收 Callable 类型的参数，用来处理有返回结果的情况

## 观察多个线程同时运行

主要是理解：

- 交替执行
- 谁先谁后，不由我们控制

## 查看进程线程的方法

### windows

- 任务管理器可以查看进程和线程数，也可以用来杀死进程
- `tasklist` 查看进程
- `taskkill` 杀死进程

### linux

- `ps -fe` 查看所有进程
- `ps -fT -p  <PID>` 查看某个进程（PID）的所有线程
- `kill` 杀死进程
- `top` 按大写 H 切换是否显示线程
- `top -H -p <PID>` 查看某个进程（PID）的所有线程

### Java

- `jps` 命令查看所有 Java 进程
- `jstack  <PID>` 查看某个 Java 进程（PID）的所有线程状态
- `jconsole` 来查看某个 Java 进程中线程的运行情况（图形界面）

jconsole 远程监控配置

- 需要以如下方式运行你的 java 类

  > java -Djava.rmi.server.hostname=`ip地址` -Dcom.sun.management.jmxremote - Dcom.sun.management.jmxremote.port=`连接端口`
  -Dcom.sun.management.jmxremote.ssl=是否安全连接 - Dcom.sun.management.jmxremote.authenticate=是否认证 java类

- 修改 /etc/hosts 文件将 127.0.0.1 映射至主机名

如果要认证访问，还需要做如下步骤

- 复制 jmxremote.password 文件
- 修改 jmxremote.password 和 jmxremote.access 文件的权限为 600 即文件所有者可读写
- 连接时填入 controlRole（用户名），R&D（密码）

## 原理之线程运行

### 栈与栈帧

### 线程上下文切换（Thread Context Switch）





