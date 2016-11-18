package edu.upc.eetac.dsa;


//creo la classe User amb els seus atributs, el constructor i els getters i setters (code-> generate)
public class User extends DAO{

    public int id;
    public String name;


    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id: ").append(this.getId());
        sb.append("\nname: ").append(this.getName());
        return sb.toString();
    }
}

