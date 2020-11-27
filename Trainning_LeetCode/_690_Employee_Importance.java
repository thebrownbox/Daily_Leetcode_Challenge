/**
 * 690. Employee Importance
 * URL: https://leetcode.com/problems/employee-importance/ 
 * Tags: #BFS, #DFS
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _690_Employee_Importance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    Set<Employee> checked = new HashSet<>();
    Map<Integer, Employee> map = new HashMap<>();

    public int DFS(Employee curEmployee)
    {
        if(curEmployee == null) return 0;
        int sum = curEmployee.importance;
        
        for (Integer id : curEmployee.subordinates) {
            Employee subEm = map.get(id);
            if(checked.contains(subEm) == false)
            {
                checked.add(subEm);
                sum += DFS(subEm);
            }
        }

        return sum;
    }


    public int getImportance(List<Employee> employees, int id) {

        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        for (Employee employee : employees) {
            if(employee.id == id){
                return DFS(employee);
            }
        }
        return 0;
    }
    
}
