package com.he.encode;

public class HuffmanNode extends HuffmanTree {

    private HuffmanTree rightTree;

    public HuffmanTree getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(HuffmanTree leftTree) {
        this.leftTree = leftTree;
    }

    private HuffmanTree leftTree;

    public HuffmanNode(HuffmanTree leftTree, HuffmanTree rightTree) {
        super(rightTree.getFrequency() + leftTree.getFrequency());
        this.rightTree = rightTree;
        this.leftTree = leftTree;
    }

    public HuffmanTree getRightTree() {
        return rightTree;
    }

    public void setRightTree(HuffmanTree rightTree) {
        this.rightTree = rightTree;
    }
}
