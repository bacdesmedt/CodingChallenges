package desmedt.bac.linkedlists;

public class LinkedList {
    public LLNode node;

    public LinkedList() {}
    public LinkedList(int[] values) {
        for (int value : values) {
            this.append(value);
        }
    }

    public void append(int data) {
        if (node == null) {
            node = new LLNode(data);
            return;
        }

        LLNode current = node;
        while (current.hasNext()) {
            current = current.next;
        }
        current.next = new LLNode(data);
    }

    public void appendAll(LLNode node) {
        if (node == null) return;
        if (this.node == null) {
            this.node = node;
            return;
        }

        LLNode current = this.node;
        while (current.hasNext()) {
            current = current.next;
        }
        current.next = node;
    }

    public void remove(int value) {
        if(this.node == null) return;
        if(node.data == value) node = node.next;
        else {
            LLNode current = this.node;
            while (current.hasNext()) {
                if(current.next.data == value){
                    current.next = current.next.next;
                }
                current = current.next;
            }
            current.next = node;
        }
    }

    @Override
    public String toString() {
        return "[" + this.node.toString() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList){
            LinkedList other = (LinkedList) obj;
            return this.node.equals(other.node);
        }
        return false;
    }
}
