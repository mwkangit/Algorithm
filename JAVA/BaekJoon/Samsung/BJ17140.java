package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17140 {
	
	static int r;
	static int c;
	static int k;
	static ArrayList<ArrayList<Integer>> list;
	static int max_R = 0;
	static int max_C = 0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		for(int i = 0 ; i < 3 ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ArrayList<Integer> sub_list = new ArrayList<>();
			sub_list.add(Integer.parseInt(st.nextToken()));
			sub_list.add(Integer.parseInt(st.nextToken()));
			sub_list.add(Integer.parseInt(st.nextToken()));
			list.add(sub_list);
		}
		
		int answer = 0;
		boolean flag = false;
		while(true) {
			if(list.size() >= r && list.get(0).size() >= c) {
				if(list.get(r-1).get(c-1) == k) {
					break;
				}
			}
			if(list.size() >= list.get(1).size()) {
				func_R();
			}else {
				func_C();
			}
			
			
			answer++;
			if(answer > 100) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.print(-1);
		}else {
			System.out.print(answer);
		}
		
		
	
	}
	
	static void func_C() {
		int R_size = list.size();
		int C_size = list.get(0).size();
		ArrayList<ArrayList<Integer>> sub_list = new ArrayList<>();
		
		for(int j = 0 ; j < C_size ; j++) {
			ArrayList<Integer> conv = new ArrayList<>();
			
			for(int i = 0 ; i < R_size ; i++) {
				if(list.get(i).get(j) == 0 )continue;
				
				conv.add(list.get(i).get(j));
			}
			
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int k = 0 ; k < conv.size() ; k++) {
				int num = conv.get(k);
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			
			PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
					if(n1.value > n2.value) {
						return 1;
					} else if(n1.value == n2.value) {
						if(n1.key > n2.key) {
							return 1;
						} else {
							return -1;
						}
					} else {
						return -1;
					}
				}
			});
			for(int k : map.keySet()) {
				q.add(new Node(k, map.get(k)));
			}
			
			ArrayList<Integer> adder = new ArrayList<>();
			int count = 0;
			while(!q.isEmpty()) {
				
				Node node = q.poll();
                
				if(count+1 > 100)break;
				count++;
				adder.add(node.key);
				
				if(count+1 > 100)break;
                count++;
                adder.add(node.value);
				
				
			}
			max_R = Math.max(max_R, count);
			
			
			sub_list.add(adder);
			
			
		}
		
		for(int i = 0 ; i < sub_list.size() ; i++) {
			if(sub_list.get(i).size() < max_R) {
				int comp = sub_list.get(i).size();
				for(; comp < max_R ; comp++) {
					sub_list.get(i).add(0);
				}
			}
		}
	
		ArrayList<ArrayList<Integer>> list_conv = new ArrayList<>();
		for(int i = 0 ; i < sub_list.get(0).size() ; i++) {
			ArrayList<Integer> sub_list_conv = new ArrayList<>();
			for(int j = 0 ; j < sub_list.size() ; j++) {
				sub_list_conv.add(sub_list.get(j).get(i));
			}
			list_conv.add(sub_list_conv);
		}
		
		list = list_conv;
	}
	
	static void func_R() {
		int R_size = list.size();
		int C_size = list.get(0).size();
		ArrayList<ArrayList<Integer>> sub_list = new ArrayList<>();
		
		for(int i = 0 ; i < R_size ; i++) {
			HashMap<Integer, Integer> map = new HashMap<>();

			
			for(int j = 0 ; j < C_size ; j++) {
				if(list.get(i).get(j) == 0) continue;
				
				int num = list.get(i).get(j);
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
			
			PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node n1, Node n2) {
					if(n1.value > n2.value) {
						return 1;
					} else if(n1.value == n2.value) {
						if(n1.key > n2.key) {
							return 1;
						} else {
							return -1;
						}
					} else {
						return -1;
					}
				}
			});
			for(int k : map.keySet()) {
				q.add(new Node(k, map.get(k)));
			}
			ArrayList<Integer> adder = new ArrayList<>();
			int count = 0;
			while(!q.isEmpty()) {
				Node node = q.poll();
                
				if(count+1 > 100)break;
				count++;
				adder.add(node.key);
				
				if(count+1 > 100)break;
                count++;
                adder.add(node.value);
			}
			max_C = Math.max(max_C, count);
			
			sub_list.add(adder);
			
			
		}
		
		for(int i = 0 ; i < sub_list.size() ; i++) {
			if(sub_list.get(i).size() < max_C) {
				int comp = sub_list.get(i).size();
				for(; comp < max_C ; comp++) {
					sub_list.get(i).add(0);
				}
			}
		}
		
		list = sub_list;

	}
	
	static class Node{
		int key;
		int value;
		
		public Node(int k, int v) {
			key = k;
			value = v;
		}
	}

}
