# 【分布式事务Seata
入门教程】

## 学习资料

### Seata 是什么?

### 分布式事务（ 图解 + 秒懂 + 史上最全 ） 

- 一图解读分布式事务

	- 名词解释
	- 分布式事务与分布式锁的区别：

- 事务简介

	- 事务的四个特征：

		- 1、Atomic原子性
		- 2、Consistency一致性
		- 3、Isolation隔离性
		- 4、Durability持久性

	- SQL中的4个事务隔离级别：

		- （1）读未提交
		- （2）读已提交
		- （3）可重复读
		- （4）串行化

	- 数据一致性和高性能，是天生的矛盾
	- MySQL的本地事务实现方案
	- 脏读、幻读、不可重复读

		- 脏读（Dirty Read）
		- 幻读（Phantom Read）
		- 不可重复读（Unrepeatable Read）

	- 事务的隔离级别

- 分布式事务的基本概念

	- 分布式环境的事务复杂性
	- 什么是分布式事务？

		- 1. 跨库事务
		- 2. 分库分表
		- 3. 微服务化

- CAP定理

	- 分布式事务的理论基础
	- CAP定理

		- 1、一致性
		- 2、可用性
		- 3、分区容错性

	- CAP的应用

		- 1、放弃P
		- 2、放弃A
		- 3、放弃C
		- CAP 理论告诉我们:

	- CAP 权衡
	- CAP和ACID中的A和C是完全不一样的

		- A的区别：
		- C的区别：

- BASE定理

	- BASE定理

		- 1、Basically Available（基本可用）
		- 2、Soft state（软状态）
		- 3、Eventually consistent（最终一致性）

	- BASE理论的特点：
	- BASE理论与CAP的关系
	- ACID 和 BASE 的区别与联系

- 分布式事务分类：柔性事务和刚性事务

	- 分布式事务分类
	- 刚性事务
	- 柔性事务

- 刚性事务：XA模型、XA接口规范、XA实现

	- XA模型 或者 X/Open DTP模型
	- XA规范
	- 什么是XA
	- XA协议的实现

		- 2PC/3PC协议
		- Seata
		- Jta规范
		- JTS规范
		- Atomikos分布式事务实现
		- XA的主要限制
		- Seata AT 模式
		- LCN（2pc）

	- 2PC（标准XA模型）

		- 2PC节点角色
		- 详解：二个阶段

			- 阶段一：提交事务请求
			- 阶段二：执行事务提交，或者执行中断事务;
			- 执行事务提交
			- 执行事务中断

		- 2pc解决的是分布式数据强一致性问题
		- 2PC二阶段提交的特点

			- 2PC方案比较适合单体应用
			- 2PC具有明显的优缺点：

				- 总结一下： XA-两阶段提交协议（以2PC为参考）中会遇到的一些问题
				- 性能问题
				- 协调者单点故障问题
				- 丢失消息导致的数据不一致问题

	- 3PC

		- 详解：三个阶段

			- 阶段一：CanCommit
			- 阶段二：PreCommit
			- 阶段三：doCommit

		- 2PC和3PC的区别：

			- 3PC主要解决的单点故障问题：
			- 3PC主要没有解决的数据一致性问题：
			- "3PC相对于2PC而言到底优化了什么地方呢?"

	- XA规范的问题

- 柔性事务的分类

	- 通知型事务

		- 异步确保型事务

			- MQ事务消息方案
			- 异步确保型事务使用示例
			- 基于阿里 RocketMQ实现MQ异步确保型事务
			- 本地消息表方案
			- MQ事务消息 VS 本地消息表

		- 最大努力通知

			- MQ事务消息方案
			- 本地消息表方案
			- 最大努力通知事务 VS 异步确保型事务

		- 通知型事务的问题

			- 消息发送一致性
			- 常规MQ消息处理流程和特点
			- 消息重复发送问题和业务接口幂等性设计

	- 补偿型

		- 什么是补偿模式？
		- TCC 事务模型

			- 什么是TCC 事务模型
			- TCC的工作流程
			- TCC事务案例
			- TCC事务模型的要求：
			- TCC事务模型 VS DTP事务模型
			- TCC与2PC对比
			- TCC其实本质和2PC是差不多的：
			- TCC和2PC不同的是：
			- TCC 的使用场景

		- SAGA长事务模型

			- Saga相关概念

				- Saga 模型由三部分组成：
				- Saga的执行顺序有两种：
				- Saga 两种恢复策略：

			- Saga的使用条件
			- 对于ACID的保证：
			- SAGA模型的解决方案

				- 方案一：半消息模式。
				- 方案二：本地消息表

			- SAGA的案例
			- Saga和TCC对比

		- 总体的方案对比：

- seata

	- seata简介
	- Seata 的三大模块
	- Seata 的分布式事务的执行流程
	- 4 种分布式事务解决方案

		- Seata AT模式

			- Seata AT模式的使用前提
			- Seata AT模型图
			- Seata AT模式的例子

				- 第一阶段流程：
				- 第二阶段流程如：

			- Seata AT 模式在电商下单场景的使用
			- 电商业务场景中 Seata in AT mode 工作流程详述
			- Seata的数据隔离性

				- 写隔离
				- 写隔离的原则：
				- 读的隔离级别

			- Spring Cloud集成Seata AT模式

		- Seata TCC 模式

			- 简介
			- 第一阶段 Try
			- 第二阶段 Confirm
			- 第二阶段 Cancel
			- 多个事务并发的情况

		- SEATA Saga 模式

			- 适用场景：
			- 优势：
			- 缺点：
			- Saga的实现：
			- 基于状态机引擎的 Saga 实现：

		- Seata XA 模式

			- 使用Seata XA 模式的前提
			- Seata XA 模式的整体机制
			- Seata XA 模式的工作机制

				- 1. 整体运行机制
				- 2. 数据源代理
				- XA 模式的使用

- 面试题标准答案: 如何解决分布式事务问题的？

	- （1）强一致性场景
	- （2）弱一致性场景
	- （3）最终一致性场景
	- 各大模式的总体对比：

### seata AT模式实战（图解+秒懂+史上最全）

- 分布式事务使用场景

	- 数据库的水平分割倒逼分布式事务
	- 微服务化倒逼分布式事务
	- 10WQPS秒杀实操的分库架构

- Spring Cloud Alibaba Seata

	- AT模式(业务侵入小)
	- AT模式角色如下
	- AT模式(2PC)基本处理逻辑如下
	- AT模式第一阶段
	- 这也是Seata和XA事务的不同之处：
	- AT模式第二阶段

		- 场景一：提交，全局提交
		- 场景2：回滚，全局回滚

	- AT模式相对于XA模式的优势
	- 10WQPS秒杀实操的AT分布式事务架构

- 快速开始搭建Seata环境

	- 全局事务和分支事务的存储模式

		- file 模式
		- db 模式

	- 配置和启动Seata-server服务（TC服务）
	- seata-server包下载和解压
	- 启动 TC Server（单体的实例）
	- 使用 File 存储器全局会话
	- seata-server的TC端配置
	- TC端的参数清单，大致如下：

- 部署集群 TC Server

	- 使用 Nacos 作为注册中心
	- TC端数据库初始化

		- 创建TC端的专属独立库seata。
		- 通过 source 命令，导致sql脚本就可以了。

	- db 数据库共享全局事务会话信息：

		- 如果使用file作为配置文件
		- 如何使用nacos作为配置中心：

	- 补充：MySQL8 的支持
	- 启动 第一个TC Server
	- 启动 第2个TC Server
	- 实验演示：注册到nacos之后，可以在nacos上看效果
	- 控制台提交nacos配置脚本

		- 修改 自己定义的服务组
		- 修改数据库连接
		- 将文件中的配置导入nacos 即可

	- 直接使用nacos 的data-id配置文件

		- 制作和上传配置文件
		- config文件中的修改
		- 重启 TC，一切OK

- NameSpace、Group、DataId

	- NameSpace：区分不同的环境
	- 进行Group的切换
	- 进行NameSpace的切换

- AT模式的RM&TM&TC直接的交互流程
- TM&RM 应用开发

	- 业务场景
	- 中间件版本选型
	- 数据库准备

		- 创建RM端的专属独立库seata。
		- 创建RM端的专属独立的表。

- TM端的注册中心配置

	- file.conf本地配置
	- file.conf 配置文件分部分说明

		- 1.transport
		- 2.service
		- 3.client

- 项目准备

	- 模块架构
	- 模块的角色架构
	- maven依赖
	- 事务分组是什么？

- TM&RM配置详解

	- registry.conf配置：配置注册中心和配置中心

		- 注册中心
		- 配置中心

	- file.conf

		- 事务日志存储配置：
		- TC信息配置
		- 客户端相关工作的机制

	- DataSourceConfig
	- 事务注解

- 代码实现

	- 10WQPS秒杀实操的AT分布式事务架构
	- 服务秒杀

		- seckillController
		- seckillServiceImpl
		- 库存服务的Feign类
		- 订单服务的Feign类

	- 订单服务

		- orderController
		- OrderServiceImpl

	- 库存服务

		- stockController
		- StockServiceImpl

	- 实验演示：启动后进行事务演示
	- 错误排除

- Seata AT分布式事务执行流程演示

	- 正常执行

		- 观察每个阶段的undo_log和TC的记录
		- 本实验演示：通过配套视频给出

	- 异常执行

		- 观察每个阶段的undo_log和TC的记录

- 参考面试题

	- 简述：Seata AT模式的事务流程

		- 回顾： Seata执行流程

	- 为什么Seata在第一阶段就直接提交了分支事务？
	- 怎么使用Seata框架，来保证事务的隔离性？

		- Seata隔离级别

	- 请比较一下：经典 XA和Seata AT模式
	- 简述：AT模式的性能问题？

### seata AT模式源码解读( 图解+秒懂+史上最全）

- seata基础知识

	- 图解：Seata AT分布式事务的执行流程
	- 分布式事务的执行流程整体图
	- 10WQPS秒杀的分布式事务 执行流程

- TM&RM启动

	- springboot-starter 启动
	- spring.factories
	- SeataAutoConfiguration
	- 配置事务分组名称
	- GlobalTransactionScanner 初始化
	- 获取 Netty RPC实例
	- 初始化 Netty RPC实例 TmRpcClient
	- Netty RPC客户端的继承关系
	- AbstractRpcRemotingClient发起连接
	- RpcClientBootstrap#setChannelHandlers
	- RpcClientBootstrap.start()方法
	- getTransactionServiceGroup()
	- NettyClientChannelManager 的reconnect 方法
	- getAvailServerList
	- NettyClientChannelManager 的acquireChannel方法
	- NettyClientChannelManager 的doConnect
	- AbstractNettyRemoting的init方法

- RM初始化

	- RM的客户端初始化
	- RMClient.init(applicationId, txServiceGroup)
	- DefaultResourceManager 的Spi 实现
	- 根据Seata Spi 加载ResourceManager实现类
	- ResourceManager是seata的重要组件之一，RM负责管理分支数据资源的事务。
	- AbstractResourceManager
	- DefaultResourceManager
	- DataSourceManager
	- 异步AsyncWorker
	- UndoLogManager
	- Rm netty Channel 启动
	- AbstractNettyRemotingClient 初始化
	- 为DataSource生成代理的DataSourceProxy
	- 自动装配 SeataAutoDataSourceProxyCreator
	- SeataAutoDataSourceProxyCreator 何方神圣？
	- 基类AbstractAutoProxyCreator 创建动态代理
	- SeataAutoDataSourceProxyAdvice
	- DataSourceProxy初始化
	- DefaultResourceManager的registerResource
	- DataSourceManager的registerResource
	- AbstractResourceManager的registerResource
	- RmRpcClient的registerResource
	- sendAsyncRequest方法发送请求
	- 数据源代理

- RM分布式事务的第一阶段

	- 全局事务的初始化
	- SeataSeckillServiceImpl.doSeckill
	- AbstractAutoProxyCreator
	- wrapIfNecessary
	- Spring中Bean的关键初始化过程
	- GlobalTransactionalInterceptor 事务拦截器
	- 根据注解开启 aop切面
	- postProcessAfterInitialization:299, AbstractAutoProxyCreator
	- wrapIfNecessary:223, GlobalTransactionScanner
	- TransactionalTemplate事务模板
	- TransactionalTemplate事务模板execute方法中主要有以下几个步骤：
	- 真正执行事务开始的地方: 获取xid
	- DefaultTransactionManager负责 TM 与 TC 通讯
	- GlobalBeginRequest 消息类型的说明
	- 业务代码执行business.execute()
	- TM分支事务的第一阶段

		- 图解 AT 模式一阶段分支事务流程
		- 分支事务注册与事务提交
		- Seata AT 的工作流程
		- 工作流程总览
		- RM的一阶段提交
		- 一阶段加载
		- Seata AT 模式客户端部分
		- AT模式对 DataSource,Connection,Statement 都做了代理
		- prepareStatement.executeUpdate
		- ExecuteTemplate.executeUpdate
		- 执行器接口 execute 的实现
		- AbstractDMLBaseExecutor 执行器基类
		- 本地connectionProxy.commit() 代理提交
		- 分支事务：代理连接的一阶段提交

	- 第一阶段本地事务相关的问题

		- GlobalLock 的具体作用
		- 检查锁
		- 汇报状态
		- RM是如何加入到全局事务中的呢？
		- RM是加入到全局事务中的具体步骤
		- RM如何绑定 XID到上下文

	- 至此一阶段事务完成

- 全局事务二阶段提交

	- 图解：TM全局事务二阶段 Commit 流程
	- 图解：RM分支事务的二阶段提交
	- 逻辑：RM的二阶段提交
	- RM提交分支事务 doBranchCommit
	- 异步提交分支事务
	- 异步删除对应的undo_log记录
	- 通过资源管理器提交分支事务
	- 分支事务子类的完成提交

- 全局事务的二阶段回滚

	- 官方的RM的二阶段回滚
	- 图解TC二阶段 Rollback 流程
	- 图解RM二阶段 Rollback 流程
	- 二阶段回滚
	- AbstractRMHandler.handle(BranchRollbackRequest request)
	- DataSourceManager 执行回滚
	- AbstractUndoLogManager 执行回滚

### seata TCC模式源码解读( 图解+秒懂+史上最全）

- Seata TCC基本原理

	- Seata TCC模式的流程图
	- Seata TCC 事务的3个操作

- 10WQPS秒杀的TCC分布式事务架构

	- 库存服务

		- controller
		- service

	- 订单服务

		- controller
		- service

	- 秒杀服务

		- controller
		- service

- 以下两个实验，请参见配套视频

	- Seata TCC 事务的常见问题

		- 幂等控制
		- 空回滚
		- 防悬挂

	- 解决实验过程中MYSQL出现死锁问题

		- MYSQL出现死锁的现象
		- 如何排查？
		- 操作步骤
		- 结束线程
		- 最简单的死锁避免方案：

- 总结

### 【Seata】分布式事务Seata入门与实战

## 一、分布式事务的基本概念

## 二、分布式事务分类

## 三、Seata简介

## 四、Seata环境搭建

## 五、10WQPS分布式事务实战

## 六、Seata AT模式源码解读

## 七、Seata TCC模式源码解读

### 

*XMind - Trial Version*