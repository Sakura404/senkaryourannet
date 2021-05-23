package net.togogo.utils;

import java.sql.*;

public class JdbcUtils {
    static Connection connection = null;
    static PreparedStatement preparedStatement =null;
    static ResultSet resultSet = null;
    public  static Connection getMyConnection(){
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";
            String userName = "root";
            String pwd ="root123456";
            //获取数据库的连接
            connection = DriverManager.getConnection(url, userName, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return  connection;
    }


    public static ResultSet getMyResultSet(String sql,Object...obj){
        if(getMyConnection() != null){
            try {
                    preparedStatement = connection.prepareStatement(sql);
                for (int i=0;i<obj.length;i++){
                    preparedStatement.setObject(i+1,obj[i]);
                }
                   resultSet = preparedStatement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  resultSet;
    }
    public  static int getMyUpdate(String sql ,Object...obj){
        int count = 0;
        if(getMyConnection() != null){

            try {
                preparedStatement = connection.prepareStatement(sql);

            for (int i=0;i<obj.length;i++){
                preparedStatement.setObject(i+1,obj[i]);
             }
                 count = preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    public static void getMyClose(){
        //先进后出 后进先出
        if(resultSet!= null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection!= null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
