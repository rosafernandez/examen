package edu.upc.eetac.dsa;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

//establim connexió

public abstract class DAO {

    public static Connection getConnection() {
        Connection con = null;
        try {
            String host = "localhost";
            int port = 3306;
            String database = "dao"; //posar el nom d la bbdd q faci servir!!!!
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            Properties info = new Properties();
            info.setProperty("user", "root");
            info.setProperty("password", "root");
            info.setProperty("useSSL", "false");
            info.setProperty("serverTimezone", "UTC");
            con = DriverManager.getConnection(url, info);
            System.out.println("Conexion creada.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

    //la funció getValors agafa els valos dels getters i setters

    public String getValors(Field f) {
        String res = null;
        try {
            Method m = this.getClass().getMethod(getUpper(f.getName()), null);
            res = m.invoke(this, null).toString();
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (InvocationTargetException e1) {
            e1.printStackTrace();
        }
        return res;
    }

    //la funció insterarElementos insereix els valors en els "?"

    public void insertarElementos(PreparedStatement preparedStatement) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        int i = 1;
        Field[] fields = this.getClass().getFields();

        for (Field f : fields) {
            String res = getValors(f);
            preparedStatement.setObject(i, res);
            i++;
        }
    }

    //la funció getUpper et modifica la primera lletra en majucules per poder accedir als getters
    public String getUpper(String m) {
        String result = Character.toUpperCase(m.charAt(0)) + m.substring(1);
        return "get".concat(result);
    }
    // ------------------------------------------------------------------------------

    //funció getAllUsers q retorna tots els usuaris en una llista ordenats pel nom
    public static List<User> getAllUsers() throws SQLException {
        Connection con = getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs = stmt.executeQuery("SELECT * FROM User ORDER BY name");
        List<User> lista = new ArrayList<User>();
        while (rs.next()) {
            User user = new User(rs.getInt("id"), rs.getString("name"));
            lista.add(user);
        }
        //System.out.println(lista);
        for (User u : lista) {
            System.out.println(u + "\n");
        }
        return lista;
    }

    //------------------------------------------------------------------------
    //funció per INSERTAR  a les taules elements (insertar un usuari o un etakemon)

    public void insert() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StringBuffer sb = new StringBuffer();
        sb.append("INSERT INTO ").append(this.getClass().getSimpleName());

        //recorro tots els atributs que tingui la classe posant els noms i els separo amb comes excepte si es l'ultim.
        Field[] fields = this.getClass().getFields();

        sb.append(" (");
        int i = 0;
        for (Field f : fields) {
            sb.append(f.getName());
            i++;
            if (i != fields.length)
                sb.append(",");
        }

        //Ex en el cas q sigui un user vaig creant la query: INSERT INTO User (id,name) VALUES (?,?)
        sb.append(") VALUES (");
        i = 0;
        for (Field f : fields) {
            i++;
            sb.append("?");
            if (i != fields.length)
                sb.append(",");
        }

        sb.append(");");

        System.out.println("QUERY: " + sb.toString() + "\n");

        //estableixes la conexió i fas el INSERT
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------------------

    //UPDATE: modificar un usuari q indiques
    public void update() {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(this.getClass().getSimpleName()).append(" SET ");

        Field[] fields = this.getClass().getDeclaredFields(); //campos--> obtener campos declarados en esta clase:id, name, address

        int numfields = 0;
        for (Field f : fields) {
            if (numfields == fields.length - 1) {
                sb.append(f.getName() + "=?");
            } else {
                sb.append(f.getName() + "=?,");
            }
            numfields++;
        }

        int id = Integer.parseInt(getValors(fields[0])); //convertir el string corresponent a la [0] de fields q fa referencia al id a int
        sb.append(" WHERE id=" + id);
        //si fos per name: sb.append (" WHERE name=" + nom);

        System.out.println("QUERY: " + sb.toString());

        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //--------------------------------------------------------

    //SELECT d'un usuari
    public void select(int id) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT * FROM ").append(this.getClass().getSimpleName()).append(" WHERE ID = ").append(id);
        System.out.println("QUERY: " + sb.toString());

        Connection con = getConnection();

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sb.toString());
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) { //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-------------------------------------------------------

    //SELECT  etakemons dun usuari (donant el name) en ordre d'inserció
    public void select2(int id) {
        StringBuffer sb = new StringBuffer();
        sb.append("SELECT etakemons FROM ").append(this.getClass().getSimpleName()).append(" WHERE name = ").append(id);
        System.out.println("QUERY: " + sb.toString());

        Connection con = getConnection();

        try {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sb.toString());
            ResultSetMetaData rsmd = rs.getMetaData();
            rs.next();
            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) { //lo ejecuto el numero de veces de columnas que tenga en la tabla
                try {
                    if (rsmd.getColumnTypeName(i).equals("INT")) {//para la columna i,si es del tipo int
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getInt(i)); //obtengo la etiqueta de la columna y el entero (id=1...)
                    }
                    if (rsmd.getColumnTypeName(i).equals("VARCHAR")) { //si es del tipovarchar, obtengo lo que es tambien
                        System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(i));
                    }
                    if (i == rsmd.getColumnCount()) { //cuando i=numero de columnas, voy al siguiente y salgo del bucle,reiniciando i
                        rs.next();
                        i = 0;
                    }
                } catch (Exception e) {
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//UPDATE: afegir un etakemon a l'usuari q indiques (per id)
    public void update2() {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE ").append(this.getClass().getSimpleName()).append(" SET ");

        Field[] fields = this.getClass().getDeclaredFields(); //campos--> obtener campos declarados en esta clase:nom, descripcio, tipus

        int numfields = 0;
        for (Field f : fields) {
            if (numfields == fields.length - 1) {
                sb.append(f.getName() + "=?");
            } else {
                sb.append(f.getName() + "=?,");
            }
            numfields++;
        }

        int id = Integer.parseInt(getValors(fields[0])); //convertir el string corresponent a la [0] de fields q fa referencia al id a int
        sb.append(" WHERE id=" + id);
        //si fos per name: sb.append (" WHERE name=" + nom);

        System.out.println("QUERY: " + sb.toString());

        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sb.toString());
            insertarElementos(preparedStatement);
            preparedStatement.execute();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------------------------------------


}


