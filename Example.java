import java.util.Queue;
import java.util.ArrayDeque;

public class Example {

    public static void main(String[] args) {
        Node root = new Node("Root");
        Node child1 = new Node("Child 1");
        Node child2 = new Node("Child 2");

        root.addChild(child1);
        root.addChild(child2);

        Example example = new Example();

        System.out.println("Root label: " + root.label);
        System.out.println("Children of Root:");
        for (Node child : root.children) {
            System.out.println("- " + child.label);
        }
        System.out.println("Has child: " + example.hasChild(root));
        System.out.println("Height: " + example.height(root));
        System.out.println("Find Child 2: " + bfs(root, "Child 2").label);
    }

    private boolean hasChild(Node node) {
        return node != null && node.children != null && !node.children.isEmpty();
    }

    private int height(Node node) {
        if (!hasChild(node)) {
            return 0;
        }

        int maxHeight = 0;
        for (Node child : node.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }

        return maxHeight + 1;
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

    private static Node bfs(Node root, String key) {
        if (root == null) {
            return null;
        }

        Queue<Node> non_visit = new ArrayDeque<>();
        non_visit.offer(root);

        while (!non_visit.isEmpty()) {
            Node visit = non_visit.poll();
            if (visit.label.equals(key)) {
                return visit;
            }

            for (Node child : visit.children) {
                non_visit.offer(child);
            }
        }

        return null;
    }

}
