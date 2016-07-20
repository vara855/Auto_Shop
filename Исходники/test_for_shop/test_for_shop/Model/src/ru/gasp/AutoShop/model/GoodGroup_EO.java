package ru.gasp.AutoShop.model;

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
@NamedQueries({ @NamedQuery(name = "GoodGroup_EO.findAll", query = "select o from GoodGroup_EO o") })
@Table(name = "GOOD_GROUP")
public class GoodGroup_EO implements Serializable {
    private static final long serialVersionUID = 8824762649339011284L;
    @Column(name = "GROUP_GOOD", unique = true)
    private String groupGood;
    @Id
    @Column(name = "ID_GROUP", nullable = false)
    private BigDecimal idGroup;
    @OneToMany(mappedBy = "goodGroup", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Goods_EO> goods_EOList;
    @ManyToOne
    @JoinColumn(name = "GOOD_GROUP_ID_GROUP")
    private GoodGroup_EO goodGroup1;
    @OneToMany(mappedBy = "goodGroup1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<GoodGroup_EO> goodGroupList;
    @OneToMany(mappedBy = "goodGroup2", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Sales_EO> salesList;

    public GoodGroup_EO() {
    }

    public GoodGroup_EO(GoodGroup_EO goodGroup1, String groupGood, BigDecimal idGroup) {
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

    public List<Goods_EO> getGoods_EOList() {
        return goods_EOList;
    }

    public void setGoods_EOList(List<Goods_EO> goods_EOList) {
        this.goods_EOList = goods_EOList;
    }

    public Goods_EO addGoods_EO(Goods_EO goods_EO) {
        getGoods_EOList().add(goods_EO);
        goods_EO.setGoodGroup(this);
        return goods_EO;
    }

    public Goods_EO removeGoods_EO(Goods_EO goods_EO) {
        getGoods_EOList().remove(goods_EO);
        goods_EO.setGoodGroup(null);
        return goods_EO;
    }

    public GoodGroup_EO getGoodGroup1() {
        return goodGroup1;
    }

    public void setGoodGroup1(GoodGroup_EO goodGroup1) {
        this.goodGroup1 = goodGroup1;
    }

    public List<GoodGroup_EO> getGoodGroupList() {
        return goodGroupList;
    }

    public void setGoodGroupList(List<GoodGroup_EO> goodGroupList) {
        this.goodGroupList = goodGroupList;
    }

    public GoodGroup_EO addGoodGroup_EO(GoodGroup_EO goodGroup_EO) {
        getGoodGroupList().add(goodGroup_EO);
        goodGroup_EO.setGoodGroup1(this);
        return goodGroup_EO;
    }

    public GoodGroup_EO removeGoodGroup_EO(GoodGroup_EO goodGroup_EO) {
        getGoodGroupList().remove(goodGroup_EO);
        goodGroup_EO.setGoodGroup1(null);
        return goodGroup_EO;
    }

    public List<Sales_EO> getSalesList() {
        return salesList;
    }

    public void setSalesList(List<Sales_EO> salesList) {
        this.salesList = salesList;
    }

    public Sales_EO addSales_EO(Sales_EO sales_EO) {
        getSalesList().add(sales_EO);
        sales_EO.setGoodGroup2(this);
        return sales_EO;
    }

    public Sales_EO removeSales_EO(Sales_EO sales_EO) {
        getSalesList().remove(sales_EO);
        sales_EO.setGoodGroup2(null);
        return sales_EO;
    }
}
