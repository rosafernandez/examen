package edu.upc.eetac.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by rosa on 18/11/2016.
 */
public class Manager implements GameManager{

    private List<User> users = new ArrayList<User>();
    private User user;
    private List<Etakemon> etakemons = new ArrayList<Etakemon>();
    private Etakemon etakemon;

    private List<Etakemon> userEtakemons = new ArrayList<Etakemon>();

    public Manager(){}


    @Override
    public List<User> userByName()
    {
        if (!users.isEmpty())
        {
            Collections.sort(users, new Comparator<Employee>()
            {
                @Override
                public int compare(Employee e1, Employee e2) {
                    //You should ensure that list doesn't contain null values!
                    return e1.getName().compareTo(e2.getName());
                }
            });
        }
        return this.users;
    }

    @Override
    public void addUser(String name, int id)
    {
        user = new User (name,id);
        users.add(user);
    }
    @Override
    public List<Etakemon> allEtakemons()
    {
        return this.etakemons;
    }

    @Override
    public void addEtakemon(String nom, String descripcio, int tipus)
    {
        etakemon = new Etakemon (nom,descripcio, tipus);
        etakemons.add(etakemon);
    }







    //public void addEmployee(String DNI, String name, double salary, String Department){} Employee esta declarada como abstracta.

    @Override
    public void addSalesMan(String DNI, String name, double salary, String department)
    {
        salesman = new Salesman(DNI, name, salary, department);
        employees.add(salesman);
    }

    @Override
    public void addDirector(String DNI, String name, double salary, String department)
    {
        director = new Director(DNI, name, salary,department);
        employees.add(director);
    }

    @Override
    public void addSale(String DNI, int sale, double amount)
    {
        for (int i=0; i<employees.size(); i++)
        {
            if(employees.get(i).getDNI().equals(DNI))
            {
                employees.get(i).setSale(sale, amount);
            }
        }
    }


    @Override
    public List<Employee> employeeBySalary()
    {
        updateSalaries();
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        });
        return employees;
    }



    @Override
    public List<Employee> employeesByDepartment(String department)
    {
        for (int i=0; i<employees.size();i++)
        {
            if(employees.get(i).getDepartment().equals(department))
            {
                depEmployees.add(employee);
            }
        }
        if (!depEmployees.isEmpty())
        {
            Collections.sort(depEmployees, new Comparator<Employee>()
            {
                @Override
                public int compare(Employee e1, Employee e2)
                {
                    return Double.compare(e1.getSalary(), e2.getSalary());
                }
            });
        }
        return depEmployees;
    }

}