/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;

/**
 *
 * @author elias
 */
public class Standart {

    protected String table;
    protected Connection con;
    protected String query;

    public Standart() {
        ConexaoBD conexao = new ConexaoBD();
        try {

            if (conexao.abriuConexao()) {
                System.out.println("Abriu Normalmente");
            } else {
                System.out.println("erro de conexao");
            }
        } catch (Exception e) {
            System.out.println("erro de conexao");
        }

        try {

            this.con = conexao.obterConexao();
        } catch (Exception e) {

        }

    }

    public void setTable(String table) {
        this.table = table;
    }

    public ResultSet getById(String table, String id) throws SQLException {
        PreparedStatement ps = this.con.prepareStatement("Select * from  " + table + " where id = ?;");
        int idInt = 0;
        try {
            idInt = Integer.parseInt(id);
            ps.setInt(1, idInt);
        } catch (Exception e) {
            ps.setString(1, id);
        }
        return ps.executeQuery();
//        return this.con.createStatement().executeQuery("Select * from "+ table + " Where id ='"+id+"'");
    }

    public boolean delete(String table, String id) throws SQLException {
        PreparedStatement ps = this.con.prepareStatement("DELETE FROM " + table + " where id = ?;");
        int idInt = 0;
        try {
            idInt = Integer.parseInt(id);
            ps.setInt(1, idInt);
        } catch (Exception e) {
            ps.setString(1, id);
        }
        return ps.execute();
    }

    public int currentInteger(String table) throws SQLException {
        ResultSet rs;
        rs = this.con.createStatement().executeQuery("SELECT currval('" + table + "_id_sequence');");
        rs.next();
        return rs.getInt(1);
    }

    public int getPages(String table) throws SQLException {
        String query = "select(SELECT count(*) FROM " + table + ")/10; ";
        PreparedStatement ps = this.con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1) + 1;
    }
    
    public String addOffset(String query){
        return query += "  order by id desc limit 10 offset ?";
    }
    
}
