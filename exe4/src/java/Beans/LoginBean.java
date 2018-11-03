/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.ejb.Stateless;

/**
 *
 * @author LucasMello
 */
@Stateless
public class LoginBean {

    private int id;
    private String nome;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public LoginBean() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
