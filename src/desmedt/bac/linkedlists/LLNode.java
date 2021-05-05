package desmedt.bac.linkedlists;

public class LLNode {
    public int data;
    public LLNode next;

    public LLNode(int data) {
        this.data = data;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(Integer.toString(this.data));
        LLNode next = this.next;
        while (next != null) {
            sb.append(", ");
            sb.append(next.data);
            next = next.next;
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LLNode) {
            LLNode other = (LLNode) obj;
            return this.toString().equals(other.toString());
        }
        return false;
    }
}
