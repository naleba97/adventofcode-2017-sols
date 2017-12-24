import java.util.List;
import java.util.ArrayList;

public class TreeNode{
	private String data = null;
	private int weight = 0;
	private List<TreeNode> children = new ArrayList<>();
	private TreeNode parent = null;
	private int totalWeight = 0;

	public TreeNode (String data, int weight){
		this.data = data;
		this.weight = weight;
	}

	public void addChild(String data, int weight){
		TreeNode newChild = new TreeNode(data, weight);
		newChild.setParent(this);
		children.add(newChild);
	}

	public void addChild(String data){
		TreeNode newChild = new TreeNode(data, 0);
		newChild.setParent(this);
		children.add(newChild);
	}

	public void addChild(TreeNode node){
		node.setParent(this);
		children.add(node);
	}

	public List<TreeNode> getChildren(){
		return children;
	}

	public void setWeight(int weight){
		this.weight = weight;
	}

	public int getWeight(){
		return weight;
	}

	public void setTotalWeight(int weight){
		this.totalWeight = this.weight + weight;
	}

	public int getTotalWeight(){
		return totalWeight;
	}

	public void setData(String data){
		this.data = data;
	}

	public String getData(){
		return data;
	}

	public void setParent(TreeNode parent){
		this.parent = parent;
	}

	public TreeNode getParent(){
		return parent;
	}

	public String toString(){
		StringBuilder str = new StringBuilder("Data: " + data + "\n" + "Weight: " 
		+ weight + "\n" + "Number of Children: ");
		str.append(children.size());
		str.append("\n");
		str.append("Total Weight: " + totalWeight + "\n");
		if(this.parent != null){
			str.append("Parent: " + this.parent.getData() + "\n");
		}
		return str.toString();
	}
}
