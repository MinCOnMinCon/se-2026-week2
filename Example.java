import java.util.Queue;
import java.util.ArrayDeque;

public class Example {

    public static void main(String[] args) {
        Node root = new Node("Root");
        Node child1 = new Node("Child 1");
        Node child2 = new Node("Child 2");
        

        root.addChild(child1);
        root.addChild(child2);
        
        System.out.println("Root label: " + root.label);
        System.out.println("Children of Root:");
        for (Node child : root.children) {
            System.out.println("- " + child.label);
        }
    }

    private void hasChild(){

    }

    private void height(){

    }

    private static Node dfs(Node root, String key){
        if(root == null) 
            return null;
        if(key.equals(root.label)){
            return root;
        }

        for(Node child : root.children){
            Node result = dfs(child, key);
            if(result != null){
                return result;
            }
        }
    
        return null;
    }
    
    private static Node bfs(Node root, String key){
        Queue<Node> non_visit = new ArrayDeque<>();
        non_visit.offer(root);

        while(!non_visit.isEmpty()){
            Node visit = non_visit.poll();
            if(visit.label.equals(key)){
                return visit;
            }
            else{
                for(int i = 0; i < visit.children.size(); i++){
                    non_visit.offer(visit.children.get(i));
                }
            }
        }

        return null;
    }

}
