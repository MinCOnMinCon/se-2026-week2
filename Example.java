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

    private void dfs(){

    }
    
    private void bfs(){
        
    }
}
