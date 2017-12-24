import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Set;

public class Tree {

	private static List<TreeNode> nodes = new ArrayList<>();
	//hashmap contains a 1 if the node has been created and contains a weight
	//hashmap contains a 0 if the node has been created and contains no weight
	private static HashMap<String, Integer> cache = new HashMap<>();


	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String line = input.nextLine();
			if(line.equals("exit")){
				break;
			}
			ArrayList<String> tokens = new ArrayList<>(Arrays.asList(line.split("[[),]\\s[(]|\\->]")));
			for(Iterator<String> it = tokens.iterator(); it.hasNext(); ){
				String element = it.next();
				if(element.equals("")){
					it.remove();
				}
			}
			makeTreeNode(tokens);
			
		}
		TreeNode root = searchRoot(nodes.get(0));
		calculateTotalWeight(root);
		System.out.println(weightFix(root));

	}

	public static void calculateTotalWeight(TreeNode n){
		List<TreeNode> children = n.getChildren();
		int sum = 0;
		if(!children.isEmpty()){
			for(TreeNode tn: children){
				calculateTotalWeight(tn);
				sum += tn.getTotalWeight();
			}
			n.setTotalWeight(sum);
		}
		else{
			n.setTotalWeight(0);
		}
	}

	public static int weightFix(TreeNode n){
		List<TreeNode> children = n.getChildren();
		if(!children.isEmpty()){
			HashMap<TreeNode, Integer> totalWeights = new HashMap<>();
			HashMap<Integer, Integer> count = new HashMap<>();
			for(TreeNode tn: children){
				int childTotalWeight = tn.getTotalWeight();
				totalWeights.put(tn, childTotalWeight);
				if(count.containsKey(childTotalWeight)){
					count.put(childTotalWeight, count.get(childTotalWeight)+1);
				}
				else{
					count.put(childTotalWeight, 1);
				}
			}
			if(count.values().size() > 1){
				Set<Integer> keySet = count.keySet();
				int unbalanced = -1;
				for(Iterator<Integer> it = keySet.iterator(); it.hasNext(); ){
					int key = it.next();
					if(count.get(key) == 1){
						unbalanced = key;
						break;
					}
				}
				Set<TreeNode> nodeSet = totalWeights.keySet();
				for(Iterator<TreeNode> it = nodeSet.iterator(); it.hasNext(); ){
					TreeNode key = it.next();
					if(totalWeights.get(key) == unbalanced){
						int diff = weightFix(key);
						if(diff == 0){
							//assuming that the unbalanced weight is not the last weight in the list
							return key.getWeight() - key.getTotalWeight() + it.next().getTotalWeight(); 
						}
						else{
							return diff;
						}
					}
				}
			}
			else{
				return 0;
			}
		}
		else{
			return 0;
		}
		return 0;
	}

	public static TreeNode searchRoot(TreeNode n){
		boolean found = false;
		TreeNode root = null;
		while(!found){
			if(n.getParent() != null){
				root = searchRoot(n.getParent());
			}
			else{
				return n;
			}
			found = true;
		}
		return root;
	}

	public static TreeNode makeTreeNode(ArrayList<String> info){
		TreeNode newNode = null;
		if(!cache.containsKey(info.get(0))){
			newNode = new TreeNode(info.get(0), Integer.parseInt(info.get(1)));
			nodes.add(newNode);
			cache.put(info.get(0), 1);
		}
		else{
			for(TreeNode n: nodes){
				if(n.getData().equals(info.get(0))){
					n.setWeight(Integer.parseInt(info.get(1)));
					newNode = n;
					cache.replace(n.getData(), 1);
					break;
				}
			}
		}
		if(info.size() >= 2){
			for(int i = 2; i < info.size(); i++){
				boolean hasBeenCreated = false;
				for(TreeNode n: nodes){
					if(n.getData().equals(info.get(i))){
						newNode.addChild(n);
						hasBeenCreated = true;
						break;
					}
				}
				if(!hasBeenCreated){
					TreeNode childNode = new TreeNode(info.get(i), 0);
					newNode.addChild(childNode);
					nodes.add(childNode);
					cache.put(info.get(i), 0);
				}
			}
		}
		return newNode;
	}


}
//lhrml (164) -> ecblhee, sdjshz
//tqefb (40)
//"[)\\s|\\s(|,\\s|\\->]"