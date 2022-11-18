import java.util.List;

public class MyLinkedList implements  NodeList{

    private ListItem root = null;

    public MyLinkedList(ListItem root){
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if(this.root == null){
            this.root = item;
            return true;
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0)// item is bigger than the root.
            { // moving towards right
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }
                else {
                    // no more elements to the right of current element, end of the list
                    currentItem.setNext(item).setPrevious(currentItem);
                    return true;
                }
            }else if(comparison > 0)// item is smaller than root value.
            {
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(item).setPrevious(currentItem.previous());
                    item.setNext(currentItem).setPrevious(item);
                }
                else{
                    item.setNext(this.root).setPrevious(item);
                    this.root = item;
                }
                return true;
            }
            else{
                System.out.println(item.getValue()+" already exists, not added");
                return false;
            }
        }
        return  false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting the item "+item.getValue());
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                if(currentItem == this.root){
                    this.root = currentItem.next();
                }
                else{
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            }else if(comparison < 0){
                currentItem = currentItem.next();
            }else{
                // Already ahead of the item to be deleted, hence item not in list
                return false;
            }
        }
        // Did not find the item in the list
        return false;
    }

    @Override
    public void traverse(ListItem root) {

        if(this.root == null){
            System.out.println("the list is empty ");
        }
        else {
           while(root != null){
               System.out.println(root.getValue());
               root = root.next();
           }
        }
    }
}
