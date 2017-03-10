package com.zhang.search;

public class RedAndBlackTree<Key extends Comparable<Key>,Value>{
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Node root;
	private class Node{
		private Node left,right;
		private Key key;
		private Value val;
		private int N;
		private boolean color;
		private Node(int N,Key key,Value val,boolean color){
			this.color=color;
			this.key=key;
			this.N=N;
			this.val=val;
		}	
	}
	//递归获取节点h所有涵盖的节点数
	private int size(Node h){
		if(h==null) return 0;
		else return 1+size(h.left)+size(h.right);
	}
	//判断节点是否是红连接，红连接的定义是该节点到父节点的连接是红连接
	private boolean isRed(Node x){
		if(x==null) return false;
		return x.color==RED;
	}
	//右红连接时需要进行左旋转，返回一个当前节点位置的新节点
	private Node rotateLeft(Node h){
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		
		return x;
		
	}
	
	//左红连接时需要进行右旋转，返回一个当前节点位置的新节点
		private Node rotateRight(Node h){
			Node x=h.left;
			h.left=x.right;
			x.right=h;
			x.color=h.color;
			h.color=RED;
			x.N=h.N;
			h.N=size(h.left)+size(h.right)+1;
			
			return x;
			
		}
		//当节点的左右孩子节点都为红连接节点时，执行该函数
		//不可能出现节点h也为红连接节点的情况，因为在处理中，这种情况在连续红连接的情况已经进行了处理
		private void flipColors(Node h){
			h.color=RED;
			h.left.color=BLACK;
			h.right.color=BLACK;	
		}
		private void put(Key key,Value val){
			//查找key，找到就更新它的值，否则创建一个新的root节点
			root=put(root, key, val);
			root.color=BLACK;
		}
		//插入新节点
		//插入新节点时如要进行下面的步骤返回一个红黑树
		private Node put(Node h,Key key,Value val){
			if(h==null) return new Node(1, key, val, RED);
			//提供Comparable 进行比较找到插入位置，为 递归算法
			int cmp=key.compareTo(h.key);
			if(cmp<0)       h.left=put(h.left, key,val);
			else if(cmp>0)  h.right=put(h.right, key, val);
			else            h.val=val;
			//判断节点红连接进行旋转的执行顺序，顺序不能颠倒，先判断右红连接，进行左旋转，
			//再判断连续左红连接，进行右旋转，最后进行判断节点左右孩子节点是否都为红连接节点
			if(isRed(h.right)&&!isRed(h.left))   h=rotateLeft(h);
			if(isRed(h.left)&&isRed(h.left.left)) h=rotateRight(h);
			if(isRed(h.left)&&isRed(h.right))     flipColors(h);
			
			h.N=size(h.left)+size(h.right)+1;
			return h;
		}


	

}

//class Key{
//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//}
//class Value{
//	private String name;
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//}


