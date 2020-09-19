目录：
数据结构
	1. 数组
	2. 链表
	3. 栈
	4. 队列
	5. 集合
	6. 映射
	7. 树
	8. 图
	9. 堆
	10. 并查集
	11. 字典树 Trie
	12. 位运算
	13. 布隆过滤器
	14. LRU Cache

算法
深度优先搜索 广度优先搜索 

学习习惯：
1、1.5倍速看视频，遇到难点反复看，反复揣摩
2、不断练习，三分看七分练
3、不要死磕
4、敢于放手，敢于死记硬背代码（五毒神掌）
5、不要AC了事，要看高票答案
6、将高票答案过5遍以上，直到理解

数据结构分类：一维数据结构、二维数据结构和特殊数据结构
	• 一维：
		○ 基础
			§ 数组(array)
				□ ArrayList
				□ 线性数据结构，存储相同数据类型
				□ 由内存管理器分配一段连续的内存空间
				□ 下标从 0 -- len-1
				□ 随机查询的时间复杂度是O(1)
				□ 插入：
					® 如果不考虑原数据顺序，可以在末尾新增一条，跟第k位的数据做交换，时间复杂度是O(1)
					® 不改变原有顺序的话，需要逐个后移元素，时间复杂度是O(n)
				□ 删除：
					® 删除数组末尾元素的时间复杂度是O(1)，不需要移动其他数组
					® 删除第k 位的数据，在保持原顺序不变的情况下，需要逐条前移，时间复杂度是O(n)
					® 不考虑数据顺序，可以第k位与末尾数据交换，然后删除交换后的末位数据。
				□ 常见面试题：
					® 数组的查找最大值、最小值、给定值、重复值
					® 数组的排序，快排、归并排序等
					® 多个数组的排序，合并、求交集、求并集
				□ 常见优化方向：
					® 如果数组有序，可以考虑二分法查找
					® 如果数组无序，常使用Hash帮助统计
			§ 链表(linked list)
				□ 单链表
					® 除存储数据元素外，只有一个后继指针，尾节点指向空
					® 查找
						◊ 需要从头遍历链表，时间复杂度是O(n)
					® 插入
						◊ 指定指针的情况下插入节点，时间复杂度是O(1)
						◊ 没有指定指针的时候，需要先遍历确定插入位置，再执行插入操作，时间复杂度是O(n)
					® 删除
						◊ 删除给定指针的结点，需要遍历前驱结点，时间复杂度是O(n)
						◊ 注意删除头、尾节点，推荐画图法
				□ 双链表
					® 除存储数据元素外，包含前驱和后继指针，头结点的前驱和尾节点的后继指针指向空。
					® 查找
						◊ 同单链表，需要从头遍历，时间复杂度是O(n)
					® 插入\删除
						◊ 不需要遍历找到前驱节点，时间复杂度是O(1)
					® 实际例子：
						◊ LinkedHashMap
						◊ 空间换时间的思想
				□ 循环链表
					® 定义：尾指针指向头结点的链表。可以是单链表，也可以是双链表。
					® 特点：从链尾到链头十分方便
					® 经典问题：约瑟夫环
					
				□ 静态链表
					® 定义：用数组描述的链表，即称为静态链表。首先让数组的元素都是由两个数据域构成，data和cur, 也就是说每个数组的下标都要对应一个data和一个cur数据域，data用来存放数据，而cur相当于单链表中的next指针，存放该元素的后继在数组中的下标，我们把cur叫做游标。
					® 游标	5	2	3	4	5	6
					数据		A	C	D	E	
					下标	0	1	2	3	4	5
				□ 常考面试题
					® 1、从尾到头打印单链表
						◊ 从头到尾遍历数据，依次入栈，打印栈中的数据
					® 2、单链表实现的约瑟夫环
					® 3、逆置/反转单链表
					® 4、K个节点为一组进行翻转
					® 5、返回链表中间（1/2）节点（扩展 返回链表1/K节点）
					® 6、单链表排序（冒泡排序&快速排序）
					® 7、查找单链表的中间节点，要求只能遍历一次链表
					® 8、查找单链表的倒数第K个节点，要求只能遍历一次
						◊ 典型的滚动框，框长度为K，框尾到尾节点时，框首便是题解
					® 9、删除链表的倒数第K个节点
					® 10、判断单链表是否带环？若带环，求环的长度？求环的入口节点？
					® 11、判断两个链表是否相交，若相交，求交点（1、假设链表不带环；2 假设链表可能带环）
					® 13、求两个已排序单链表中相同的数据
					® 14、合并两个有序链表，合并后依然有序
		○ 高级
			§ 栈（stack）
				□ 是一种“操作受限”的线性表
				□ 先进后出
				□ 操作：
					® 入栈 push
					® 出栈 pop
					® 取栈顶元素，但不弹出：top或者peek
				□ 用数组实现的叫顺序栈，用链表实现的叫链式栈
				□ 注意的点：
					® 1、函数调用栈
					® 2、编译器利用栈实现表达式求值
					® 3、浏览器的前进后退功能使用栈
				□ 常考的面试题:
					® 1、实现一个栈，入栈push、出栈pop、返回最小值min的复杂度为O(1)
					® 2、使用两个栈实现一个队列
					® 3、不借助额外空间实现栈的逆序
					® 4、实现共享栈
					® 5、括号的匹配问题
			§ 队列（queue）
				□ 操作受限的线性表
				□ 先进先出
				□ 操作：
					® 入队：从队尾放入数据
					® 出队：从队头取数据
				□ 常见队列
					® 普通队列
						◊ 1、由于队列是在两端操作，需要两个指针，一个是head指针，指向队头；一个是tail指针，指向队尾
						◊ 2、入队就是尾指针后移，出队的时候头指针会后移
						◊ 3、使用数组实现的是顺序队列，使用链表实现的是链式队列
						◊ 4、在顺序队列中判断队满的条件时tail==n, 队空的条件时head==tail
						◊ 5、在顺序队列中，当尾指针指向最后一个位置时，入队操作就有问题，此时head由于出队操作已经后移，数组中有位置，为了利用这部分空间，因此出现循环队列，就是想数组首尾相连，当尾指针指向最后一个位置时，再次从数组的第一个位置开始，循环队列判断队满和对空的条件是重点。
						◊ 6、实际应用中，出现阻塞队列和并发队列
						◊ 7、阻塞队列就是给队列增加阻塞机制，入队的时候如果队列满的就会阻塞，等待队列有空余位置，出队的时候如果队空就会阻塞，等待队列有数据，常应用于生产-消费中
					® 双端队列（deque）
						◊ 是一种具有队列和栈性质的数据结构。双端队列中的元素可用两端弹出，其限定插入和删除操作在队列的两端进行。实际使用中还可以有输出受限的双端队列（即一个端点允许插入和删除，另一个端点只允许插入的双端队列），输入受限的双端队列（即一个端点允许插入和删除，另一个端点只允许删除的双端队列）。  而如果限定双端队列从某个端点插入的元素只能从该端点删除，则该双端队列就蜕变为两个栈底相邻的栈了
					® 优先级队列 （priority queue）
						◊ 1、是0个或者多个元素的集合，每个元素都有一个优先权，对优先级队列执行的操作有查询、插入一个新元素或者删除
						◊ 2、一般情况下，查找操作用来搜索优先权最大的元素，删除操作用来删除该元素
						◊ 3、对于优先权相同的元素，可按先进先出次序处理，或按任意优先权进行
						◊ 4、最突出的优点就是自动排序，本质上是堆实现，故入队和出队的效率都是log(n), 因此也不是线性结构
				□ 常考面试题
					® 使用两个队列实现一个栈
					® BFS 使用队列
					® 滑动窗口
			§ 集合（set）
			§ 映射（map）
				□ 也称之为 Hash Table 、哈希表、Hash表，支持高效的数据插入、删除、查询操作，根据key直接访问在内存存储位置的数据散列表来源于数组，借助散列函数对这种数据结构进行扩展，利用的数组支持按照小标随机访问元素的特性
				□ 散列表有两个核心问题：
					® 1、散列函数的设计，是决定发生散列冲突的关键因素
					® 2、散列冲突解决
				□ 散列函数
					® hash(key) key表示元素的键值， hash(key)的值表示经过散列函数计算得到的散列值
					® 设计散列函数：
						◊ 1、散列函数计算得到的散列值是一个非负整数
						◊ 2、如果 key1 = key2，则 hash(key1) = hash(key2)
						◊ 3、如果key 1 != key2, 则 hash(key) !=hash(key2)
						◊ 实际中，由于数组的存储空间有限，也就无法完全避免散列冲突
					® 散列冲突解决方法：
						◊ 1、开放寻址法
						◊ 2、链表法
	• 二维：
		○ 基础
			§ 树（tree）
				□ 概念：树是一种非线性的数据结构，就像真实的树倒挂，具体定义：树是包含n(n>=0)个结点的有穷集，其中：
				     1、每个元素成为结点
				     2、有一个特定的结点被成为根节点或者树根
				     3、除根结点之外的其余数据元素被分为 m (m>=0)个互不相交的集合T1, T2 … Tm-1,   其中Ti本身也是一棵树，被称作原树的子树
				
				□ 根据节点个数分为：二叉树、三叉树、多叉树
				□ 分类
					® 满二叉树
						◊ 符合叶子结点全部在最底层，除叶子结点外，每个结点都有左右两个子结点的条件就是满二叉树
					® 完全二叉树
						◊ 若设二叉树的深度为h, 除第h层外，其他各层的结点数都达到最大个数，第h层所有的结点都连续集中在最左边，这就是完全二叉树
					® 二叉搜索树
						◊ 定义：在树中的任意一个结点，其左子树的值都小于这个结点的值，而右子树的结点都大于这个结点的值
						◊ 特征：二叉搜索树是为了实现快速查找而设计，不仅仅可以快速查找数据，还可以快速插入删除
						◊ 查找操作：先取根节点，如果等于目标值则返回；如果根节点小于目标值则在左子树中递归查找，反之则在右子树中递归查找
						◊ 删除操作：分三种情况
							} 1、如果目标结点没有子结点，只需要将目标结点的父节点指向目标结点的指针指向null
							} 2、如果目标结点只有一个子结点（只有左子结点或者右子结点），只需将目标结点的父节点的指针指向其子结点即可
							} 3、如果目标结点有两个子结点，需要找到其右子树中最小的结点，将它替换目标结点，然后再删除这个最小结点
						◊ 中序遍历后是升序的
						◊ 容易退化成链表
				□ 平衡树
				平衡树有很多种，包括2-3tree、B+tree、AVL、红黑树等
				维基百科：https://en.wikipedia.org/wiki/Self-balancing_binary_search_tree
					® 平衡二叉搜索树（AVL）
						◊ 考虑二叉搜索树的高度可能退化成单链表的情况，造成插入、删除变成O(n)，因此设计出了平衡二叉搜索树，高度接近logn，也因此插入删除和查找的时间复杂度接近为O(logn)
						◊ 定义：二叉树中任意一个结点的左右子树的高度差不能大于1
						◊ Balance Factor 平衡因子
						左子树的高度减去右子树的高度（有时候相反）
						balance factor = {-1, 0, 1}
						◊ 通过旋转操作进行平衡
							} 左旋
							} 右旋
							} 左右旋
							} 右左旋
						◊ 不足：结点需要存储额外的信息，且调整次数频繁
					® 红黑树
					近似平衡二叉树
					可以保证任何一个结点的左右子树高度差小于两倍，
						◊ 定义：红黑树的结点，一类被标记为黑色，一类被标记为红色
							} 1、根结点是黑色的
							} 2、每个叶子结点都是黑色的空结点，且不存数据
							} 3、任何相邻结点都不能同时为红色，被黑色结点隔开
							} 4、每个结点，从该节点向下，到可达叶子结点的左右路径，都包含相同数目的黑色结点。
							} 红黑树是一种平衡二叉搜索树，为了解决二叉搜索树可能退化成链表的问题。红黑树的高度近似为logn，插入删除搜索的时间复杂度都是O(logn)
				□ 二叉树的存储
					® 1、基于指针或者引用的二叉链表存储法
					® 2、基于数组的顺序存储法，其中完全二叉树使用数组存储是最节省内存的一种方式
				□ 遍历方式
					® 广度优先搜索，也称为层次遍历
					® 深度优先搜索
						◊ 前序遍历：根 - 左 - 右
						◊ 中序遍历：左 - 根 - 右
						◊ 后序遍历：左 - 右 - 根
				□ 常考面试题
					® 1、判断一棵树是否平衡
					® 2、求二叉树的深度
					® 3、二叉树的递归遍历、非递归遍历
					® 4、二叉树的最大路径和
					® 5、所有路径的给定和
					® 6、二叉树的最低公共父节点
					® 7、求二叉树第K层的结点个数
			§ 图（graph）
				□ 由点和边组成，数学上用Graph(V, E)表示
				□ V - vertex: 点
					® 1、入度和出度
						◊ 如果无向，则入度 = 出度
					® 2、点与点之间连通与否
				□ E - edge : 边
					® 1、有向和无向（单行线）
					® 2、权重（边长）
				□ 分类：
					® 有向图
					® 无向图
					® 带权图
				□ 图的存储
					® 1、邻接矩阵：存储方式是用两个数组来表示图。一个一维数组存储图中的顶点信息，一个二维数组（称为邻接矩阵）存储图中的边的信息
						◊ 不足：由于存在n个顶点的图需要n*n个数组元素进行存储，当图为稀疏图时，使用邻接矩阵存储方法将会出现大量0元素，这会造成极大的空间浪费。这时可以考虑使用邻接表表示法来存储图中的数据。
					® 2、邻接表：邻接表由表头结点和表结点两部分组成，图中每个顶点均对应一个存储在数组中的表头结点。如果这个表头结点所对应的顶点存在邻接节点，则把邻接节点依次存放于表头结点所指向的单向链表中
				□ 常见算法：
					® DFS 和 BFS
				□ 相关知识链接：
					® https://zhuanlan.zhihu.com/p/34871092
					® https://www.bilibili.com/video/av25829980?from=search&seid=13391343514095937158
					
		○ 高级
			§ 二叉搜索树（binary search tree (red-black tree、AVL)）
			§ 堆 heap
				□ 概念：
					® 1、堆是一个完全二叉树
					® 2、堆中每一个节点的值都必须大于等于（或者小于等于）其子树中每个节点的值，都大于等于的叫大顶堆，都小于等于的叫小顶堆
				□ 堆存储：
					® 由于堆是一个完全二叉树，比较适合用数组存储，可以使用下标方便找到左右子节点和父节点
				□ 常见操作：以大顶堆为例，小顶堆亦同
					® 1、堆化图（知识地图）
					方向分为从下到上和从上到下，以从下到上为例：
					    每次在数组的最后添加一个元素，依次让新插入的结点和父亲结点进行比较，如果    大于父节点则交换，直到小于等于父结点
					® 2、插入元素，图见知识地图
				□ 堆的实现
					® 思路一：在数组的基础上，从小标1开始，依次插入2,3,4…n的元素，类似上面的插入过程，从前向后处理数据，每个数据插入的时候，从下往上堆化，这种处理效率为O(nlogn)
					® 思路二：从后向前处理数组，并且每个数据从上往下进行堆化，考虑叶子节点往下堆化只能是自己，因此从非叶子结点开始堆化，时间复杂度为O(n)
				□ 堆的应用
					® 1、堆排序，包括建堆和排序，将下标n/2到1的节点，依次从上到下的堆化操作，然后将数组中的数据组织成堆，接下来迭代处理将堆顶的元素放到堆的末位，并将堆的大小减 1 ，然后再堆化，重复这个过程，直到元素省下一个，此时数组就是有序的了
					® 2、大数据中选出TopK（静态数据，动态数据），如从几十亿条订单日志中选出金额靠前的1000条数据
					® 3、优先队列
					® 4、中位数
				□ 常考面试题
					® 1、10GB文件，计算机只有512MB大小的可用内存，如何按照字符串大小，给这个10GB的大文件排序
					® 2、静态数据求中位数
					® 3、动态数据求中位数
			§ 并查集（disjoint set）
				□ 概念：并查集是一种树型的数据结构，用于处理一些不想交集合的合并及查询问题。常常在使用中以森林来表示
				□ 主要操作
					® 1、初始化： 把每个点所在集合初始化为自身，这个步骤在每次使用该数据结构时只需要执行1次，时间复杂度 O(n)
					® 2、查找：查找元素所在的集合，即跟节点
					® 3、合并：将两个元素所在的集合合并为一个集合
			§ 字典树 Trie
				□ 代码
				/**
				 * 前缀树
				 *  发音同 try ，是一种树数据结构，用于检索字符串数据集中的键，这种高级的应用有多钟应用
				 *  1、自动补全
				 *  2、拼写检查
				 *  3、IP路由（最长前缀匹配）
				 *  4、T9 (9宫格打字预测）
				 *  5、单词游戏
				 *  6、
				 * Created by yutao
				 * Create date 2020/8/20 21:39
				 */
				public class Trie {
				    private TrieNode root;
				    /** Initialize your data structure here. */
				    public Trie() {
				        root = new TrieNode();
				    }
				    /** Inserts a word into the trie. */
				    public void insert(String word) {
				        if (word == null || "".equals(word)) return;
				        TrieNode node = root;
				        for (char c : word.toCharArray()) {
				            if (node.next[c - 'a'] == null) {
				                node.next[c - 'a'] = new TrieNode();
				            }
				            node = node.next[c - 'a'];
				        }
				    }
				    /** Returns if the word is in the trie. */
				    public boolean search(String word) {
				        return false;
				    }
				    /** Returns if there is any word in the trie that starts with the given prefix. */
				    public boolean startsWith(String prefix) {
				        return false;
				    }
				    class TrieNode {
				        private boolean isEnd;
				        TrieNode[] next;
				        public TrieNode() {
				            isEnd = false;
				            next = new TrieNode[26];
				        }
				    }
				}
				
	• 特殊：
		○ 位运算 （bitwise）
		○ 布隆过滤器（BloomFilter）
			§ 布隆过滤器实际上是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在集合中。
				□ 优点：空间和时间效率都比一般的算法好很多
				□ 缺点：有一定的误识别率
			§ 基本实现和特征
				□ 底层使用的是位图。当一个元素被加入到集合时，通过 K 个Hash函数将一个元素映射成一个位阵列中的 K 个点，把它们置为 1 。检索时，我们只要看看这些点是不是都是 1 就（大约）知道集合中有没有它了：
					® 1、如果这些点有任何一个 0 ， 则被检索元素一定不存在
					® 2、如果都是 1 ， 则被检索可能存在
			§ 与Hash表的区别：
				□ 布隆过滤器是位图+hash表构成，更省空间
			§ 应用：
				□ 1、网页URL的去重
				□ 2、垃圾邮件的判别
				□ 3、集合重复元素的判别
				□ 4、查询加速（比如基于key-value的存储系统）
			§ 常考面试题
				□ 一个网站有100亿URL存在一个黑名单中，每条URL平均64字节。这个黑名单怎么存？若此时随便输入一个URL，你如何快速判断该URL是否在这个黑名单中？
		○ LRU Cache
			§ 概念：缓存是一种提高数据读取性能的技术，在软硬件中都广泛应用。CPU缓存，数据库缓存、浏览器缓存等。常见的淘汰策略有：FIFO 先进先出策略、LFU最少使用策略、LRU 最近最少使用策略
			§ 基本实现和特性
				□ 可以基于双向链表和散列表实现，时间复杂度O(1), 也可以基于数组实现
			§ 常考面试题：
				□ 实现一个LRU缓存，当缓存达到 N 之后淘汰最近最少使用的数据
			§ 代码：
			import java.util.HashMap;
			import java.util.Hashtable;
			/**
			 * 146. LRU缓存机制
			 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
			 *
			 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
			 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
			 *
			 *
			 *
			 * 进阶:
			 *
			 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
			 *
			 *
			 *
			 * 示例:
			 *
			 * LRUCache cache = new LRUCache( 2  //缓存容量  )
			        *
			        *cache.put(1,1);
			        *cache.put(2,2);
			        *cache.get(1);       // 返回  1
			        *cache.put(3,3);    // 该操作会使得关键字 2 作废
			        *cache.get(2);       // 返回 -1 (未找到)
			        *cache.put(4,4);    // 该操作会使得关键字 1 作废
			        *cache.get(1);       // 返回 -1 (未找到)
			        *cache.get(3);       // 返回  3
			        *cache.get(4);       // 返回  4
			 *
			 * Created by yutao
			 * Create date 2020/9/9 9:48
			 */
			public class LRUCache {
			    class DLinkedNode {
			        int key;
			        int val;
			        DLinkedNode pre;
			        DLinkedNode post;
			    }
			    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
			    private int count;
			    private int capacity;
			    private DLinkedNode head, tail;
			    public LRUCache(int capacity) {
			        this.count = 0;
			        this.capacity = capacity;
			        head = new DLinkedNode();
			        head.pre = null;
			        tail = new DLinkedNode();
			        tail.post = null;
			        head.post = tail;
			        tail.pre = head;
			    }
			    /**
			     * Always add the new node right after head;
			     * @param node
			     */
			    private void addNode(DLinkedNode node) {
			        node.pre = head;
			        node.post = head.post;
			        head.post.pre = node;
			        head.post = node;
			    }
			    /**
			     * Remove an existing node from linked list.
			     * @param node
			     */
			    private void removeNode(DLinkedNode node) {
			        DLinkedNode pre = node.pre;
			        DLinkedNode post = node.post;
			        pre.post = post;
			        post.pre = pre;
			    }
			    /**
			     * Move certain node in between to the head
			     * @param node
			     */
			    private void moveToHead(DLinkedNode node) {
			        this.removeNode(node);
			        this.addNode(node);
			    }
			    //pop the current tail
			    private DLinkedNode popTail() {
			        DLinkedNode res = tail.pre;
			        this.removeNode(res);
			        return res;
			    }
			    public int get(int key) {
			        DLinkedNode node = cache.get(key);
			        if (node == null) {
			            return -1;      //should raise exception here.
			        }
			        //move the accessed node to the head.
			        this.moveToHead(node);
			        return node.val;
			    }
			    public void put(int key, int value) {
			        DLinkedNode node = cache.get(key);
			        if (node == null) {
			            DLinkedNode newNode = new DLinkedNode();
			            newNode.key = key;
			            newNode.val = value;
			            this.cache.put(key, newNode);
			            this.addNode(newNode);
			            ++count;
			            if (count > capacity) {
			                // pop the tail
			                DLinkedNode tail = this.popTail();
			                cache.remove(tail.key);
			                --count;
			            }
			        } else {
			            //update the value
			            node.val = value;
			            this.moveToHead(node);
			        }
			    }
			}
			

算法： 总共八大点
前三点，基础：
	• if-else switch --> branch
	• for、while loop --> Iteration
	• 递归 Recursion (Divide & Conquer, Backtrace)
		○ 模板代码：
		○ public void recur(int level, int param ) {
		○       //terminator
		○       if (level > MAX_LEVEL) {
		○           //process result
		○           return;
		○       }
		
		○       //process current logic
		○       process(level, param);
		
		○       //drill down
		○       recur(level + 1, param);
		
		○       //restore currents status
		○ }

基于此三点基础，以找重复单元为核心，有如下五点高级算法：
	• 搜索 Search
		○ 深度优先搜索 Depth first search
			§ 代码模板
			 public List<List<Integer>> levelOrder(TreeNode root) {
			     if (root == null)  return Collections.emptyList();
			     List<List<Integer>> resultList = new ArrayList<>();
			     _levelOrder(root, 0, resultList);
			     
			    return resultList;
			 }
			 private void _levelOrder(TreeNode root, int level, List<List<Integer>> resultList) {
			     if (resultList.size() == level) {
			         resultList.add(new ArrayList<Integer>());
			     }
			     
			     resultList.get(level).add(root.val);
			     if (root.left != null)
			        _levelOrder(root.left, level + 1, resultList);
			    
			    if (root.right != null)
			        _levelOrder(root.right, level + 1, resultList);
			 }
			
		○ 广度优先搜索 Breadth first search
			§ 代码模板
			public List<Integer> largestValues(TreeNode root) {
			    if (root == null) return Collections.emptyList();
			    List<Integer> resultList = new ArrayList<>();
			    Queue<TreeNode> queue = new LinkedList<>();
			    queue.offer(root);
			    while (!queue.isEmpty()) {
			        int max = Integer.MIN_VALUE;
			        int currSize = queue.size();
			        while (currSize --> 0) {
			            TreeNode node = queue.poll();
			            max = Math.max(max, node.val);
			            if (node.left != null)
			                queue.offer(node.left);
			            if (node.right != null)
			                queue.offer(node.right);
			        }
			        resultList.add(max);
			    }
			    return resultList;
			}
			
		○ A*  启发式优先搜索
			§ https://zhuanlan.zhihu.com/p/54510444
	• 动态规划 Dynamic Programming
		○ 概念：每次决策依赖于当前状态，又随即引起状态的转移，一个决策序列就是在变化的状态中产生的，所以，这种多阶段最优化决策解决问题的过程就是 动态规划
		○ 使用情况
			§ 1、最优子结构
				□ 指 问题的最优解 包含子问题的最优解，也就是说，通过子问题的最优解可以推导出问题的最优解
			§ 2、无后效性
				□ 即某阶段的状态一旦确定，就不受这个状态以后决策的影响，也就是说，某状态以后的过程不会影响以前的状态，只与当前状态有关
			§ 3、重复子问题
				□ 不同的决策序列，到达某个相同的阶段时，可能产生重复的状态（该性质并不是动态规划适用的必要条件，但是如果没有这条性质，动态规划算法同其他算法相比就不具备优势）
		○ 回溯、贪心、分治、动态规划的比较
			§ 1、回溯法指数级别的算法复杂度比较高，只能用来解决小规模数据的问题
			§ 2、能用动态规划的问题具有最优子结构、无后效性和重复子问题三个特性
			§ 3、在重复子问题上，分治算法要求分隔成的子问题不能有重复子问题，而动态规划正好相反
			§ 4、贪心算法实际上是动态规划的一种特殊情况
		○ 状态转移方程
			§ 状态转移方程是解决动态规划问题的关键
			§ 分析某个问题如何通过子问题来递归求解，也就是最优子结构，根据最优子结构，写出状态转移方程
			§ 实现状态转移方程的方法：
				□ 1、递归加备忘录
				□ 2、迭代递归
		○ 解题思路
			§ 1、分析最优解的性质，并刻画其结构特征
			§ 2、递归的定义最优解
			§ 3、以自底向上或者自顶向下的记忆化方式（备忘录法）计算出最优值
			§ 4、根据计算最优值时得到的信息，构造问题的最优解
		○ 常考面试题
			i. 背包问题
			ii. 计算两个字符串的相似度
			iii. 最长公共子串长度
			iv. 求最长递增子序列
			v. 最小编辑距离
			vi. 爬楼梯
			vii. 连续子数组的最大和
			viii. 最长回文子串
	
	• 二分查找 Binary Search
		○ 概念
			§ 二分查找每次选取区间的中间元素进行比较，将查找的区间缩小为一半，直到找到要查找的元素或者区间长度为 0 结束查找，思想类似分制
		○ 前提条件：数组有序
		○ 查找效率：O(logn)
		○ 代码模板
			§ 递归法
			§ 非递归法
		○ 易错点
			§ 1、循环退出的条件
			§ 2、每次查找区间一半 mid的取值
			§ 3、查找区间left、right的每次更新情况
		○ 二分查找的应用
			§ 适用于处理静态数据，没有频繁插入、删除的操作
		○ 二分查找的局限
			§ 1、二分查找必须依赖顺序表（数组）
			§ 2、二分查找，查找的必须的有序的数据
			§ 3、数据量太小不适合使用二分查找
		○ 常考面试题
			§ 1、查找第一个值等于给定元素
			§ 2、查找最后一个元素等于给定元素
			§ 3、查找第一个大于等于给定值的元素
			§ 4、查找最后一个小于等于给定值的元素
			§ 5、旋转数组的二分查找
	• 贪心算法 Greedy
		○ 概念：
			§ 贪心算法是指 在对问题求解时，总是做出在当前看来是最好的选择。由于不从整体最优上加以考虑，所做出的是在某种意义上的局部最优解
		○ 基本实现和特性
			§ 贪心算法的基本思路是从问题的某一个初步解出发一步一步的进行，根据某个优化测度，每一步都要确保能获得局部最优解。每一步只考虑一个数据，选取应该满足局部优化的条件。若下一个数据和部分最优解连在一起不再是可行解时，就不把该数据添加到部分解中，直到把所有数据枚举完，或者不能再添加时算法停止
			§ 过程步骤：
				□ 1、建立数学模型来描述问题
				□ 2、把求解的问题分成若干个子问题
				□ 3、对每个子问题求解，得到子问题的局部最优解
				□ 4、把子问题的局部最优解，合成原来问题的一个解
		○ 贪心算法的应用
			§ 1、霍夫曼编码
			§ 2、Prim 和 Kruskal 最小生成树
			§ 3、Dijkstra 单源最短路径
			§ 4、任务调度
		○ 常考面试题
			§ 1、分苹果：有m个苹果和n个孩子（m<n), m 个苹果大小相同，n 个孩子对苹果的多少需求不同，如何分配让最多数量的孩子得到苹果
			§ 2、钱币找零：有 1 元、2 元、5 元、10 元，且张数分别是a1,a2,a3,a4, 用这些钱来支付M元，最少需要多少张？
		○ 区分动态规划
			§ 相同点
				1) 都是一种推导算法
				2) 都是分解成子问题来求解，都需要具有最优子结构
			§ 不同点 1
				□ 贪心：每一步的最优解一定包含上一步的最优解，上一步之前的最优解不做保留
				□ 动态规划：全局最优解中一定包含某个绝不最优解，但不一定包含前一个局部最优解，因此需要记录之前的所有的局部最优解
			§ 不同点 2
				□ 贪心：如果把所有子问题看成一棵树的话，贪心从根出发，每次向下遍历最优子树即可；这样的话，就不需要知道一个节点的所有子树情况，构不成一棵完整的数
				□ 动态规划：动态规划则是自底向上，从叶子向根，构造子问题的解，对每一个子树的根，求出下面每个叶子的值，最后得到一棵完整的树，并且最终选择其中的最优值作为资深的值，得到答案
			根据上述两条可以知道，贪心不能保证求得的最后解是最佳的，一般复杂度低；而动态规划本质是穷举法，可以保证结果是最佳的，但复杂度高
	• 数学 Math、 几何 Geometry

***注意：在头脑中回忆上面每种算法的思想和代码模板

排序算法：

	1. 冒泡排序：
		是一种简单的排序算法，一次只比较两个元素，如果顺序错误就交换过来
		资料：https://www.cnblogs.com/onepixel/p/7674659.html
				代码：
		    public void bubbleSort(int[] arrays) {
		        int len = arrays.length;
		        for (int i = 0; i < len - 1; i++) {
		            for (int j = 0; j < len - 1 - i; j++) {
		                if (arrays[j] > arrays[j + 1]) {
		                    int temp = arrays[j + 1];
		                    arrays[j + 1] = arrays[j];
		                    arrays[j] = temp;
		                }
		            }
		        }
		    }
	2. 选择排序
		a. 工作原理：
			i. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
		b. 代码：
		    public void selectSort(int[] arrays) {
		        int len = arrays.length;
		        int minIndex, temp;
		        for (int i = 0; i < len - 1; i++) {
		            minIndex = i;
		            for (int j = i; j < len; j++) {
		                if (arrays[j] < arrays[i]) {
		                    minIndex = j;
		                }
		            }
		            temp = arrays[i];
		            arrays[i] = arrays[minIndex];
		            arrays[minIndex] = temp;
		        }
		    }
		
	3. 、插入排序
		a. 工作原理：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
		b. 代码：
		public void insertionSort(int[] arrays) {
		        int len = arrays.length;
		        int proIndex, current;
		        for (int i = 1; i < len; i++) {
		            proIndex = i -1;
		            current = arrays[i];
		            while (proIndex >= 0 && arrays[proIndex] > current) {
		                arrays[proIndex + 1] = arrays[proIndex];
		                proIndex--;
		            }
		            arrays[proIndex + 1] = current;
		        }
		    }
	4. 希尔排序
	1959年Shell发明，第一个突破了O(n2)的排序算法，是简单插入的改进版。与插入排序不同的是，它会优化距离较远的元素。也叫缩小增量排序。
	
	代码：
	   public void shellSort(int[] arrays) {
	        int len = arrays.length;
	        for (int gap = len/2; gap > 0; gap = gap/2) {
	            for (int i = gap; i < len; i++) {
	                int j = i;
	                int curren = arrays[i];
	                while (j - gap >= 0 && curren < arrays[j - gap]) {
	                    arrays[j] = arrays[j - gap];
	                    j = j - gap;
	                }
	                arrays[j] = curren;
	            }
	        }
	    }
	
	5. 归并排序
		建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
		
		代码：
		    public static void mergeSort(int[] array, int left, int right) {
		        if (right <= left) return;
		        int mid = (left + right) >> 1; // (left + right) / 2
		        mergeSort(array, left, mid);
		        mergeSort(array, mid + 1, right);
		        merge(array, left, mid, right);
		    }
		    public static void merge(int[] arr, int left, int mid, int right) {
		        int[] temp = new int[right - left + 1]; // 中间数组
		        int i = left, j = mid + 1, k = 0;
		        while (i <= mid && j <= right) {
		            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
		        }
		        while (i <= mid)   temp[k++] = arr[i++];
		        while (j <= right) temp[k++] = arr[j++];
		        for (int p = 0; p < temp.length; p++) {
		            arr[left + p] = temp[p];
		        }
		        // 也可以用 System.arraycopy(a, start1, b, start2, length)
		    }
		
	6. 快速排序

	代码：
	    /**
	     * 快速排序
	     * @param array
	     * @param begin
	     * @param end
	     */
	    public static void quickSort(int[] array, int begin, int end) {
	        if (end <= begin) return;
	        int pivot = partition(array, begin, end);
	        quickSort(array, begin, pivot - 1);
	        quickSort(array, pivot + 1, end);
	    }
	    static int partition(int[] a, int begin, int end) {
	        // pivot: 标杆位置，counter: 小于pivot的元素的个数
	        int pivot = end, counter = begin;
	        for (int i = begin; i < end; i++) {
	            if (a[i] < a[pivot]) {
	                int temp = a[counter]; a[counter] = a[i]; a[i] = temp;
	                counter++;
	            }
	        }
	        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;
	        return counter;
	    }

		
		

	

