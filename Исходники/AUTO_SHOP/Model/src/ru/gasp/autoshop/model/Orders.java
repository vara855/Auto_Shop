package ru.gasp.autoshop.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "Orders.findAll", query = "select o from Orders o"),
                @NamedQuery(name = "Orders.getByIdOrder", query = "select o from Orders o where o.idOrder = :p_idOrder"),
                @NamedQuery(name = "Orders.getByIdUser", query = "select o from Orders o where o.users = :p_idUser"),
                @NamedQuery(name = "Orders.getByDate", query = "select o from Orders o where o.orderDate like :p_orderDate"),
                @NamedQuery(name = "Orders.currentBonusMoreThan", query = "select o from Orders o where o.curBonus > :p_curBonusMore"),
                @NamedQuery(name = "Orders.currentBonusLessThan", query = "select o from Orders o where o.curBonus < :p_curBonusLess"),
                @NamedQuery(name = "Orders.currentBonusExactly", query = "select o from Orders o where o.curBonus = :p_curBonusExactly"),
                @NamedQuery(name = "Orders.currentPersonalDiscountMoreThan", query = "select o from Orders o where o.curPersonalDiscount > :p_curPersonalDiscMore"),
                @NamedQuery(name = "Orders.currentPersonalDiscountLessThan", query = "select o from Orders o where o.curPersonalDiscount < :p_curPersonalDiscLess"),
                @NamedQuery(name = "Orders.currentPersonalDiscountExactly", query = "select o from Orders o where o.curPersonalDiscount = :p_curPersonalDiscExactly"),
                @NamedQuery(name = "Orders.totalAmountMoreThan", query = "select o from Orders o where o.totalAmount > :p_totalAmountMore"),
                @NamedQuery(name = "Orders.totalAmountLessThan", query = "select o from Orders o where o.totalAmount < :p_totalAmountLess"),
                @NamedQuery(name = "Orders.totalAmountExactly", query = "select o from Orders o where o.totalAmount = :p_totalAmountExactly"),
                @NamedQuery(name = "Orders.totalAmountWithSaleMoreThan", query = "select o from Orders o where o.totalAmountWithSale > :p_totalAmountWithSaleMore"),
                @NamedQuery(name = "Orders.totalAmountWithSaleLessThan", query = "select o from Orders o where o.totalAmountWithSale < :p_totalAmountWithSaleLess"),
                @NamedQuery(name = "Orders.totalAmountWithSaleExactly", query = "select o from Orders o where o.totalAmountWithSale = :p_totalAmountWithSaleExactly")})
public class Orders implements Serializable {
    private static final long serialVersionUID = -3761485654827315175L;
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
    private List<GoodsInOrder> goodsInOrderList1;
    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private Users users;

    public Orders() {
    }

    public Orders(BigDecimal curBonus, BigDecimal curPersonalDiscount, BigDecimal idOrder, Users users, Date orderDate,
                  BigDecimal totalAmount, BigDecimal totalAmountWithSale) {
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

    public List<GoodsInOrder> getGoodsInOrderList1() {
        return goodsInOrderList1;
    }

    public void setGoodsInOrderList1(List<GoodsInOrder> goodsInOrderList1) {
        this.goodsInOrderList1 = goodsInOrderList1;
    }

    public GoodsInOrder addGoodsInOrder(GoodsInOrder goodsInOrder) {
        getGoodsInOrderList1().add(goodsInOrder);
        goodsInOrder.setOrders(this);
        return goodsInOrder;
    }

    public GoodsInOrder removeGoodsInOrder(GoodsInOrder goodsInOrder) {
        getGoodsInOrderList1().remove(goodsInOrder);
        goodsInOrder.setOrders(null);
        return goodsInOrder;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
