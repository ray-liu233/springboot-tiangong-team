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
### Happy Path
    1.当用户向天宫团队发出添加成员请求时，天宫团队能接收到请求，并返回创建后的成员结果
    2.当用户向天宫团队发出添加任务请求时，天宫团队能接收到请求，并返回创建后的任务结果
    
 