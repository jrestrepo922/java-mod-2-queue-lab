import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Restaurant {

private Map<String , String> table; 
private Queue<String> waitList;



public Restaurant() {
    this.table = new HashMap<String, String>();
    this.waitList = new LinkedList<String>();
}

public Map<String, String> getTable() {
    return table;
}
public void setTable(Map<String, String> table) {
    this.table = table;
}
public Queue<String> getWaitList() {
    return waitList;
}
public void setWaitList(Queue<String> waitList) {
    this.waitList = waitList;
}
  

}

