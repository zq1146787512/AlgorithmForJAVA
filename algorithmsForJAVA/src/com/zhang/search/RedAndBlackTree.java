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
	//�ݹ��ȡ�ڵ�h���к��ǵĽڵ���
	private int size(Node h){
		if(h==null) return 0;
		else return 1+size(h.left)+size(h.right);
	}
	//�жϽڵ��Ƿ��Ǻ����ӣ������ӵĶ����Ǹýڵ㵽���ڵ�������Ǻ�����
	private boolean isRed(Node x){
		if(x==null) return false;
		return x.color==RED;
	}
	//�Һ�����ʱ��Ҫ��������ת������һ����ǰ�ڵ�λ�õ��½ڵ�
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
	
	//�������ʱ��Ҫ��������ת������һ����ǰ�ڵ�λ�õ��½ڵ�
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
		//���ڵ�����Һ��ӽڵ㶼Ϊ�����ӽڵ�ʱ��ִ�иú���
		//�����ܳ��ֽڵ�hҲΪ�����ӽڵ���������Ϊ�ڴ����У�������������������ӵ�����Ѿ������˴���
		private void flipColors(Node h){
			h.color=RED;
			h.left.color=BLACK;
			h.right.color=BLACK;	
		}
		private void put(Key key,Value val){
			//����key���ҵ��͸�������ֵ�����򴴽�һ���µ�root�ڵ�
			root=put(root, key, val);
			root.color=BLACK;
		}
		//�����½ڵ�
		//�����½ڵ�ʱ��Ҫ��������Ĳ��践��һ�������
		private Node put(Node h,Key key,Value val){
			if(h==null) return new Node(1, key, val, RED);
			//�ṩComparable ���бȽ��ҵ�����λ�ã�Ϊ �ݹ��㷨
			int cmp=key.compareTo(h.key);
			if(cmp<0)       h.left=put(h.left, key,val);
			else if(cmp>0)  h.right=put(h.right, key, val);
			else            h.val=val;
			//�жϽڵ�����ӽ�����ת��ִ��˳��˳���ܵߵ������ж��Һ����ӣ���������ת��
			//���ж�����������ӣ���������ת���������жϽڵ����Һ��ӽڵ��Ƿ�Ϊ�����ӽڵ�
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


