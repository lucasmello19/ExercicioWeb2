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
public class ConfigBean {
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public ConfigBean() {
    }
}
