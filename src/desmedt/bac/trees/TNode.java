package desmedt.bac.trees;

public class TNode {
    public final int value;
    public TNode left, right;

    public TNode(int value) {
        this(value, null, null);
    }

    public TNode(int value, TNode left, TNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public static TNode deserialize(String source) {
        if (source == null || source.isEmpty()) return null;

        int index1 = source.indexOf("'");
        int index2 = source.indexOf("'", index1 + 1);
        int val = Integer.parseInt(source.substring(index1 + 1, index2));

        if ((index2 + 2) < source.length()) {
            String branches = source.substring(index2 + 2, source.length() - 1).trim();
            int counter = 0;
            int index = branches.length();
            for (int i = 0; i < branches.length(); i++) {
                if (branches.charAt(i) == '(') {
                    counter++;
                } else if (branches.charAt(i) == ')') {
                    counter--;
                    if (counter == 0) {
                        index = Math.min(index, i);
                    }
                }
            }
            String left = null;
            String right = null;
            if (index < branches.length() - 1) {
                left = branches.substring(0, index + 1);
                right = branches.substring(index + 2).trim();
            } else {
                left = branches;
            }

            return new TNode(val, deserialize(left), deserialize(right));
        } else return new TNode(val);
    }

    public String serialize() {
        StringBuilder builder = new StringBuilder(getClass().getSimpleName());
        builder.append("('");
        builder.append(value);
        builder.append("'");

        if (left != null) {
            builder.append(", ");
            builder.append(left.serialize());
        }
        if (right != null) {
            builder.append(", ");
            builder.append(right.serialize());
        }
        builder.append(")");

        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TNode) {
            TNode other = (TNode) obj;
            return this.serialize().equals(other.serialize());
        }
        return false;
    }

    public void reverseNodes(){
        var temp = left;
        left = right;
        right = temp;
    }

    @Override
    public String toString() {

        return this.serialize();
    }
}
