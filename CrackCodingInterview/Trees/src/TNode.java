/**
 * Created by ayush on 16/6/16.
 */
public class TNode {
    private int data;
    private TNode left;
    private TNode right;
    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
    public TNode getLeft(){
        return left;
    }
    public TNode getRight(){
        return right;
    }
    public void setLeft(TNode left){
        this.left = left;
    }
    public void setRight(TNode right){
        this.right = right;
    }
    public TNode(int data) {
          this.data = data;
    }
    public TNode(int data, TNode left,TNode right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

}