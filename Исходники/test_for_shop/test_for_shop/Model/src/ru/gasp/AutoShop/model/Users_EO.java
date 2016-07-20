package ru.gasp.AutoShop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "Users_EO.findAll", query = "select o from Users_EO o") })
@Table(name = "USERS")
public class Users_EO implements Serializable {
    private static final long serialVersionUID = 4239060749250029469L;
    private BigDecimal bonus;
    @Id
    @Column(name = "ID_USER", nullable = false)
    private BigDecimal idUser;
    @Column(unique = true)
    private String login;
    private String name;
    @Column(name = "PERSONAL_DISCOUNT")
    private BigDecimal personalDiscount;
    private String surname;
    private String telephone;
    @Column(name = "THIRD_NAME")
    private String thirdName;
    @OneToMany(mappedBy = "users", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Orders_EO> ordersList;

    public Users_EO() {
    }

    public Users_EO(BigDecimal bonus, BigDecimal idUser, String login, String name, BigDecimal personalDiscount,
                    String surname, String telephone, String thirdName) {
        this.bonus = bonus;
        this.idUser = idUser;
        this.login = login;
        this.name = name;
        this.personalDiscount = personalDiscount;
        this.surname = surname;
        this.telephone = telephone;
        this.thirdName = thirdName;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPersonalDiscount() {
        return personalDiscount;
    }

    public void setPersonalDiscount(BigDecimal personalDiscount) {
        this.personalDiscount = personalDiscount;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public List<Orders_EO> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders_EO> ordersList) {
        this.ordersList = ordersList;
    }

    public Orders_EO addOrders_EO(Orders_EO orders_EO) {
        getOrdersList().add(orders_EO);
        orders_EO.setUsers(this);
        return orders_EO;
    }

    public Orders_EO removeOrders_EO(Orders_EO orders_EO) {
        getOrdersList().remove(orders_EO);
        orders_EO.setUsers(null);
        return orders_EO;
    }
}
