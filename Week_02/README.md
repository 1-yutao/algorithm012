学习笔记
HashMap的总结
概述
	• HashMap是基于数组、链表和红黑树实现的哈希表。采用数组作为键值对的容器。
	• 数组中存放的是单链表的头结点。HashMap采用单链表的方式处理hash冲突。
	• hash冲突时，将冲突的元素接到链表上去。
	• key/value都可以为null；HashTable不支持
	• 非线程安全
关键词
	• initialCapacity：默认桶容量，可以通过构造函数传入，建议为2的幂次方，若传入非2的幂次方数，HashMap会调tableSizeFor转换为临近的2次幂
	阿里开发规范中规定：如果无法确定集合大小，用默认的16即可；确定大小则使用：
		○ 正例：initialCapacity = (需要存储的元素个数 / 负载因子) + 1  注意：负载因子用默认的0.75
		○ 反例：HashMap需要放置1024个元素，由于没有设置容量初始大小，随着元素不断增加，容量7次被迫扩大，resize需要重建hash表。当放置的集合元素个数达千万级别时，不断扩容会严重影响性能。
	• loadFactor：负载因子，值越大越容易出现hash冲突，建议用默认的0.75, 
	• threshold：临界值，默认是DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY
存储结构
	• 数组+链表的结构存储；jdk 1.8之后，会根据一定的阈值(java 14 中值是 8 )将链表转换为红黑树，以提高效率。
	• 默认容量大小是 16，默认负载因子是0.75 
	• 默认临界值threshold = 16*0.75 = 12
	• 判断key冲突的代码：
	p = tab[i = (n - 1) & hash]
	
	if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k))))
	
	==判断的是hashCode是否相同，也就是比较的是内存地址
	equals比较的是内容是否一致
	
hash怎么算的？
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
	key是null时 hash为0
	调hashCode 异或(^) hashCode无符号右移16位



信息参考：
https://www.jianshu.com/p/a7651fb45d96

https://juejin.im/post/5dcb53a8e51d45225371ad30
