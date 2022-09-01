import java.util.*;

public class L690_employeWeight {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    public static void main(String[] args) {

    }


    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();

        for(Employee e : employees) {
            map.put(e.id, e);
        }

        return getImportance_dfs(map, id);
    }


    public int getImportance_dfs(Map<Integer, Employee> map, int id) {

        System.out.println("emp Id = "+id);
        if(map.get(id).subordinates.isEmpty()) {
            System.out.println("    returning emp importance = "+map.get(id).importance);
            return map.get(id).importance;
        }

        int weight = map.get(id).importance;

        for(Integer empId : map.get(id).subordinates) {
            System.out.println("   dfs emp Id = "+ empId);
            weight = weight + getImportance_dfs(map, empId);
        }
        System.out.println("   weight = "+ weight);
        return weight;

    }


    public int getImportance_bfs_queue(Map<Integer, Employee> map, int id) {

        System.out.println("emp Id = "+id);

        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);

        while (!queue.isEmpty()) {

            int empId = queue.poll();
            sum = sum + map.get(empId).importance;
            System.out.println("sum = " + sum);
            queue.addAll(map.get(empId).subordinates);
        }
        return sum;

    }
}
