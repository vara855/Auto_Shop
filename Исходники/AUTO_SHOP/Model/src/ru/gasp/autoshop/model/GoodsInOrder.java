package ru.gasp.autoshop.model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "GoodsInOrder.findAll", query = "select o from GoodsInOrder o"),
                @NamedQuery(name = "GoodsInOrder.costMoreThan", query = "select o from GoodsInOrder o where o.curCost > :p_costMore"),
                @NamedQuery(name = "GoodsInOrder.costLessThan", query = "select o from GoodsInOrder o where o.curCost < :p_costLess"),
                @NamedQuery(name = "GoodsInOrder.costExactly", query = "select o from GoodsInOrder o where o.curCost = :p_costExactly"),
                @NamedQuery(name = "GoodsInOrder.goodAmountMoreThan", query = "select o from GoodsInOrder o where o.goodAmount > :p_goodAmountMore"),
                @NamedQuery(name = "GoodsInOrder.goodAmountLessThan", query = "select o from GoodsInOrder o where o.goodAmount < :p_goodAmountLess"),
                @NamedQuery(name = "GoodsInOrder.goodAmountExactly", query = "select o from GoodsInOrder o  where o.goodAmount = :p_goodAmountExactly"),
                @NamedQuery(name = "GoodsInOrder.getByIdGood", query = "select o from GoodsInOrder o where o.goods = :p_idGoodFk"),
                @NamedQuery(name = "GoodsInOrder.getByIdOrder", query = "select o from GoodsInOrder o where o.orders = :p_idOrderFk"),
                @NamedQuery(name = "GoodsInOrder.getByIdGoodsInOrder", query = "select o from GoodsInOrder o where o.idGoodsInOrder = :p_idGoodsInOrder")
                })
@Table(name = "GOODS_IN_ORDER")
public class GoodsInOrder implements Serializable {
    private static final long serialVersionUID = 5943636767417463592L;
    @Column(name = "CUR_COST")
    private BigDecimal curCost;
    @Column(name = "GOOD_AMOUNT")
    private BigDecimal goodAmount;
    @Id
    @Column(name = "ID_GOODS_IN_ORDER", nullable = false)
    private BigDecimal idGoodsInOrder;
    @ManyToOne
    @JoinColumn(name = "ID_GOOD")
    private Goods goods;
    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Orders orders;

    public GoodsInOrder() {
    }

    public GoodsInOrder(BigDecimal curCost, BigDecimal goodAmount, Goods goods, BigDecimal idGoodsInOrder,
                        Orders orders) {
        this.curCost = curCost;
        this.goodAmount = goodAmount;
        this.goods = goods;
        this.idGoodsInOrder = idGoodsInOrder;
        this.orders = orders;
    }

    public BigDecimal getCurCost() {
        return curCost;
    }

    public void setCurCost(BigDecimal curCost) {
        this.curCost = curCost;
    }

    public BigDecimal getGoodAmount() {
        return goodAmount;
    }

    public void setGoodAmount(BigDecimal goodAmount) {
        this.goodAmount = goodAmount;
    }


    public BigDecimal getIdGoodsInOrder() {
        return idGoodsInOrder;
    }

    public void setIdGoodsInOrder(BigDecimal idGoodsInOrder) {
        this.idGoodsInOrder = idGoodsInOrder;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
