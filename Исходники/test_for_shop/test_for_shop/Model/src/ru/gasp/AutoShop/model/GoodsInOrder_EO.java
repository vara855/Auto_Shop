package ru.gasp.AutoShop.model;

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
@NamedQueries({ @NamedQuery(name = "GoodsInOrder_EO.findAll", query = "select o from GoodsInOrder_EO o") })
@Table(name = "GOODS_IN_ORDER")
public class GoodsInOrder_EO implements Serializable {
    private static final long serialVersionUID = -3195255762223318971L;
    @Column(name = "CUR_COST")
    private BigDecimal curCost;
    @Column(name = "GOOD_AMOUNT")
    private BigDecimal goodAmount;
    @Id
    @Column(name = "ID_GOODS_IN_ORDER", nullable = false)
    private BigDecimal idGoodsInOrder;
    @ManyToOne
    @JoinColumn(name = "ID_GOOD")
    private Goods_EO goods_EO;
    @ManyToOne
    @JoinColumn(name = "ID_ORDER")
    private Orders_EO orders;

    public GoodsInOrder_EO() {
    }

    public GoodsInOrder_EO(BigDecimal curCost, BigDecimal goodAmount, Goods_EO goods_EO, BigDecimal idGoodsInOrder,
                           Orders_EO orders) {
        this.curCost = curCost;
        this.goodAmount = goodAmount;
        this.goods_EO = goods_EO;
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


    public Goods_EO getGoods_EO() {
        return goods_EO;
    }

    public void setGoods_EO(Goods_EO goods_EO) {
        this.goods_EO = goods_EO;
    }

    public Orders_EO getOrders() {
        return orders;
    }

    public void setOrders(Orders_EO orders) {
        this.orders = orders;
    }
}
