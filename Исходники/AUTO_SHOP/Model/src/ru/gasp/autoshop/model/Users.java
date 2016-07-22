package ru.gasp.autoshop.model;

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

@Entity
@NamedQueries({ @NamedQuery(name = "Users.findAll", query = "select o from Users o"),
                @NamedQuery(name = "Users.getByIdUser", query = "select o from Users o where o.idUser = :p_idUser"),
                @NamedQuery(name = "Users.getByLogin", query = "select o from Users o where o.login = :p_login"),
                @NamedQuery(name = "Users.getByName", query = "select o from Users o where o.name like :p_name"),
                @NamedQuery(name = "Users.getBySurname", query = "select o from Users o where o.surname like :p_surname"),
                @NamedQuery(name = "Users.getByThirdName", query = "select o from Users o where o.thirdName like :p_thirdName"),
                @NamedQuery(name = "Users.getByTelephone", query = "select o from Users o where o.telephone like :p_telephone"),
                @NamedQuery(name = "Users.bonusMoreThan", query = "select o from Users o where o.bonus > :p_bonusMore"),
                @NamedQuery(name = "Users.bonusLessThan", query = "select o from Users o where o.bonus < :p_bonusLess"),
                @NamedQuery(name = "Users.bonusExactly", query = "select o from Users o where o.bonus = :p_bonusExactly"),
                @NamedQuery(name = "Users.personalDiscountMoreThan", query = "select o from Users o where o.personalDiscount > :p_personalDiscMore"),
                @NamedQuery(name = "Users.personalDiscountLessThan", query = "select o from Users o where o.personalDiscount < :p_personalDiscLess"),
                @NamedQuery(name = "Users.personalDiscountExactly", query = "select o from Users o where o.personalDiscount = :p_personalDiscExactly")})
public class Users implements Serializable {
    private static final long serialVersionUID = -8096344681131367397L;
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
    private List<Orders> ordersList;

    public Users() {
    }

    public Users(BigDecimal bonus, BigDecimal idUser, String login, String name, BigDecimal personalDiscount,
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

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Orders addOrders(Orders orders) {
        getOrdersList().add(orders);
        orders.setUsers(this);
        return orders;
    }

    public Orders removeOrders(Orders orders) {
        getOrdersList().remove(orders);
        orders.setUsers(null);
        return orders;
    }
}
