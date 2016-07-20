package ru.gasp.AutoShop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Orders_EO.findAll", query = "select o from Orders_EO o") })
@Table(name = "ORDERS")
public class Orders_EO implements Serializable {
    private static final long serialVersionUID = -1364418984424476333L;
    @Column(name = "CUR_BONUS")
    private BigDecimal curBonus;
    @Column(name = "CUR_PERSONAL_DISCOUNT")
    private BigDecimal curPersonalDiscount;
    @Id
    @Column(name = "ID_ORDER", nullable = false)
    private BigDecimal idOrder;
    @Temporal(TemporalType.DATE)
    @Column(name = "ORDER_DATE")
    private Date orderDate;
    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;
    @Column(name = "TOTAL_AMOUNT_WITH_SALE")
    private BigDecimal totalAmountWithSale;
    @OneToMany(mappedBy = "orders", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GoodsInOrder_EO> goodsInOrderList1;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private Users_EO users;

    public Orders_EO() {
    }

    public Orders_EO(BigDecimal curBonus, BigDecimal curPersonalDiscount, BigDecimal idOrder, Users_EO users,
                     Date orderDate, BigDecimal totalAmount, BigDecimal totalAmountWithSale) {
        this.curBonus = curBonus;
        this.curPersonalDiscount = curPersonalDiscount;
        this.idOrder = idOrder;
        this.users = users;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.totalAmountWithSale = totalAmountWithSale;
    }

    public BigDecimal getCurBonus() {
        return curBonus;
    }

    public void setCurBonus(BigDecimal curBonus) {
        this.curBonus = curBonus;
    }

    public BigDecimal getCurPersonalDiscount() {
        return curPersonalDiscount;
    }

    public void setCurPersonalDiscount(BigDecimal curPersonalDiscount) {
        this.curPersonalDiscount = curPersonalDiscount;
    }

    public BigDecimal getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(BigDecimal idOrder) {
        this.idOrder = idOrder;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmountWithSale() {
        return totalAmountWithSale;
    }

    public void setTotalAmountWithSale(BigDecimal totalAmountWithSale) {
        this.totalAmountWithSale = totalAmountWithSale;
    }

    public List<GoodsInOrder_EO> getGoodsInOrderList1() {
        return goodsInOrderList1;
    }

    public void setGoodsInOrderList1(List<GoodsInOrder_EO> goodsInOrderList1) {
        this.goodsInOrderList1 = goodsInOrderList1;
    }

    public GoodsInOrder_EO addGoodsInOrder_EO(GoodsInOrder_EO goodsInOrder_EO) {
        getGoodsInOrderList1().add(goodsInOrder_EO);
        goodsInOrder_EO.setOrders(this);
        return goodsInOrder_EO;
    }

    public GoodsInOrder_EO removeGoodsInOrder_EO(GoodsInOrder_EO goodsInOrder_EO) {
        getGoodsInOrderList1().remove(goodsInOrder_EO);
        goodsInOrder_EO.setOrders(null);
        return goodsInOrder_EO;
    }

    public Users_EO getUsers() {
        return users;
    }

    public void setUsers(Users_EO users) {
        this.users = users;
    }
}
