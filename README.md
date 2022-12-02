# About Project
This is a basic java (jdk 11+) project with gradle 7 & junit 5.
## Context
    XX集团准备成立新的交付团队--天宫，以完成某向软件开发任务
    1.可以向天宫团队assign 成员（member）和交付任务（story）。
    2.成员分为BA，DEV和QA。assign的成员和角色没有数量限制。
    3.BA的工作是为交付团队产生1～3个新的story，并且给所有空闲的DEV assign一张卡（不需要考虑分配机制和策略）；  
      DEV的工作是实现被assign的story;   
      QA的工作是测试（移除）2个完成的卡（无特定要求怎么选择2个卡）。  
    4.DEV在已分配story的情况下再次分配新的story时，会产生带宽不足异常。
##  Require
    1.cd DeliveryTeam
    2. ./gradlew idea
    3.Using idea open project
    4.TDD + OOP
    5.功能需要有API接口
    6.需要有DB进行数据持久化
    7.使用SpringBoot / JPA postgres
##  Demand Split  
    1.当向天宫团队发出添加成员请求时，天宫团队能接收到请求，并返回创建的结果是成功的
    2.当向天宫团队发出添加story卡请求时，天宫团队能接收到请求，并返回创建的结果是成功的
    3.当成员类型是BA，同时向团队发出添加新的story请求时，返回添加的结果是成功的
    4.当成员类型是BA, 当向团队的领卡为空闲的DEV分配卡时，能返回分配的结果是成功的
    5.当成员类型是BA，给story已分配的团队成员为DEV发出分配请求时，会返回宽带不足异常信息
    6.当向团队时DEV的成员发出story实现请求时，story的状况由被分配变成完成状态，并返回正确的结果
    7.当成员类型是QA，同时向团队发出删除已完成的story请求时，stroy状态变成已完成，并返回正确的结果
    8.当向天宫团队发出查询所有成员请求时，天宫团队能接收到请求，并返回查询的结果
    9.当向天宫团队发出查询所有Story请求时，天宫团队能接收到请求，并返回查询的结果
    
    
 