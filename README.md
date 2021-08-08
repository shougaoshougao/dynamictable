# dynamictable

## master分支
基于Thread Local，Mybatis-plus实现动态表名切换，
其中还使用到InvacationHandler对mapper所有方法进行代理自动设置ThreadLocal。
配套博客：https://www.jianshu.com/p/8f2736f21d8f

## aop分支：
为了完全基于spring机制的优雅实现，在aop分支上面做了一下修改：
1. 使用@@Scope("prototype")+@Lookup注入替代手动new MapperWrapper()。
2. 使用@Cacheable+ConcurrentMapCacheManager替代手动使用ConcurrentHashMap。
3. 使用AOP的@Aspect+@Around("within(MapperWrapper)")注解自动设置threadlocal。
