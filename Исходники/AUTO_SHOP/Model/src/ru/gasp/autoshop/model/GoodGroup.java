package ru.gasp.autoshop.model;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@NamedQueries({ @NamedQuery(name = "GoodGroup.findAll", query = "select o from GoodGroup o"),
                @NamedQuery(name = "GoodGroup.getByIdGroupGood", query = "select o from GoodGroup o where o.idGroup = :p_idGoodGroup"),
                @NamedQuery(name = "GoodGroup.getByGroupGood", query = "select o from GoodGroup o where o.groupGood like :p_groupGood")})
@Table(name = "GOOD_GROUP")
public class GoodGroup implements Serializable {
    private static final long serialVersionUID = -5296566405445745700L;
    @Column(name = "GROUP_GOOD", unique = true)
    private String groupGood;
    @Id
    @Column(name = "ID_GROUP", nullable = false)
    private BigDecimal idGroup;
    @OneToMany(mappedBy = "goodGroup", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Goods> goodsList;
    @ManyToOne
    @JoinColumn(name = "GOOD_GROUP_ID_GROUP")
    private GoodGroup goodGroup1;
    @OneToMany(mappedBy = "goodGroup1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GoodGroup> goodGroupList;
    @OneToMany(mappedBy = "goodGroup2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Sales> salesList;

    public GoodGroup() {
    }

    public GoodGroup(GoodGroup goodGroup1, String groupGood, BigDecimal idGroup) {
        this.goodGroup1 = goodGroup1;
        this.groupGood = groupGood;
        this.idGroup = idGroup;
    }


    public String getGroupGood() {
        return groupGood;
    }

    public void setGroupGood(String groupGood) {
        this.groupGood = groupGood;
    }

    public BigDecimal getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(BigDecimal idGroup) {
        this.idGroup = idGroup;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Goods addGoods(Goods goods) {
        getGoodsList().add(goods);
        goods.setGoodGroup(this);
        return goods;
    }

    public Goods removeGoods(Goods goods) {
        getGoodsList().remove(goods);
        goods.setGoodGroup(null);
        return goods;
    }

    public GoodGroup getGoodGroup1() {
        return goodGroup1;
    }

    public void setGoodGroup1(GoodGroup goodGroup1) {
        this.goodGroup1 = goodGroup1;
    }

    public List<GoodGroup> getGoodGroupList() {
        return goodGroupList;
    }

    public void setGoodGroupList(List<GoodGroup> goodGroupList) {
        this.goodGroupList = goodGroupList;
    }

    public GoodGroup addGoodGroup(GoodGroup goodGroup) {
        getGoodGroupList().add(goodGroup);
        goodGroup.setGoodGroup1(this);
        return goodGroup;
    }

    public GoodGroup removeGoodGroup(GoodGroup goodGroup) {
        getGoodGroupList().remove(goodGroup);
        goodGroup.setGoodGroup1(null);
        return goodGroup;
    }

    public List<Sales> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales> salesList) {
        this.salesList = salesList;
    }

    public Sales addSales(Sales sales) {
        getSalesList().add(sales);
        sales.setGoodGroup2(this);
        return sales;
    }

    public Sales removeSales(Sales sales) {
        getSalesList().remove(sales);
        sales.setGoodGroup2(null);
        return sales;
    }
}
